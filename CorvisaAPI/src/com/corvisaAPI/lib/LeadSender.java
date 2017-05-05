package com.corvisaAPI.lib;

import com.corvisaAPI.leadalert.Credentials;
import com.corvisaAPI.leadalert.PhoneNumbers;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class LeadSender {
    private final TwilioRestClient client;

    public LeadSender() {
        client = new TwilioRestClient(
                Credentials.getTwilioAccountSid(),
                Credentials.getTwilioAuthToken());
    }

    public LeadSender(TwilioRestClient client) {
        this.client = client;
    }

    public void send(String message) throws TwilioRestException {
        List<NameValuePair> params = buildParams(message);

        client.getAccount().getMessageFactory().create(params);
    }

    private List<NameValuePair> buildParams(String message) {
        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("To", PhoneNumbers.getAgentPhoneNumber()));
        params.add(new BasicNameValuePair("From", PhoneNumbers.getTwilioPhoneNumber()));
        params.add(new BasicNameValuePair("Body", message));

        return params;
    }
}