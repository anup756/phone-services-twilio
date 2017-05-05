package com.corvisaAPI;

import com.twilio.sdk.resource.instance.Account;
import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.AppSetup;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class sendSMS
 */
@WebServlet("/sendSMS")
public class SendSMS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppSetup appsetup;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSMS() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		this.appsetup = new AppSetup();
		try {
			String accountSid = this.appsetup.getAccountSid();
			String authToken = this.appsetup.getAuthToken();
			String fromNumber = this.appsetup.getTwilioNumber();
			TwilioRestClient client = new TwilioRestClient(accountSid, authToken);
			String pNumber = request.getParameter("phoneSMS");
			String pMessage = request.getParameter("testSMS");
			Account account = client.getAccount();
			MessageFactory messageFactory = account.getMessageFactory();
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("To", pNumber)); // Replace with a valid phone number for your account.
	        params.add(new BasicNameValuePair("From", fromNumber)); // Replace with a valid phone number for your account.
	        params.add(new BasicNameValuePair("Body", pMessage));
	        Message sms = messageFactory.create(params);
	        System.out.println("Sending SMS...: To:" + pNumber + "From:"+ fromNumber+ "and Message:" +pMessage);
		} catch (UndefinedEnvironmentVariableException | TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		
		
	}

}
