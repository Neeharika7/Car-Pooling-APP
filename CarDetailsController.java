package com.bvrit.happyride.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.happyride.dao.CarDetailsDAO;


public class CarDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   // public CarDetailsController() {
      //  super();
   // }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	protected  void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		boolean result;
		String carnumber =  request.getParameter("carnumber");
		String carcolor = request.getParameter("carcolor");
		String carmodel = request.getParameter("carmodel");

		
		try{
				CarDetailsDAO cd = new CarDetailsDAO();
				HttpSession session=request.getSession();
			    String username =(String)session.getAttribute("username");
				
			
			result = cd.cardetails(username, carnumber,carcolor, carmodel);
			
			
			 if(result){
				
					response.sendRedirect("journeydetails.jsp");
				}
				else{
					
					response.sendRedirect("cardetails.jsp");  
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
