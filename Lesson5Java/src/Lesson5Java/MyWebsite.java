//Magento Website

package Lesson5Java;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyWebsite {
	WebDriver driver = new ChromeDriver();
	String linkwebsite = "https://magento.softwaretestingboard.com/";
	Random rand= new Random();
	String password = "Tamara12345#12111";
	String Email=" ";

	@BeforeTest
	public void setup() {
		driver.get(linkwebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test //(invocationCount=5, priority=1)
	public void parameter() {
		// WebElement
		// createAccount=driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
		// createAccount.click();
		// WebElement createAccount2 = driver.findElement(By.partialLinkText("an
		// Account"));
		// createAccount2.click();

		WebElement createAccount3 = driver.findElement(By.linkText("Create an Account"));
		createAccount3.click();

		String[] firstNames = { "John", "Jane", "Michael", "Emily", "David", "Sarah", "Robert", "Jessica", "Daniel","Laura" };
		String[] LastNames = { "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore","Taylor" };

		//rand.nextInt(7);
		//System.out.println(rand.nextInt(7));
		int firstNameNO= rand.nextInt(firstNames.length);
		int lastNameNO= rand.nextInt(LastNames.length);
		System.out.println(firstNameNO);
		System.out.println(lastNameNO);
		
		WebElement fillFirstName= driver.findElement(By.id("firstname"));
		fillFirstName.sendKeys(firstNames[firstNameNO]);
		WebElement fillLastName= driver.findElement(By.name("lastname"));
		fillLastName.sendKeys(LastNames[lastNameNO]);
		WebElement fillEmail= driver.findElement(By.id("email_address"));
		//int randoomNumber= rand.nextInt(7532);
		String Domain2= "@gmail.com";
		int randomNumburForEmail= rand.nextInt(7532);
		fillEmail.sendKeys(firstNames[firstNameNO]+LastNames[lastNameNO]+randomNumburForEmail+Domain2);
		Email= firstNames[firstNameNO]+LastNames[lastNameNO]+randomNumburForEmail+Domain2; 
	
		
		WebElement passwordField= driver.findElement(By.id("password"));
		WebElement confirmPasswordField= driver.findElement(By.id("password-confirmation"));
		WebElement submitButton= driver.findElement(By.xpath("//button[@title='Create an Account']"));
		
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(password);
		submitButton.click();
		
		
		//WebElement assertForSuccessMessage= driver.findElement(By.className("message-success"));
		//Another way
		WebElement assertForSuccessMessage= driver.findElement(By.cssSelector(".message-success.success.message"));
		Assert.assertEquals(assertForSuccessMessage.getText().contains("Thank you for registering with Main Website Store."), true);
		
		//Another Way
		
		String ActualResul=assertForSuccessMessage.getText();
		String ExpectedResult= "Thank you for registering with Main Website Store.";
		Assert.assertEquals(ActualResul, ExpectedResult);
		
		
		//-------------------------------------------   Wrong way                    
	   // Assert.assertEquals(ActualResul, ExpectedResult);
		//if (ActualResul == ExpectedResult) {
			//System.out.println("Pass");
		//} else { System.out.println("Failed");}	
	}
	
	@Test (priority=2 ) 
	//enabled=false)
	public void logout(){
		String urlLogout= "https://magento.softwaretestingboard.com/customer/account/logout/";
		driver.get(urlLogout);
		WebElement successMessageForLogout = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
		//WebElement successMessageForLogout = driver.findElement(By.className("base"));
		Assert.assertEquals(successMessageForLogout.getText().contains("You are"), true);
		
		
	}

	@Test (priority = 3)
			//enabled = false)
	public void login() throws InterruptedException {
		WebElement signIn= driver.findElement(By.linkText("Sign In"));
		signIn.click();
		
		WebElement username= driver.findElement(By.id("email"));
		WebElement PasswordSignIN= driver.findElement(By.id("pass"));
		WebElement Signin= driver.findElement(By.id("send2"));
		username.sendKeys(Email);
		PasswordSignIN.sendKeys(password);
		Signin.click();
		
		//WebElement CheckTheNameOfEmployee = driver.findElement(By.className("logged-in"));
		//Another Way
		WebElement CheckTheNameOfEmployee = driver.findElement(By.cssSelector("div[class='panel header'] span[class='logged-in']"));
		
		//It's not working
		//WebElement CheckTheNameOfEmployee = driver.findElement(By.xpath("//span[@data-bind='text: new String('Welcome, %1!').replace('%1', customer().fullname)']"));
		
		Boolean ActualResult= CheckTheNameOfEmployee.getText().contains("Welcome,");
		Boolean ExpectedResult= true;
		
		Assert.assertEquals(ActualResult, ExpectedResult);

		driver.close();
		
		
	}
}
