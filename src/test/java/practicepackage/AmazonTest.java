package practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTest {

	@Test
	public void name() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//div[@id='icp-nav-flyout']/button[@class='nav-flyout-button nav-icon nav-arrow']")).click();
		 String lang = "MR";
	
		driver.findElement(By.xpath("//div[@id='nav-flyout-icp']/descendant::span[text()='"+lang+"']/preceding-sibling::i[@class='icp-radio']")).click();
		
		driver.quit();
		
		System.out.println("hello");
	}
	
}
