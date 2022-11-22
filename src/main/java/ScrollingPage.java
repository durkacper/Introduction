import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class ScrollingPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //SCENARIO:
        // 1. scroll down page
        // 2. scroll down table and grab all "Amount" values from it
        // 3. compare sum of grabbed values with "Total Amount Collected" under the table


        //must create JavaScript executor to do window scrolling (Selenium does not have option scroll)
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // 1
        // HINT - first we can try to use javascript code in browser Console to find proper value (0, 500)
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

        // 2. Scroll only table inside the page
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        // HINT - to scroll horizontal use scrollLeft method instead of scrollTop

        //Grab all amount values from table
        List<WebElement> amountValues = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));

        //sum all values - start from zero and add values during iteration
        int sum = 0;

        for (int i = 0; i < amountValues.size(); i++) {
            // need to converse String to Integer because values are text
            sum = sum + Integer.parseInt(amountValues.get(i).getText());

        }

        System.out.println(sum);

        //Comparison
        int totalAmountCollected = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum, totalAmountCollected);
    }
}
