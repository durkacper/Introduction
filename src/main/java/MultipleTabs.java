import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultipleTabs {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Scenario:
        //1. open URL1
        //2. open URL2 and getText of first course name
        //3. go to URL1 and paste the text to Name field

        //1
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //2
        driver.switchTo().newWindow(WindowType.TAB);

        //mechanism from "Handling multiple windows lesson"...
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentWindowId = iterator.next();
        String childWindowId = iterator.next();
        driver.switchTo().window(childWindowId);

        //now driver is in second tab...
        driver.get("https://rahulshettyacademy.com/");

        //get text of first course name
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        //3
        driver.switchTo().window(parentWindowId);
        WebElement nameField = driver.findElement(By.xpath("//div/input[@name='name']"));
        nameField.sendKeys(courseName);

        //Capture screenshot of field "Name" (to check that course name is pasted)
        File file = nameField.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("screenshot.png"));

        //driver.quit();

        }


    }

