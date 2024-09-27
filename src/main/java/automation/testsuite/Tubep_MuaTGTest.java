package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.Tubep_MuaTraGopPageFactory;

public class Tubep_MuaTGTest extends CommonBase {
	
	String hoten = "Abc";
	String soDienThoai = "0987654321";
	String diaChi = "Hà Nội";
	
    private Tubep_MuaTraGopPageFactory muaTG_TuBep;
	
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}
	
	@Test(priority = 1)
	public void muaTGThanhCong() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction(hoten, soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("(//div[text()='Đăng ký thành công'])[1]")));
	}
	
	@Test(priority = 2)
	public void muaTGThatBai_HoTenBlank() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction("", soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[2]")));
	}
	
	@Test(priority = 3)
	public void muaTGThatBai_SoDienThoaiBlank() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction(hoten, "", diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[2]")));
	}
	
	@Test(priority = 4)
	public void muaTGThatBai_DiaChiBlank() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction(hoten, soDienThoai, "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[2]")));
	}
	
	@Test(priority = 5)
	public void muaTGThatBai_LeaveBlank() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction("", "", "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[2]")));
	}
	
	@Test(priority = 6)
	public void muaTGThatBai_sdtInvalid() {
		muaTG_TuBep = new Tubep_MuaTraGopPageFactory(driver);
		muaTG_TuBep.MuaTGFunction(hoten, "0987", diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[2]")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}

