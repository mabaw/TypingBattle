/**
 * 
 */
package jp.co.fitec.traning.project.typing.entity;

import java.io.Serializable;

import jp.co.fitec.traning.project.typing.gamedata.Level;

/**
 * @author R.Miyachi
 *
 */
public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String name ;

	public Location(){
		
	}
	
	public Location(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}




	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
