package com.flipkart.stepdefinition;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	static WebDriver driver;
	@Given("user login into flipkart")
	public void user_login_into_flipkart() throws InterruptedException {
	// To launch chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
	//To delete all cookies
		driver.manage().deleteAllCookies();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
	// set dynamic wait
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//To enter URL
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	// To maximize window
		driver.manage().window().maximize();
//		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
	}

	@When("user get the list of links")
	public void user_get_the_list_of_links() {
	//links are available with a href tag
	//images are available with img href tag
				
	// To get all the list of all links and images
		List<WebElement> linksList= driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
				
		System.out.println("size of full Links & images:"+ linksList.size());
				
		List<WebElement> activeLinks= new ArrayList<WebElement>();
	}

	@When("user iterated the links list")
	public void user_iterated_the_links_list() {
	// To iterate linksList checks all the links and images whether href is present
		List<WebElement> linksList= driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
				for (int i = 0; i < linksList.size(); i++) {
					System.out.println(linksList.get(i).getAttribute("href"));
					if (linksList.get(i).getAttribute("href") !=null && (! linksList.get(i).getAttribute("href").contains("javascript"))) {
					List<WebElement> activeLinks= new ArrayList<WebElement>();				
						activeLinks.add(linksList.get(i));
			}
				
	// To get the size of activeLinks list
		List<WebElement> activeLinks= new ArrayList<WebElement>();
		System.out.println("size of activeLinks & images:"+ activeLinks.size());
		}
	}
	@Then("user verify the list with httpconnection api")
	public void user_verify_the_list_with_httpconnection_api() throws MalformedURLException, IOException {
		// To check all href url with httpconnection api
		List<WebElement> activeLinks= new ArrayList<WebElement>();
				for (int j = 0; j < activeLinks.size(); j++) {
					
					HttpURLConnection connection= (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
					connection.connect();
					String response= connection.getResponseMessage();
					connection.disconnect();
					System.out.println(activeLinks.get(j).getAttribute("href")+"---->"+response);
	}

	}
				}
