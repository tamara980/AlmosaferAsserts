//How to List

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElemntsList {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void setup() {
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();		
	}
	
	@Test (priority =1) 
	public void login() {
		String usernsmeID= "user-name";
		String passwordID= "password";
		
		WebElement EnterUser= driver.findElement(By.id(usernsmeID));
		WebElement EnterPass= driver.findElement(By.id(passwordID));
		WebElement LoginButton= driver.findElement(By.id("login-button"));
		EnterUser.sendKeys("standard_user");
		EnterPass.sendKeys("secret_sauce");
		LoginButton.click();
		
	}
	@Test (priority =2) 
	public void additems() throws InterruptedException {
	List <WebElement> AddItems= driver.findElements(By.className("btn"));
	//AddItems.get(0).click();
	 // for(int i=0; i<6; i++) {
	    for(int i=0; i< AddItems.size();i++) {
	    	if(i==4) { 
	    		break;}
		  AddItems.get(i).click();
		  Thread.sleep(1000);
	}
		
		
		
	}
	@Test (priority =3) 
	public void removeitems() throws InterruptedException {
	List <WebElement> Removeitems= driver.findElements(By.className("btn"));
	//AddItems.get(0).click();
	 // for(int i=0; i<6; i++) {
	    for(int i=0; i< Removeitems.size();i++) {
	    	if(i<4) { 
	    		Removeitems.get(i).click();
	    		 Thread.sleep(1000);}
	    		 else {
	    		break; }
		 // Removeitems.get(i).click();
		 
	}
		
		
		
	}

}
