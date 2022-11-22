import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitExercise2 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String user = "rahulshettyacademy";
        String pass = "learning";

        driver.get("https://rahulshettyacademy.com/loginpagePractise");

        driver.findElement(By.cssSelector("#username")).sendKeys(user);
        driver.findElement(By.cssSelector("#password")).sendKeys(pass);
        driver.findElement(By.xpath("//label[2]/span[@class='checkmark']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));
        driver.findElement(By.cssSelector("#okayBtn")).click();

        WebElement dropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);

        driver.findElement(By.cssSelector("#terms")).click();
        driver.findElement(By.cssSelector("#signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-info']")));
        List<WebElement> list = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
        for (int i = 0; i < list.size(); i++) {
            list.get(i).click();
        }

        driver.findElement(By.cssSelector(".btn-primary")).click();

    }
}
