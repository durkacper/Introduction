import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);

        driver.get("https://jqueryui.com/droppable/");

        //switch to frame with WebElement - now all activities will affect only WebElements inside the frame
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        //drag and drop
        actions.dragAndDrop(driver.findElement(By.cssSelector("#draggable")), driver.findElement(By.cssSelector("#droppable"))).build().perform();
        // OR we can define source and target WebElements in variables and use them in code:
//        WebElement source = driver.findElement(By.cssSelector("#draggable"));
//        WebElement target = driver.findElement(By.cssSelector("#droppable"));
//        actions.dragAndDrop(source, target).build().perform();


        //IMPORTANT: switch out from frame
        driver.switchTo().defaultContent();
    }

}
