package com.stosh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.stosh.pensionerModal.Pensioner;
import com.stosh.util.PensionerDBConnection;


public class PensionerSignUpDao {
	
	
	
	
//	to insert data
	
	public void insertPensionerInfo(Pensioner pn){
		
			try {
				
				Connection con = PensionerDBConnection.myConnection();
				String query = "insert into Pensioner(firstName, lastName, password, address) values(?,?,?,?)";
				
				
				
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, pn.getFirstName());
				pst.setString(2, pn.getLastName());
				pst.setString(3, pn.getPassword());
				pst.setString(4, pn.getAddress());
				
				pst.execute();
				con.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

//	to retrive all data in list
	
	
	public List <Pensioner> getPensionerCompleteList(){
		
		try {
			
			Connection cons = PensionerDBConnection.myConnection();
			String query = "select * from Pensioner";
			PreparedStatement pst = cons.prepareStatement(query);
			
			ResultSet rs1= pst.executeQuery();
			List<Pensioner> li = new ArrayList<>();
			
			
			
			while(rs1.next()) {
				Pensioner psn = new Pensioner();
				psn.setId(rs1.getInt("id"));
				psn.setFirstName(rs1.getString("firstName"));
				psn.setLastName(rs1.getString("lastName"));
				psn.setPassword(rs1.getString("password"));
				psn.setAddress(rs1.getString("address"));
				
				
				li.add(psn);
				
			}
			return li;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
//	to retrive only one property eg. id from database
	
	public Pensioner getSinglePensionerInfo(int id) {
		try {
			Connection con = PensionerDBConnection.myConnection();
			String query = "select * from Pensioner where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			
			ResultSet rs2 = pst.executeQuery();
			while(rs2.next()) {
				Pensioner ps2 = new Pensioner();
				ps2.setId(rs2.getInt("id"));
				ps2.setFirstName(rs2.getString("firstName"));
				ps2.setLastName(rs2.getString("lastName"));
				ps2.setPassword(rs2.getString("password"));
				ps2.setAddress(rs2.getString("address"));
				return ps2;
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	to delete data
	
	
	public void deletePensioner(int idForDeletes) {
		try {
			Connection con = PensionerDBConnection.myConnection();
			String query3 = "delete from Pensioner where id = ?";
			PreparedStatement pst3 = con.prepareStatement(query3);
			pst3.setInt(1, idForDeletes);
			pst3.executeUpdate();
			con.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void add(int i) {
		
	}
	
//	to update data
	
	public void updateStudent(Pensioner pn4) {
		try {
			Connection con = PensionerDBConnection.myConnection();
			String query4 = "update Pensioner set firstName = ?, lastName = ? password = ?, address = ? where id = ?";
			
			
			PreparedStatement pst4 = con.prepareStatement(query4);
			
			//Student st4 = new Student();
			pst4.setString(1, pn4.getFirstName());
			pst4.setString(2, pn4.getLastName());
			pst4.setString(3, pn4.getPassword());
			pst4.setString(4, pn4.getAddress());
			pst4.setInt(5, pn4.getId());
			pst4.executeUpdate();
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
