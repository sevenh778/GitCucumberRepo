package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Ninjalogin {

	public WebDriver driver;

	@Before("@Ninja") // tagged hooks (which will run for only tag (@Ninja) tagged scenario's
	public void browserInitiation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^I launched the Ninja website and lauched login page$")
	public void i_launched_the_ninja_website_and_lauched_login_page() {
		// System.setProperty(webdriver.chromedriver.setup(), null)

		driver.get("http://www.tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	@And("^I entered username and password$")
	public void i_entered_username_and_password() {
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("sukumar89@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("nlr@123");
	}

	@When("^i click on submit button$")
	public void i_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("^user logged in successfully$")
	public void user_logged_in_successfully() {
		String validate = driver.findElement(By.xpath("//body/div[@id='account-account']/ul[1]/li[2]/a[1]")).getText();

		Assert.assertEquals("Account", validate);

		System.out.println("successfully logged in to the ninja");

	}

// second scenario

	@And("^I entered invalid username and password$")
	public void i_entered_invalid_username_and_password() {
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("sukumar99@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("nlr@123");
	}

	@Then("^user failed to login to the website$")
	public void user_failed_to_login_to_the_website() {
		boolean failedlogin = driver.findElement(By.cssSelector(
						"body:nth-child(2) div.container:nth-child(4) > div.alert.alert-danger.alert-dismissible")).isDisplayed();
		System.out.println("Failed to login =  " + failedlogin);

		Assert.assertTrue("User fails to login with wrong credentials, this is yedu statement", failedlogin);
		System.out.println("Yes user failed to login , this we require");

	}

	@And("^I not entered any values$")
	public void i_not_entered_any_values() {
		System.out.println("USER NOT ENTERED ANY VALUES");
	}

	@After("@Ninja")
	public void teardown() {
		driver.quit();
	}

}
