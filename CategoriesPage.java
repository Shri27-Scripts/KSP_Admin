package ksp.admin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
	
	@FindBy(xpath = "//a[contains(text(),'Add') and @class='btn add-btn']")
	private WebElement Add;
	
	@FindBy(id = "Category_Code")
	private WebElement Code;
	
	@FindBy(id = "Category_Title")
	private WebElement Title;
	
	@FindBy(id = "Category_OrderIndex")
	private WebElement OrderIndex;
	
	@FindBy(id = "Category_StatusCode")
	private WebElement Status;
	
	@FindBy(xpath = "//a[@class='text-decoration-none btn btn-secondary rounded-5 text-center d-flex align-items-center' and contains(text(),'Cancel')]")
	private WebElement Cancel;
	
	@FindBy(xpath = "//button[@type='submit' and contains(text(),'Save')]")
	private WebElement Save;
	
	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]")
	private WebElement OKConfirm_button;
	
	@FindBy(xpath = "//span[@class='material-symbols-outlined me-2' and contains(text(),'arrow_back')]")
	private WebElement BackButton;
	
	@FindBy(xpath = "((//tr[@data-orderindex='1']//td)//span[contains(text(), 'edit')])[2]")
	private WebElement Edit;
	
	@FindBy(id = "CategoryDTO_Code")
	private WebElement Edit_Code;
	
	@FindBy(id = "CategoryDTO_Title")
	private WebElement Edit_Title;
	
	@FindBy(id = "CategoryDTO.OrderIndex")
	private WebElement Edit_OrderIndex;
	
	@FindBy(id = "CategoryDTO_StatusCode")
	private WebElement Edit_Status;
	
	@FindBy(xpath = "//a[@class='btn btn-secondary rounded-5 text-center d-flex align-items-center text-decoration-none' and contains(text(),'Cancel')]")
	private WebElement Cancel_Edit;
	
	@FindBy(xpath = "((//tr[@data-orderindex='1']//td)//span[contains(text(), 'visibility')])[2]")
	private WebElement View;
	
	@FindBy(xpath = "((//tr[@data-orderindex='1']//td)//span[text()= 'delete'])[2]")
	private WebElement Delete;
	
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Yes, delete it!')]")
	private WebElement Yes_DeleteIt;
	
	@FindBy(xpath = "//button[@type='button' and contains(text(),'Cancel')]")
	private WebElement CancelDelete;
	
	@FindBy(xpath = "//input[@type='checkbox' and @class='form-check-input me-2 header-checkbox']")
	private WebElement HeaderCheckbox; 
	
	@FindBy(xpath = "//tbody[@id='tableBody']/tr[1]//input[@type='checkbox']")
	private WebElement SingleCheckbox;
	
	@FindBy(id = "itemsPerPage")
	private WebElement EntriesPerPage;
	
	@FindBy(id = "statusSelect")
	private WebElement SelectStatus;
	
	@FindBy(id = "submitStatusBtn")
	private WebElement Apply;
	
	@FindBy(id = "search-bar")
	private WebElement Searchbar;
	
	@FindBy(xpath = "//a[@class='page-link' and contains(text(),'2')]")
	private WebElement NextPage;
	
	@FindBy(xpath = "//a[@class='page-link' and contains(text(),'1')]")
	private WebElement PreviousPage;
	
	public CategoriesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getAdd() {
		return Add;
	}
	public WebElement getCode() {
		return Code;
	}
	public WebElement getTitle() {
		return Title;
	}
	public WebElement getOrderIndex() {
		return OrderIndex;
	}
	public WebElement getStatus() {
		return Status;
	}
	public WebElement getCancel() {
		return Cancel;
	}
	public WebElement getSave() {
		return Save;
	}
	public WebElement getOk_Button() {
		return OKConfirm_button;
	}
	public WebElement getBackButton() {
		return BackButton;
	}
	public WebElement getEdit() {
		return Edit;
	}
	public WebElement getEdit_Code() {
		return Edit_Code;	
	}
	public WebElement getEdit_Title() {
		return Edit_Title;	
	}
	public WebElement getEdit_OrderIndex() {
		return Edit_OrderIndex;
	}
	public WebElement getEdit_Status() {
		return Edit_Status;
	}
	public WebElement getCancel_Edit() {
		return Cancel_Edit;
	}
	public WebElement getView() {
		return View;
	}
	public WebElement getDelete() {
		return Delete;
	}
	public WebElement getYes_DeleteIt() {
		return Yes_DeleteIt;
	}
	public WebElement getCancel_Delete() {
		return CancelDelete; 
	}
	public WebElement getHeaderCheckbox() {
		return HeaderCheckbox;
	}
	public WebElement getSingleCheckbox() {
		return SingleCheckbox;
	}
	public WebElement getEntriesPerPage() {
		return EntriesPerPage;
	}
	public WebElement getSelectStatus() {
		return SelectStatus; 
	}
	public WebElement getApply() {
		return Apply;
	}
	public WebElement getSearchbar() {
		return Searchbar; 
	}
	public WebElement getNext_Page() {
		return NextPage;
	}
	public WebElement getPrevious_Page() {
		return PreviousPage; 
	}
}
