import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {

    @Test
    public void checkFileUploadText() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/1.txt");
        driver.findElement(By.xpath("//*[@type='file']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        String uploadFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(uploadFileName, file.getName());
        driver.quit();
    }
}
