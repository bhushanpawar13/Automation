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

public class testfall_logi_kip_opt_019 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "..//automationframe//chrome//chromedriver.exe");

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
		driver.findElement(By.xpath("//input[@type='text' and @name='filter[PRODUCTS]']")).sendKeys("9V2:B03;!OF7;!OF6;!VFT;!FE1;!FM2;!FM3;!FI3;!FI4");
		
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
				 

		//Click on next page button
				 
				driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='skipSelectionButton']")).click();
				
				Thread.sleep(1000);
				
			// Select FI4
				
				 String textValue2 = driver.findElement(By.xpath("//div[@class='checkbox3Column02']//label[@for='id_products_MOBILEOPT_FI4']//strong[normalize-space()='Mobile & International-Allnet-Flat [FI4]']")).getText();

				 if(textValue2.equals("Mobile & International-Allnet-Flat [FI4]")){
				      driver.findElement(By.xpath("//div[@class='checkbox3Column01']//input[@id='id_products_MOBILEOPT_FI4']")).click();
				 }
				 else{
				        System.out.println("Prod Not Found");
				 } 
				 
				//Click on next page button
				 
					driver.findElement(By.xpath("//div[@class='buttonreihe3']//a[@id='applySelectionButton']")).click();
					
					Thread.sleep(1000);
					
				// Select marking codes
					
					Select Marketingcode = new Select(driver.findElement(By.xpath("//div[@class='inputMargin']//select[@id='marketingCode']")));
					Marketingcode.selectByValue("BRI");
					
					Select Werbecode = new Select(driver.findElement(By.id("marketingChannel")));
					Werbecode.selectByValue("INB");
					
					Select Kampagne = new Select(driver.findElement(By.id("campagne")));
					Kampagne.selectByValue("000");
					
				// Check the checkbox for communication channel 
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='dataSharingOptIn']")).click();
					
					driver.findElement(By.xpath("//div[@class='inputMargin']//input[@id='communicationChannelOptIn']")).click();
				 

					// Click on next page button (yello button)
					
					driver.findElement(By.xpath("//a[@id='nextStepButton']")).click();
					
					Thread.sleep(1000);
					
					 JavascriptExecutor js = (JavascriptExecutor) driver;
				      js.executeScript("window.scrollBy(0,10000)");
				        
				      // Again click on next button 
						driver.findElement(By.xpath("(//div[@class='buttonreihe3']//a[@id='order-commit'])")).click();

						
						// Get the Weborder ID
						
						String Weborder  = driver.findElement(By.xpath("//div[@class='startInhalt']//p[@class='widthContentTextCopy']//span")).getText();
						
						System.out.println("Weborder"+" : "+Weborder);

						driver.quit();
					
					
	}

}
