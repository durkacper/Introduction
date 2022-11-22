import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        //timeout waiting for all elements until there will be visible
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Thomas");
        driver.findElement(By.name("inputPassword")).sendKeys("pass123");
        driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector(".error")).getText();
        System.out.println(driver.findElement(By.cssSelector(".error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        //bad sleep - waiting for element will be in stable state
        Thread.sleep(1000);

        //css
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Guthier");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Guthier@test.com");

        //xpath
        //driver.findElement(By.cssSelector("//input[@placeholder='Email']")).sendKeys("Guthier@test.com");

//        Another way to find element by indexing in xpath and css
//        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("email@test.com");
//        driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("email2@test.com");

        //xpath - from parent to child
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("500678789");
        //css - from parent to child
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector(".infoMsg")).getText());




        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        //the same but using xpath and parent->child and complex path
        //driver.findElement(By.cssSelector("//div[@class='forgot-pwd-btn-container']/button[1]")).click();

        Thread.sleep(1000);

        //Correct login process (but without grabbing password from previous step)
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Guthier");
        //Case when "placeholder" attribute is dynamic and last four characters are changing every page load.
        //Then we use regular expression (*=) to find attribute by first four static chars "pass"
        driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("#chkboxOne")).click();
        driver.findElement(By.cssSelector(".signInBtn")).click();
    }
}

