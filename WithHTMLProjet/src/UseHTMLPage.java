//I created a new page by VS Code you can find the code of page D:\VS Code projects

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UseHTMLPage {
	WebDriver driver= new ChromeDriver();
	
	
	@BeforeTest
	public void setup() {  
		driver.get("file:///D:/VS%20Code%20projects/index.html?");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void tests() throws InterruptedException {
		WebElement username = driver.findElement(By.id("tamara"));
		WebElement password = driver.findElement(By.id("ta"));
		WebElement telephone = driver.findElement(By.id("t"));
		WebElement Date = driver.findElement(By.id("a"));
		username.sendKeys("Tamara");
		password.sendKeys("dabit");
		telephone.sendKeys("0877");
		Date.sendKeys("05241998");
		Thread.sleep(1000);
		//WebElement buttonSubmit= driver.findElement(By.xpath("//button[@type='submit']"));
		//buttonSubmit.click();
		WebElement buttonReset= driver.findElement(By.xpath("//button[@type='reset']"));
		buttonReset.click();
		
		//WebElement googlelink= driver.findElement(By.xpath("//a[@href='https://www.google.co.uk/']"));
		//googlelink.click();
		
		// WebElement link2= driver.findElement(By.linkText("Google"));
		// link2.click();
		 
		 WebElement link3= driver.findElement(By.partialLinkText("oo"));
		 link3.click();
		
	}
	

}
