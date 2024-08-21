import java.util.Random;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class CssSelectorMagento {

	WebDriver driver= new ChromeDriver();
	Random rand = new Random();
	
	@BeforeTest
	public void setup() {
		driver.get("https://magento.softwaretestingboard.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	@Test (priority=1, enabled=false)
	public void clickByCSSSelector() {
		
		//WebElement CreateNewAccountClick= driver.findElement(By.linkText("Create an Account"));
	    //WebElement CreateNewAccountClick= driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
		WebElement CreateNewAccountClick= driver.findElement(By.cssSelector("[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		CreateNewAccountClick.click();
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	@Test (priority= 2)
	public void menList(){
		WebElement ViewMenMenue= driver.findElement(By.cssSelector("#ui-id-5"));
		ViewMenMenue.click();
		
		
	}
	@Test (priority= 3)
	public void container() throws InterruptedException{
		WebElement ContainersList = driver.findElement(By.className("product-items"));
		List <WebElement> itemsOFproduct= ContainersList.findElements(By.className("product-item"));
	    //Another way
		//List <WebElement> itemsOFproducts= ContainersList.findElements(By.tagName("li"));
		int count = itemsOFproduct.size();
		System.out.println("Items sum. = "+count);
		int randIndex = rand.nextInt(count);
		System.out.println("Index number of items= "+ randIndex);
		WebElement RandomItem= itemsOFproduct.get(randIndex);
		RandomItem.click();
	
	}
	@Test (priority= 4)
	public void selectSize(){
		
		WebElement SizesContainer= driver.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));
		//List <WebElement> getSizes= SizesContainer.findElements(By.className("swatch-option"));
		//Another Wayy
		List <WebElement> getSizes= SizesContainer.findElements(By.tagName("div"));
		int numberOfSizes = getSizes.size();
		System.out.println("Sizes sum = "+numberOfSizes);
		int randomSizeIndex = rand.nextInt(numberOfSizes);
		System.out.println("Index number of size= "+randomSizeIndex);
		getSizes.get(randomSizeIndex).click();
		
	}
	@Test (priority= 5)
	public void selectColor(){
		
		WebElement colorsContainer= driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		//List <WebElement> getColors= colorsContainer.findElements(By.tagName("div"));
		//Another way
		//List <WebElement> getColors= colorsContainer.findElements(By.className("swatch-option"));
		List <WebElement> getColors= colorsContainer.findElements(By.cssSelector(".swatch-option.color"));
		int numberOfColors = getColors.size();
		System.out.println("Colors sum = "+ numberOfColors);
		int randomColorIndex= rand.nextInt(numberOfColors);
		System.out.println("Index number of color= "+ randomColorIndex);
		getColors.get(randomColorIndex).click();	
		
	}
	
	@Test (priority= 6)
	public void AddButton(){
	
		//ways of clicking add button
		//WebElement ClickButton= driver.findElement(By.id("product-addtocart-button"));
		//WebElement ClickButton= driver.findElement(By.className("action primary tocart"));
		//WebElement ClickButton= driver.findElement(By.cssSelector("#product-addtocart-button"));
	    WebElement ClickButton= driver.findElement(By.xpath("//button[@title='Add to Cart']"));
		ClickButton.click();
		
		
	}
	@Test (priority= 7)
	public void SuccessMessage() throws InterruptedException{
		//Thread.sleep(10000);
		//WebElement CheckMessage= driver.findElement(By.className("message-success"));
		WebElement CheckMessage= driver.findElement(By.cssSelector(".message-success.success.message"));
	    //System.out.println(CheckMessage.getText());
		//1st way
		System.out.println(CheckMessage.getText().contains("You added"));
	    //2nd way
	    if(CheckMessage.getText().contains("You added")== true) {
	    	System.out.println("True T");}
	    	else  {
	    		System.out.println("False T");
			}
	    
	    //3rd way
	    org.testng.Assert.assertEquals(CheckMessage.getText().contains("You added"), true);
	    //Assert
	    
	    driver.close();
	    }
	   
	}
	
	
	
	
		

