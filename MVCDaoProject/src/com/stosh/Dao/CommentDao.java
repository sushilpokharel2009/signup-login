package com.stosh.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stosh.pensionerModal.Comment;
import com.stosh.util.PensionerDBConnection;

public class CommentDao {
	
	public void insertComments(Comment cmt) {
		try {
			
			Connection con = PensionerDBConnection.myConnection();
			String query = "insert into Complete(completeName, message)values(?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, cmt.getCompleteName());
			pst.setString(2, cmt.getMessage());
			pst.execute();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public  List<Comment> getCommentList() {
		try {
			Connection con = PensionerDBConnection.myConnection();
			String query = "select * from Complete";
			PreparedStatement pst = con.prepareStatement(query);
			
			
			ResultSet rs = pst.executeQuery();
			
			List<Comment> li = new ArrayList<>();
			
			while(rs.next()) {
				Comment c1 = new Comment();
				c1.setId(rs.getInt("id"));
				c1.setCompleteName(rs.getString("completeName"));
				c1.setMessage(rs.getString("message"));
				
				li.add(c1);
			}
			return li;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
