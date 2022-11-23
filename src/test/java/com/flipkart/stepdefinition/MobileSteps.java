package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSteps {
	
	static WebDriver driver;
	
	@Given("user login to flipkart")
	public void user_login_to_flipkart() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver .get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		try {
			driver.findElement(By.xpath("//button[text()='✕']")).isDisplayed();
			driver.findElement(By.xpath("//button[text()='✕']")).click();
		}catch (Exception e) {
			System.out.println("user login");
		}
	
	}
	
	String search;
	@When("user search mobile")
	public void user_search_mobile() {
		search= "one plus mobile";
	   driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	   WebElement mobileSearch= driver.findElement(By.xpath("(//div[@class='_4rR01T'])[6]"));
	   String mob = mobileSearch.getText();
	   mobileSearch.click();
	}

	@When("user choose the mobile")
	public void user_choose_the_mobile() {
		String parent = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String x : allwindow) {
			if(!x.equals(parent));
			{
				driver.switchTo().window(x);
				System.out.println("window switched");
	}
		}
	}

	@When("user doing payment by using UPI")
	public void user_doing_payment_by_using_UPI() {
	   System.out.println("Dropdown & Screenshot");
	   
	   JavascriptExecutor js= (JavascriptExecutor)driver;
	   WebElement buy= driver.findElement(By.xpath("//button[text()='BUY NOW']"));
	   js.executeScript("arguments[0].scrollIntoView(true)", buy);
	   String text= buy.getText();
	   
	  Assert.assertEquals("BUY NOW", text);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  buy.click();
	}

	@Then("user receives confirmation message")
	public void user_receives_confirmation_message() {
	   System.out.println("finished");
	   driver.quit();
	}
	
	@When("user search mobile by using oneD list")
	public void user_search_mobile_by_using_oneD_list(DataTable dataTable) {
		 List<String>datas= dataTable.asList();
		 
		search= datas.get(4);
		   driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		   WebElement mobileSearch= driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]"));
		   String mob = mobileSearch.getText();
		   mobileSearch.click();
	}
	
	@When("user search mobile by using oneD map")
	public void user_search_mobile_by_using_oneD_map(DataTable dataTable) {
		 Map<String, String>datas= dataTable.asMap(String.class, String.class);
		 
		search= datas.get("phone4");
		   driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		   WebElement mobileSearch= driver.findElement(By.xpath("(//div[@class='_4rR01T'])[8]"));
		   String mob = mobileSearch.getText();
		   mobileSearch.click();
	}
	
	@When("user search mobile {string}")
	public void user_search_mobile(String string) {
		search= string;
	   driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	   WebElement mobileSearch= driver.findElement(By.xpath("(//div[@class='_4rR01T'])[5]"));
	   String mob = mobileSearch.getText();
	   mobileSearch.click();
	}
}
