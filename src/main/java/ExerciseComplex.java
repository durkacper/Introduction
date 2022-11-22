import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class ExerciseComplex {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        driver.manage().window().maximize();

        //1. navigate to www.qaclickacademy.com/practice.php
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");


        //2. select one checkbox and grab the text
        driver.findElement(By.id("checkBoxOption1")).click();
        String checkBoxValue = driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset//label[1]")).getText().toLowerCase(Locale.ROOT);


        //3. select from Dropdown the same option which is selected in Checkbox (use variable from 2nd step)
        WebElement dropdownList = driver.findElement(By.cssSelector("#dropdown-class-example"));
        Select dropdown = new Select(dropdownList);
        dropdown.selectByValue(checkBoxValue);


        //4. Enter the same variable into "Enter Your Name" box in Switch To Alert Complete section
        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(checkBoxValue);


        //5. click Alert and verify that text grabbed in step 2 is present in alert popup window
        WebElement alertButton = driver.findElement(By.cssSelector("input[id='alertbtn']"));
        action.moveToElement(alertButton).click().build().perform();

        String alertText = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];

        Assert.assertEquals(alertText, checkBoxValue);

        System.out.println(checkBoxValue);
        System.out.println(alertText);

    }
}
