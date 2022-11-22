import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //create Soft Assertion object
        SoftAssert softAssert = new SoftAssert();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //INFO: link is broken because of broken URL (attached to this link)

        //Test approach:
        //find all links and check the status code (if status code >400 then URL is broken)

        //Step 1 - get all URLs tide up to the links on page using Selenium
        List<WebElement> listOfLinks = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (int i = 0; i < listOfLinks.size(); i++) {

            String attribute = listOfLinks.get(i).getAttribute("href");
            //build connection
            //cast? - do not understand this structure...
            URL urlConnection = new URL(attribute);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection.openConnection();

            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            System.out.println(responseCode);

            //check condition for all links and only store potentially founded errors
            softAssert.assertTrue(responseCode < 400 , "The link with text " + listOfLinks.get(i).getText() + " is broken with code " + responseCode);
        }

        //after loop is done check if Soft Assertion found some errors. If yes - then fail, if not - pass.
        softAssert.assertAll();
    }
}
