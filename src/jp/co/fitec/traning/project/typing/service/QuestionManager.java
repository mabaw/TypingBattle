package jp.co.fitec.traning.project.typing.service;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import jp.co.fitec.traning.project.typing.dao.DAOException;
import jp.co.fitec.traning.project.typing.dao.DAOFactory;
import jp.co.fitec.traning.project.typing.dao.QuestionDao;
import jp.co.fitec.traning.project.typing.entity.Question;
import jp.co.fitec.traning.project.typing.gamedata.Level;

public class QuestionManager {
	private static QuestionDao questionDao;
	static {
		DAOFactory factory;
		try {
			factory = DAOFactory.getInstance();
			questionDao = factory.getQuestionDao();
		} catch (DAOException e) {		
			e.printStackTrace();			
		}		
	}
	
	private static Set<Question> getQuestionSet(Level level) throws GameServiceException{
		try {
			return questionDao.getQuestionSet(level);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new GameServiceException();
		}
	}
	
	
	//[
	//{"Q": "abstract", "A": "abstract"},
	//{"Q": "公共の", "A": "public"},
	//{"Q": "接点", "A": "interface"},
	//{"Q": "拡張する", "A": "extend"},
	//{"Q": "実装する", "A": "implement"}
	//]
	public static void generateJSONQuestionFile(String path,Level level) throws GameServiceException{
		Set<Question> questionSet = getQuestionSet(level);
		
		FileWriter writer = null ;
		try
		{
			Object[] questionList = questionSet.toArray();
			
			writer = new FileWriter(path);
			//System.out.print("[\n");
			writer.write("[\n");
			for(int i=0;i<questionList.length;i++){
				Question q = (Question) questionList[i];
				//System.out.print("{"+'"'+"Q"+'"'+": " + '"'+ q.getQuestion() +'"'+ "}");
				writer.write("{"+'"'+"Q"+'"'+": " +  '"'+ q.getQuestion() +'"'+ "}");
				if(i!=questionList.length-1)
				{
				//	System.out.print(",\n");
					writer.write(",\n");
				}
			}
			writer.write("]");	
			//System.out.print("]");
		}
		catch(FileNotFoundException e)
		{
			System.err.println(e.getMessage());
			throw new GameServiceException("Problem occur when creating Question file : File not fould");
		}
		catch(IOException e){
			throw new GameServiceException("Problem occur when creating Question file : Can not write file");
		}
		finally
		{			
			try {
				if(writer!=null) // if cannot open file from start
					writer.close();
			} catch (IOException e) {
				System.out.println("cannot close file.");
			}
		}
		
	}
	
	
	
}
