package ksp.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(id = "navbarDropdown4")
	private WebElement MasterButton;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item hori-item' and contains(text(),'Applying Types')]")
	private WebElement ApplyingTypes;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Categories')]")
	private WebElement Categories;
	
	@FindBy(xpath = "(//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Districts')])[2]")
	private WebElement Districts;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Document Types')]")
	private WebElement Document_Type;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Ex-Service Educational Qualification')]")
	private WebElement ExService_Education_Qualification;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Army Forces')]")
	private WebElement Army_Forces;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Ex-Servicemen Child Relations')]")
	private WebElement ExServicemen_ChildRelation;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Genders')]")
	private WebElement Genders;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Identity Cards Types')]")
	private WebElement Identity_CardTypes;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Kalayan Karanataka Districts')]")
	private WebElement KalyanaKarnataka_Districts;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Kannada Paper Types')]")
	private WebElement Kannada_PaperTypes;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Union State Territories')]")
	private WebElement UnionState_Territories;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Qualification Board')]")
	private WebElement Qualification_Board;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Recruitment Activities')]")
	private WebElement Recruitement_Activities;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'KSP Wings')]")
	private WebElement KSP_Wings;
	
	@FindBy(xpath = "(//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Sports / Games')])[2]")
	private WebElement Sports_Games;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Sports / Games Achievement')]")
	private WebElement SportsGames_Achievements;
	
	@FindBy(xpath = "(//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Pincode')])[1]")
	private WebElement Pincode;
	
	@FindBy(xpath = "//a[@class='dropdown-item custom-dropdown-item' and contains(text(),'Pincode District')]")
	private WebElement Pincode_District;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMasterButton() {
		return MasterButton;
	}
	public WebElement getApplyingTypes() {
		return ApplyingTypes;
	}
	public WebElement getCategories() {
		return Categories;
	}
	public WebElement getDistricts() {
		return Districts;
	}
	public WebElement getDocumentTypes() {
		return Document_Type;
	}
	public WebElement getExService_EducationQualification() {
		return ExService_Education_Qualification;
	}
	public WebElement getArmyForces() {
		return Army_Forces;
	}
	public WebElement getExService_ChildRelation() {
		return ExServicemen_ChildRelation;
	}
	public WebElement getGenders() {
		return Genders;
	}
	public WebElement getIdentity_CardTypes() {
		return Identity_CardTypes;
	}
	public WebElement getkalyanaKarnataka_Districts() {
		return KalyanaKarnataka_Districts;
	}
	public WebElement getKannada_PaperType() {
		return Kannada_PaperTypes;
	}
	public WebElement getunionState_territories() {
		return UnionState_Territories;
	}
	public WebElement getQualificationBoard() {
		return Qualification_Board;
	}
	public WebElement getRecruitement_Activities() {
		return Recruitement_Activities;
	}
	public WebElement getKSP_Wings() {
		return KSP_Wings;
	}
	public WebElement getSports_Games() {
		return Sports_Games;
	}
	public WebElement getSportsGames_Achievements() {
		return SportsGames_Achievements;
	}
	public WebElement getPincode() {
		return Pincode;
	}
	public WebElement getPincode_District() {
		return Pincode_District;
	}
}
