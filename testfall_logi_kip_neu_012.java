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

public class testfall_logi_kip_neu_012 {
	
	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "..//Logistik//chrome//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://qatools.kabeldeutschland.de/index.php");
		
		// Find the Text box
		WebElement email =driver.findElement(By.id("userfield"));
		
	// Send username in text box 
		email.sendKeys("bhushan.pawar");
		
	// Find the Password field
		WebElement password =driver.findElement(By.name("pass"));
	
	// Send password 
		password.sendKeys("England2026");
		
	//Find Submit button 
		WebElement submit  = driver.findElement(By.id("linklinelogin"));
	
	//Click on login button s
		submit.click();
	
	//Click on Testkunden link 
		
		driver.findElement(By.xpath("//div[@class='linkList']//a[normalize-space()='Testkunden']")).click();
		
		// *****************
		// Select Environment
		
		Select env = new Select(driver.findElement(By.name("env")));
		env.selectByValue("test2b");
		Thread.sleep(1000);
	// *****************

		// Search customer address
		
				Select address = new Select(driver.findElement(By.name("filter[ADDRESSTYPE]")));
				address.selectByValue("NE3-NE4-INV");	
				
	// Click on Search cusotmer button
				
				WebElement search_customer =driver.findElement(By.id("startsearch"));
				search_customer.click();
				Thread.sleep(2000);
				
	// Click on Logout button
				

				//WebElement Clickonlogout=driver.findElement(By.xpath("//*[@id='queue']/tbody/tr/td/div[@class='container']/div[@class='linkline']/div[@id='1_btnecc']/a[normalize-space()='Logout']"));
				//Clickonlogout.click();
				
				Thread.sleep(2000);
	// Click on ECC
				
				WebElement ClickonEcc=driver.findElement(By.xpath("//div[@class='linkline']//a[normalize-space()='ECC'][1]"));
				ClickonEcc.click();
				
				String ParentWindow = driver.getWindowHandle();
				Set <String> Childwindow =  driver.getWindowHandles();
				Iterator <String> SwitchWindow = Childwindow.iterator();
				
				while (SwitchWindow.hasNext())
				{
					String wind  = SwitchWindow.next();
					if(!(ParentWindow.equals(wind)))
					{
						Thread.sleep(5000);
						driver.switchTo().window(wind);
						
					}
				}
				
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username']")).sendKeys("qaecc");
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password']")).sendKeys("testTEST-1");
				
				driver.findElement(By.xpath("//input[@id='kc-login']")).click();
				//Actions action= new Actions(driver);
				//action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
				System.out.println(driver.getCurrentUrl());
				
				Thread.sleep(5000);
				
				WebElement Newcust = driver.findElement(By.xpath("//div[@class='portalLogo']/a[@href='/ecc']"));	
				Newcust.click();
				
				Thread.sleep(1000);
				
				Alert alrt = driver.switchTo().alert();
				alrt.accept();
				
				Thread.sleep(2000);
				
				WebElement Createcust  = driver.findElement(By.xpath("//div[@class='buttonreihe3']/a[@id='address_submit']"));
				Createcust.click();
				
				Thread.sleep(2000);
		// Scroll Down 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				 js.executeScript("window.scrollBy(0,10000)");
				
		 // Click on Private button 
				 
				 WebElement Privatebutton  = driver.findElement(By.xpath("//div[@id='new_private_customer']"));
				 Privatebutton.click();
				 
		// Click on Kabel HSI/Phone Button 
				 WebElement KIPCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[4]"));
				 KIPCust.click();
				 
				 Thread.sleep(2000);
				 
		// Select the product on the page 
				 
				 String textValue = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_DOCSIS2020_03G:B06']")).getText();

				 if(textValue.equals("Red Internet & Phone 250 Cable, 1.-6. Monat 19,99 € [03G:B06]")){
				      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_DOCSIS2020_03G:B06']")).click();
				 }
				 else{
				        System.out.println("Prod Not Found");
				 } 
				 
		//Click on next page button
				 
				driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
				
				Thread.sleep(1000);
				
				
		// Unselect  OW3
				String textValue1 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_OW3:000']//strong[normalize-space()='Option WLAN [OW3:000]']")).getText();

				 if(textValue1.equals("Option WLAN [OW3:000]']")){
				      driver.findElement(By.xpath("//input[@id='id_products_TSERVICE_OW3:000']")).click();
				 }
				 else{
				        System.out.println("Prod Not Found");
				 } 
			
		//Check 2S2 is selected 
				String textValue2 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_2S2:002']//strong[normalize-space()='Sicherheitspaket, 1.-2. Monat 0,00 € [2S2:002]']")).getText();
				WebElement radio = driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TSERVICE_2S2:002']"));
				
				if (!(radio.isSelected()))
				 if(textValue2.equals("Sicherheitspaket, 1.-2. Monat 0,00 € [2S2:002]")){
				      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TSERVICE_2S2:002']")).click();
				 }
				 else{
				        System.out.println("Prod Not Found");
				 } 
				
		//Click on Next Button 
				 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
				 
				 Thread.sleep(2000);
				 
		/*
		 * // Check TOEVN
		 * 
		 * 
		 * String TOEVNradio = driver.findElement(By.
		 * xpath("//div[@class='checkbox3Column02']//label[@for='id_products_RC_DCX']//strong[normalize-space()='Digital HD-Recorder zur Nutzung überlassen [DCX]']"
		 * )).getText();
		 * 
		 * if(TOEVNradio.equals("Digital HD-Recorder zur Nutzung überlassen [DCX]")){
		 * 
		 * WebElement TOEVN_radio= driver.findElement(By.xpath(
		 * "//div[@class='checkbox3Column01']//input[@id='id_products_RC_DCX']"));
		 * 
		 * if (!(TOEVN_radio.isSelected())) {
		 * 
		 * TOEVN_radio.click(); } } else{ System.out.println("Selected"); }
		 * 
		 * // Click on TOVDS
		 * 
		 * WebElement TOVDSradio = driver.findElement(By.xpath(
		 * "//div[@class='checkbox3Column01']//input[@id='id_products_TODS_TOVDS']"));
		 * 
		 * if(!(TOVDSradio.isSelected())) { TOVDSradio.click();
		 * 
		 * } else{ System.out.println("Selected"); }
		 * 
		 * // 
		 * 
		 * // Click on RNRN WebElement RNRNradio = driver.findElement(By.xpath(
		 * "//div[@class='checkbox3Column01']//input[@id='id_products_PORNRP_RNRN']"));
		 * 
		 * if(!(RNRNradio.isSelected())) { RNRNradio.click();
		 * 
		 * } else{ System.out.println("Selected"); }
		 * 
		 * // Click on TOTBN WebElement TOTBNradio = driver.findElement(By.xpath(
		 * "//div[@class='checkbox3Column01']//input[@id='id_products_TOTB_TOTBN']"));
		 * if(!(TOTBNradio.isSelected())) { TOTBNradio.click();
		 * 
		 * } else{ System.out.println("Selected"); }
		 */
				 
		// Scroll Down
				 JavascriptExecutor js1 = (JavascriptExecutor) driver;
				 js1.executeScript("window.scrollBy(0,1000)");
				 
	   // Click on next button 
				 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='submitButtonUseSelection']")).click();
					 
					 
				 
				 //Click on Bankverbindung and Enter bank Details
					driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[11]")).click();
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='bankAccountNumber']")).sendKeys("DE83700500001585647341");
					
					driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='accountHolderEqualCustomer']")).click();
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='zdMandateEmail']")).sendKeys("bhushan.pawar@vodafone.com");
					
					driver.findElement(By.xpath("//div[@class='radioBox3Column02']//input[@id='zdMandateMethodPaper']")).click();

	// Clcik on next button 
					
					//driver.findElement(By.xpath("(//div[@class='buttonreihe3' and contains(normalize-space(),'Bankdaten prüfen')]")).click();
					driver.findElement(By.xpath("(//div[@class='buttonreihe3']//a[@id='Login.Submit'])[1]")).click();
				 
					Thread.sleep(2000);
	// Fill up Customer Information
				 
				 Select Anrede = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='title']")));
				 Anrede.selectByValue("Frau");
			
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='lastName']")).sendKeys("testfall_logi_kip_neu_012");
				
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='firstName']")).sendKeys("Regression");
				
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='birthday']")).sendKeys("05.05.1989");
				
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='telPrivateAreaCode']")).sendKeys("089");
				
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='telPrivateExchange']")).sendKeys("6565656");
				
				js.executeScript("window.scrollBy(0,1000)");
				
				
     // Select Future Date - Wunschlieferdatum
				
				driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='deliveryDate']")).sendKeys("24.05.2021");
				
	//Check the marketing information
				
				Select Marketingcode = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='marketingCode']")));
				Marketingcode.selectByValue("BRI");
				
				Select Werbecode = new Select(driver.findElement(By.id("marketingChannel")));
				Werbecode.selectByValue("INB");
				
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
				

				
				
		/*
		 * WebElement element= driver.findElement(By.xpath(
		 * "(//div[@class='popup--buttons']//button[@class='popup--submit'])[1]"));
		 * ((JavascriptExecutor)driver).executeScript("argument[0].click()",element);
		 * Alert ale=driver.switchTo().alert(); String alerttext = ale.getText();
		 * System.out.println(alerttext); ale.accept();
		 */
				
	// Click on Pop - up window
				driver.findElement(By.xpath("//div[@class='emailPopup popup--overlay']//div[@class='popup']//div[@class='popup--content']//div[@class='popup--buttons']//button[@class='popup--submit']")).click();
				
	// Scroll up 
				//js.executeScript("window.scrollBy(0,500)");
				
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