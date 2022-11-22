import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Checkbox {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //select Checkbox and verify that it is selected
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //count number of all checkboxes
        List<WebElement> checkboxesList = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkboxesList.size());

        Assert.assertEquals(checkboxesList.size(), 6);

    }

}
