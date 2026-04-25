import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;


public class CheckboxesTest {

    @Test
    public void checkboxes() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> element = driver.findElements(By.cssSelector("[type=checkbox]"));
        WebElement checkbox = element.get(0);
        WebElement checkbox2 = element.get(1);
        softAssert.assertFalse(checkbox.isSelected());
        checkbox.click();
        softAssert.assertTrue(checkbox.isSelected());
        softAssert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        softAssert.assertFalse(checkbox2.isSelected());
        driver.quit();
        softAssert.assertAll();
    }
}
