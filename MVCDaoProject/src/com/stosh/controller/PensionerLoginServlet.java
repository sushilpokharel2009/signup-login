package com.stosh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stosh.Dao.VerifyLoginDao;
import com.stosh.Dao.PensionerSignUpDao;
import com.stosh.pensionerModal.Pensioner;

/**
 * Servlet implementation class PensionerLoginServlet
 */
@WebServlet("/PensionerLoginServlet")
public class PensionerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PensionerLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			VerifyLoginDao pld = new VerifyLoginDao();
			
			//System.out.println("----->>>"+request.getParameter("login"));
			
			if(request.getParameter("login")!=null) {
				
				if(request.getParameter("FirstName").isEmpty()  || request.getParameter("FirstName")==null){
					response.sendRedirect("Signup.jsp");
					return;
				}
				if(request.getParameter("LastName").isEmpty()  || request.getParameter("LastName")==null){
					response.sendRedirect("Signup.jsp");
					return;
				}
				if(request.getParameter("Password").isEmpty()  || request.getParameter("Password")==null){
					response.sendRedirect("Signup.jsp");
					return;
				}
				if(request.getParameter("Address").isEmpty()  || request.getParameter("Address")==null){
					response.sendRedirect("Signup.jsp");
				return;
				}
				Pensioner pn1 = new Pensioner();
				pn1.setFirstName(request.getParameter("FirstName"));
				pn1.setLastName(request.getParameter("LastName"));
				pn1.setPassword(request.getParameter("Password"));
				pn1.setAddress(request.getParameter("Address"));
				
				
				Pensioner pno = pld.verifyPensioner(pn1);
				//System.out.println("==>>"+pno);
				if(pno!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("vfp", pno);
					response.sendRedirect("Home.jsp");
				}else {
					response.sendRedirect("Signup.jsp?in=invalidate");
//					Please do not make space here [in=invalidate] otherwise it won't work.
				}
				
			}
			
			
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
