package com.corvisaAPI.CallForward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.verbs.Gather;
import com.twilio.sdk.verbs.Play;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 * Servlet implementation class CallForward
 */
@WebServlet("/CallForward")
public class CallForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallForward() {
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

        Gather gather = new Gather();
        gather.setAction("menu/show");
        gather.setNumDigits(1);

        Play play = new Play("http://howtodocs.s3.amazonaws.com/et-phone.mp3");
        play.setLoop(3);

        try {
            gather.append(play);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }

        TwiMLResponse twiMLResponse = new TwiMLResponse();
        try {
            twiMLResponse.append(gather);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/xml");
        response.getWriter().write(twiMLResponse.toXML());
	}

}
