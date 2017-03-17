package com.bvrit.happyride.controller;
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.bvrit.happyride.dao.ConnectionDAO;
public class AddPhotoServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	doProcess(request, response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	doProcess(request, response);
}
protected void doProcess(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
try {
Connection con;
ConnectionDAO cdao;

// Apache Commons-Fileupload library classes
DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload sfu = new ServletFileUpload(factory);
if (! ServletFileUpload.isMultipartContent(request)) {
System.out.println("sorry. No file uploaded");
return;
}
// parse request
List items = sfu.parseRequest(request);
System.out.println(items);
FileItem fileItem = (FileItem) items.get(0);
String firstname = fileItem.getString();
System.out.println(firstname);
fileItem = (FileItem) items.get(1);
String lastname = fileItem.getString();
fileItem = (FileItem) items.get(2);
String email = fileItem.getString();
fileItem = (FileItem) items.get(3);
String contactnumber = fileItem.getString();
fileItem = (FileItem) items.get(4);
String username = fileItem.getString();
fileItem = (FileItem) items.get(5);
String password = fileItem.getString();
//System.out.println(firstname + lastname + email + contactnumber + username + password);
// get uploaded file
FileItem image = (FileItem) items.get(6);
// Connect to Oracle
//Will work only in mysql as mysql is having longblob datatype
cdao = new ConnectionDAO();
con = cdao.getConnection();
String query = "insert into users(firstname,lastname,email,contactnumber,username,password,photo) values('"+firstname+"','"+lastname+"','"+email+"','"+contactnumber+"','"+username+"','"+password+"',?)";
System.out.println(query);


PreparedStatement ps = con.prepareStatement(query);

//PreparedStatement ps = con.prepareStatement("insert into user(firstname,lastname,email,contactnumber,username,password) values('"+firstname+"','"+lastname+"','"+email+"','"+contactnumber+"','"+username+"',"+password+")");
// size must be converted to int otherwise it results in error
System.out.println((int) image.getSize());
ps.setBinaryStream(1, image.getInputStream(), (int) image.getSize());
ps.executeUpdate();
con.close();
request.setAttribute("msg", "User added successfully!!!"); 
request.getRequestDispatcher("/startwelcome.jsp").forward(request,response);
}
catch(Exception ex) {
	ex.printStackTrace(System.out);


}
}
}



