import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExercise {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TO DO: switch to frame nested inside the frame and print out the content

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //double switch - first to parent frame and next to nested frame
//        driver.switchTo().frame("frame-top");
        //OR
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));


//        driver.switchTo().frame("frame-middle");
        //OR
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));



        System.out.println(driver.findElement(By.cssSelector("#content")).getText());

    }
}
