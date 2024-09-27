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
import automation.page.Tubep_LapDatTaiNhaPageFactory;

public class Tubep_LapDatTaiNhaTest extends CommonBase{
	
	String hoten = "Abc";
	String soDienThoai = "0987654321";
	String diaChi = "Hà Nội";
	
    private Tubep_LapDatTaiNhaPageFactory lapDatTN_TuBep;
	
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}
	
	@Test(priority = 1)
	public void tuVanThanhCong() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction(hoten, soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("(//div[text()='Đăng ký thành công'])[2]")));
	}
	
	
	@Test(priority = 2)
	public void tuVanThatBai_HoTenBlank() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction("", soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[1]")));
	}
	
	@Test(priority = 3)
	public void tuVanThatBai_SoDienThoaiBlank() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction(hoten, "", diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[1]")));
	}
	
	@Test(priority = 4)
	public void tuVanThatBai_DiaChiBlank() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction(hoten, soDienThoai, "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[1]")));
	}
	
	@Test(priority = 5)
	public void tuVanThatBai_LeaveBlank() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction("", "", "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[1]")));
	}
	
	@Test(priority = 6)
	public void tuVanThatBai_sdtInvalid() {
		lapDatTN_TuBep = new Tubep_LapDatTaiNhaPageFactory(driver);
		lapDatTN_TuBep.LapDatTNFunction(hoten, "0987", diaChi);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[1]")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
