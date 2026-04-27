import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.HashMap;

/*
8. * Notification Messages - кликнуть на кнопку, дождаться появления нотификации,
проверить соответствие текста ожиданиям
 */

public class NotificationMessagesTest {
    @Test
    public void notificationMessages() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.cssSelector("a[href='/notification_message']")).click();
        WebElement message = driver.findElement(By.cssSelector("#flash"));
        String text = message.getText();
        Assert.assertTrue(
                text.contains("Action successful")
                || text.contains("Action unsuccessful, please try again"));
        driver.quit();
}
}