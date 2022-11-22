import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BookingExercise {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://booking.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();

        //go to "Loty"
        driver.findElement(By.xpath("(//a[@class='bui-tab__link'])[1]")).click();
        Thread.sleep(3000);

        //radiobutton "W jedną stronę"
        driver.findElement(By.xpath("(//div[@class='css-1yl6p1k'])[2]")).click();


        //"Dokąd lecisz?" - TBC....
        driver.findElement(By.cssSelector("input[placeholder='Dokąd lecisz?']")).sendKeys("BER");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[class='css-bwf0ll']")).click();


        //"Data wylotu"
        driver.findElement(By.cssSelector("td[class*='today']")).click();


        //"Klasa Biznesowa"
        WebElement flightClass = driver.findElement(By.cssSelector(".css-1k0jlfl"));
        Select classDropdown = new Select(flightClass);
        classDropdown.selectByValue("BUSINESS");


        //number of passengers
        driver.findElement(By.cssSelector("div[class='css-vvcyi3'] div div span[class='Flyout-module__root___2Oncm']")).click();
        Thread.sleep(2000);

        for (int i = 1; i < 3; i++) {
            driver.findElement(By.xpath("(//button[@class='css-153jucu'])[1]")).click();
        }
        driver.findElement(By.xpath("//button[@class='css-ya5gr9']")).click();

        //Search
        driver.findElement(By.cssSelector("button[data-testid='searchbox_submit']")).click();

    }
}
