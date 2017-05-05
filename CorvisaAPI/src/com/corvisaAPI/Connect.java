package com.corvisaAPI;

import java.io.IOException;
import com.corvisaAPI.lib.AppSetup;
import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.sdk.TwilioUtils;
import com.twilio.sdk.verbs.Hangup;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.Verb;
import com.twilio.sdk.verbs.Record;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  AppSetup appSetup;
	  TwilioUtils validator;
	  public Connect(){}
	  public Connect(AppSetup appSetup, TwilioUtils validator) {
	    this.appSetup = appSetup;
	    this.validator = validator;
	  }
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	private String getXMLResponse(HttpServletRequest request) {
	    TwiMLResponse twimlResponse = new TwiMLResponse();
    	Record recordnow = new Record();
    	recordnow.setMaxLength(30);
    	//recordnow.setAction("/handle-recording");
	    Say sayMessage = new Say("This is Dumbsum.com. If this were a real click to call implementation, you would be connected to an agent at this point.");
	    Hangup hangup = new Hangup();
	    Say pleaseLeaveMessage = new Say("Your voice is recorded");
	    try {
	    	String recordCall = (String) request.getServletContext().getAttribute("record");
	    	System.out.println(recordCall);
	     
	      twimlResponse.append(sayMessage);
	      if ("true".equals(recordCall)){
	    		twimlResponse.append(recordnow);
	    		System.out.println("recordnow");
	    	  }
	      twimlResponse.append(pleaseLeaveMessage);
	      twimlResponse.append(hangup);
	    } catch (TwiMLException e) {
	      System.out.println("Twilio's response building error");
	    }
	    System.out.println(twimlResponse.toXML());
	    return twimlResponse.toXML();
	  }

	  /**
	   * Uses TwilioUtils to validate that the incoming request comes from Twilio automated services
	   * @param request passed servlet request to extract parameters necessary for validation
	   * @return boolean determining validity of the request
	   */
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
