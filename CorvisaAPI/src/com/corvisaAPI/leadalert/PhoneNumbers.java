package com.corvisaAPI.leadalert;

public class PhoneNumbers {
    public static String getTwilioPhoneNumber() {
        return System.getenv("TWILIO_NUMBER");
    }

    public static String getAgentPhoneNumber() {
        return System.getenv("AGENT_PHONE_NUMBER");
    }
}