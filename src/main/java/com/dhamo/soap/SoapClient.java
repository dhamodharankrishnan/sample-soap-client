package com.dhamo.soap;

import com.dhamo.soap.client.GetCountryRequest;
import com.dhamo.soap.client.GetCountryResponse;
import feign.Headers;
import feign.RequestLine;

public interface SoapClient {
    @RequestLine("POST")
    @Headers({"SOAPAction: getCountryRequest", "Content-Type: text/xml;charset=UTF-8",
            "Accept: text/xml"})
    String getCountryRequestWithPlainText(String soapBody);

    @RequestLine("POST")
    @Headers({"Content-Type: text/xml;charset=UTF-8"})
    GetCountryResponse getCountryResponseFeignSoapCodec(GetCountryRequest soapBody);

}
