import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckboxExercise {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("input[value='option1']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

        driver.findElement(By.cssSelector("input[value='option1']")).click();
        Assert.assertFalse(driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

        List<WebElement> list = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertEquals(list.size(), 3);


    }
}
