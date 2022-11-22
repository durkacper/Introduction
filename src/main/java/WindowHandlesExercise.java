import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesExercise {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href='/windows']")).click();
        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);

        System.out.println(driver.findElement(By.cssSelector("body div h3")).getText());

        driver.switchTo().window(parentWindow);

        System.out.println(driver.findElement(By.cssSelector("div div h3")).getText());

    }
}
