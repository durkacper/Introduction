import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://google.com");

        //use navigate to go to specific url when browser is already open
        driver.navigate().to("https://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();

    }
}
