package jp.co.fitec.training.project.typing.ui;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.fitec.traning.project.typing.entity.UserAccount;
import jp.co.fitec.traning.project.typing.gamedata.BattleMatch;
import jp.co.fitec.traning.project.typing.service.AccountManager;
import jp.co.fitec.traning.project.typing.service.BattleManager;
import jp.co.fitec.traning.project.typing.service.GameServiceException;


import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;


/**
 * Servlet implementation class BattleServlet
 */
@WebServlet("/battle")
public class BattleServlet extends WebSocketServlet  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private static final String GUEST_PREFIX = "Guest";

    private final Set<BattleMessageInbound> connections =
            new CopyOnWriteArraySet<BattleMessageInbound>();

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol,
            HttpServletRequest request) {
    	String player = request.getParameter("player");
    	System.out.println("register player msg : " + player);
    	HttpSession session = request.getSession();
    	UserAccount playerAccount = (UserAccount) session.getAttribute("player");
        return new BattleMessageInbound(playerAccount);
    }

    
    private final class BattleMessageInbound extends MessageInbound {

        BattleManager battleManager;
        UserAccount	  user;

        private BattleMessageInbound(UserAccount user) {
            this.user = user;
        }

        @Override
        protected void onOpen(WsOutbound outbound) {
            connections.add(this);
            System.out.println("xxx");
            String message = String.format("* %s %s",
                    user.getName(), "has joined.");
           // broadcast(message);
        }

        @Override
        protected void onClose(int status) {
            connections.remove(this);
            String message = String.format("* %s %s",
            		user.getName(), "has disconnected.");
           // broadcast(message);
        }

        @Override
        protected void onBinaryMessage(ByteBuffer message) throws IOException {
            throw new UnsupportedOperationException(
                    "Binary message not supported.");
        }

        @Override       
        protected void onTextMessage(CharBuffer message) throws IOException {
        	//System.out.println("incoming message : " + message);
        	String msg = message.toString();
        	String[] splitedMsg = msg.split(",");
        	String hostname = splitedMsg[0];
        	String action =  splitedMsg[1];
        	if(action.equals("A"))
        	{
        		int power = Integer.parseInt(splitedMsg[2]);
        		String attackTo = splitedMsg[3];
        		try {
	        			if(attackTo.equals(hostname))
	        				BattleManager.attackHost(hostname,power);
	        			else 
	        				BattleManager.attackJoined(hostname, power);
	        			if(BattleManager.isGameEnd(hostname)){
	        				
	        				BattleMatch  match = BattleManager.getMatch(hostname);
	        				String winner = "";
	        				if(match.getHostPlayerLife()==match.getJoinedPlayerLife())// draw match
	        					winner = "draw";
	        				else
	        					winner = BattleManager.getWinner(hostname).getName();
	        				broadcast(hostname+",E,"+winner,hostname);  
	        				broadcast(hostname+",E,"+winner,match.getJoinedPlayer().getName());      
	        				BattleManager.removeMatch(hostname);
	        			}
	        			else
	        			{
	        				broadcast(hostname+",U,"+BattleManager.getHostLife(hostname)+","+BattleManager.getJoinedLife(hostname),attackTo);
	        			}
        			} catch (GameServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	else if(action.equals("J")){
        		String joinedName = splitedMsg[2];
        		BattleManager.joinMatch(hostname, user);        	
        		broadcast(hostname+",J,"+joinedName,hostname);
        		BattleManager.startMatch(hostname);
        	}
        	
        }

        private void broadcast(String message,String receiver) {
            for (BattleMessageInbound connection : connections) {          
            	if(connection.user.getName().equals(receiver))
            	{
	                try {
	                    CharBuffer buffer = CharBuffer.wrap(message);
	                    connection.getWsOutbound().writeTextMessage(buffer);
	                } catch (IOException ignore) {
	                    // Ignore
	                	System.err.println(ignore.getMessage());
	                }
            	}
            }
        }
    }   
}
