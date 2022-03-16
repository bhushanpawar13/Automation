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

public class testfall_logi_kad_best_007 {

	public static void main(String[] args) throws InterruptedException {
		
		
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
				KAD.selectByValue("=1");
				
		// Set Product filter
				//driver.findElement(By.xpath("//input[@type='text' and @name='filter[PRODUCTS]']")).sendKeys("!TR");
				driver.findElement(By.xpath("//input[@type='text' and @name='filter[CONTRACTS]']")).sendKeys("!IPG");
				
		// Select Customer without open web orders

				Select custtype = new Select(driver.findElement(By.name("filter[HAS_OPEN_ORDERS]")));
				custtype.selectByValue("=0");

		// Search customer address

				Select address = new Select(driver.findElement(By.name("filter[ADDRESSTYPE]")));
				address.selectByValue("NE3-NE4-INV");
				
			// KAD Market 
				Select KADmarket = new Select(driver.findElement(By.name("filter[KAD_WORKFLOW]")));
				KADmarket.selectByValue("B");
				
			
		// Click on Search cust button

				WebElement search_customer = driver.findElement(By.id("startsearch"));
				search_customer.click();
				Thread.sleep(2000);

				//WebElement Clickonlogout=driver.findElement(By.xpath("//*[@id='queue']/tbody/tr/td/div[@class='container']/div[@class='linkline']/div[@id='1_btnecc']/a[normalize-space()='Logout']"));
				//Clickonlogout.click();
				
				Thread.sleep(2000);
				
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
			//Select TV option 
				WebElement TVCust = driver.findElement(By.xpath("(//div[@class='rechtsoben']//img[@class='spinne_icon'])[3]"));
				 TVCust.click();

				// Select Existing outlet 
		
				  WebElement outlet001 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-001-order']"));
				  WebElement outlet002 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-002-order']"));
				  WebElement outlet003 = driver.findElement(By.xpath("//div[@class='buttonreihe3']//button[@id='outlet-003-order']"));
				 
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
				  else if(outlet003.isEnabled()){
					  
					  //This will scroll the page till the element is found
					  JavascriptExecutor js = (JavascriptExecutor) driver;
				      js.executeScript("arguments[0].scrollIntoView();", outlet003);
				      outlet003.click();
				  }
				  else {
					  
					  System.out.println("Outlet not found");
				  }
				  
//		//Select TV product
//				String textValue = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_KDI_TR2']/strong[normalize-space()='Vodafone TV International Russisch Cable [TR2]']")).getText();
//
//				 if(textValue.equals("Vodafone TV International Russisch Cable [TR2]")){
//				      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_KDI_TR2']")).click();
//				 }
//				 else{
//				        System.out.println("Prod Not Found");
//				 } 
//				 
//				 //Click on Next Button 
//				 driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
//				 
//				 Thread.sleep(2000);
//				 


	}

}
