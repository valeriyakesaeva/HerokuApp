import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {

    @Test
    public void checkFrames() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//*[@href='/iframe']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")));
        WebElement closeButton = driver.findElement(By.xpath("//*[@aria-label='Close']"));
        closeButton.click();
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        Assert.assertEquals(text.getText(), "Your content goes here.");
        driver.quit();
    }
}
