import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesDelete {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //delete all cookies
        driver.manage().deleteAllCookies();

        //delete specific cookies
        driver.manage().deleteCookieNamed("sessionKey");

        //maximize browser window
        driver.manage().window().maximize();

        driver.get("https://google.com");
    }
}
