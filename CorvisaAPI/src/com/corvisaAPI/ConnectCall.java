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
import com.twilio.sdk.verbs.Play;
import com.twilio.sdk.verbs.Gather;

/**
 * Servlet implementation class ConnectCall
 */
@WebServlet("/ConnectCall")
public class ConnectCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a dict of people we know.
        HashMap<String, String> callers = new HashMap<String, String>();
        callers.put("+14027380150", "Anup Khanal");
        callers.put("+14028717058", "Kevin Shallenberger");
        callers.put("+14027796293", "Bob Smith");
        callers.put("+16609981890", "Prajol Shakya");
 
        String fromNumber = request.getParameter("From");
        String knownCaller = callers.get(fromNumber);
        String message;
        if (knownCaller == null) {
            // Use a generic message
            message = "Hello Monkey";
        } else {
            // Use the caller's name
            message = "Hello " + knownCaller;
        }
 
        // Create a TwiML response and add our friendly message.
        TwiMLResponse twiml = new TwiMLResponse();
        Say say = new Say(message);
 
        // Play an MP3 for incoming callers.
        //Play play = new Play("http://demo.twilio.com/hellomonkey/monkey.mp3");
 
        Gather gather = new Gather();
        gather.setAction("/CorvisaAPI/handle-key");
        gather.setNumDigits(10);
        gather.setFinishOnKey("#");
        gather.setMethod("POST");
        Say sayInGather = new Say("To speak to a real monkey, press a 10 digit number and then press a hash key.");
        try {
            gather.append(sayInGather);
            twiml.append(say);
            //twiml.append(play);
            twiml.append(gather);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        System.out.println(twiml);
        response.setContentType("application/xml");
        System.out.println(twiml.toXML());
        response.getWriter().print(twiml.toXML());
    }
}
