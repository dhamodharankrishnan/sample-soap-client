package com.dhamo.soap;


import com.dhamo.soap.client.GetCountryRequest;
import com.dhamo.soap.client.GetCountryResponse;
import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import org.junit.Test;


import static org.junit.Assert.*;

public class TestGetCountryFeignSoapCodec {
    @Test
    public void whenSoapRequest_thenReturnSoapResponse() {
        JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8").build();
        SoapClient client = Feign.builder()
                .encoder(new SOAPEncoder(jaxbFactory))
                .decoder(new SOAPDecoder(jaxbFactory))
                .target(SoapClient.class, "http://localhost:8080/ws/");
        GetCountryRequest countryRequest = new GetCountryRequest();
        countryRequest.setName("Spain");
        GetCountryResponse countryResponse = client.getCountryResponseFeignSoapCodec(countryRequest);
        assertNotNull(countryResponse);
        assertNotNull(countryResponse.getCountry());
        assertEquals(countryResponse.getCountry().getCapital(), "Madrid");
        System.out.println(countryResponse.getCountry().getCapital());
    }
}
