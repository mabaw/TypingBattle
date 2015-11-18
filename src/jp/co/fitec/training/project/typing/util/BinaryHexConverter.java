/**
 * 
 */
package jp.co.fitec.training.project.typing.util;

/**
 * 
 * @author R.Miyachi
 *
 */
public class BinaryHexConverter {

	/**
	 * Byte型配列から16進数表記文字列へ変換する
	 * @param fromByte 変換対象Byte型配列
	 * @return 16進数表記に変換後の文字列
	 */
	public static String bytesToHexString(byte[] fromByte) {

	      StringBuilder hexStrBuilder = new StringBuilder();
	      for (int i = 0; i < fromByte.length; i++) {

	          // 16進数表記で1桁数値だった場合、2桁目を0で埋める
	          if ((fromByte[i] & 0xff) < 0x10) {
	              hexStrBuilder.append("0");
	          }
	          hexStrBuilder.append(Integer.toHexString(0xff & fromByte[i]));
	      }

	      return hexStrBuilder.toString();
	  }
}
