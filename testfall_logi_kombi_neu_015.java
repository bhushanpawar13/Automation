package Logistik;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testfall_logi_kombi_neu_015 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "..//automationframe//chrome//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://qatools.kabeldeutschland.de/index.php?module=ajax&action=genIBAN");

		// Get the IBAN generated and store in a variable

		String IBAN = driver.findElement(By.tagName("body")).getText();

		System.out.println(IBAN);

		Thread.sleep(1000);

		driver.get("https://qatools.kabeldeutschland.de/index.php");

		// Find the Text box
		WebElement email = driver.findElement(By.id("userfield"));

		// Send username in text box
		email.sendKeys("bhushan.pawar");

		// Find the Password field
		WebElement password = driver.findElement(By.name("pass"));

		// Send password
		password.sendKeys("England2025");

		// Find Submit button
		WebElement submit = driver.findElement(By.id("linklinelogin"));

		// Click on login button
		submit.click();

		// Click on Testkunden link

		driver.findElement(By.xpath("//div[@class='linkList']//a[normalize-space()='Testkunden']")).click();

		
		// *****************
		// Select Environment
		
		Select env = new Select(driver.findElement(By.name("env")));
		env.selectByValue("test1b");
		Thread.sleep(1000);
	// *****************

		// Select Customer without open web orders

		Select custtype = new Select(driver.findElement(By.name("filter[HAS_OPEN_ORDERS]")));
		custtype.selectByValue("=0");

		// Search customer address

		Select address = new Select(driver.findElement(By.name("filter[ADDRESSTYPE]")));
		address.selectByValue("NE3");

		// Click on Search cust button

		WebElement search_customer = driver.findElement(By.id("startsearch"));
		search_customer.click();
		Thread.sleep(2000);

		// Click on Logout
		//WebElement Clickonlogout = driver.findElement(By.xpath(
		//		"//*[@id='queue']/tbody/tr/td/div[@class='system']/div[@class='container']/div[@class='linkline']/div[@id='1_btnhv']/a[normalize-space()='Logout']"));
		//Clickonlogout.click();
		
		Thread.sleep(2000);
		// Click on HV
		WebElement ClickonHV = driver.findElement(By.xpath("//div[@class='linkline']//a[normalize-space()='HV'][1]"));
		ClickonHV.click();

		Thread.sleep(2000);

		String ParentWindow = driver.getWindowHandle();
		Set<String> Childwindow = driver.getWindowHandles();
		Iterator<String> SwitchWindow = Childwindow.iterator();

		while (SwitchWindow.hasNext()) {
			String wind = SwitchWindow.next();
			if (!(ParentWindow.equals(wind))) {
				Thread.sleep(5000);
				driver.switchTo().window(wind);

			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username']")).sendKeys("qahv");
		driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password']")).sendKeys("testTEST-1");
		
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();

		// Actions action= new Actions(driver);
		// action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(5000);
		// Click on HV symbol
		driver.findElement(By.xpath("//div[@class='portalLogo']/a[@href='/hv']")).click();
		
		Thread.sleep(1000);
		
		Alert alrt = driver.switchTo().alert();
		alrt.accept();
		
		Thread.sleep(2000);

		// Click on kundenerfassung
		driver.findElement(By.xpath("//a[@title='Kundenerfassung']//span[@class='navElement']")).click();

		Thread.sleep(1000);

		// Click on address search button

		WebElement Createcust = driver.findElement(By.xpath("//div[@class='buttonreihe3']/a[@id='address_submit']"));
		Createcust.click();

		Thread.sleep(2000);

		// Scroll the page for addresses

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// Click on Private button

		WebElement Privatebutton = driver.findElement(By.xpath("//div[@id='new_private_customer']"));
		Privatebutton.click();

		Thread.sleep(2000);

		WebElement TVCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[3]"));
		TVCust.click();

		Thread.sleep(2000);

		// Select the Primary product

// Select the product on the page  CKH7

		String textValue = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TVBASIC_CHDC0NK']/strong[normalize-space()='Vodafone Basic TV Cable inklusive Endgerät für Vodafone TV Connect [CHDC0NK]']")).getText();

		if (textValue.equals("Vodafone Basic TV Cable inklusive Endgerät für Vodafone TV Connect [CHDC0NK]")) {
			driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TVBASIC_CHDC0NK']")).click();
		} else {
			System.out.println("Prod Not Found");
		}

//// Select TC1 Product
//		String secondprod = driver.findElement(By.xpath(
//				"//div[@class='checkbox3Column02']//label[@for='id_products_KANSCHLUSS_TC1']/strong[normalize-space()='Vodafone TV Connect [TC1]']"))
//				.getText();
//
//		if (secondprod.equals("Vodafone TV Connect [TC1]")) {
//
//			driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_KANSCHLUSS_TC1']"))
//					.click();
//		} else {
//			System.out.println("Prod Not Found");
//		}

		// Click on Next Button
		driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();

		Thread.sleep(2000);

		// Click on CCX

		String textValue1 = driver.findElement(By.xpath(
				"//div[@class='checkbox3Column02']//label[@for='id_products_RC_CCX']//strong[normalize-space()='Zuzahlung CI+ Modul zur Nutzung (HD-fähig) [CCX]']"))
				.getText();

		if (textValue1.equals("Zuzahlung CI+ Modul zur Nutzung (HD-fähig) [CCX]")) {

			WebElement radio = driver
					.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_RC_CCX']"));

			if (!(radio.isSelected())) {

				radio.click();
			}
		} else {
			System.out.println("Selected");
		}

		// Click on next button
		driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='submitButtonUseSelection']")).click();

		Thread.sleep(2000);

		// Click on Kabel HSI/Phone Button
		WebElement KIPCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[4]"));
		KIPCust.click();

		Thread.sleep(2000);

		// Select 03G:Product

		String KIPprod = driver
				.findElement(
						By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_DOCSIS2020_03G:B06']"))
				.getText();

		if (KIPprod.equals("Red Internet & Phone 250 Cable, 1.-6. Monat 19,99 € [03G:B06]")) {
			driver.findElement(
					By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_DOCSIS2020_03G:B06']")).click();
		} else {
			System.out.println("Prod Not Found");
		}

		// Click on next page button

		driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();

		Thread.sleep(1000);

		// Unselect OW3
		String UnselectOW3 = driver.findElement(By.xpath(
				"//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_OW3:000']//strong[normalize-space()='Option WLAN [OW3:000]']"))
				.getText();

		if (UnselectOW3.equals("Option WLAN [OW3:000]']")) {
			driver.findElement(By.xpath("//input[@id='id_products_TSERVICE_OW3:000']")).click();
		} else {
			System.out.println("Prod Not Found");
		}

		// Click on Next Button
		driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();

		Thread.sleep(2000);

		// Check TOEVN

		 String TOEVNradio = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_POEV_TOEVN']//strong[normalize-space()='Kein Einzelverbindungsnachweis [TOEVN]']")).getText();
		  System.out.println(TOEVNradio);
		  
		  if(TOEVNradio.equals("Kein Einzelverbindungsnachweis [TOEVN]")){
		 
		  WebElement TOEVN_radio= driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_POEV_TOEVN']"));
		  
		  if (!(TOEVN_radio.isSelected())) {
		  
		 TOEVN_radio.click(); } } 
		  
		  else{ 
			  
			  System.out.println("Selected"); 
			  
		  }
		 
		// Click on next button 
			 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='submitButtonUseSelection']")).click();

			 
				Thread.sleep(2000);
// Fill up Customer Information
			 
			 Select Anrede = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='title']")));
			 Anrede.selectByValue("Frau");
		
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='lastName']")).sendKeys("testfall_logi_kombi_neu_015");
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='firstName']")).sendKeys("Regression");
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='birthday']")).sendKeys("05.05.1989");
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='telPrivateAreaCode']")).sendKeys("089");
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='telPrivateExchange']")).sendKeys("6565656");
			
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(1000);
			
	//Check the marketing information
			
