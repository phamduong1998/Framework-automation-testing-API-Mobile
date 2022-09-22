package stepdefinition;

import core.AppiumBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.net.MalformedURLException;
public class ServiceHooks {
    AppiumBase appiumBase = new AppiumBase();
    @Before
    public void initTest() throws MalformedURLException {
        appiumBase.createDriver();
    }

    @After
    public void afterHooks(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(((TakesScreenshot)AppiumBase.driver).getScreenshotAs(OutputType.BYTES),
                    "image/png", "imageDemo");
        }
        appiumBase.tearDown();
    }
}
