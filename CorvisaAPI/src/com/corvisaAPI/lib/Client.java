package com.corvisaAPI.lib;

import com.corvisaAPI.exceptions.UndefinedEnvironmentVariableException;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private AppSetup appsetup;
    private TwilioRestClient client;

    public Client() throws UndefinedEnvironmentVariableException {
        this.appsetup = new AppSetup();
        String accountSid = this.appsetup.getAccountSid();
        String authToken = this.appsetup.getAuthToken();
        this.client = new TwilioRestClient(accountSid, authToken);
    }

    public Client(TwilioRestClient client, AppSetup appsetup) {
        this.appsetup = appsetup;
        this.client = client;
    }

    public void sendMessage(String to, String message, String mediaUrl) throws UndefinedEnvironmentVariableException {
        List<NameValuePair> params = getParams(to, message, mediaUrl);

        try {
            this.client.getAccount().getMessageFactory().create(params);
        } catch (TwilioRestException exception) {
            exception.printStackTrace();
        }
    }

    private List<NameValuePair> getParams(String to, String message, String mediaUrl) throws UndefinedEnvironmentVariableException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("Body", message));
        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("From", this.appsetup.getTwilioNumber()));
        params.add(new BasicNameValuePair("MediaUrl", mediaUrl));

        return params;
    }
}
