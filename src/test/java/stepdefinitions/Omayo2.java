package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
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

public class Omayo2 {

	public WebDriver driver;

	@Before("@omayologin") // tagged hooks (which will run for only tag (@Ninja) tagged scenario's
	public void browserInitiation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^I navigated to the blog home page$")
	public void i_navigated_to_the_blog_home_page() {

		driver.get("https://omayo.blogspot.com/");
	}

	@When("^I have entered (.+) and (.+)$")
	public void i_have_entered_and(String username, String password) {
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pswrd']")).sendKeys(password);
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			System.out.println("division with zero is undefined, kindly check it =" + e);
		}

	}

	@And("^I click on submit button$")
	public void i_click_on_submit_button() {
		driver.findElement(By.xpath("//input[@type='button'][@value='Login']")).click();

	}

	@Then("^User should be login with the (.+) status$")
	public void user_should_be_login_with_the_status(String expected) {
		String actual = null;

		try {
			Alert alert = driver.switchTo().alert();
			if (alert.getText().contains("Error Password or Username")) {

				actual = "Failure";
				System.out.println(">>>>>> I am in try block");

			}

		} catch (Exception e) {
			actual = "Success";

			System.out.println(">>>>>> I am in catch block");
		}

		Assert.assertEquals(expected, actual);

		System.out.println("user login with the expected status=   " + expected);

	}

	@After("@omayologin")
	public void teardown() {
		driver.quit();
	}

}
