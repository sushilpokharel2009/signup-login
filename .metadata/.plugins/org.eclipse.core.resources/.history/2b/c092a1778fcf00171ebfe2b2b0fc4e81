package com.stosh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.stosh.pensionerModal.Pensioner;
import com.stosh.util.PensionerDBConnection;

public class VerifyLoginDao {
	
	public Pensioner verifyPensioner(Pensioner pn2) {
		try {
			
			Connection con = PensionerDBConnection.myConnection();
			String query = "select * from Pensioner where firstName = ? and lastName = ? and password = ? and address = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, pn2.getFirstName());
			pst.setString(2, pn2.getLastName());
			pst.setString(3, pn2.getPassword());
			pst.setString(4, pn2.getAddress());
			
						
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Pensioner pn = new Pensioner();
				pn.setId(rs.getInt("id"));
				pn.setFirstName(rs.getString("firstName"));
				pn.setLastName(rs.getString("lastName"));
				pn.setPassword(rs.getString("password"));
				pn.setAddress(rs.getString("address"));
				return pn;
			}
		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		return null;
		
	}

}
