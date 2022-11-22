import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Locators4_RelativeLocators {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        //we try to catch the WebElement label "Name" above text box

        //first - find WebElement text box
        WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));

        ////Relative selector - above
        // driver.findElement(with(By.tagName("label")).above(By.cssSelector("input[name='name']")));
        driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();

        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());


        ////Relative selector - below
        WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        //info - it will find second "input" in DOM witch is <Submit> button because text box has "flex" type (no idea what it means)
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();


        ////Relative selector - left
        WebElement checkboxLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        //checkbox click
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxLabel)).click();


        ////Relative selector - right
        WebElement checkboxStudent = driver.findElement(By.cssSelector("#inlineRadio1"));
        //check label text
        String labelText = driver.findElement(with(By.tagName("label")).toRightOf(checkboxStudent)).getText();
        System.out.println(labelText);
    }
}
