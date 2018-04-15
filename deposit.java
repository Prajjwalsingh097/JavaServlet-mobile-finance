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
@WebServlet(urlPatterns = {"/deposit"})
public class deposit extends HttpServlet {

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
               int am,am1 = 0,am2;
               String amount,amount1,name = null,date1,mobile = null;
           String mobile1=request.getParameter("mobile1");
           
                     try
        {
         String a="select * from finance where mobile=";
          
           a+=mobile1;
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          Statement st=conn.createStatement();
          ResultSet rs=st.executeQuery(a);
          rs.next();
          name=rs.getString(1);
          String aadhar=rs.getString(2);
          mobile=rs.getString(3);
          String email=rs.getString(4);
          String address=rs.getString(5);
          String date=rs.getString(6);
          String post=rs.getString(7);
          String income=rs.getString(8);
          System.out.println("name is "+name);
          String compc=rs.getString(9);
          String imei=rs.getString(10);
          String model=rs.getString(11);
          String price=rs.getString(12);
          String compm=rs.getString(13);
         amount=rs.getString(14);
         am1=Integer.parseInt(amount);
         
      
          String inst=rs.getString(15);
          String instam=rs.getString(16);
          conn.close();
            
        }
        catch(Exception e)
        {}
          
       amount1=request.getParameter("amount");
     date1=request.getParameter("date");
            try
        {
            String a="insert into findep(name,date,amount,mobile)"+"values(?,?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
            java.sql.PreparedStatement preparedstmt=conn.prepareStatement(a);
            preparedstmt.setString(1,name);
           preparedstmt.setString(2,date1);
           preparedstmt.setString(3,amount1);
          preparedstmt.setString(4,mobile);
          
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
            
       am=Integer.parseInt(amount1);
       am2=am1-am;
         amount1=Integer.toString(am2);
         
         
         try
        {
         String a="update finance set amount=? where mobile=?";
           
          Class.forName("com.mysql.jdbc.Driver");
          java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/prajjwal","root","root");
          PreparedStatement preparedstmt=conn.prepareStatement(a);
          preparedstmt.setString(1,amount1);
           preparedstmt.setString(2,mobile1);
            preparedstmt.executeUpdate();
            System.out.println(" update run");
                    response.sendRedirect("services.html");
  
          conn.close();
            
        }
        catch(Exception e)
        {}
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet deposit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet deposit at " + request.getContextPath() + "</h1>");
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
