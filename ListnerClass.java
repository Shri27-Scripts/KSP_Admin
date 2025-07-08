package ksp.admin.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerClass extends Admin_BaseClass implements ITestListener{
	
@Override
	
	public void onTestFailure(ITestResult result) {
		String res= result.getName();
		
		TakesScreenshot Sct= (TakesScreenshot) driver;
		File src= Sct.getScreenshotAs(OutputType.FILE);
		File dest= new File("./ScreenShots/"+res+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	}
	
  @Override
	
	public void onTestSkipped(ITestResult result) {
		String res= result.getName();
		
		TakesScreenshot Sct= (TakesScreenshot) driver;
		File src= Sct.getScreenshotAs(OutputType.FILE);
		File dest= new File("./ScreenShots/"+res+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
  }

}
