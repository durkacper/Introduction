import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

public class ActionsDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //create object of Action class to be able to call methods
        Actions actions = new Actions(driver);

        //navigate to website
        driver.get("https://www.amazon.com/");

        //type text into search box with capital letters:
        //scenario: go to search window --> click --> press and hold Shift button --> type text --> double click to select the text
        actions.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();


        //move mouse to specific WebElement using Action method and do Right Click
        //we must .build() the step and then get it ready to execute using .perform()
        //code:
        actions.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();

        //to do code more clear we can define WebElement as variable:
//        WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
        //and then code looks like:
//        actions.moveToElement(move).contextClick().build().perform();



    }
}
