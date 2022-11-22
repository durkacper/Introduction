import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.remote.DesiredCapabilities.*;

public class HTTPScertifications {
    public static void main(String[] args) {

        //SSL certification

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        //Add Desired Capabilities to local browser
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(desiredCapabilities);
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }

}
