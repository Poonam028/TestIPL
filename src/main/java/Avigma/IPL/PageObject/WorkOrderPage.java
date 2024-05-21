package Avigma.IPL.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Avigma.IPL.AbstractComponents.AbstractComponent;

public class WorkOrderPage extends AbstractComponent {
	WebDriver driver;

	public WorkOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//Task 1 In office result tab 
	@FindBy(xpath = "//div[@class=\"overlay ng-tns-c164-3 ng-trigger ng-trigger-fadeIn ng-star-inserted\"]")
	WebElement Spinner;
	
	
	@FindBy(xpath = "/html/body/app-root/div/ng-component/app-header-client-result/div/div[2]/div[1]/ul/li[1]/b")
	WebElement IPLNumber;
	

	@FindBy(xpath = "//a[.='Office Results ']")
	WebElement OfficeResutBtn;

	@FindBy(xpath = "//div[@class=\"ng-tns-c164-3 ng-star-inserted\"]")
	WebElement OfficeSpinner;

	@FindBy(xpath = "//span[.='Select']")
	WebElement Tasklist;

	@FindBy(xpath = "//li[@index=\"15\"]")
	WebElement TaskOption;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement Quantity;

	@FindBy(xpath = "//select[@class='form-control form-control-sm p-0 ng-pristine ng-valid ng-touched']")
	WebElement UOM;

	@FindBy(xpath = "//select/option[.=' CYD ']")
	WebElement UOMOption;

	@FindBy(xpath = "//input[@class='form-control form-control-sm ng-pristine ng-valid ng-touched']")
	WebElement ContractorPrice;

	@FindBy(css = "tbody tr[type='Bid'] td:nth-child(5) div:nth-child(1) input:nth-child(1)")
	WebElement ContractorTotal;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/div[1]/textarea[1]")
	WebElement CommentBox;

	@FindBy(xpath = "//label[@for='damageBid0']")
	WebElement damageBid;

	@FindBy(xpath = "//div[@id='home2']//button[1]")
	WebElement AddBtn;

	// Task in office result tab
	@FindBy(xpath = "//li[@index=\"10\"]")
	WebElement Task2Option;

	@FindBy(xpath = "//label[@for='violationBid1']")
	WebElement violationBid1;

	@FindBy(xpath = "//div[@id='home2']//button[2]")
	WebElement BidSaveBtn;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
	WebElement QuantityTask2;

