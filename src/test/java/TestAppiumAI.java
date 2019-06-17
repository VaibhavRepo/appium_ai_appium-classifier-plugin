import io.appium.java_client.MobileBy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestAppiumAI {


    private static AndroidDriver driver;

    @Test
    public void installTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "4b7496d00305");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "uiautomator2");

        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("noReset", "false");


        capabilities.setCapability("appPackage", "com.android.settings");
        capabilities.setCapability("appActivity","com.android.settings.MainSettings");

        HashMap<String, String> customFindModules = new HashMap<String, String>();
        customFindModules.put("ai", "test-ai-classifier");

        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //driver.findElement(MobileBy.custom("ai:search")).click();
        driver.findElement(MobileBy.custom("ai:bluetooth")).click();
        driver.quit();

    }
}
