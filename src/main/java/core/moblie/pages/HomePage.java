package core.moblie.pages;

import core.moblie.AppiumBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


public class HomePage extends AppiumBase {
    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.todoist:id/name")
    private ArrayList<MobileElement> menuList;

    @AndroidFindBy(id = "com.todoist:id/text")
    private ArrayList<MobileElement> taskList;

    @AndroidFindBy(id= "com.todoist:id/bottom_app_bar" )
    private MobileElement bottomAppBar;

    @AndroidFindBy(xpath= "//android.widget.ImageButton[@content-desc=\"Menu\"]" )
    private MobileElement buttonMenu;

    @AndroidFindBy(id= "com.todoist:id/fab" )
    private MobileElement buttonAddTask;

    @AndroidFindBy(id= "android:id/message" )
    private MobileElement messageTask;

    @AndroidFindBy(xpath= "//android.widget.ImageView[@content-desc=\"Add\"]" )
    private MobileElement buttonCreateTask;

    @AndroidFindBy(xpath= "//android.widget.CheckBox[@content-desc=\"Complete\"]" )
    private MobileElement buttonComolete;

    @AndroidFindBy(id= "com.todoist:id/item" )
    private MobileElement selectTask;

    @AndroidFindBy(id = "com.todoist:id/menu_item_complete")
    private MobileElement completeTaskButton;

    @AndroidFindBy(id = "com.todoist:id/snackbar_text")
    private MobileElement completeMsg;


    public void verifyHomeScreenIsDisplay(){
        verifyElementDisplay(bottomAppBar);
    }

    public void clickButtonMenu(){
        selectToElement(buttonMenu);
    }

    public void createNewTask(String message){
        selectToElement(buttonAddTask);
        senkeysToElement(messageTask,message);
        selectToElement(buttonCreateTask);
        driver.hideKeyboard();
    }

    public void completeTaskCreated()  {
        selectToElement(selectTask);
        selectToElement(buttonComolete);
    }

    public boolean verifyCompleteSucceeded(String expectedMessage){
        return completeMsg.getText().equals(expectedMessage);
    }

    public boolean verifyProjectCreated(String namePrj){
        return getElementFromList(menuList,namePrj).getText().equals(namePrj);
    }

    public boolean verifyTaskIsDisplay(String task){
        return getElementFromList(taskList,task).getText().equals(task);
    }

    private MobileElement getElementFromList(ArrayList<MobileElement> list, String elementName) {
        return list.stream().filter(x -> x.getText().equalsIgnoreCase(elementName)).findFirst().get();
    }
}
