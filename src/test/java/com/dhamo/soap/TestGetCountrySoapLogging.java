package com.dhamo.soap;

import feign.Feign;
import feign.Logger;
import feign.hc5.ApacheHttp5Client;
import feign.slf4j.Slf4jLogger;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class TestGetCountrySoapLogging extends TestGetCountry{

    @Test
    public void testGetCountry(){

        SoapClient client = Feign.builder()
                .client(new ApacheHttp5Client())
                .logger(new Slf4jLogger(SoapClient.class))
                .logLevel(Logger.Level.FULL)
                .target(SoapClient.class, "http://localhost:8080/ws/");

        String soapResponse= null;
        try {
            soapResponse = client.getCountryRequestWithPlainText(soapPayload());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------RESPONSE---------");
        System.out.println(soapResponse);
        System.out.println("----------RESPONSE---------");
        assertNotNull(soapResponse);
    }
}
