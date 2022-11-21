package core.api.service;

import config.TodoiesConstant;
import core.api.base.BaseRestApiService;
import core.api.dto.request.ObjectMapperUtils;
import core.api.dto.request.todoistrequest.LoginRequestDTO;
import core.api.dto.response.LoginResponse;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Service;

@Service
public class LoginTodiistService extends BaseRestApiService {

    public LoginTodiistService() {
        super();
        this.setHost(TodoiesConstant.DOMAIN);
    }

    public LoginResponse loginResponse(LoginRequestDTO loginRequestDTO) {
        RequestSpecification spec =
                this.getDefaultRequestBuilder(TodoiesConstant.LOGIN_PATH)
                        .contentType(ContentType.JSON)
                        .body(loginRequestDTO.convertDTOObjectToJSONString());
        Response response = this.dispatchServiceRequest(spec, Method.POST);
        System.out.println(response);
        return ObjectMapperUtils.convertJSONStringToDTOClassByObjectMapper(
                response.body().asString(), LoginResponse.class);
    }

}
