package com.corvisaAPI.notification.filter;

import com.corvisaAPI.notification.Administrator;
import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.corvisaAPI.lib.Client;
import com.corvisaAPI.notification.Repository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ErrorFilter", urlPatterns = {"/launch"})
public class ErrorFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String errorMessage = "Generic error message";
        try {
            chain.doFilter(request, response);
        } catch (Throwable throwable) {
            String message = customMessage(throwable.getMessage());
            String mediaUrl = "http://goo.gl/ObTXdX";

            // Send a message to the administrators when something went unexpectedly wrong.
            Administrator[] administrators = new Repository().getAdministrators();
            for (Administrator administrator : administrators) {
                try {
					new Client().sendMessage(administrator.getPhoneNumber(), message, mediaUrl);
				} catch (UndefinedEnvironmentVariableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }

        Object error = errorMessage;
        request.setAttribute("error", error);
        //request.getRequestDispatcher("error.jsp").forward(request, response);
      request.getRequestDispatcher("secure/error.jsp").forward(request, response);
    }

    public void destroy() {
    }

    private String customMessage(String exceptionMessage) {
        return String.format("It appears the server is having Exception: %s " +
                        "Go to: http://newrelic.com for more details. " +
                        "Image URL: http://goo.gl/ObTXdX",
                exceptionMessage);
    }
}
