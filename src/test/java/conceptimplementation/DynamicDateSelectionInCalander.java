package conceptimplementation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicDateSelectionInCalander {
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// page will scroll down
		js.executeScript("window.scrollBy(0,350)", "");

		// table will scroll down
		js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=3000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			sum = sum + Integer.parseInt(values.get(i).getText());
		}

		int total = Integer
				.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
	}
}
