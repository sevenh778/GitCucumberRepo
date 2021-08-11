package stepdefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NinjaRegistration {
	
	public WebDriver driver = null;
	
	@Before("@reg")
	public void browserInitiation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Given("^I launch the registration page from ninja url$")
	public void I_launch_the_registration_page_from_ninja_url() {
	
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	}
	@And("^I entered below details$")
	public void I_entered_below_details(DataTable data) {
		          Map<String, String> dataMap = data.asMap(String.class,String.class);
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("Firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("Secondname"));
		driver.findElement(By.name("email")).sendKeys(dataMap.get("Email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password"));
		
		}
	@When("^I accepted the privacy policy and clicked submit$")
		public void I_accepted_the_privacy_policy_and_clicked_submit() {
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
		}
	@Then("^User registered successfully$")
	public void User_registered_successfully() {
		
		try {
			boolean actual = driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed();
			Assert.assertTrue(actual, "YOU logged in successfully");
		}catch(Exception e) {
			System.out.println("Mail id is already registered , kindly give other mail = "   +e);
		}
		
		
			
	}
	@After("@reg")
	public void teardown() {
		driver.quit();
	}
		
	}

	


