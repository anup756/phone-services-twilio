package com.corvisaAPI.leadalert;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class alertme
 */
@WebServlet("/alertme")
public class AlertMe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertMe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("houseTitle", "Talk to our Sales Rep");
        request.setAttribute("housePrice", "Weekly HOT Sales Leads");
        request.setAttribute("houseDescription",
                "You will love our weekly HOT sales leads " +
                "Featuring Recently Divorced, New Parents, Recently Married, New Businesses, New Homeowners and New Movers! "
        		);

        request.getRequestDispatcher("secure/leadalert.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
