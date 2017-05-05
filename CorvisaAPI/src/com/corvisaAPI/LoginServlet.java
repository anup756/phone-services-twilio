package com.corvisaAPI;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
        description = "Login Servlet", 
        urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;   
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        //get request parameters for userID and password
        String username = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //String strErrMsg = null;
        //get userdetails
        final String Query = "SELECT * FROM user WHERE Username= '"+username+"' AND Password = '"+pwd+"';";
        System.out.println(Query);
        try(
        		Connection con = DBConnection.getConnection();
        		//PreparedStatement prepStmt = con.prepareStatement(Query);
        		//prepStmt.setString(1, user);
        		//prepStmt.setString(2, pwd);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(Query)) {  
            while(rs.next()){
                String id = rs.getString("ID");
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String uname = rs.getString("Username");
                String password = rs.getString("Password");
                System.out.println(id + "," +fname+ "," +lname+"," +uname+"," +password);
                if(uname.equals(username) && password.equals(pwd)){
                	System.out.println("Redirecting...");
                    //response.sendRedirect("secure/home.jsp");
                    request.setAttribute("FirstName", fname);
                    request.setAttribute("LastName", lname);
                	RequestDispatcher rd = getServletContext().getRequestDispatcher("/secure/home.jsp");
                    rd.forward(request,  response);
                }else{
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
                    PrintWriter out= response.getWriter();
                    out.println("<font color=red>Either user name or password is wrong.</font>");
                    rd.include(request, response); 
                }
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //logging example
        log("User="+username+"::password="+pwd);
         
    }
    
    private void closeConnection(Connection con) {
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
			}
		} catch(SQLException sqle) {
			System.out.println("Error while closing connection.");
		}
	}
}
