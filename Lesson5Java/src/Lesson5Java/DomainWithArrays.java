//Magento Website

package Lesson5Java;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DomainWithArrays {
	
	
		WebDriver driver= new ChromeDriver();
		Random rand= new Random();
		
		@BeforeTest
		public void setup() {
			driver.get("https://magento.softwaretestingboard.com/");
			driver.manage().window().maximize();
			
		}
		
		@Test (invocationCount = 5)
		public void howToUseArrayForDomain() {
			//                                          (By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
			WebElement CreateAccount= driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
			CreateAccount.click();
			String [] Domain= {"@gmail.com","@outlock.com","@yahoo.com"};
			int ran= rand.nextInt(Domain.length);
			WebElement Email= driver.findElement(By.id("email_address"));
			Email.sendKeys(Domain[ran]);
			
			
		}

	}


