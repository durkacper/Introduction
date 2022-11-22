import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // clicking 4 times button "+" to add passengers
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        //OR use while loop
        //int i = 1;
        //while (i<5){
        //driver.findElement(By.id("hrefIncAdt")).click();
        //i++;
        //}

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
