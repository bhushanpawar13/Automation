package Logistik;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testfall_logi_sc_tausch_009 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
System.setProperty("webdriver.chrome.driver", "..//Logistik//chrome//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://qatools.kabeldeutschland.de/index.php");
		
		
		// Find the Text box
		WebElement email =driver.findElement(By.id("userfield"));
		
	// Send username in text box 
		email.sendKeys("bhushan.pawar");
		
	// Find the Password field
		WebElement password =driver.findElement(By.name("pass"));
	
	// Send password yes
		password.sendKeys("England2026");
		
	//Find Submit button 
		WebElement submit  = driver.findElement(By.id("linklinelogin"));
	
	//Click on login button 
		submit.click();
	
		//Click on Testkunden link 
		
				driver.findElement(By.xpath("//div[@class='linkList']//a[normalize-space()='Testkunden']")).click();
				
				// *****************
				// Select Environment
				
				Select env = new Select(driver.findElement(By.name("env")));
				env.selectByValue("test2b");
				Thread.sleep(1000);
			// *****************

				
		//*********** Customer Search  ********************
				// Set KAD =1 
				Select KAD = new Select(driver.findElement(By.name("filter[KAD]")));
				KAD.selectByValue("=1");
			
				// Select Customer without open web orders

				Select custtype = new Select(driver.findElement(By.name("filter[HAS_OPEN_ORDERS]")));
				custtype.selectByValue("=0");
				
				// Set converter type =G9
				Select convertertype = new Select(driver.findElement(By.name("filter[CONVERTER_TYPE]")));
				convertertype.selectByValue("G9");
				
				// Select EquipType
				Select EquipType = new Select(driver.findElement(By.name("filter[EQUIP_TYPE]")));
				EquipType.selectByValue("SC");
				
				// Click on Search cust button

				WebElement search_customer = driver.findElement(By.id("startsearch"));
				search_customer.click();
				Thread.sleep(2000);
				
				// Click on logout 
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
				
				Thread.sleep(1000);
				
				//Select TV option 
				WebElement TVCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[3]"));
				 TVCust.click();
				 
				// Scroll Down 
					JavascriptExecutor js = (JavascriptExecutor) driver;
					 js.executeScript("window.scrollBy(0,3000)");
					
					 Thread.sleep(2000);
				
			   // Click on SC-Tausch
					 WebElement SC_Tausch1 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-001-swap']"));
					 //WebElement SC_Tausch2 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-002-swap']"));
					  
					  if(SC_Tausch1.isDisplayed()) {
				       
						  SC_Tausch1.click();
				        
					  }
//					  else if(SC_Tausch2.isDisplayed()){
//						  
//						  SC_Tausch2.click();
//					  }

					  else {
						  
						  System.out.println("Outlet not found");
					  }

					  
					  //Select SCSWLC product
					  
					  String textValue_SCSWLC = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_SCSWAPLOSTC_SCSWLC']//strong[normalize-space()='Kartentausch wegen Verlust beim Kunden [SCSWLC]']")).getText();
					 // String textvalue_ESC  = driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_SCSWAPLOSTC_ESC']")).getText();
						 
					  if(textValue_SCSWLC.equals("Kartentausch wegen Verlust beim Kunden [SCSWLC]")){
						      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_SCSWAPLOSTC_SCSWLC']")).click();
						 }
						 else{
						        System.out.println("Prod Not Found");
						 } 
						 
						
					  //Click on next button Auswahl übernehmen
		                
					  Thread.sleep(1000);
					driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='Login.Submit']")).click();
					
					// Click on  Übersicht / Abschluss
	                
					driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='Login.Submit']")).click();
					
					Thread.sleep(1000);
					
					// Get the Weborder No
					js.executeScript("window.scrollBy(0,3000)");
					
		// Click on Abschließen Button

					driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='order-commit']")).click();
					
					Thread.sleep(1000);
					
		// Get the Weborder ID
					
					String Weborder  = driver.findElement(By.xpath("//div[@class='startInhalt']//p[@class='widthContentTextCopy']//span")).getText();
					
					System.out.println("Weborder"+" : "+Weborder);
							 
						
					driver.quit();

	}

}
