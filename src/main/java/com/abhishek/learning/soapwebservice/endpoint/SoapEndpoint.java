package com.abhishek.learning.soapwebservice.endpoint;

import com.abhishek.learning.producingwebservice.GetUserRequest;
import com.abhishek.learning.producingwebservice.GetUserResponse;
import com.abhishek.learning.producingwebservice.User;
import com.abhishek.learning.soapwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SoapEndpoint {

    @Autowired
    UserService userService;

    @PayloadRoot(namespace = "http://abhishek.com/learning/producingwebservice",localPart ="getUserRequest" )
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest getUserRequest){

        GetUserResponse response = new GetUserResponse();
        User user = userService.getUser(getUserRequest.getName());
        response.setUser(user);
        return response;

    }
}
