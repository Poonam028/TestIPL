package Avigma.IPL.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Avigma.IPL.PageObject.DashboardPage;
import Avigma.IPL.PageObject.LoginPage;
import Avigma.IPL.PageObject.WorkOrderList;
import Avigma.IPL.PageObject.WorkOrderPage;
import Avigma.IPL.TestComponents.BaseTest;

public class TaskTests extends BaseTest {

	
	@Test
	public void FilterWorkOrder() throws IOException {
		LoginPage loginPage = launchApplication();
		DashboardPage dashboardPage = loginPage.LoginApplication("mike123", "Work2021!");
		dashboardPage.Wait(By.xpath("//button[.='Close']"));
		dashboardPage.DashboardPopUp();
		dashboardPage.VisibilityOfElement(By.xpath("//a[.=' Work Orders ']"));
		dashboardPage.WorkOrderBtn();
		WorkOrderList workOrderList = new WorkOrderList(driver);
	//	dashboardPage.VisibilityOfElement(By.xpath("/html/body/app-root/div/ng-component/div/div/div[2]/div/div/div/div[2]/div/kendo-grid/div/div/div[2]/table/thead/tr[2]/td[6]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input"));
		//String IPLActualFromWorkOrderPage = workOrderPage.GrabIPL();
		workOrderList.InvisibilityOfSpinner(By.xpath("//div[@class=\"overlay ng-tns-c164-0 ng-trigger ng-trigger-fadeIn ng-star-inserted\"]"));
		workOrderList.VisibilityOfElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/ng-component[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/kendo-grid[1]/div[1]/div[1]/div[2]/table[1]/thead[1]/tr[2]/td[8]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]"));
		workOrderList.FilterWorkOrder("242012", "123 Main Street, Anytown, USA 12345");
		workOrderList.InvisibilityOfSpinner(By.cssSelector("body > app-root > div > ng-component > div > div > ngx-spinner > div"));
		workOrderList.Wait(By.xpath("//a[contains(.,'View')]")); 
		workOrderList.ViewWorkOrder();
		WorkOrderPage workOrderPage = new WorkOrderPage(driver);
		workOrderPage.InvisibilityOfSpinner(By.xpath("//div[@class=\"overlay ng-tns-c164-0 ng-trigger ng-trigger-fadeIn ng-star-inserted\"]"));
		workOrderPage.AddInstructionComment("Test comment");
		workOrderPage.Wait(By.xpath("//*[@id='myFrame']/div/iframe"));
		workOrderPage.AddInstruComment("Test comment");
		workOrderPage.VisibilityOfElement(By.xpath("//button[text()='Continue']"));
		workOrderPage.CloseBtn();
		workOrderPage.TaskTabClick();
		workOrderPage.VisibilityOfElement(By.xpath("//div[@class='col-6 p-0 row m-0']//select[@id='TaskType']"));
		workOrderPage.AddBidTask("10", "Bid task comment added successfully");
		workOrderPage.Wait(By.xpath("//div[@class='col-md-12 onLarge row m-0 mt-2 text-dark font-weight-bold']//div[2]//div[1]//div[1]//div[1]//select[1]"));
		workOrderPage.AddCompletionTask("20", "Completion task");
		workOrderPage.Wait(By.xpath("//div[@class='col-12 p-0']//div[3]//div[1]//div[1]//div[1]//select[1]"));
		workOrderPage.AddInspectionTask1("30", "Inspection Comment");
		workOrderPage.Wait(By.xpath("//button[contains(.,'Continue')]"));
		workOrderPage.ClosePopUp();
			}
	}
	
