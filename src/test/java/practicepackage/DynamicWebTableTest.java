package practicepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DynamicWebTableTest {

	@Test
	public void dynamicTable() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		act.scrollToElement(driver.findElement(By.id("HTML12"))).perform();
		
		String name = "Firefox";
		String cpu = driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr/td[text()='"+name+"']/following-sibling::td[contains(text(),'%')]")).getText();
		
		System.out.println("CPU % of "+name+" is : "+cpu);
		
		driver.quit();
	}
	
}
