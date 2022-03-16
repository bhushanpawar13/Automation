package Logistik;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testfall_logi_kip_tw_018 {

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
				WebElement email =driver.findElement(By.id("userfield"));
				
			// Send username in text box 
				email.sendKeys("bhushan.pawar");
				
			// Find the Password field
				WebElement password =driver.findElement(By.name("pass"));
			
			// Send password 
				password.sendKeys("England2025");
				
			//Find Submit button 
				WebElement submit  = driver.findElement(By.id("linklinelogin"));
			
			//Click on login button 
				submit.click();
			
			//Click on Testkunden link 
				
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
				
				// Set Product filter
				driver.findElement(By.xpath("//input[@type='text' and @name='filter[PRODUCTS]']")).sendKeys("A32;!A32:");
				
				// Select selfinstall option
						
						Select selfinstall = new Select(driver.findElement(By.name("filter[SEL_AVAILABLE]")));
						selfinstall.selectByValue("J");
						Thread.sleep(1000);
						
			   // Click on Search cust button
						
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
						
						Thread.sleep(3000);
						
					// Click on Kabel HSI/Phone Button 
						 WebElement KIPCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[4]"));
						 KIPCust.click();
						 
						 Thread.sleep(2000);
						
						// Select the product on the page  03G:B06
						 
						 String textValue = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_KIPTW2020_03G:B03']")).getText();

						 if(textValue.equals("Red Internet & Phone 250 Cable, 1.-3. Monat 29,99 € [03G:B03]")){
						      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_KIPTW2020_03G:B03']")).click();
						 }
						 else{
						        System.out.println("Prod Not Found");
						 } 
						 
				//Click on next page button
						 
						driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
						
						Thread.sleep(1000);
						
						
//				// Unselect  OW3
//						String textValue1 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_OW3']//strong[normalize-space()='Option WLAN [OW3]']")).getText();
//
//						 if(textValue1.equals("Option WLAN [OW3]")){
//						      driver.findElement(By.xpath("//input[@id='id_products_TSERVICE_OW3']")).click();
//						 }
//						 else{
//						        System.out.println("Prod Not Found");
//						 } 
					
				//Check 2S2 is selected 
						//2S2:002
						String textValue2 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_2S2:002']//strong[normalize-space()='Sicherheitspaket, 1.-2. Monat 0,00 € [2S2:002]']")).getText();
						WebElement radio = driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TSERVICE_2S2:002']"));
						
//						// 2S2
//						String textValue3 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_TSERVICE_2S2']//strong[normalize-space()='Sicherheitspaket [2S2]")).getText();
//						WebElement radio1 = driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TSERVICE_2S2']"));
						
						if(radio.isDisplayed())
						if (!(radio.isSelected()))
						 if(textValue2.equals("Sicherheitspaket, 1.-2. Monat 0,00 € [2S2:002]")){
						      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_TSERVICE_2S2:002']")).click();
						 }
//						 else if(radio1.isDisplayed()) {
//							 
//							 if(!(radio1.isSelected())) {
//								 if(textValue3.equals("Sicherheitspaket [2S2]")){
//									 
//									 radio1.click();
//								 }
//								 
//								 
//							 }
						 
						 else{
						        System.out.println("Prod Not Found");
						 } 
						
				//Click on Next Button 
						 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
						 
						 Thread.sleep(2000);
						 
				
						// Scroll Down
						 JavascriptExecutor js1 = (JavascriptExecutor) driver;
						 js1.executeScript("window.scrollBy(0,500)");
						 
//			   // Click on next button 
//						 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='submitButtonUseSelection']")).click();
//
//						 js1.executeScript("window.scrollBy(0,500)");
//						
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
						
//			// Click on Lieferadresse 
//						
//						driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[9]")).click();
//						
//			// Click on Lieferadresse löschen button 
//						driver.findElement(By.xpath("(//a[@id='Login.Submit'])[1]")).click();
//						Thread.sleep(1000);
//						
//						js1.executeScript("window.scrollBy(0,100)");
						
			// Click on next page button (yello button)
						
						driver.findElement(By.xpath("//a[@id='nextStepButton']")).click();
						
						Thread.sleep(1000);
		
						
				/*
				 * WebElement element= driver.findElement(By.xpath(
				 * "(//div[@class='popup--buttons']//button[@class='popup--submit'])[1]"));
				 * ((JavascriptExecutor)driver).executeScript("argument[0].click()",element);
				 * Alert ale=driver.switchTo().alert(); String alerttext = ale.getText();
				 * System.out.println(alerttext); ale.accept();
				 */
						
//			// Click on Pop - up window
//						WebElement popup = driver.findElement(By.xpath("//div[@class='emailPopup popup--overlay']//div[@class='popup']//div[@class='popup--content']//div[@class='popup--buttons']//button[@class='popup--submit']"));
//						
//						if(popup.isDisplayed())
//						{
//							popup.click();
//						}
						
			// Scroll up 
						//js.executeScript("window.scrollBy(0,500)");
						
						//Find element by link text and store in variable "Element"        		
				        WebElement Absluss = driver.findElement(By.id("nextStepButton"));

				        //This will scroll the page till the element is found		
				        js1.executeScript("arguments[0].scrollIntoView();", Absluss);
				        
				        Thread.sleep(2000);
				      js1.executeScript("window.scrollBy(0,10000)");
				        
			// Again click on next button 
						driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='order-commit']")).click();

						
//			// Get the Weborder No
//						js1.executeScript("window.scrollBy(0,2000)");
//						
//			// Click on Abschließen Button
//
//						driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='order-commit']")).click();
//						
//						Thread.sleep(1000);
						
			// Get the Weborder ID
						
						String Weborder  = driver.findElement(By.xpath("//div[@class='startInhalt']//p[@class='widthContentTextCopy']//span")).getText();
						
						System.out.println("Weborder"+" : "+Weborder);

						
						driver.quit();
						
				
			

	}

}
