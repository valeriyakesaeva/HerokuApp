import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class InputsTest {

    @Test
    public void inputs() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Hi, Анна");
        String value = input.getAttribute("value");
        softAssert.assertTrue(value.isEmpty());
        input.clear();
        input.sendKeys("10");
        value = input.getAttribute("value");
        softAssert.assertEquals(value,"10");
        input.sendKeys(Keys.ARROW_UP);
        value = input.getAttribute("value");
        softAssert.assertEquals(value,"11");
        input.sendKeys(Keys.ARROW_DOWN);
        value = input.getAttribute("value");
        softAssert.assertEquals(value,"10");
        driver.quit();
        softAssert.assertAll();
    }
}
