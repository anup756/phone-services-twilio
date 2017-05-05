package com.corvisaAPI;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
 
import com.twilio.sdk.verbs.TwiMLResponse;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.Say;
import com.twilio.sdk.verbs.Dial;

/**
 * Servlet implementation class HandleKeyServlet
 */
@WebServlet("/HandleKeyServlet")
public class HandleKeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
        String digits = request.getParameter("Digits");
        System.out.println(digits);
        TwiMLResponse twiml = new TwiMLResponse();
        // Check if the user pressed "1" on their phone
        if (digits != null) {
            // Connect 310 555 1212 to the incoming caller.
            Dial dial = new Dial(digits);
            
            // If the above dial failed, say an error message.
            Say say = new Say("The call failed, or the remote party hung up. Goodbye.");
            try { 
                twiml.append(dial);
                twiml.append(say);
            } catch (TwiMLException e) {
                e.printStackTrace();
            }
        } else {
            // If they didn't press 1, redirect them to the TwilioServlet
            response.sendRedirect("/CorvisaAPI/ConnectCall");
            return;
        }
 
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
    }

}
