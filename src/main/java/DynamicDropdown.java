import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // //a[@value='BLR'] - xpath for Bengaluru
        // //a[@value='MAA']  - xpath for Chennai

        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        // (//a[@value='MAA'])[2] - add index [2] because first MAA value will be find in FROM dropdown
//        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //OR
        // different way to handle problem with dynamic dropdown and that two elements are match- Parent -> Child
        //Parent (whole dropdown window) - div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']
        //Child - //a[@value='MAA']
        // ! Remember to add space between parent and child
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

    }
}
