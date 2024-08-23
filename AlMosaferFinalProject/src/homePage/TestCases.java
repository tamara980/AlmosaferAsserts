package homePage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class TestCases {

	WebDriver driver= new ChromeDriver();
	String AlmosaferURL= "https://global.almosafer.com/en";
	String ExpectedLanguage= "en";
	Random rand = new Random();
	
	@BeforeTest
	public void setup() {
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(AlmosaferURL);
		WebElement popUp = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		popUp.click();
	}
	
	@Test (priority= 1)
	public void CheckTheLanguage() {
		WebElement language= driver.findElement(By.tagName("html"));
		String ActualLanguage= language.getAttribute("lang");
		org.testng.Assert.assertEquals(ActualLanguage, ExpectedLanguage);		
		
	}
	@Test (priority= 2)
	public void CheckTheCurrrency() {
		String ExpectedCurrency= "SAR";
		WebElement ActualCurrency =driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));
		String ACTUALCurrency= ActualCurrency.getText();
		org.testng.Assert.assertEquals(ACTUALCurrency, ExpectedCurrency);
	}
	
	@Test (priority= 3)
	public void CheckContactNumber() {
	String ExpectedContactNO= "+966554400000";
	WebElement ActualContactNO= driver.findElement(By.tagName("strong"));
	String Contact= ActualContactNO.getText();
	org.testng.Assert.assertEquals(Contact, ExpectedContactNO);
	
	}
	@Test (priority= 4)
	public void CheckLOGO() {
		boolean ExpectedResult= true;
		WebElement theFooter = driver.findElement(By.tagName("footer"));
		boolean ActualLogo= theFooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();               
		//another way
		//Boolean Logo= theFooter.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF")).isDisplayed();
		
		
		//(.xpath("//svg[@data-testid='Footer__QitafLogo']")).isDisplayed();)// couldn't use the xpath 
		System.out.println(ActualLogo);
		org.testng.Assert.assertEquals(ActualLogo,ExpectedResult );
		
	}
	@Test (priority= 5)
	public void FlightTab() {
	boolean expectedResult = false;
	WebElement TabHotels =driver.findElement(By.cssSelector(".sc-gHboQg.dSBdPR.nav.nav-tabs")).findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	//TabHotels.click();
	String ActualResult= TabHotels.getAttribute("aria-selected");
	System.out.println(TabHotels.getAttribute("aria-selected"));	
	boolean convertResult= Boolean.parseBoolean(ActualResult);
	//System.out.println(convertResult);
		org.testng.Assert.assertEquals(convertResult, expectedResult);		
	}	

	@Test (priority= 6)
	public void CheckDates() {
		LocalDate date = LocalDate.now();
		int theCurrentDate =date.getDayOfMonth();
		System.out.println(theCurrentDate);
		int theExpectedTomorrowDate= date.plusDays(1).getDayOfMonth();
		int TheExpectedAfterTomorrowDate =date.plusDays(2).getDayOfMonth();
		//int ExpectedDate= theCurrentDate+1; not correct
		//System.out.println(theExpectedTomorrowDate);
	
		List <WebElement> datesSapnContainer= driver.findElements(By.className("LiroG"));
		
		WebElement DepartureBox= datesSapnContainer.get(0);
		String departureDate= DepartureBox.getText(); System.out.println(departureDate); 
		int DepatureDateINT= Integer.parseInt(departureDate); System.out.println(DepatureDateINT);
		org.testng.Assert.assertEquals(DepatureDateINT, theExpectedTomorrowDate);
		
		WebElement ReturnBox= datesSapnContainer.get(1);
		String ReturnDate= ReturnBox.getText(); System.out.println(ReturnDate); 
		int ReturnDateINT= Integer.parseInt(ReturnDate); System.out.println(ReturnDateINT);
		org.testng.Assert.assertEquals(ReturnDateINT, TheExpectedAfterTomorrowDate);
		
	}
	@Test (priority= 7)
	public void ChangeLanguage() {
		String [] URL= {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		int Size = URL.length; System.out.print(Size +"  ---");
		int randomIndesx = rand.nextInt(Size); System.out.println(randomIndesx);
		driver.get(URL[randomIndesx]);
	
	}
	@Test (priority= 8, enabled=false)
	public void HotelTab() {
		WebElement openTab= driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		openTab.click();
		
		String [] EnglishCities= {"Dubai","Jaddah","Riyadh"};
		int EnglishIndex= rand.nextInt(EnglishCities.length);
		String [] ArabicCities= {"دبي","جدة"};
		int ArabicIndex= rand.nextInt(ArabicCities.length);
		
		WebElement searchField= driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		//searchField.sendKeys("TEST");
		WebElement checkLanguage = driver.findElement(By.cssSelector("html"));
		String Lang= checkLanguage.getAttribute("lang");
		//System.out.println(Lang);
		if(Lang == "en") {
			searchField.sendKeys(EnglishCities[EnglishIndex]);}
		
		else {searchField.sendKeys(ArabicCities[ArabicIndex]);}
		
	}
	@Test (priority= 8)
	public void HotelTab2() {
		WebElement openTab= driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		openTab.click();
		String [] EnglishCities= {"Dubai","Jaddah","Riyadh"};
		int EnglishIndex= rand.nextInt(EnglishCities.length);
		System.out.println(EnglishIndex);
		String [] ArabicCities= {"دبي","جدة"};
		int ArabicIndex= rand.nextInt(ArabicCities.length);
		System.out.println(ArabicIndex);
		
		WebElement searchField= driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));
		String URL=driver.getCurrentUrl();
		if(URL.contains("ar")) {
			searchField.sendKeys(ArabicCities[ArabicIndex]);}
		
		else {searchField.sendKeys(EnglishCities[EnglishIndex]);}
		
		
		WebElement ListOfLocations=driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		WebElement firstOption= ListOfLocations.findElements(By.tagName("Li")).get(1);
		firstOption.click();
		
	}
	@Test (priority= 9)
	public void randomlySelectRoom() {
		WebElement selector =driver.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select select =new Select(selector);
		int randomIndex=rand.nextInt(2);
		select.selectByIndex(randomIndex);
		//select.selectByValue("B");
		//select.selectByVisibleText("1 Room, 2 Adults, 0 Children");
		
		WebElement SearchButton= driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchButton.click();
	}
	@Test (priority= 10)
	public void assertforSearching() throws InterruptedException {
		Thread.sleep(20000);
		//String ExpectedMessage ="properties found in";
		WebElement getIndex = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		String text =getIndex.getText();
		System.out.println(getIndex.getText());
		boolean assertion= text.contains("properties found in") ||text.contains("وجدنا");
		
		org.testng.Assert.assertEquals(assertion, true);
		
	}
	@Test (priority= 11)
	public void FromLowestToHighestPrice () {
		WebElement clickLowestPrice = driver.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		clickLowestPrice.click();
		WebElement Container= driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));
		List <WebElement> PricesField= Container.findElements(By.className("Price__Value"));
				
		String lowestPrice= PricesField.get(0).getText();
		int lowest= Integer.parseInt(lowestPrice);
		String HighestPrice= PricesField.get(PricesField.size()-1).getText();
		int highest= Integer.parseInt(HighestPrice);
		System.out.println(lowestPrice+"=================+"+HighestPrice);
		org.testng.Assert.assertEquals(lowest<highest, true);
	}
	
}
	

