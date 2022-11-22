import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //go to parent window
        driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");

        //click link and new tab will be open
        //TIP: window and tab are the same objects for Selenium
        driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();

        //move to child tab:
        //first create Set object to get and collect IDs of parent and child tabs
        Set<String> tabs = driver.getWindowHandles();    // created Set collection with [parentID, childID]

        //extract ID values from Set collection and grab them to variables:
        Iterator<String> iterator = tabs.iterator();
        String parentID = iterator.next();  //0 index
        String childID = iterator.next();   //1 index

        //then switch to child tab
        driver.switchTo().window(childID);

        //get Username from parent window (email value)
        String username = driver.findElement(By.xpath("//div/p/strong/a")).getText();
        //or use split method to get username:
//        String usernameID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        //switch back to parent tab
        driver.switchTo().window(parentID);

        //type Username
        driver.findElement(By.cssSelector("#username")).sendKeys(username);


    }
}
