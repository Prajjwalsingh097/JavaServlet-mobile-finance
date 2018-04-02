/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(urlPatterns = {"/upname"})
public class upname extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
           String mobile1=request.getParameter("mobile1");
            
           String mobile=request.getParameter("mobile");
            
           String name=request.getParameter("name");
            
           String email=request.getParameter("email");
              
           String address=request.getParameter("address");
           if(name==null)
           {
           }
           else
           {
        try
        {
         String a="update finance set name=? where mobile=?";
           
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          PreparedStatement preparedstmt=conn.prepareStatement(a);
          preparedstmt.setString(1,name);
           preparedstmt.setString(2,mobile1);
            preparedstmt.executeUpdate();
            System.out.println(" update run");
                    response.sendRedirect("services.html");
  
          conn.close();
            
        }
        catch(Exception e)
        {}
           }
           
            if(mobile!=null)
           {
    
     try
        {
         String a="update finance set mobile=? where mobile=?";
           
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          PreparedStatement preparedstmt=conn.prepareStatement(a);
          preparedstmt.setString(1,mobile);
           preparedstmt.setString(2,mobile1);
            preparedstmt.executeUpdate();
            System.out.println(" update run");
                    response.sendRedirect("services.html");
  
          conn.close();
            
        }
        catch(Exception e)
        {}
           }
             if(address==null)
           {
           }
             else
             {
     try
        {
         String a="update finance set address=? where mobile=?";
           
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          PreparedStatement preparedstmt=conn.prepareStatement(a);
          preparedstmt.setString(1,address);
           preparedstmt.setString(2,mobile1);
            preparedstmt.executeUpdate();
            System.out.println(" update run");
                    response.sendRedirect("services.html");
  
          conn.close();
            
        }
        catch(Exception e)
        {}
           }
              if(email==null)
           {
           }
              else
              {
     try
        {
         String a="update finance set email=? where mobile=?";
           
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          PreparedStatement preparedstmt=conn.prepareStatement(a);
          preparedstmt.setString(1,email);
           preparedstmt.setString(2,mobile1);
            preparedstmt.executeUpdate();
            System.out.println(" update run");
                    response.sendRedirect("services.html");
  
          conn.close();
            
        }
        catch(Exception e)
        {}
        
           }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upname</title>");            
            out.println("</head>");
            out.println("<body>");
          //  out.println("<h1>Servlet upname at " + request.getContextPath() + "</h1>");
            out.println("</body>");
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
