package com.genai.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPGeneratorService {

    public static String generateOTP() {
        int otpLength = 6;
        Random random = new Random();
        StringBuilder otp=new StringBuilder();
        for(int i=0;i<otpLength;i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    public static void main(String[] args) {
        System.out.println("Generated OTP is:"+generateOTP());
    }
}

