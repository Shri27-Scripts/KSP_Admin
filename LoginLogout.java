package ksp.admin.scripts;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import KspAdmin.ksp.HomePage;
import ksp.admin.generic.Admin_BaseClass;

@Listeners(ksp.admin.generic.ListnerClass.class)

public class LoginLogout extends Admin_BaseClass{
	
	@Test
	public void LoginLogout_Script() throws InterruptedException {
		Reporter.log("Login and Logout Run Successfully",true);
		
		HomePage hp = new HomePage();
		Thread.sleep(2000);
		hp.getProfile().click();
		Thread.sleep(2000);
		hp.getLogout().click();
	}
}
