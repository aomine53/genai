package com.genai.ecommerce.service;

import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;

@Service
public class TwilioService {

//    @Value("${twilio.account_sid}")
    private String accountSid="AC51245a828af661a6f6c3ba7ee5256eed";
//
//    @Value("${twilio.auth_token}")
    private String authToken="f2131ed5aaa8b4a1c12cbfed4e964e40";

    public void sendOTP(String phoneNumber, String otp) {
        Twilio.init(accountSid, authToken);

        Message  message = Message.creator(
                new PhoneNumber("+91"+phoneNumber),
                new PhoneNumber("+1 513 488 1759"),
                "Your OTP is " + otp).create();
    }
}
