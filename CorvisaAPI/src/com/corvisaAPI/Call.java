package com.corvisaAPI;

import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.AppSetup;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import org.json.simple.JSONObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
/**
 * Servlet implementation class Call
 */
@WebServlet("/Call")
public class Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AppSetup appSetup;
	  TwilioRestClient client;

	  public Call() {}

	  public Call(AppSetup appSetup, TwilioRestClient client) {
	    this.appSetup = appSetup;
	    this.client = client;
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
	    String phoneNumber = request.getParameter("phone");
	    if(phoneNumber==null||phoneNumber==""){
	    	phoneNumber = request.getParameter("phoneNumber");
	    }
	    boolean record = request.getParameter( "record" ) != null;
	    String CallRecord = "false";
	    if (record == true){
	    	CallRecord = "true";
	    }
	    request.getServletContext().setAttribute("record", CallRecord);
	    
	    if (phoneNumber != null) {
	      if (this.appSetup == null || this.client == null) {
	        appSetup = new AppSetup();
	        client = null;
	        try {
	          client = new TwilioRestClient(appSetup.getAccountSid(), appSetup.getAuthToken());
	        } catch (UndefinedEnvironmentVariableException e) {
	          response.getOutputStream().write(getJSONResponse(e.getMessage()).getBytes());
	          return;
	        }
	      }

	      Map<String, String> params = new HashMap<>();
	      String twilioNumber;
	      try {
	        twilioNumber = appSetup.getTwilioNumber();
	      } catch (UndefinedEnvironmentVariableException e) {
	        response.getOutputStream().write(getJSONResponse(e.getMessage()).getBytes());
	        return;
	      }

	      // Full path to the end point that will respond with the call TwiML
	      //String path = request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/CorvisaAPI/connect?record="+CallRecord;
	      String path = request.getRequestURL().toString().replace(request.getRequestURI(), "") + "/CorvisaAPI/connect";
	      params.put("From", twilioNumber);
	      params.put("To", phoneNumber);
	      params.put("Url", path);
	      try {
	        client.getAccount().getCallFactory().create(params);
	      } catch (TwilioRestException e) {
	        String message = "Twilio rest client error: " + e.getErrorMessage() +
	            "\nRemember not to use localhost to access this app, use your ngrok URL";
	        response.getOutputStream().write(getJSONResponse(message).getBytes());
	        return;
	      }
	      response.getOutputStream().write(getJSONResponse("Phone call incoming!").getBytes());
	    } else {
	      response.getOutputStream()
	          .write(getJSONResponse("The phone number field can't be empty").getBytes());
	    }
	}
	private String getJSONResponse(String message) {
	    JSONObject obj = new JSONObject();
	    obj.put("message", message);
	    obj.put("status", "ok");

	    return obj.toJSONString();
	  }

}
