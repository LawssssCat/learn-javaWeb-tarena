package cn.edut.day30;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String name ; 
	private int age; 
	private Date birthday;
	
	

	public User() {
		super();
	}

	public User(String name, int age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	/**
	 * 逻辑视图
	 */
	public String getBirthdayStr() {
		if(birthday!=null) {//SDF处理null会有NullPointException
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return sdf.format(birthday);
		}else {
			return null ;
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
