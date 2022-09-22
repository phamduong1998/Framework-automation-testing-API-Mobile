package pages;

import core.moblie.AppiumBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends AppiumBase {
    public MenuPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id= "com.todoist:id/add" )
    private MobileElement addProject;

    @AndroidFindBy(id= "com.todoist:id/name" )
    private MobileElement inputNameProject;

    @AndroidFindBy(id= "com.todoist:id/menu_form_submit" )
    private MobileElement submitCreateProject;


    public void createProject(String nameProject){
        selectToElement(addProject);
        senkeysToElement(inputNameProject,nameProject);
        selectToElement(submitCreateProject);
        driver.hideKeyboard();
    }
}
