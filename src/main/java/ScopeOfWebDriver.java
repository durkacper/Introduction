import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScopeOfWebDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://qaclickacademy.com/practice.php");

        // 1. Give me the count of links on the page.
        // TIP: links always have tag "a" (like anchor)

        int tagList = driver.findElements(By.tagName("a")).size();
        System.out.println(tagList);


        // 2. Give the count of links present only in the footer section (bottom of the page)
        //TIP: we need to limit the scope of searching to footer section
        //we must create WebElement of our section
        WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));

        //end use this WebElement as a driver limited to our section
        int tagListFooterSection = footerDriver.findElements(By.tagName("a")).size();
        System.out.println(tagListFooterSection);


        // 3. Limit the driver to only first column of links in the footer section.
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int tagListColumn = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(tagListColumn);


        // 3. click on each link in the first column and check if pages are opening in separate tabs (check web titles of each tabs)

        for (int i = 1; i < tagListColumn; i++) {

            //keyboard action of: hold CTRL button and press ENTER to open link in new tab
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            //find WebElement, move the cursor to link and using sendKeys method do the action of keys sequence
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
            Thread.sleep(5000L);
        }


        //Implement the same solution like in WindowHandles exercise to get indexes of all tabs and move from tab to tab
        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> iterator = tabs.iterator();

        //while tab has next tab after it then go to it and grab the title
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
    }
}
