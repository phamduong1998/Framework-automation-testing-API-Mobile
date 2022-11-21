package stepdefinition;

import config.TodoiesConstant;
import core.BaseSteps;
import core.api.dto.request.todoistrequest.AddNewTaskRequest;
import core.api.dto.request.todoistrequest.CreateNewProjectRequest;
import core.api.dto.request.todoistrequest.LoginRequestDTO;
import core.api.dto.response.*;
import core.api.service.LoginTodiistService;
import core.api.service.ProjectTodoistService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import settings.ScenarioContext;


import java.util.List;

public class ApiTodoistSteps extends BaseSteps {

//    LoginTodiistService loginTodiistService = new LoginTodiistService();
    ProjectTodoistService projectTodoistService = new ProjectTodoistService();
    String token ;
    String prjID;
    String idTask;


    @Given("I login with api todoist")
    public void loginTotoist(){
        LoginResponse loginResponse = loginTodiistService.loginResponse(createLoginRequestDTO());
        token = loginResponse.getToken();
    }

    @Given("I get projects todoist")
    public void getProjects(){
        List<GetProjectResponse> getProjectResponse = projectTodoistService.getProjectResponse(token);
    }

    @Then("I should see task rerutn in response with content {string}")
    public void verifyTaskCreated(String content){
        List<GetProjectResponse> getListTaskResponse = projectTodoistService.getListTask(token);
        GetProjectResponse detailTask = getListTaskResponse.stream().filter(task -> task.getContent().equals(content)).findFirst().get();
        Assert.assertEquals(detailTask.getContent(),content);
    }

   @And("I create new project with {string} API")
    public void createNewProject(String namePrj){
        CreateNewProjectRequest createNewProjectRequest = new CreateNewProjectRequest();
        createNewProjectRequest.setName(namePrj);
        CreateNewProjectResponse createNewProjectResponse = projectTodoistService.createNewProjectResponse(createNewProjectRequest,token);
        prjID = createNewProjectResponse.getId();
    }

    @And("I add new task with content {string}")
    public void addNewTask(String content){
        AddNewTaskRequest addNewTaskRequest = new AddNewTaskRequest();
        addNewTaskRequest.setProjectId(prjID);
        AddNewTaskResponse addNewTaskResponse = projectTodoistService.addNewTaskResponse(addNewTaskRequest,content);
        idTask = addNewTaskResponse.getId();
    }

    @And("I compete task")
    public void completeTask(){
        projectTodoistService.completingATask(idTask,token);
    }

    @And("I delete project")
    public void deleteProject(){
        projectTodoistService.deleteProject(prjID,token);
    }

    private LoginRequestDTO createLoginRequestDTO(){
        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setEmail(TodoiesConstant.USER_EMAIL);
        loginRequestDTO.setPassword(TodoiesConstant.PASSWORD);
        return loginRequestDTO;
    }

    @And("I get id task created with {string} API")
    public void getIdTask(String content){
        getIDTask(content);
    }

    @And("I reopen task with {string} API")
    public void reopenTask(String content ){
        projectTodoistService.reopenTask(getIDTask(content),token);
    }
    private String getIDTask(String content){
        List<ListTasksActiveResponse> listTasksActiveResponses = projectTodoistService.listTasksActiveResponse(token);
        ListTasksActiveResponse detailTaskActive = listTasksActiveResponses.stream().filter(task -> task.getContent().equals(content)).findFirst().get();
        return detailTaskActive.getId();
    }


}
