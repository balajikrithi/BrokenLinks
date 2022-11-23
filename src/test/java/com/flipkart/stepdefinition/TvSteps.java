package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TvSteps {

	String search;
	@When("user search tv")
	public void user_search_tv() {
		search= "Samsung tv";
	   MobileSteps.driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
	   WebElement tvSearch= MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[6]"));
	   String tv1 = tvSearch.getText();
	   tvSearch.click();
	}

	@When("user choose the tv")
	public void user_choose_the_tv() {
		String parent = MobileSteps.driver.getWindowHandle();
		Set<String> allwindow = MobileSteps.driver.getWindowHandles();
		for (String x : allwindow) {
			if(!x.equals(parent));
			{
				MobileSteps.driver.switchTo().window(x);
				System.out.println("window switched");
	}
		}
	}
	
	@When("user search tv by using oneD list")
	public void user_search_tv_by_using_oneD_list(DataTable dataTable) {
		List<String>datas1= dataTable.asList();
		search= datas1.get(1);
		   MobileSteps.driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		   WebElement tvSearch= MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[4]"));
		   String tv1 = tvSearch.getText();
		   tvSearch.click();
		}
	
	@When("user search tv by using oneD map")
	public void user_search_tv_by_using_oneD_map(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String>datas1= dataTable.asMap(String.class, String.class);
		search= datas1.get("tv1");
		   MobileSteps.driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		   WebElement tvSearch= MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		   String tv1 = tvSearch.getText();
		   tvSearch.click();
	}
	
	@When("user search tv {string}")
	public void user_search_tv(String string) {
		search= string;
		   MobileSteps.driver.findElement(By.name("q")).sendKeys(search,Keys.ENTER);
		   WebElement tvSearch= MobileSteps.driver.findElement(By.xpath("(//div[@class='_4rR01T'])[5]"));
		   String tv1 = tvSearch.getText();
		   tvSearch.click();
	}

}


