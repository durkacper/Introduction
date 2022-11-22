
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        String name = "Thomas";

        String password = getPassword(driver);
        //or create object of SignInPage2 class and call method (getPassword method can not be static)
        //SignInPage2 pass = new SignInPage2();
        //pass.getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");

        //Log out - using xpath locator 'text'
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Guthier");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Guthier@test.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("500678789");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector(".infoMsg")).getText();

        //Whole String = Please use temporary password 'rahulshettyacademy' to Login.
        //First we split whole String in two parts on first ' character and put them to Array so we have:
        //0th index - Please use temporary password
        //1st index - rahulshettyacademy' to Login.

        //Then we split one more time the 1st index in our Array on ' character, so we have:
        //0th index - rahulshettyacademy
        //1st index -  to Login.

        String[] passwordArray = passwordText.split("'");
        String password = passwordArray[1].split("'")[0]; //accessing to 0th index in second split
        return password;






    }

}