	@FindBy(xpath = "//button[.='Close..']")
	WebElement Closebtn;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/app-property-history[1]/div[1]/div[1]/div[2]/app-bid-client-result[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[8]/div[1]/div[1]/textarea[1]")
	WebElement Comment2;

	@FindBy(xpath = "//table[@class=\"result-table table col-11.5 mt-1 mb-1\"]")
	WebElement BidTaskDetails;

	// Checking the bid task details from office result tab and field result tab
	@FindBy(xpath = "//a[.='Field Results ']")
	WebElement FieldResultBtn;

	@FindBy(xpath = "//div[@class='ng-tns-c164-9 ng-star-inserted']")
	WebElement SpinnerOnFieldResults;

	@FindBy(xpath = "//table[@class=\"result-table table col-11.5 mt-1 mb-1\"]")
	WebElement FieldResultDetails;

	@FindBy(xpath = "//div[@id='home2']//button[2]")
	WebElement BidSaveBtn2;

	// Instructions Task
	
	/*
	 * public String GrabIPL() { String IPLNum = IPLNumber.getText(); String[]
	 * IPLNumSplit =IPLNum.split("#"); String IPLActual = IPLNumSplit[1].trim();
	 * System.out.println(IPLActual); return IPLActual;
	 * 
	 * }
	 */
	public void CreateBidTask1() {
		Actions action = new Actions(driver);
		action.scrollToElement(Tasklist);
		Tasklist.click();

	}

	public void CreateBidTask2(String quantity) {
		TaskOption.click();
		Quantity.clear();
		Quantity.sendKeys(quantity);
		// UOM.click();
		// UOMOption.click();
		// ContractorPrice.sendKeys(contractorprice);
		// ContractorTotal.sendKeys(contractortotal);

	}

	public void CreateBidTask3(String comment) {
		CommentBox.sendKeys(comment);
		damageBid.click();
		Actions action = new Actions(driver);
		action.moveToElement(AddBtn);

	}

	public void AddNewTask(String quantity, String comment) {
		AddBtn.click();
		Tasklist.click();
		Task2Option.click();
		QuantityTask2.clear();
		QuantityTask2.sendKeys(quantity);
		Comment2.sendKeys(comment);
		violationBid1.click();
		Actions action = new Actions(driver);
		action.moveToElement(BidSaveBtn);
		BidSaveBtn.click();

	}

	public void OfficeResultTaskDetails() {
		Closebtn.click();
	}

	public String GrabTaskDetails() {
		String TaskDetails = BidTaskDetails.getText();
		// System.out.println(TaskDetails);
		// Need to wait to grab the text
		return TaskDetails;

	}

	public void FieldResultTab() {
		FieldResultBtn.click();

	}

	private void waitForTextToMatch(final WebElement FieldResultDetails, final String TaskDetails) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return FieldResultDetails.getText().equals(TaskDetails);
			}
		});
	}

	public void FieldResultBidTask1(String TaskDetails) {
		waitForTextToMatch(FieldResultDetails, TaskDetails);

		String FieldResultBidTaskDetails = FieldResultDetails.getText();
		if (TaskDetails.equals(FieldResultBidTaskDetails)) {
			System.out.println("Task details match between Office Result and Field Result.");
		} else {
			System.out.println("Task details do not match between Office Result and Field Result.");
		}
		Assert.assertEquals(TaskDetails, FieldResultBidTaskDetails);
		// ACTUAL, EXPECTED

	}

	@FindBy(xpath = "//kendo-editor[@id='myFrame']")
	WebElement iframeElement1;

	@FindBy(xpath = "//*[@id='myFrame']/div/iframe")
	WebElement iframeElement2;

	@FindBy(xpath = "/html/body/div")
	WebElement CommentInstru;

	@FindBy(xpath = "//button[starts-with(text(),' Save ')]")
	WebElement InsCommentSaveBtn;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement Continue;

	@FindBy(css = "body > app-root:nth-child(1) > div:nth-child(2) > ng-component:nth-child(2) > div:nth-child(2) > ng-component:nth-child(2) > div:nth-child(1) > div:nth-child(1) > app-ipl-app-work-order-details-tabs:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")
	WebElement TaskTab;

	@FindBy(xpath = "//div[@class='col-6 p-0 row m-0']//select[@id='TaskType']")
	WebElement TaskType;

	@FindBy(xpath = "//div[@class='col-6 p-0 row m-0']//select[@id='TaskType']/following::span[.='Select']")
	WebElement TaskName;

	@FindBy(xpath = "//li[@index=\"20\"]")
	WebElement TaskNameOpt;

	@FindBy(xpath = "//input[@placeholder=\"Enter Qty\"]")
	WebElement BidTaskQnt;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/textarea[1]")
	WebElement BidTaskComment;

	@FindBy(xpath = "//button[.=' Add Task']")
	WebElement AddTask;

	// Task 2
	@FindBy(xpath = "//div[@class='col-md-12 onLarge row m-0 mt-2 text-dark font-weight-bold']//div[2]//div[1]//div[1]//div[1]//select[1]")
	WebElement TaskType2;

	@FindBy(xpath = "(//input[@placeholder='Enter Qty'])[2]")
	WebElement CompletionTaskQnt;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/textarea[1]")
	WebElement CompletionTaskComment;

	// Task 3
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[2]/div[1]/kendo-dropdownlist[1]/span[1]/span[1]")
	WebElement InspectionTaskName;

	@FindBy(xpath = "//div[@class='col-12 p-0']//div[3]//div[1]//div[1]//div[1]//select[1]")
	WebElement TaskType3;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[10]")
	WebElement InspectionTaskOption;

	@FindBy(xpath = "(//input[@placeholder='Enter Qty'])[3]")
	WebElement InspectionTaskQnt;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/textarea[1]")
	WebElement InspectionTaskComment;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/ng-component[1]/div[1]/div[1]/app-ipl-app-work-order-details-tabs[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/button[2]/i[1]")
	WebElement InstructionSaveBtn;
	
	@FindBy(xpath = "//button[contains(.,'Continue')]")
	WebElement CloseBTN;

	public void AddInstructionComment(String comment) {
		Actions action = new Actions(driver);
		action.scrollToElement(iframeElement1);

	}

	public void AddInstruComment(String comment) {
		Actions action = new Actions(driver);
		driver.switchTo().frame(iframeElement2);
		CommentInstru.sendKeys(comment);
		driver.switchTo().defaultContent();
		action.scrollToElement(InsCommentSaveBtn);
		InsCommentSaveBtn.click();

	}

	public void CloseBtn() {
		// driver.switchTo().frame(IframeContinue);
		Continue.click();

	}

	public void TaskTabClick() {
		Actions action = new Actions(driver);
		action.scrollToElement(TaskTab);
		TaskTab.click();

	}

	public void AddBidTask(String qunatity, String comment) {
		Actions action = new Actions(driver);
		Select dropdown = new Select(TaskType);
		dropdown.selectByVisibleText("Bid");
		TaskName.click();
		TaskNameOpt.click();
		BidTaskQnt.clear();
		BidTaskQnt.sendKeys(qunatity);
		BidTaskComment.sendKeys(comment);
		AddTask.click();
	}

	public void AddCompletionTask(String qunatity, String comment) {
		Actions action = new Actions(driver);
		Select dropdown = new Select(TaskType2);
		dropdown.selectByVisibleText("Completion");
		TaskName.click();
		TaskNameOpt.click();
		CompletionTaskQnt.clear();
		CompletionTaskQnt.sendKeys(qunatity);
		CompletionTaskComment.sendKeys(comment);
		AddTask.click();
	}

	public void AddInspectionTask1(String qunatity, String comment) {
		Actions action = new Actions(driver);
		Select dropdown = new Select(TaskType3);
		dropdown.selectByVisibleText("Inspection");
		InspectionTaskName.click();
		InspectionTaskOption.click();
		InspectionTaskQnt.clear();
		InspectionTaskQnt.sendKeys(qunatity);
		InspectionTaskComment.sendKeys(comment);
		InstructionSaveBtn.click(); // AddTask2.click();
	}
	
	public void ClosePopUp() {
		CloseBTN.click();

	}

	// public void AddInspectionTask2(String qunatity, String comment) {

	// }

}
