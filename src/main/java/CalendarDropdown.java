import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendarDropdown {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //One way and Round Trip - how to know if webelement is enable or disable

        //First check the "style" attribute before click on Round Trip:
        //System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
        //style = display: block; opacity: 0,5;
        //then select Round Trip
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        //Second check the "style" attribute after click on Round Trip:
        //System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
        //style = display: block; opacity: 1;

        //verify if RETURN DATE is enable by comparing "style" attribute
        if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("opacity: 1")){
            System.out.println("it is enabled");
            Assert.assertTrue(true);
        }
        else {
            //fail test when it is still disable (opacity: 0,5) even after selected Round Trip radiobutton
            Assert.assertTrue(false);
        }




        //open the calendar (no needed for E2E scenario)
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();

        //select current date
        driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();

        //select return date (hardcode the date here)
        //???

    }
}
