package core.api.service;

import config.TodoiesConstant;
import core.api.base.BaseRestApiService;
import core.api.dto.request.ObjectMapperUtils;
import core.api.dto.request.todoistrequest.AddNewTaskRequest;
import core.api.dto.request.todoistrequest.CreateNewProjectRequest;
import core.api.dto.response.AddNewTaskResponse;
import core.api.dto.response.CreateNewProjectResponse;
import core.api.dto.response.GetProjectResponse;
import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class ProjectTodoistService extends BaseRestApiService {

    public ProjectTodoistService() {
        super();
        this.setHost(TodoiesConstant.DOMAIN_PROJECT_TODOIST);
    }

    public List<GetProjectResponse> getProjectResponse(String token) {
        RequestSpecification spec =
                this.getDefaultRequestBuilder(TodoiesConstant.PROJECTS_PATH)
                        .contentType(ContentType.JSON)
                        .headers("Authorization","Bearer "+token);
        Response response = this.dispatchServiceRequest(spec, Method.GET);
        System.out.println(response.body().asString());
        return ObjectMapperUtils.convertResponseToGenericDTOObject(
                response.body().asString(), new TypeReference<>() {});
    }

    public CreateNewProjectResponse createNewProjectResponse(CreateNewProjectRequest createNewProjectRequest, String token) {
        RequestSpecification spec =
                this.getDefaultRequestBuilder(TodoiesConstant.PROJECTS_PATH)
                        .contentType(ContentType.JSON)
                        .headers("Authorization","Bearer "+token)
                        .body(createNewProjectRequest.convertDTOObjectToJSONString());
        Response response = this.dispatchServiceRequest(spec, Method.POST);
        System.out.println(response.body().asString());
        return ObjectMapperUtils.convertJSONStringToDTOClassByObjectMapper(
                response.body().asString(), CreateNewProjectResponse.class);
    }

    public AddNewTaskResponse addNewTaskResponse(AddNewTaskRequest addNewTaskRequest, String token) {
        RequestSpecification spec =
                this.getDefaultRequestBuilder(TodoiesConstant.PROJECTS_PATH)
                        .contentType(ContentType.JSON)
                        .headers("Authorization","Bearer "+token)
                        .body(addNewTaskRequest.convertDTOObjectToJSONString());
        Response response = this.dispatchServiceRequest(spec, Method.POST);
        System.out.println(response.body().asString());
        return ObjectMapperUtils.convertJSONStringToDTOClassByObjectMapper(
                response.body().asString(), AddNewTaskResponse.class);
    }


    public Response completingATask(String id, String token){
        RequestSpecification spec =
                this.getDefaultRequestBuilder(String.format("%s/%s",TodoiesConstant.PROJECTS_PATH,id))
                        .headers("Authorization","Bearer "+token);
        return this.dispatchServiceRequest(spec, Method.POST);
    }

    public Response deleteProject(String id, String token){
        RequestSpecification spec =
                this.getDefaultRequestBuilder(String.format("%s/%s",TodoiesConstant.PROJECTS_PATH,id))
                .headers("Authorization","Bearer "+token);
        return this.dispatchServiceRequest(spec, Method.DELETE);
    }





}
