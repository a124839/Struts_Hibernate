package entity;

import java.util.Date;

/**
 * @author k570
 * ѧ��ʵ����
 *
 */
public class Students {
	private int sid;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	//�޲ι��췽��
	public Students(){
		
	}
	//�вι��췽��
	public Students(int sid,String sname,String gender,Date birthday,String address){
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
