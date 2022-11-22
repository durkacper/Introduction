import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alerts {

    public static void main(String[] args) {

        String text = "kacper";

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        //switch to Alert window with one button: OK (positive)
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(text);
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        //switch to Alert window with two buttons: OK and Cancel.
        //Choose Cancel (negative)
        driver.findElement(By.cssSelector("#confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


    }
}
