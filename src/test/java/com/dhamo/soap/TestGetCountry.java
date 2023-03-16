package com.dhamo.soap;

import com.dhamo.soap.SoapClient;
import feign.Feign;
import feign.hc5.ApacheHttp5Client;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNotNull;

public class TestGetCountry {

    @Test
    public void givenSOAPPayload_whenRequest_thenReturnSOAPResponse() throws Exception {
        String successMessage="Success! Created the user with id";
        SoapClient client = Feign.builder()
                .client(new ApacheHttp5Client())
                .target(SoapClient.class, "http://localhost:8080/ws");

//        assertDoesNotThrow(() -> client.getCountryRequestWithPlainText(soapPayload()));

        String soapResponse= client.getCountryRequestWithPlainText(soapPayload());
        System.out.println("----------RESPONSE---------");
        System.out.println(soapResponse);
        System.out.println("----------RESPONSE---------");
        assertNotNull(soapResponse);
    }

    public String soapPayload() throws IOException {
        File requestXml = new File("src/test/resources/request.xml");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(requestXml));
        byte[] byteArrayInputStream = bis.readAllBytes();
        String sb = new String(byteArrayInputStream);
        System.out.println("----------REQUEST---------");
        System.out.println(sb);
        System.out.println("----------REQUEST---------");
        return sb.toString()    ;

    }
}
