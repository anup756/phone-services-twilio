package com.corvisaAPI.message;

import java.util.Map;
import java.util.HashMap;
 
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
public class SmsSender {
 
    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "ACd8c0aaf51f435282be65408b610e6692";
    public static final String AUTH_TOKEN = "b3c78bde1a764b110d5a066e2b3f248a";
 
    public static void main(String[] args) throws TwilioRestException {
 
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
        Account account = client.getAccount();
 
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+14027380150")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From", "+14024152620")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", "Where's Wallace?"));
        Message sms = messageFactory.create(params);
    }
}
