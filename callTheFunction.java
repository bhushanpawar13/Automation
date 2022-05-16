package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AutoTrial.excelread;
import AutoTrial.excelwrite;

public class callTheFunction {

	public static void main(String[] args) throws IOException {
	
	//	System.setProperty("webdriver.chrome.driver", "..//auto//chrome//chromedriver.exe");
	//	WebDriver driver = new ChromeDriver();
		
	
		excelread ex = new excelread();
		ex.read();
		
		excelwrite ew = new excelwrite();
		ew.write();

	}

	private static void read() {
		// TODO Auto-generated method stub
		
	}

}
