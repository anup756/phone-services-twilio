package com.corvisaAPI.token;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.AppSetup;
import com.twilio.sdk.CapabilityToken;
import com.twilio.sdk.client.TwilioCapability;
import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.AppSetup;
import com.twilio.sdk.CapabilityToken;
import com.twilio.sdk.client.TwilioCapability;

/**
 * Servlet implementation class CapabilityTokenGenerate
 */
@WebServlet("/CapabilityTokenGenerator")
public class CapabilityTokenGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TwilioCapability capability;
	  private AppSetup appSetup;
	  private String role;
	  public CapabilityTokenGenerator(String role) {
		    this.role = role;
		    appSetup = new AppSetup();
		    try {
		      /**
		       * To find TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN visit
		       * https://www.twilio.com/user/account
		       */
		      this.capability = new TwilioCapability(appSetup.getAccountSid(), appSetup.getAuthToken());
		    } catch (UndefinedEnvironmentVariableException e) {
		      e.printStackTrace();
		    }
		  }
	  public CapabilityTokenGenerator(String role, TwilioCapability capability, AppSetup setup) {
		    this.role = role;
		    appSetup = setup;
		    this.capability = capability;
		  }
	  public String generate() {
		    String token = null;
		    try {
		      /**
		       * Sets the role depending on the page that requests que token.
		       * If the token is requested from the /dashboard page, the role will be support_agent.
		       */
		      capability.allowClientIncoming(role);
		      capability.allowClientOutgoing(appSetup.getApplicationSid());
		      token = capability.generateToken();
		    } catch (CapabilityToken.DomainException e) {
		      e.printStackTrace();
		    } catch (UndefinedEnvironmentVariableException e) {
		      e.printStackTrace();
		    }
		    //System.out.println(token);
		    return token;
		    
		  }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapabilityTokenGenerator() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String role = page.equals("/dashboard") ? "support_agent" : "customer";
	    CapabilityTokenGenerator generator = new CapabilityTokenGenerator(role);
	    String token = generator.generate();

	    JSONObject obj = new JSONObject();
	    obj.put("token", token);
	   // System.out.println(token);
	    //System.out.println(obj);
		response.getWriter().write(obj.toJSONString());
	}

}
