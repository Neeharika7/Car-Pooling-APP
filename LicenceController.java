package com.bvrit.happyride.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.happyride.dao.LicenceDAO;


public class LicenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    // public SignupController() {
     // super();
	
	

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			 // Set response content type
		     
		//response.getWriter().append("Served at: ").append(request.getContextPath());
			try {
				doProcess(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		protected  void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			boolean result;
			String licencenumber =  request.getParameter("licencenumber");
			String validationdate = request.getParameter("validationdate");
			
			try{
					LicenceDAO ld = new LicenceDAO();
					HttpSession session=request.getSession();
				    String username =(String)session.getAttribute("username");
					
				
				result = ld.licence(username, licencenumber,validationdate);
				
				
				 if(result){
					
						response.sendRedirect("cardetails.jsp");
					}
					else{
						
						response.sendRedirect("licence.jsp");  
					}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
