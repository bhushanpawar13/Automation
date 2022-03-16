package Logistik;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testfall_logi_kad_tvtw_017 {

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
		// Set KAD =1 
				Select KAD = new Select(driver.findElement(By.name("filter[KAD]")));
				KAD.selectByValue("=1");
		// Set KAA =1
				Select KAA = new Select(driver.findElement(By.name("filter[KAA]")));
				KAA.selectByValue("=1");
		// Set Product filter
				driver.findElement(By.xpath("//input[@type='text' and @name='filter[PRODUCTS]']")).sendKeys("DF2;HDB:000");
		// Set contract filter
				driver.findElement(By.xpath("//input[@type='text' and @name='filter[CONTRACTS]']")).sendKeys("TRA;VOD;!TRP;!BUN");
		// Set converter type =10
//				Select convertertype = new Select(driver.findElement(By.name("filter[CONVERTER_TYPE]")));
//				convertertype.selectByValue("00");
		// Set Capex value
//				Select capex = new Select(driver.findElement(By.name("filter[capop]")));
//				capex.selectByValue("capex");
		
				
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
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='username']")).sendKeys("qaecctvup");
				driver.findElement(By.xpath("//div[@class='form-group']//input[@name='password']")).sendKeys("testTEST-1");
				
				driver.findElement(By.xpath("//input[@id='kc-login']")).click();
				
				//Actions action= new Actions(driver);
				//action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
				System.out.println(driver.getCurrentUrl());

	}

}
