package com.corvisaAPI.token;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.AppSetup;
import com.twilio.sdk.TwilioUtils;
import com.twilio.sdk.verbs.Client;
import com.twilio.sdk.verbs.Dial;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.Number;

/**
 * Servlet implementation class BrowserCall
 */
@WebServlet("/BrowserCall")
public class BrowserCall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppSetup appSetup;
	  TwilioUtils validator;
	  public BrowserCall(){}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BrowserCall(AppSetup appSetup, TwilioUtils validator) {
    	this.appSetup = appSetup;
	    this.validator = validator;
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
		System.out.println("Calling Me Now...");
		//String recordCall = request.getParameter("record");
				if (this.appSetup == null) {
				      this.appSetup = new AppSetup();
				    }
				    if (isValidRequest(request)) {
				      response.getOutputStream().write(getXMLResponse(request).getBytes());
				      response.setContentType("application/xml");
				    } else {
				      response.getOutputStream().write("Invalid twilio request".getBytes());
				    }
	}
	public String getXMLResponse(HttpServletRequest request) {
	    String twilioPhoneNumber = null;
	    try {
	      twilioPhoneNumber = appSetup.getTwilioNumber();
	    } catch (UndefinedEnvironmentVariableException e) {
	      e.printStackTrace();
	    }
	    String phoneNumber = request.getParameter("phoneNumber");

	    TwiMLResponse twimlResponse = new TwiMLResponse();
	    Dial dial = new Dial();

	    /**
	     * If the phoneNumber parameter is sent on the request, it means you are calling a customer.
	     * If not, you will make a call to the support agent
	     */
	    try {
	      if (phoneNumber != null) {
	        dial.append(new Number(phoneNumber));
	        dial.setCallerId(twilioPhoneNumber);
	      } else {
	        dial.append(new Client("support_agent"));
	      }
	      twimlResponse.append(dial);
	    } catch (TwiMLException e) {
	      e.printStackTrace();
	    }
	    System.out.println(twimlResponse.toXML());
	    return twimlResponse.toXML();
	  }
	private boolean isValidRequest(HttpServletRequest request) {
	    if (this.validator == null) {
	      try {
	        validator = new TwilioUtils(appSetup.getAuthToken());
	      } catch (UndefinedEnvironmentVariableException e) {
	        e.printStackTrace();
	        return false;
	      }
	    }

	    String url = request.getRequestURL().toString();
	    Map<String, String> params = new HashMap<>();

	    Enumeration<String> names = request.getParameterNames();
	    while (names.hasMoreElements()) {
	      String currentName = names.nextElement();
	      params.put(currentName, request.getParameter(currentName));
	    }

	    String signature = request.getHeader("X-Twilio-Signature");

	    return validator.validateRequest(signature, url, params);
	  }
}
