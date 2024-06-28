package com.algoriant.sms.model;

import java.sql.Date;
public class Student{
	
	private int Id;
	private String Name;
	private Date  Dob;
	private String Email;
	private long Phone;
	private String DrNo;
	private String StName;
	private String Village;
	private String District;
	private int Pincode;
	
	public void setId(int Id){
		this.Id = Id;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public void setDob(String dob){
		this.Dob =  Date.valueOf(dob);
	}
	
	public void setEmail(String Email){
		this.Email = Email;
	}
	
	public void setPhone(long Phone){
		this.Phone = Phone;
	}
	
	public void setDrNo(String DrNo){
		this.DrNo = DrNo;
	}
	
	public void setStName(String StName){
		this.StName = StName;
	}
	
	public void setVillage(String Village){
		this.Village = Village;
	}
	
	public void setDistrict(String District){
		this.District = District;
	}
	
	public void setPincode(int Pincode){
		this.Pincode = Pincode;
	}
	
	
	public int getId(){
		return Id;
	}
	
	public String getName(){
		return Name;
	}
	
	public Date getDob(){
		return Dob;
	}
	
	public String getEmail(){
		return Email;
	}
	
	public long getPhone(){
		return Phone;
	}
	
	public String getDrNo(){
		return DrNo;
	}
	
	public String getStName(){
		return StName;
	}
	
	public String getVillage(){
		return Village;
	}
	
	public String getDistrict(){
		return District;
	}
	
	public int getPincode(){
		return Pincode;
	}
}