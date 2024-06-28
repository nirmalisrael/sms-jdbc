package com.algoriant.sms;

import com.algoriant.sms.dao.impl.StudentDAOImpl;
import com.algoriant.sms.model.Student;
import java.util.Scanner;
import java.util.List;
import java.sql.Date;	

public class UIClass{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		StudentDAOImpl stdao = new StudentDAOImpl();
		Date Dob;
		Student student = new Student();
		int op;
		do{
			System.out.print("\n1. New Student\n2. Modify Student Info\n3. Remove Student Info\n4. Display Single Student Info\n5. Display All Student Details\n6. Forget Id? \n7. Exit..\n\nEnter your option: ");
			op = scan.nextInt();
			
			try{
				int id,pincode;
				long phone;
				String name,dob,email,dr_no,st_name,village,dist;
				switch(op){
					case 1:		
						System.out.print("Student Name: ");
						name = scan.next();
						name += scan.nextLine();
						System.out.print("Student Date of Birth ordere by 'yyyy-mm-dd':");
						dob = scan.next();
						System.out.print("Student Email-Id: ");
						email = scan.next();
						System.out.print("Student Phone: ");
						phone = scan.nextLong();
						System.out.print("Student House Door No: ");
						dr_no = scan.next();
						System.out.print("Student Street Name: ");
						st_name = scan.next();
						st_name += scan.nextLine();
						System.out.print("Student Village: ");
						village = scan.next();
						village += scan.nextLine();
						System.out.print("Student District: ");
						dist = scan.next();
						dist += scan.nextLine();
						System.out.print("Village Pincode: ");
						pincode = scan.nextInt();
						
						student.setName(name);
						student.setDob(dob);
						student.setEmail(email);
						student.setPhone(phone);
						student.setDrNo(dr_no);
						student.setStName(st_name);
						student.setVillage(village);
						student.setDistrict(dist);
						student.setPincode(pincode);
						
						if(stdao.createStudent(student) == true){
							student = stdao.getStudentId(student);
							id = student.getId();
							System.out.println("\nStudent Information Stored succesfully...");
							System.out.println(name+" your Id is '"+id+"'");
						}else{
							System.out.println("\nStudent Information Stored is failed!!!");							
						}
						break;
						
					case 2:
						
						System.out.println("Enter your Id:");
						id = scan.nextInt();
						student.setId(id);
						System.out.println("1. Update Email-Id\n2. Update Mobile Number\n3. Update Address");
						int uo = scan.nextInt();
						int rw;
						switch(uo){
							case 1:
								System.out.println("Enter New Email-Id:");
								email = scan.next();
								student.setEmail(email);
								rw = stdao.modifyStudent(student,uo);
								if(rw>0)
									System.out.println("Id "+student.getId()+" Your Email-Id was Updated...");
								else
									System.out.println("Failure to modify the Email-Id because, Student Id is Invalid...");	
								break;

							case 2:
								System.out.println("Enter New Mobile No:");
								phone = scan.nextLong();
								student.setPhone(phone);
								rw = stdao.modifyStudent(student,uo);
								if(rw>0)
										System.out.println("Id "+student.getId()+" Your Mobile Number was Updated...");
								else
									System.out.println("Failure to modify the Mobile number because, Student Id is Invalid...");	
								break;
						
							case 3:
								System.out.println("Enter the New Address...");
								System.out.print("Student House Door No: ");
								dr_no = scan.next();
								System.out.print("Student Street Name: ");
								st_name = scan.next();
								st_name += scan.nextLine();
								System.out.print("Student Village: ");
								village = scan.next();
								village += scan.nextLine();
								System.out.print("Student District: ");
								dist = scan.next();
								dist += scan.nextLine();
								System.out.print("Village Pincode: ");
								pincode = scan.nextInt();
								
								student.setDrNo(dr_no);
								student.setStName(st_name);
								student.setVillage(village);
								student.setDistrict(dist);
								student.setPincode(pincode);
								
								rw = stdao.modifyStudent(student,uo);
								if(rw>0)
										System.out.println("Id "+student.getId()+" Your Address was Updated...");
								else
									System.out.println("Failure to modify the address because, Student Id is Invalid...");	
								break;
							
							default:
								System.out.println("Invalid Option");
						}
						break;
						
					case 3:
						System.out.println("\nDelete student where Id: ");
						id = scan.nextInt();
						student.setId(id);
						rw = stdao.removeStudent(student);
						if(rw>0)
							System.out.println("Id "+student.getId()+" Your details was Deleted...");
						else
							System.out.println("Failure to remove record because, Student Id is Invalid...");
						break;
						
					case 4:
						System.out.println("\nDisplay student where Id: ");
						id = scan.nextInt();
						student.setId(id);
						student = stdao.getStudent(student,id);
						id = student.getId();
						name = student.getName();
						Dob = student.getDob();
						email = student.getEmail();
						phone = student.getPhone();
						dr_no = student.getDrNo();
						st_name = student.getStName();
						village = student.getVillage();
						dist = student.getDistrict();
						pincode = student.getPincode();
						if(name != null){
							System.out.println("\nYour details here...");
							System.out.println("\nId\t\t: "+id+"\nName\t\t: "+name+"\nDOB\t\t: "+Dob+"\nEmail-Id\t: "+email+"\nPhone No\t: "+phone+"\nAddress\t\t: "+dr_no+", "+st_name+",\n\t\t  "+village+",\n\t\t  "+dist+",\n\t\t  "+pincode+".\n");						
						}else{
							System.out.println("Failure to get the student record because, Student Id is Invalid...");							
						}
						break;
						
					case 5:
						List<Student> listOfStudent = stdao.getAllStudent(student);

						for(Student std : listOfStudent){
							id = std.getId();
							name = std.getName();
							Dob = std.getDob();
							email = std.getEmail();
							phone = std.getPhone();
							dr_no = std.getDrNo();
							st_name = std.getStName();
							village = std.getVillage();
							dist = std.getDistrict();
							pincode = std.getPincode();
							System.out.println("\nId\t\t: "+id+"\nName\t\t: "+name+"\nDOB\t\t: "+Dob+"\nEmail-Id\t: "+email+"\nPhone No\t: "+phone+"\nAddress\t\t: "+dr_no+", "+st_name+",\n\t\t  "+village+",\n\t\t  "+dist+",\n\t\t  "+pincode+".\n");
						}
						break;
						
					case 6:
						System.out.print("Enter your name: ");
						name = scan.next();
						name += scan.nextLine();
						student.setName(name);
						student = stdao.getStudentId(student);
						id = student.getId();
						if(id > 0)
							System.out.println(student.getName()+"\n ... Your Id is '"+id+"'");
						else
							System.out.println("Your name is not present in The Student Details...");
						break;
						
					case 7:
						System.out.println("Good Bye...");
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}while(op < 7);
	}
	
}