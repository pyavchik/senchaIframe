import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;
    private By usernameFld = By.cssSelector(ta("usernameFld", "#textfield-1028-inputEl"));


    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("http://examples.sencha.com/extjs/6.6.0/examples/admin-dashboard/#forms");
        Thread.sleep(3000);
        driver.switchTo().frame("examples-iframe");
        driver.findElement(usernameFld).sendKeys("Username");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}