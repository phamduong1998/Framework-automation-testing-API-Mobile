package stepdefinition;
import config.TodoiesConstant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;

public class TodoistSteps {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MenuPage menuPage = new MenuPage();

    @Given("I login app todoist")
    public void clickToButonContinueEmail() {
        loginPage.loginApp(TodoiesConstant.USER_EMAIL,TodoiesConstant.PASSWORD);
    }

    @When("I should see homescreen is displayed")
    public void verifyHomeScreenIsDisplay(){
        homePage.verifyHomeScreenIsDisplay();
        homePage.clickButtonMenu();

    }

    @And("I create project todoies with name {string}")
    public void createProjectTodoies(String nameProject){
        menuPage.createProject(nameProject);
    }

    @And("I create new task with message {string}")
    public void createTask(String message){
        homePage.createNewTask(message);
    }

    @And("I complete new task")
    public void completeNewTask() {
        homePage.completeTaskCreated();
    }

    @Then("I should see new task completed with message {string}")
    public void verifyNewTaskCompleted(String expectedMessage){
        Assert.assertTrue(homePage.verifyCompleteSucceeded(expectedMessage));
    }
}
