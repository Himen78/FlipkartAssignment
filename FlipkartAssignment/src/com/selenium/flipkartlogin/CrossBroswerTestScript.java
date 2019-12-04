package com.selenium.flipkartlogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBroswerTestScript {

	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void chromeTest(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Himen\\Downloads\\Selenium Related\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Himen\\Downloads\\Selenium Related\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void assignmentExample() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, 10);
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("flipkart");
		
		List<WebElement> printAllSearchOption = driver.findElements(By.xpath("//div[@class='aajZCb']"));
		   w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='aajZCb']")));
			for(int i=0; i<printAllSearchOption.size();i++)
			{
				String printSearchName = printAllSearchOption.get(i).getText();
				System.out.println(printSearchName);
			}
		
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector("cite[class='iUh30']")).click();
		driver.findElement(By.cssSelector("button[class='_2AkmmA _29YdH8']")).click();

		// Click on TV & Appliances drop-down

		driver.findElement(By.xpath("//span[text()='TVs & Appliances']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Window ACs']")));
		driver.findElement(By.xpath("//a[text()='Window ACs']")).click();

		// Click on “Add To Compare” checkbox of 2nd and 3rd product displayed.

		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[3]/div/div/div/a/div[1]/div[2]/div/label/span"))
				.click();
		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[2]/div[4]/div/div/div/a/div[1]/div[2]/div/label/span"))
				.click();

		// Then Click on COMPARE button.

		driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
		driver.findElement(By.xpath("//body/div[@id='container']/div/div[@id='fk-compare-page']/div[@class='_3Yugl7']/div[@class='_37Mj_H']/div/div[@class='_1SVp3c']/div[@class='_1k1axX _1DLH7w']/div[@class='row']/div[@class='col-2-5']/div[1]/div[1]/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//div[@class='LG4KV_']//div[@class='_2KISpu'][contains(text(),'Samsung')]")).click();

		driver.findElement(By.xpath("//div[@class='_3092M2 LykW5d'][contains(text(),'Choose a Product')]")).click();
		driver.findElement(By.xpath("//div[@class='LG4KV_']//div[@class='_3ozNsv']//div[1]")).click();
		
		System.out.println("--- Compare Page Data----");
		
		List<WebElement> getAllPrice = driver.findElements(By.cssSelector("div[class='_1vC4OE']"));
		for(int i=0; i<getAllPrice.size();i++)
		{
			String printPrice = getAllPrice.get(i).getText();
			System.out.println(printPrice);
		}
		
		List<WebElement> getAllItemName = driver.findElements(By.cssSelector("a[class='_3YNWH1']"));
		for(int i=0; i<getAllItemName.size();i++)
		{
			String printItemName = getAllItemName.get(i).getText();
			System.out.println(printItemName);
		}
		
		
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Browser Close");
		driver.close();
		System.out.println("Test Run Successfully....");
		
	}

}
