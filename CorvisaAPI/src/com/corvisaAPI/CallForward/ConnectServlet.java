package com.corvisaAPI.CallForward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.sdk.verbs.Dial;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;
import java.util.HashMap;
import java.util.Map;
/**
 * Servlet implementation class ConnectServlet
 */
@WebServlet("/ConnectServlet")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String selectedOption = request.getParameter("Digits");
        Map<String, String> optionPhones = new HashMap<>();
        optionPhones.put("2", "+14027380150");
        optionPhones.put("3", "+14027380150");
        optionPhones.put("4", "+14027380150");

        TwiMLResponse twiMLResponse = null;

        try {
            twiMLResponse = optionPhones.containsKey(selectedOption)
                    ? dial(optionPhones.get(selectedOption))
                    : Redirect.toMainMenu();
        } catch (TwiMLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/xml");
        response.getWriter().write(twiMLResponse.toXML());
	}
	private TwiMLResponse dial(String phoneNumber) throws TwiMLException {

        TwiMLResponse response = new TwiMLResponse();
        response.append(new Dial(phoneNumber));

        return response;
    }

}
