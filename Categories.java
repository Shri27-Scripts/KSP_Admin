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
import ksp.admin.pom.CategoriesPage;
import ksp.admin.pom.DashboardPage;

@Listeners(ksp.admin.generic.ListnerClass.class)

public class Categories extends Admin_BaseClass{

	@Test
	public void Categories_Scripts() throws InterruptedException {
		
        Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		DashboardPage dp = new DashboardPage(driver);
		
		WebElement master= wait.until(ExpectedConditions.elementToBeClickable(dp.getMasterButton()));
		master.click();
		Thread.sleep(1000);
		WebElement Categories = wait.until(ExpectedConditions.elementToBeClickable(dp.getCategories()));
		Categories.click();
		
		CategoriesPage cp = new CategoriesPage(driver);
		
//		Add functionality
		try {
			FileInputStream inputFile = new FileInputStream("./Input_data/KSP_Admin_Inputs.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(inputFile);
				Sheet sheet01 = wb.getSheet("Categories");

				for (int i = 1; i <=5; i++) {
					WebElement Add = wait.until(ExpectedConditions.elementToBeClickable(cp.getAdd()));
					Add.click();
					Thread.sleep(1000);
					
					try{
						Row row = sheet01.getRow(i);// Excel rows are 0-indexed
						
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

						cp.getCode().sendKeys(code);
						Thread.sleep(1000);
						
						cp.getTitle().sendKeys(title);
						Thread.sleep(1000);
						
						Select status = new Select(cp.getStatus());
						status.selectByVisibleText("Active");
						Thread.sleep(1000);
						
						Select orderIndex = new Select(cp.getOrderIndex());
						orderIndex.selectByIndex(i);
						Thread.sleep(1000);
						
						cp.getSave().click();
						Thread.sleep(1000);
						
						WebElement Ok_Popups = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
						String Popup_Text = Ok_Popups.getText();
						
						if (Popup_Text.contains("Success")) {
							System.out.println("Category Add+ "+Popup_Text);
							cp.getOk_Button().click();
							Thread.sleep(1000);
						} else if(Popup_Text.contains("Error")) {
							System.out.println("Category Add+ "+Popup_Text);
							cp.getOk_Button().click();
							Thread.sleep(1000);
							cp.getCancel().click();
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
		
//		Edit functionality
		cp.getEdit().click();
		Thread.sleep(1000);
		cp.getEdit_Title().clear();
		cp.getEdit_Title().sendKeys("Itt Category");
		Thread.sleep(1000);
		Select s3 = new Select(cp.getEdit_Status());
		s3.selectByVisibleText("Inactive");
		Thread.sleep(1000);
		cp.getSave().click();
		
		WebElement Ok_Popups = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
		String Popup_Text = Ok_Popups.getText();
		
		if (Popup_Text.contains("Success")) {
			System.out.println("Category Edit "+Popup_Text);
			cp.getOk_Button().click();
			Thread.sleep(1000);
		} else if(Popup_Text.contains("Error")) {
			System.out.println("Category Edit "+Popup_Text);
			cp.getOk_Button().click();
			Thread.sleep(1000);
			cp.getCancel_Edit().click();
		} else {
			Reporter.log("No Pop-up Displayed");
		}
		
//		View Functionality
		cp.getView().click();
		Thread.sleep(2000);
		cp.getBackButton().click();
		Thread.sleep(2000);
		
//		Delete Functionality
		WebElement Delete_icon = wait.until(ExpectedConditions.elementToBeClickable(cp.getDelete()));
		Delete_icon.click();
		WebElement Cancel_Delete = wait.until(ExpectedConditions.elementToBeClickable(cp.getCancel_Delete()));
		Cancel_Delete.click();
		Thread.sleep(1000);
		
		Delete_icon.click();
		WebElement Yes_DeleteIt = wait.until(ExpectedConditions.elementToBeClickable(cp.getYes_DeleteIt()));
		Yes_DeleteIt.click();
		cp.getOk_Button().click();
		Thread.sleep(1000);
		
//		CheckBox Functionality
		WebElement HeaderCheckbox = wait.until(ExpectedConditions.elementToBeClickable(cp.getHeaderCheckbox()));
		HeaderCheckbox.click();
		
		Select StatusApply = new Select(cp.getSelectStatus());
		StatusApply.selectByIndex(1);
		WebElement ApplyButton = wait.until(ExpectedConditions.elementToBeClickable(cp.getApply()));
		ApplyButton.click();
		cp.getOk_Button().click();
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement NextPage = wait.until(ExpectedConditions.elementToBeClickable(cp.getNext_Page()));
		NextPage.click();
		
		WebElement SingleCheckbox = wait.until(ExpectedConditions.elementToBeClickable(cp.getSingleCheckbox()));
		SingleCheckbox.click();
		Select StatusApply01 = new Select(cp.getSelectStatus());
		StatusApply01.selectByIndex(2);
		cp.getApply().click();
		Thread.sleep(1000);
		cp.getOk_Button().click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");
		WebElement PreviousPage = wait.until(ExpectedConditions.elementToBeClickable(cp.getPrevious_Page()));
		PreviousPage.click();
		Thread.sleep(1000);
		
		Select EntriesPerPage = new Select(cp.getEntriesPerPage());
		EntriesPerPage.selectByIndex(2);
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
	}
}
