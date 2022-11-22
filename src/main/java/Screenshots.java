import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        //taking screenshot
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("D:/Java/screenshoot.png"));

    }
}
