package pages;

import core.moblie.AppiumBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AppiumBase {
    public LoginPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id= "com.todoist:id/btn_welcome_email" )
    private MobileElement butonContinueWithEmail;

    @AndroidFindBy(id= "com.todoist:id/email_exists_input" )
    private MobileElement inputUserEmail;

    @AndroidFindBy(id= "com.todoist:id/log_in_password" )
    private MobileElement inputPassWord;

    @AndroidFindBy(id= "com.todoist:id/btn_continue_with_email" )
    private MobileElement buttonContinueWithEmail;

    @AndroidFindBy(id= "com.todoist:id/btn_log_in" )
    private MobileElement butonLogin;


     public void loginApp(String userEmail, String password){
         selectToElement(butonContinueWithEmail);
         senkeysToElement(inputUserEmail,userEmail);
         selectToElement(buttonContinueWithEmail);
         senkeysToElement(inputPassWord,password);
         selectToElement(butonLogin);
         driver.hideKeyboard();
     }


}
