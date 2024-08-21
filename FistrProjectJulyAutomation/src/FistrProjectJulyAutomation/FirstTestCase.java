package FistrProjectJulyAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestCase {
	
	WebDriver driver = new ChromeDriver();
	
	// webDriver driver2 = new EdgeDriver();
	
	@BeforeTest
	public void MySetup() {
		driver.manage().window().maximize();
		driver.get("https://www.google.co.uk/");
		
	} 
	@Test
	public void MyFirst() {
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Tamara Dabit");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
		
	}

}
