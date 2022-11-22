import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExerciseTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //SCENARIO
        //1. print count number of rows - 11
        //2. print count number of columns - 3
        //3. print the second row of data ("Learn SQL in...")


        //1
        js.executeScript("window.scrollBy(0,500)");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']//tr"));
        int countRows = rows.size();
        System.out.println(countRows);


        //2
        List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table-display']//th"));
        int countColumns = columns.size();
        System.out.println(countColumns);


        //3
        String secondRowValue = driver.findElement(By.xpath("//table[@class='table-display']//tr[3]")).getText();
        System.out.println(secondRowValue);

    }
}
