import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdownExercise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
        for (WebElement listElement : list) {
//            System.out.println(listElement.getText());
            if (listElement.getText().equalsIgnoreCase("India")) {
                listElement.click();
                break;
            }
        }
    }
}
