package core.moblie;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumBase {

    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public void createDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","android");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("appActivity","com.todoist.alias.HomeActivityDefault");
        capabilities.setCapability("appPackage","com.todoist");
        capabilities.setCapability("newCommandTimeout",700);

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver,20);
    }


    public void selectToElement(MobileElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void senkeysToElement(MobileElement element, String value){
//        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    public boolean verifyElementDisplay(MobileElement element){
//        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }


    public void swipe(int startx, int starty, int endx, int endy) {
        new TouchAction(driver).longPress(PointOption.point(startx, starty))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();
    }

    public void swipeMobileUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = (int) (size.height * 0.8);
        int endy = (int) (size.height * 0.1);
        int starx = size.width / 2;
        swipe(starx, starty, starx, endy);
    }

    public void scrollMenu(MobileElement element) {
        Dimension size = element.getSize();
        int starty = (int) (element.getLocation().getY() + Math.round(size.getHeight() * 0.9));
        int endy = (int) (element.getLocation().getY() + Math.round(size.getHeight() * 0.1));
        int starx = element.getLocation().getX() + (size.getWidth()/2);
        swipe(starx, starty, starx, endy);
    }

    public void scrollToElement(String locator) {
        WebElement element = null;
        boolean check = false;
        do {
            try {
                element = driver.findElement(By.xpath(locator));
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (element == null) {
                swipeMobileUp();
            } else {
                check = true;
            }

        } while (!check);

    }

    public void tearDown() {
        driver.closeApp();
    }
}
