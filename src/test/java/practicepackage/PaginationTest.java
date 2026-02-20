package practicepackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PaginationTest {
	
	@Test
	public void paginationTableTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act = new Actions(driver);
		
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='widget Stats']"))).perform();
		
		String expect = "Streaming Device";
		String price = null;
		boolean flag = false;
		
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
		
		for (WebElement page : pages) {
			page.click();
			List<WebElement> lists = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[2]"));
			for (WebElement list : lists) {
				if (list.getText().equals(expect)) {
					list.findElement(By.xpath("//td[text()='"+expect+"']/following-sibling::td/input[@type='checkbox']")).click();
					price = list.findElement(By.xpath("//td[text()='"+expect+"']/following-sibling::td[1]")).getText();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		    
			
		}
		
		System.out.println("hii");
		
		System.out.println("Price of "+expect+" is : "+price);
		
		driver.quit();
		
		System.out.println("hello");
		
	}
	
	

}
