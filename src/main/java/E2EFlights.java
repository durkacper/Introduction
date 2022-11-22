import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EFlights {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //FROM
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);

        //TO
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
//        Thread.sleep(2000);

        //DEPARTURE DATE
        driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();

        //RETURN DATE - check if it is enabled
        if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("opacity: 0.5")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);

        }

        //PASSENGERS
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        // clicking 4 times button "+" to add passengers
        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

        //CURRENCY
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);

        //CHECKBOX
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        //SEARCH
        driver.findElement(By.cssSelector("input[id*=FindFlights]")).click();


    }

}