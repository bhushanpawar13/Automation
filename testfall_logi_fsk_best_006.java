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

public class testfall_logi_fsk_best_006 {

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
	
	// Send password 
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
		// Set KAD >0 
				Select KAD = new Select(driver.findElement(By.name("filter[KAD]")));
				KAD.selectByValue(">0");
				
		// Set Product filter
				driver.findElement(By.xpath("//input[@type='text' and @name='filter[PRODUCTS]']")).sendKeys("DH5;!D18;ULT");
				
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
				//WebElement Clickonlogout = driver.findElement(By.xpath("//*[@id='queue']/tbody/tr/td/div[@class='system']/div[@class='container']/div[@class='linkline']/div[@id='1_btnhv']/a[normalize-space()='Logout']"));
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

				// Actions action= new Actions(driver);
				// action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
				System.out.println(driver.getCurrentUrl());
				
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username']")).sendKeys("qahv");
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password']")).sendKeys("testTEST-1");
				
				driver.findElement(By.xpath("//input[@id='kc-login']")).click();
	// Click on TV
				
				WebElement TVCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[3]"));
				TVCust.click();

				Thread.sleep(2000);
   // Select Existing outlet 
				
				
				  WebElement outlet001 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-001-order']"));
				  WebElement outlet002 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-002-order']"));
				 
				  if(outlet001.isEnabled()) {
			        //This will scroll the page till the element is found
				  JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("arguments[0].scrollIntoView();", outlet001);
			        outlet001.click();
			        
				  }
				  else if(outlet002.isEnabled()){
					  
					  //This will scroll the page till the element is found
					  JavascriptExecutor js = (JavascriptExecutor) driver;
				      js.executeScript("arguments[0].scrollIntoView();", outlet002);
				      outlet002.click();
				  }
				

				  else {
					  
					  System.out.println("Outlet not found");
				  }
				  
				  
				  // Select D18 Product 
				  
				  String D18Prod = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_VOD_D18']//strong[normalize-space()='FSK 18-PIN [D18]']")).getText();

					if (D18Prod.equals("FSK 18-PIN [D18]")) {
						driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_VOD_D18']")).click();
					} else {
						System.out.println("Prod Not Found");
					}
				  
					
					//Click on next page button

					driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();

					Thread.sleep(1000);
					
	 //Check the marketing information
					
//					Select Marketingcode = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='marketingCode']")));
//					Marketingcode.selectByValue("BRI");
//					
//					Select Werbecode = new Select(driver.findElement(By.id("marketingChannel")));
//					Werbecode.selectByValue("INB");
					
					Select Kampagne = new Select(driver.findElement(By.id("campagne")));
					Kampagne.selectByValue("000");
					
		 //Check the checkbox for communication channel 
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='dataSharingOptIn']")).click();
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='communicationChannelOptIn']")).click();
				
		// Click on Next button
					
					WebElement Absluss = driver.findElement(By.id("nextStepButton"));

				        //This will scroll the page till the element is found	
					 JavascriptExecutor js = (JavascriptExecutor) driver;
				     js.executeScript("arguments[0].scrollIntoView();", Absluss);
		
				 driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='schaltflaechentext'])[7]")).click();
								
					// Click on Abschließen Button

								driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='order-commit']")).click();
								
								Thread.sleep(1000);
								
					// Get the Weborder ID
								
								String Weborder  = driver.findElement(By.xpath("//div[@class='startInhalt']//p[@class='widthContentTextCopy']//span")).getText();
								
								System.out.println("Weborder"+" : "+Weborder);

								driver.quit();
		

	}

}
