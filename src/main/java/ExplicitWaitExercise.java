import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExercise {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("div[id='start'] button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));

        System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());




    }
}
