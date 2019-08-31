package com.stosh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stosh.Dao.CommentDao;
import com.stosh.pensionerModal.Comment;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			CommentDao cmd = new CommentDao();
			
			if(request.getParameter("SubmittedBy")!=null) {
				
				if(request.getParameter("Commentator").isEmpty()  || request.getParameter("Commentator")==null){					response.sendRedirect("Home.jsp");
					return;
				}
				if(request.getParameter("Message").isEmpty()  || request.getParameter("Message")==null){
					response.sendRedirect("Home.jsp");
					return;
				}
				
				Comment c1 = new Comment();
				c1.setCompleteName(request.getParameter("Commentator"));
				c1.setMessage(request.getParameter("Message"));
				cmd.insertComments(c1);
				//response.sendRedirect("Home.jsp");
			}
			
			
			List<Comment> lc = cmd.getCommentList();
			request.setAttribute("sta", lc);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
