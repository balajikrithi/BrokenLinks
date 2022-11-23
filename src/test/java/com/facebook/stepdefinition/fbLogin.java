package com.facebook.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class fbLogin {

	static WebDriver driver;
	
	@Given("user wants to launch fb")
	public void user_wants_to_launch_fb() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
		driver .get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@When("user wants to click create an account")
	public void user_wants_to_click_create_an_account() {
	    WebElement acc= driver.findElement(By.xpath("(//a[@role='button'])[2]"));
	    acc.click();
	}

	@And("user should provide personal details{string} ,{string} ,{string} ,{string} ,{string}")
	public void user_should_provide_personal_details(String string, String string2, String string3, String string4, String string5) {
		WebElement firstname= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		firstname.sendKeys(string, Keys.ENTER);
		
		WebElement surname= driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		surname.sendKeys(string2, Keys.ENTER);
		
		WebElement email= driver.findElement(By.xpath("(//input[@type='text'])[4]"));
	    email.sendKeys(string3, Keys.ENTER);
	    
	    WebElement reemail= driver.findElement(By.xpath("(//input[@type='text'])[5]"));
	    reemail.sendKeys(string4, Keys.ENTER);
	    
	    WebElement password= driver.findElement(By.xpath("(//input[@type='password'])[2]"));
	  	password.sendKeys(string5, Keys.ENTER);
	  	
	  	driver.findElement(By.xpath("(//a[@id='age_to_birthday_link']")).click();
	  	WebElement age= driver.findElement(By.xpath("(//input[@type='text'])[6]"));
	  	age.sendKeys("37");
	  	age.click();
	}

	@And("user should select the details{string} ,{string} ,{string}")
	public void user_should_select_the_details(String string, String string2, String string3) {
		WebElement day= driver.findElement(By.xpath("//select[@name='birthday_day']"));
		day.click();
		
		Actions a= new Actions(driver);
		WebElement date= driver.findElement(By.xpath("//option[@value='16']"));
		a.moveToElement(day);
		a.click();
		
		WebElement month= driver.findElement(By.xpath("//select[@name='birthday_month']"));
		month.click();
		
		WebElement mon= driver.findElement(By.xpath("(//option[@value='11'])[2]"));
		a.moveToElement(mon);
		a.click();
		
		WebElement year= driver.findElement(By.xpath("//select[@name='birthday_year']"));
		year.click();
		
		WebElement yr= driver.findElement(By.xpath("//option[@value='2020']"));
		a.moveToElement(yr);
		a.click();
	}

	@And("user wants to click creat an account")
	public void user_wants_to_click_creat_an_account() {
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	@Then("user account created succeessfully")
	public void user_account_created_succeessfully() {
	    System.out.println("Created account success");
	}
}
