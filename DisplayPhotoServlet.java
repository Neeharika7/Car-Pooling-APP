package com.bvrit.happyride.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.happyride.dao.ConnectionDAO;

public class DisplayPhotoServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        try {
        	ConnectionDAO cdao = new ConnectionDAO();
        	Connection con = cdao.getConnection();
            PreparedStatement ps = con.prepareStatement("select photo from users where username = ?");
            
           // HttpSession session=request.getSession(false);  
           // String username=(String)session.getAttribute("username");  
            
            String username = request.getParameter("username");
            ps.setString(1,username);
            
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Blob  b = rs.getBlob("photo");
            response.setContentType("image/jpg");
            response.setContentLength( (int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.close();
        }
        catch(Exception ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
