package ksp.admin.scripts;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ksp.admin.generic.Admin_BaseClass;
import ksp.admin.pom.ApplyingTypesPage;
import ksp.admin.pom.DashboardPage;

@Listeners(ksp.admin.generic.ListnerClass.class)

public class ApplyingTypes extends Admin_BaseClass{
	
	@Test
	public void ApplyingTypes_Scripts() throws InterruptedException {
		
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		DashboardPage dp = new DashboardPage(driver);
		
		WebElement master= wait.until(ExpectedConditions.elementToBeClickable(dp.getMasterButton()));
		master.click();
		Thread.sleep(1000);
		WebElement ApplyingTypes= wait.until(ExpectedConditions.elementToBeClickable(dp.getApplyingTypes()));
		ApplyingTypes.click();
		
		ApplyingTypesPage atp = new ApplyingTypesPage(driver);
		
//      Add+ Functionality
		try {
			FileInputStream inputFile = new FileInputStream("./Input_data/KSP_Admin_Inputs.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(inputFile);
				Sheet sheet01 = wb.getSheet("ApplyingTypes");

				for (int i = 1; i <=5; i++) {
					WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(atp.getAdd()));
					Add.click();
					Thread.sleep(1000);
					
					try{
						Row row = sheet01.getRow(i); // Excel rows are 0-indexed
						
						if (row == null) {
				            continue;
				        }

				        Cell cellCode = row.getCell(0);
				        Cell cellTitle = row.getCell(1);

				        if (cellCode == null || cellTitle == null) {
				            continue;
				        }

				        String code = cellCode.getStringCellValue();
				        String title = cellTitle.getStringCellValue();

						atp.getCode().sendKeys(code);
						Thread.sleep(1000);
						
						atp.getTitle().sendKeys(title);
						Thread.sleep(1000);
						
						Select status = new Select(atp.getStatus());
						status.selectByVisibleText("Active");
						Thread.sleep(1000);
						
						Select orderIndex = new Select(atp.getOrderIndex());
						orderIndex.selectByIndex(i);
						Thread.sleep(1000);
						
						atp.getSave().click();
						Thread.sleep(1000);
						
						WebElement Ok_Popups = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
						String Popup_Text = Ok_Popups.getText();
						
						if (Popup_Text.contains("Success")) {
							System.out.println("Appying Types Add+ "+Popup_Text);
							atp.getOk_Button().click();
							Thread.sleep(1000);
						} else if(Popup_Text.contains("Error")) {
							System.out.println("Appying Types Add+ "+Popup_Text);
							atp.getOk_Button().click();
							Thread.sleep(1000);
							atp.getCancel().click();
						} else {
							Reporter.log("No Pop-up Displayed");
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
			    }
				wb.close();
			} catch (Exception e) {
			    e.printStackTrace();
		}
		
//		Edit Functionality
		atp.getEdit().click();
		Thread.sleep(1000);
		atp.getEdit_Title().clear();
		atp.getEdit_Title().sendKeys("Itt Candidate");
		Thread.sleep(1000);
		Select s3 = new Select(atp.getEdit_Status());
		s3.selectByVisibleText("Inactive");
		Thread.sleep(1000);
		atp.getSave().click();
		
		WebElement Ok_Popups = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		String Popup_Text = Ok_Popups.getText();
		
		if (Popup_Text.contains("Success")) {
			System.out.println("Appying Types Edit "+Popup_Text);
			atp.getOk_Button().click();
			Thread.sleep(1000);
		} else if(Popup_Text.contains("Error")) {
			System.out.println("Appying Types Edit "+Popup_Text);
			atp.getOk_Button().click();
			Thread.sleep(1000);
			atp.getCancel().click();
		} else {
			Reporter.log("No Pop-up Displayed");
		}
		
//		View functionality
		atp.getView().click();
		Thread.sleep(2000);
		atp.getBackButton().click();
		Thread.sleep(1000);
		
//		Delete Functionality
		WebElement Delete_icon = wait.until(ExpectedConditions.elementToBeClickable(atp.getDelete()));
		Delete_icon.click();
		WebElement Cancel_Delete = wait.until(ExpectedConditions.elementToBeClickable(atp.getCancel_Delete()));
		Cancel_Delete.click();
		Thread.sleep(1000);
		
		Delete_icon.click();
		WebElement Yes_DeleteIt = wait.until(ExpectedConditions.elementToBeClickable(atp.getYes_DeleteIt()));
		Yes_DeleteIt.click();
		atp.getOk_Button().click();
		Thread.sleep(1000);
		
//		CheckBox functionality
		WebElement HeaderCheckbox = wait.until(ExpectedConditions.elementToBeClickable(atp.getHeaderCheckbox()));
		HeaderCheckbox.click();
		
		Select StatusApply = new Select(atp.getSelectStatus());
		StatusApply.selectByIndex(1);
		WebElement ApplyButton = wait.until(ExpectedConditions.elementToBeClickable(atp.getApply()));
		ApplyButton.click();
		atp.getOk_Button().click();
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement NextPage = wait.until(ExpectedConditions.elementToBeClickable(atp.getNext_Page()));
		NextPage.click();
		
		WebElement SingleCheckbox = wait.until(ExpectedConditions.elementToBeClickable(atp.getSingleCheckbox()));
		SingleCheckbox.click();
		Select StatusApply01 = new Select(atp.getSelectStatus());
		StatusApply01.selectByIndex(2);
		atp.getApply().click();
		Thread.sleep(1000);
		atp.getOk_Button().click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");
		WebElement PreviousPage = wait.until(ExpectedConditions.elementToBeClickable(atp.getPrevious_Page()));
		PreviousPage.click();
		Thread.sleep(1000);
		
		Select EntriesPerPage = new Select(atp.getEntriesPerPage());
		EntriesPerPage.selectByIndex(2);
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		}
}

