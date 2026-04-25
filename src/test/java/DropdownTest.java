import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

/*
3. Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
Локатор: By.id(“dropdown”)
 */

public class DropdownTest {

    @Test
    public void dropdown() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        List<WebElement> options1 = driver.findElements(By.cssSelector("#dropdown option"));
        softAssert.assertTrue(options1.size()==3);
        options1.get(1).click();
        softAssert.assertTrue(options1.get(1).isSelected());
        options1.get(2).click();
        softAssert.assertTrue(options1.get(2).isSelected());
        driver.quit();
        softAssert.assertAll();
    }
}
