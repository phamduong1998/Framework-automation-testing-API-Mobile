package stepdefinition;

import config.TodoiesConstant;
import core.api.dto.request.todoistrequest.AddNewTaskRequest;
import core.api.dto.request.todoistrequest.CreateNewProjectRequest;
import core.api.dto.request.todoistrequest.LoginRequestDTO;
import core.api.dto.response.AddNewTaskResponse;
import core.api.dto.response.CreateNewProjectResponse;
import core.api.dto.response.GetProjectResponse;
import core.api.dto.response.LoginResponse;
import core.api.service.LoginTodiistService;
import core.api.service.ProjectTodoistService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.List;

public class ApiTodoistSteps {

    LoginTodiistService todiistService = new LoginTodiistService();
    ProjectTodoistService projectTodoistService = new ProjectTodoistService();
    String token ;
    String prjID;
    String idTask;


    @Given("I login with api todoist")
    public void loginTotoist(){
        LoginResponse loginResponse = todiistService.loginResponse(createLoginRequestDTO());
        token = loginResponse.getToken();
    }

    @Given("I get projects todoist")
    public void getProjects(){
        List<GetProjectResponse> getProjectResponse = projectTodoistService.getProjectResponse(token);
    }

    @And("I create new project with name {string}")
    public void createNewProject(String namePrj){
        CreateNewProjectRequest createNewProjectRequest = new CreateNewProjectRequest();
        createNewProjectRequest.setName(namePrj);
        CreateNewProjectResponse createNewProjectResponse = projectTodoistService.createNewProjectResponse(createNewProjectRequest,token);
        prjID = createNewProjectResponse.getId();
    }

    @And("I add new task with content {string}")
    public void addNewTask(String content){
        AddNewTaskRequest addNewTaskRequest = new AddNewTaskRequest();
        addNewTaskRequest.setContent("content");
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
}
