/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
                 String name=request.getParameter("name");
                 String aadhar=request.getParameter("aadhar");
                 String mobile=request.getParameter("mobile");
                 String email=request.getParameter("email");
                 String address=request.getParameter("address");
                 String date=request.getParameter("date");
                 String post=request.getParameter("post");
                 String income=request.getParameter("income");
                 String compc=request.getParameter("compc");
                 
     
                 System.out.println("="+compc);
                 
                 
                 String imei=request.getParameter("imei");
                 String model=request.getParameter("model");
                 String price=request.getParameter("price");
                 String compm=request.getParameter("compm");
                 String amount=request.getParameter("amount");
                 String inst=request.getParameter("inst");
                 String instam=request.getParameter("instam");
                 
        
                 
                 try
        {
            String a="insert into finance(name,aadhar,mobile,email,address,date,post,income,compc,imei,model,price,compm,amount,inst,instam)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
            java.sql.PreparedStatement preparedstmt=conn.prepareStatement(a);
            preparedstmt.setString(1,name);
            preparedstmt.setString(2,aadhar);
            preparedstmt.setString(3,mobile);
            preparedstmt.setString(4,email);
            preparedstmt.setString(5,address);
            preparedstmt.setString(6,date);
            preparedstmt.setString(7,post);
            preparedstmt.setString(8,income);
            preparedstmt.setString(9,compc);
            preparedstmt.setString(10,imei);
            preparedstmt.setString(11,model);
            preparedstmt.setString(12,price);
            preparedstmt.setString(13,compm);
            preparedstmt.setString(14,amount);
            preparedstmt.setString(15,inst);
            preparedstmt.setString(16,instam);
            preparedstmt.execute();
            conn.close();
            response.sendRedirect("services.html");
        }
        catch(Exception e)
        {
        
         out.print(" CUSTOMER IS ALREADY REGISTRED ,DUPLICATE MOBILE NUMBER OR AADHAR NUMBER... ");
        out.print("<br>");
          out.print("<br>");
         out.print("<form action="+"services.html"+">");
          
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
          out.print("&nbsp;&nbsp;<input type='submit'"+"value="+"BACK"+">");
          
          out.print("</form>");
   
            
        
        } 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
          /*  out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            */out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
