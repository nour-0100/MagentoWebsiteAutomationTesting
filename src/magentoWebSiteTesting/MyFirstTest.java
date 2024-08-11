package magentoWebSiteTesting;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v125.domstorage.model.Item;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {

	WebDriver driver = new ChromeDriver();

	String myWebsite = "https://magento.softwaretestingboard.com/";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	Random rand = new Random();

	String password = "iLoveMyMom!234k";

	String emailAddressToLogin = "";

	@BeforeTest
	public void mySetup() {
		driver.manage().window().maximize();
		driver.get(myWebsite);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void CreateAnAccount() {

		// xpath
//		WebElement createAccountPage = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));

		// partialLinkText

//		WebElement createAccountPage = driver.findElement(By.partialLinkText("Account"));

		// linkText
//		WebElement createAccountPage = driver.findElement(By.linkText("Create an Account"));
//

		WebElement createAccountPage = driver
				.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));
		createAccountPage.click();

		// example
//		String[] thearrayNameforExampleFirstNames = { "firstname", "firstname2", "firstname3" };

		// first names
		String[] first_Names = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace" };
		// last names
		String[] Last_Names = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };

		int randomIndexForTheFirstName = rand.nextInt(first_Names.length);
		int randomIndexForTheLastName = rand.nextInt(Last_Names.length);

		System.out.println(randomIndexForTheFirstName);
		System.out.println(randomIndexForTheLastName);

		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		WebElement emailAddressInput = driver.findElement(By.id("email_address"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		String firstname = first_Names[randomIndexForTheFirstName];

		String lastname = Last_Names[randomIndexForTheLastName];

		System.out.println(firstname);
		System.out.println(lastname);
		int randomnumber = rand.nextInt(9876);

		String domainName = "@gmail.com";

		firstNameInput.sendKeys(firstname);
		lastNameInput.sendKeys(lastname);
		emailAddressInput.sendKeys(firstname + lastname + randomnumber + domainName);
		passwordInput.sendKeys(password);
		confirmPassword.sendKeys(password);
		createAccountButton.click();

		emailAddressToLogin = firstname + lastname + randomnumber + domainName;

	}

	@Test(priority = 2, enabled = false)
	public void logOut() {
		driver.get(logoutPage);

	}

	@Test(priority = 3, enabled = false)
	public void loginTest() {
		WebElement LoginPage = driver.findElement(By.linkText("Sign In"));
		LoginPage.click();

		WebElement EmailLoginInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.cssSelector(".action.login.primary"));

		EmailLoginInput.sendKeys(emailAddressToLogin);
		passwordInput.sendKeys(password);
		LoginButton.click();
	}

	@Test(priority = 4)

	public void addMenItem() throws InterruptedException {
		WebElement MenSection = driver.findElement(By.cssSelector("#ui-id-5"));
		MenSection.click();

		WebElement OlItemsContainer = driver.findElement(By.className("product-items"));

		System.out.println(OlItemsContainer.findElements(By.tagName("li")).size());
		List<WebElement> Items = OlItemsContainer.findElements(By.tagName("li"));

		int randomIndex = rand.nextInt(Items.size());
		System.out.println(randomIndex);
		Items.get(randomIndex).click();

		WebElement SizesContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));

		List<WebElement> allSizes = SizesContainer.findElements(By.tagName("div"));
		int RandomSize = rand.nextInt(allSizes.size());
		allSizes.get(RandomSize).click();
		
		WebElement colorsContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		
		List<WebElement> allColors =colorsContainer.findElements(By.tagName("div"));
		int RandomColor = rand.nextInt(allColors.size());
		
		allColors.get(RandomColor).click();
			WebElement addToCart = driver.findElement(By.cssSelector("#product-addtocart-button"));
			addToCart.click();
		}
		
}
	
	