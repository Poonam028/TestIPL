package Avigma.IPL.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testui.ipreservationlive.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//Sign in
		driver.findElement(By.id("emailaddress")).sendKeys("mike123");
		driver.findElement(By.id("password")).sendKeys("Work2021!");
		driver.findElement(By.id("client_viewdetail_1")).click();

//Dash board
		WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Close']")));
		driver.findElement(By.xpath("//button[.='Close']")).click();

		WebDriverWait WorkOrderWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WorkOrderWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[.=' Work Orders ']")));
		WebElement workorder = driver.findElement(By.xpath("//a[.=' Work Orders ']"));
		workorder.click();
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[.=' No records available. ']")));
		Thread.sleep(5000);
	//	WebElement IPL = driver.findElement(
		//		By.xpath("//td[@id='k-grid5-r1c6']//input[@class='k-textbox ng-pristine ng-valid ng-touched']"));
		//WebElement Contractor = driver.findElement(By
	//			.xpath("//*[@id=\"k-grid0-r1c6\"]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input"));
	Actions action = new Actions(driver);
	//	action.moveToElement(IPL).clickAndHold().moveByOffset(200, 0).release().perform();
	//	WorkOrderWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
	//			"//*[@id=\"k-grid5-r1c6\"]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")));
		Thread.sleep(9000);

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/kendo-grid[1]/div[1]/div[1]/div[2]/table[1]/thead[1]/tr[2]/td[8]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]"))
				.sendKeys("241755");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[contains(.,'Run Filter')]")).click();
		WebDriverWait WorkOrderWait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

		WorkOrderWait1.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@class='ng-tns-c164-1 ng-star-inserted']")));
	//	action.moveToElement(driver.findElement(By.xpath("//tr/td[@id='k-grid0-r2c1']/div/a")));
		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[@class='row ng-star-inserted']//a[@title='view Records']")).click();
		//WorkOrderWait1.until(ExpectedConditions
		//		.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ng-tns-c164-10 ng-star-inserted']")));
		Thread.sleep(9000);
		String IP2L = driver.findElement(By.xpath("//*[@id=\"myTab\"]/li[1]")).getText();
		System.out.println(IP2L);

		WebElement iframeElement = driver.findElement(By.xpath("//kendo-editor[@id='myFrame']"));
		action.scrollToElement(iframeElement);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"myFrame\"]/div/iframe")));
		WebElement Comment = driver.findElement(By.xpath("/html/body/div"));
		/*
		 * action.scrollToElement(Comment);
		 * Comment.sendKeys("Automation testing comment"); // Thread.sleep(9000);
		 * driver.switchTo().defaultContent();
		 */

		/*
		 * * WebElement Save= driver.findElement(By.xpath("//button[.=' Save ']"));
		 * action.moveToElement(Save); Save.click();
		 * driver.findElement(By.xpath("//a[.='Task']")); Thread.sleep(5000); WebElement
		 * TaskType= driver.findElement(By.
		 * xpath("//select[@class='form-control form-control-sm ng-pristine ng-valid ng-touched']"
		 * )); Select dropdown= new Select(TaskType);
		 * dropdown.selectByVisibleText("Bid");
		 */

		// Actions action = new Actions(driver);
		action.moveToElement(workorder).perform();
		driver.findElement(By.xpath("//span[.='Create Work Order']")).click();

		// create work order

		WebDriverWait LoaderWait = new WebDriverWait(driver, Duration.ofSeconds(50));

		LoaderWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//input[@placeholder=\"Enter Order Number...\"]")));
		driver.findElement(By.id("inputEmail42")).sendKeys("9998817162");
		driver.findElement(By.xpath("//label[.='Client *']/following::span[contains(text(),'Select')]")).click();
		WebDriverWait ClientDropdown = new WebDriverWait(driver, Duration.ofSeconds(20));
		ClientDropdown.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@role=\"option\"]")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@index=\"3\"]")).click();
		driver.findElement(By.xpath("//label[.='Work Type *']/following::span[contains(text(),'Select')]")).click();
		driver.findElement(By.xpath("//li[@index=\"4\"]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder=\"Enter Address\"]")).sendKeys("John, Country");
		LoaderWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"/html/body/app-root/div/ng-component/div/div/div/div/div/form/div/div[3]/div[2]/div/div[1]/div/div[2]")));
		try {
			WebElement IPLNumber = driver.findElement(By.xpath(
					"/html/body/app-root/div/ng-component/div/div/div/div/div/form/div/div[3]/div[2]/div/div[1]/div/div[2]"));
			if (IPLNumber.isDisplayed()) {
				String text = IPLNumber.getText();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(IPLNumber);
		driver.findElement(By.xpath("//label[contains(.,'State')]/following::span[contains(text(),'Select')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Select')]/following::input[@tabindex=\"-1\"]"))
				.sendKeys("Nv");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@index=\"0\"]")).click();
		driver.findElement(By.xpath("//label[.='Contractor ']/following::span[contains(text(),'Select')]")).click();
		driver.findElement(By.xpath("//li[@index=\"4\"]")).click();
		driver.findElement(By.xpath("//label[contains(.,'Zip')]/following::input[@placeholder=\"Enter zip...\"]"))
				.sendKeys("123456");
		driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//div[1]//button[1]//i[1]")).click();
		WebElement SelectMonth = driver.findElement(By.xpath("//select[@title='Select month']"));
		Select select = new Select(SelectMonth);
		select.selectByVisibleText("Jul");
		// driver.findElement(By.xpath("//div[@aria-label=\"Tuesday, April 16,
		// 2024\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Na..']")).sendKeys("poonam sawant");
		driver.findElement(By.xpath("//label[contains(.,'City')]/following::input[@placeholder=\"Enter city...\"]"))
				.sendKeys("pune");
