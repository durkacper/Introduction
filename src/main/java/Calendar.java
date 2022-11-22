import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("button[id='ez-accept-all']")).click();

        //1. select month - April
        driver.findElement(By.cssSelector("input[id='travel_date']")).click();

        // exclamation mark (!) is negation
        // so do wile false (click)... when true - stop
        while (!driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("div[class='datepicker-days'] [class='next']")).click();
        }
        //TIP: while(true) - while loop will keep on executing until it becomes false



        //2. select day - January 23 (today is Jan 17)
        //create list of all dates in specific month
        List<WebElement> listOfDays = driver.findElements(By.cssSelector(".day"));

        //get text of all dates in month
        for (int i = 0; i < listOfDays.size(); i++) {
            String day = driver.findElements(By.cssSelector(".day")).get(i).getText();

            //if date from list is equal to our date then click
            if (day.equalsIgnoreCase("23")) {
                driver.findElements(By.cssSelector(".day")).get(i).click();
                break;
            }

        }

    }
}
