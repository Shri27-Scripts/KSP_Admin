package ksp.admin.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import ksp.admin.pom.LoginPage;

public class Admin_BaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser() {
		Reporter.log("Open Browser",true);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://172.10.1.159:9052/");
	}
	
	@AfterClass
	public void CloseBrowser() {
		Reporter.log("Close Browser",true);
		driver.close();
	}
	
	@BeforeMethod
	public void Login() throws Exception {
		Reporter.log("Login",true);
		
		FileInputStream fis= new FileInputStream("./Input_data/Ksp_Admin_Credentials.xlsx");
		try (Workbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet = wb.getSheet("Login");
			String Username = sheet.getRow(1).getCell(1).getStringCellValue();
			String Password = sheet.getRow(2).getCell(1).getStringCellValue();
			
			LoginPage lp = new LoginPage(driver);
			lp.setLogin(Username, Password);
		}
	}
	
//	@AfterMethod
//	public void Logout() {
//		Reporter.log("Logout",true);
//	}

}
