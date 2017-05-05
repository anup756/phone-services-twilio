package com.corvisaAPI.CallForward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.twilio.sdk.verbs.*;
/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
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

        TwiMLResponse twiMLResponse = null;
        try {
            switch (selectedOption) {
                case "1":
                    twiMLResponse = getReturnInstructions();
                    break;
                case "2":
                    twiMLResponse = getPlanets();
                    break;
                default:
                    twiMLResponse = com.corvisaAPI.CallForward.Redirect.toMainMenu();
            }
        } catch (TwiMLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/xml");
        response.getWriter().write(twiMLResponse.toXML());
	}
	private TwiMLResponse getReturnInstructions() throws TwiMLException {

        TwiMLResponse response = new TwiMLResponse();
        Say firstPhrase = new Say(
                "This is Dumbsum Starship! To get to your extraction point, get on your bike and go down " +
                "the street. Then Left down an alley. Avoid the police cars. Turn left " +
                "into an unfinished housing development. Fly over the roadblock. Go " +
                "passed the moon. Soon after you will see your mother ship.");
        firstPhrase.setLanguage("alice");
        firstPhrase.setLanguage("en-GB");

        Say secondPhrase = new Say(
                "Thank you for calling the Dumbsum's ET Phone Home Service - the " +
                "adventurous alien's first choice in intergalactic travel");

        response.append(firstPhrase);
        response.append(secondPhrase);
        response.append(new Hangup());

        return response;
    }
	private TwiMLResponse getPlanets() throws TwiMLException {

        Gather gather = new Gather();
        gather.setAction("/commuter/connect");
        gather.setNumDigits(1);

        Say phrase = new Say(
                "To call the planet Broh doe As O G, press 2. To call the planet " +
                "DuhGo bah, press 3. To call an oober asteroid to your location, press 4. To " +
                "go back to the main menu, press the star key ");
        phrase.setVoice("alice");
        phrase.setLanguage("en-GB");
        phrase.setLoop(3);

        gather.append(phrase);

        TwiMLResponse response = new TwiMLResponse();
        response.append(gather);

        return response;
    }

}
