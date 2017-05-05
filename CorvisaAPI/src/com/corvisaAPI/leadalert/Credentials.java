package com.corvisaAPI.leadalert;

public class Credentials {
    public static String getTwilioAccountSid() {
        return System.getenv("TWILIO_ACCOUNT_SID");
    }

    public static String getTwilioAuthToken() {
        return System.getenv("TWILIO_AUTH_TOKEN");
    }
}