//			Select Marketingcode = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='marketingCode']")));
//			Marketingcode.selectByValue("BRI");
//			
//			Select Werbecode = new Select(driver.findElement(By.id("marketingChannel")));
//			Werbecode.selectByValue("INB");
			
			Select Kampagne = new Select(driver.findElement(By.id("campagne")));
			Kampagne.selectByValue("000");
			
// Check the checkbox for communication channel 
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='dataSharingOptIn']")).click();
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='communicationChannelOptIn']")).click();
			
// Click on Lieferadresse 
			
			driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[9]")).click();
			
// Click on Lieferadresse löschen button 
			driver.findElement(By.xpath("(//a[@id='Login.Submit'])[1]")).click();
			Thread.sleep(1000);
			
// Click on next page button
			
			driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='schaltflaechentext'])[6]")).click();
			
			Thread.sleep(1000);
			
			 //Enter bank Details
			driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[11]")).click();
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='bankAccountNumber']")).sendKeys(IBAN);
			
			driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='accountHolderEqualCustomer']")).click();
			
			driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='zdMandateEmail']")).sendKeys("bhushan.pawar@vodafone.com");
			
			driver.findElement(By.xpath("//div[@class='radioBox3Column02']//input[@id='zdMandateMethodPaper']")).click();
			
			Thread.sleep(2000);
//Clcik on next button 
			
	driver.findElement(By.xpath("(//div[@class='buttonreihe3' and contains(normalize-space(),'Bankdaten prüfen')]")).click();
	//driver.findElement(By.xpath("(//div[@class='buttonreihe3']//a[@id='Login.Submit'])[1]")).click();
			
 // Click on Pop - up window
			driver.findElement(By.xpath("//div[@class='emailPopup popup--overlay']//div[@class='popup']//div[@class='popup--content']//div[@class='popup--buttons']//button[@class='popup--submit']")).click();
			
			//Find element by link text and store in variable "Element"        		
	        WebElement Absluss = driver.findElement(By.id("nextStepButton"));

	        //This will scroll the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Absluss);
	        
	        
// Again click on next button 
			driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='schaltflaechentext'])[6]")).click();

			
// Get the Weborder No
			js.executeScript("window.scrollBy(0,2000)");
			
// Click on Abschließen Button

			driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='order-commit']")).click();
			
			Thread.sleep(1000);
			
// Get the Weborder ID
			
			String Weborder  = driver.findElement(By.xpath("//div[@class='startInhalt']//p[@class='widthContentTextCopy']//span")).getText();
			
			System.out.println("Weborder"+" : "+Weborder);
			
			 
			driver.quit();

		

	}

}