// WebElement SaveButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		// action.moveToElement(SaveButton).perform(); SaveButton.click();

	}
}
// WebDriverWait closeButton= new WebDriverWait(driver,Duration.ofSeconds(10));
// closeButton.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Close']")));
/*
 * WebDriverWait Wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
 * Wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//button[.='Close..']")));
 * driver.findElement(By.xpath("//button[.='Close..']")).click();
 * Thread.sleep(5000);
 * driver.findElement(By.xpath("//a[.='Office Results ']")).click();
 * Thread.sleep(6000);
 * action.moveToElement(driver.findElement(By.xpath("//span[.='Select']")));
 * driver.findElement(By.xpath("//span[.='Select']")).click(); //
 * driver.findElement(By.xpath("//li[@index=\"15\"]")).click();
 * Thread.sleep(5000); // driver.findElement( // By.
 * cssSelector("input[class='form-control form-control-sm ng-pristine ng-valid ng-touched']"
 * )) // .sendKeys("10"); // driver.findElement( // By.
 * xpath("//select[@class='form-control form-control-sm p-0 ng-pristine ng-valid ng-touched']"
 * )) // .click(); //
 * driver.findElement(By.xpath("//select/option[.=' CYD ']")).click(); //
 * driver.findElement(By.
 * xpath("//input[@class='form-control form-control-sm ng-pristine ng-valid ng-touched']"
 * )) // .click(); //
 * driver.findElement(By.xpath("//select/option[.=' CYD ']")).click();
 * driver.findElement(By.
 * xpath("//div[@class='row mt-1 ml-0']/following::button[.='Add'][1]")).click()
 * ;
 * 
 * //work order screen //check if all the details are correct
 * 
 * //String[][] formData = {
 * 
 * // {"Work Order #", "9998817162"}, // {"Client", "Five Brothers"}, //
 * {"Work Type", "5BROS QC INTERIOR INSPECTION"}, // {"Address",
 * "John, Country"}, // {"State", "NV"}, // {"Contractor", "Alex Contractor"},
 * // {"City", "Nashik" }, // {"Zip", "123456"}, // {"Estimated Date",
 * "Tuesday, April 16, 2024"}, //};
 * 
 * List<WebElement> displayedElements =
 * driver.findElements(By.xpath("//b[@class=\"ng-star-inserted\"]")); for (int i
 * = 0; i < displayedElements.size(); i++) {
 * 
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 * wait.until(ExpectedConditions.visibilityOfAllElements(displayedElements));
 * String displayedValue = displayedElements.get(i).getText();
 * System.out.println(displayedValue);
 * 
 * }
 * 
 * //for (String[] field : formData) { // String fieldName = field[0]; // String
 * expectedValue = field[1];
 * 
 * // // Assert.assertEquals(expectedValue, displayedValue); //
 * System.out.println("Field Name: " + fieldName + ", Expected Value: " + //
 * expectedValue + ", Displayed Value: " + displayedValue);
 */
