package com.corvisaAPI.leadalert;

import com.corvisaAPI.lib.LeadSender;
import com.twilio.sdk.TwilioRestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NotificationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LeadSender leadSender;

    @SuppressWarnings("unused")
    public NotificationsServlet() {
        this(new LeadSender());
    }

    public NotificationsServlet(LeadSender leadSender) {
        this.leadSender = leadSender;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String houseTitle = request.getParameter("houseTitle");
        String housePrice = request.getParameter("housePrice");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");

        String formattedMessage = formatMessage(houseTitle, name, phone, message);
        request.setAttribute("houseTitle", houseTitle);
        request.setAttribute("housePrice", housePrice);
        try {
        	leadSender.send(formattedMessage);
        	request.setAttribute("houseTitle", houseTitle);
            request.setAttribute("success", "Thanks! An agent will be contacting you shortly.");
        } catch (TwilioRestException e) {
            e.printStackTrace();
            request.setAttribute("error", "Oops! There was an error. Please try again.");
        }

        request.getRequestDispatcher("secure/leadalert.jsp").forward(request, response);
    }


    private String formatMessage(String houseTitle, String name, String phone, String message) {
        return String.format("New lead received for %s. Call %s at %s. Message: %s",
                houseTitle, name, phone, message);
    }
}
