/**
 * 
 */
package jp.co.fitec.training.project.typing.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author R.Miyachi
 *
 */
public class MD5Generater {

	 /**
	 * MD5で文字列を暗号化し、暗号化されたバイナリを16進数表記の文字列に変換した値を取得する
	 * @param str 暗号化対象の文字列
	 * @return 暗号化した結果を16進数表記に変換した文字列
	 * @throws NoSuchAlgorithmException
	 */
	public static String digestMd5(String str) throws NoSuchAlgorithmException  {
		  
	      // MD5で暗号化したByte型配列を取得する
	      MessageDigest md5 = MessageDigest.getInstance("MD5");
		
	      md5.update(str.getBytes());
	      byte[] encryptedHash = md5.digest();
	      
	      // 暗号化されたByte型配列を、16進数表記文字列に変換する
	      return BinaryHexConverter.bytesToHexString(encryptedHash);
	  }
}
