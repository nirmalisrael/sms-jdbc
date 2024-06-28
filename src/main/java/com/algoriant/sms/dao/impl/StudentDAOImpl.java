package com.algoriant.sms.dao.impl;

import com.algoriant.sms.dao.StudentDAO;
import com.algoriant.sms.service.DBService;
import com.algoriant.sms.model.Student;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;

public class StudentDAOImpl implements StudentDAO{
	
	public boolean createStudent(Student student){		
		final String INSERT_QUERY = "insert into Student_Details(name,dob,email,phone,dr_no,st_name,village,district,pincode) values(?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		
		try{
			con = DBService.getInstance().getConnection();
			pst = con.prepareStatement(INSERT_QUERY);
			pst.setString(1,student.getName());
			pst.setDate(2,student.getDob());
			pst.setString(3,student.getEmail());
			pst.setLong(4,student.getPhone());
			pst.setString(5,student.getDrNo());
			pst.setString(6,student.getStName());
			pst.setString(7,student.getVillage());
			pst.setString(8,student.getDistrict());
			pst.setInt(9,student.getPincode());
			return pst.executeUpdate()>0;
		}catch(Exception ex){
			throw new RuntimeException("Failure while create Student in the student record ",ex);
		}finally{
			DBService.closeConnection(null,pst,con);
		}
	}
	
	public int modifyStudent(Student student,int op){
		Connection con = null;
		PreparedStatement pst=null;
		
		switch(op){
			case 1:
				final String EMAIL_QUERY = "Update Student_Details set email = ? where id = ?";
				try{
					con = DBService.getInstance().getConnection();
					pst = con.prepareStatement(EMAIL_QUERY);
					pst.setString(1,student.getEmail());
					pst.setInt(2,student.getId());
					return pst.executeUpdate();
				}catch(Exception ex){
					throw new RuntimeException("Failure while update email in the student record Id is "+student.getId(),ex);
				}finally{
					DBService.closeConnection(null,pst,con);
				}
				
			case 2:	
				final String PHONE_QUERY = "Update Student_Details set phone = ? where id = ?"; 
				try{
					con = DBService.getInstance().getConnection();
					pst = con.prepareStatement(PHONE_QUERY);
					pst.setLong(1,student.getPhone());
					pst.setInt(2,student.getId());
					return pst.executeUpdate();
				}catch(Exception ex){
					throw new RuntimeException("Failure while update mobile number in the student record Id is "+student.getId(),ex);
				}finally{
					DBService.closeConnection(null,pst,con);
				}
				
			case 3:	
				final String ADDRESS_QUERY = "Update Student_Details set dr_no = ?,st_name = ? ,village = ? ,district = ? ,pincode = ? where id = ?";
				try{
					con = DBService.getInstance().getConnection();				
					pst = con.prepareStatement(ADDRESS_QUERY);
					pst.setString(1,student.getDrNo());
					pst.setString(2,student.getStName());
					pst.setString(3,student.getVillage());
					pst.setString(4,student.getDistrict());
					pst.setInt(5,student.getPincode());	
					pst.setInt(6,student.getId());
					return pst.executeUpdate();
				}catch(Exception ex){
					throw new RuntimeException("Failure while update address in the student record Id is"+student.getId(),ex);
				}finally{
					DBService.closeConnection(null,pst,con);
				}
		}
		return 0;
	}
	
	public int removeStudent(Student student){
		Connection con = null;
		PreparedStatement pst=null;
		try{
			final String DELETE_QUERY = "delete from Student_Details where id = ?";
			con = DBService.getInstance().getConnection();
			pst = con.prepareStatement(DELETE_QUERY);
			pst.setInt(1,student.getId());
			return pst.executeUpdate();
		}catch(Exception ex){
			throw new RuntimeException("Failure while remove the student record Id is "+student.getId(),ex);
		}finally{
			DBService.closeConnection(null,pst,con);
		}
	}
	
	public Student getStudent(Student student,int id){
		Connection con = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try{
			final String SELECT_QUERY = "select * from Student_Details where id = ?";
			con = DBService.getInstance().getConnection();
			pst = con.prepareStatement(SELECT_QUERY);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			while(rs.next()){
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDob(rs.getString(3));
				student.setEmail(rs.getString(4));
				student.setPhone(rs.getLong(5));
				student.setDrNo(rs.getString(6));
				student.setStName(rs.getString(7));
				student.setVillage(rs.getString(8));
				student.setDistrict(rs.getString(9));
				student.setPincode(rs.getInt(10));
			}	
			return student;
		}catch(Exception ex){
			throw new RuntimeException("Failure while get student details in student record Id is "+student.getId(),ex);
		}finally{
			DBService.closeConnection(rs,pst,con);
		}
	}
	
	public List<Student> getAllStudent(Student student){
		List<Student> listOfStudent = null;
		final String SELECT_ALL_QUERY = "select * from Student_Details";
		Connection ct = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			listOfStudent = new ArrayList<Student>();
			ct = DBService.getInstance().getConnection();
			pst = ct.prepareStatement(SELECT_ALL_QUERY);
			rs = pst.executeQuery();
			while(rs.next()){
				student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDob(rs.getString(3));
				student.setEmail(rs.getString(4));
				student.setPhone(rs.getLong(5));
				student.setDrNo(rs.getString(6));
				student.setStName(rs.getString(7));
				student.setVillage(rs.getString(8));
				student.setDistrict(rs.getString(9));
				student.setPincode(rs.getInt(10));
				listOfStudent.add(student);
			}
		}catch(Exception ex){
			throw new RuntimeException("Failure to display all student details...",ex);
		}finally{
			DBService.closeConnection(rs,pst,ct);
		}
		return listOfStudent;
	}
	
	public Student getStudentId(Student student){
		Connection con = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try{
			final String SELECT_ID_QUERY = "select id from Student_Details where name = ?";
			con = DBService.getInstance().getConnection();		
			pst= con.prepareStatement(SELECT_ID_QUERY);
			pst.setString(1,student.getName());
			rs = pst.executeQuery();
			while(rs.next()){
				student.setId(rs.getInt(1));
			}
			return student;
		}catch(Exception ex){
			throw new RuntimeException("Failure to get student Id...",ex);
		}finally{
			DBService.closeConnection(rs,pst,con);
		}
	}	
}
