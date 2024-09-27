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
import automation.page.Tubep_MuaNgayPageFactory;

public class Tubep_MuaNgayTest extends CommonBase {
	
	String hoten = "Abc";
	String soDienThoai = "0987654321";
	String diaChi = "Hà Nội";
	
    private Tubep_MuaNgayPageFactory muaNgay_TuBep;
	
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}
	
	@Test(priority = 1)
	public void muaNgayThanhCong() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction(hoten, soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("//h1[text()='Đặt Hàng Thành Công']")));
	}
	
	@Test
	public void muaNgayThatBai_HoTenBlank() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction("", soDienThoai, diaChi);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']")));
	}
	
	@Test
	public void muaNgayThatBai_SoDienThoaiBlank() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction(hoten, "", diaChi);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
	}
	
	@Test
	public void muaNgayThatBai_DiaChiBlank() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction(hoten, soDienThoai, "");
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']")));
	}
	
	@Test
	public void muaNgayThatBai_LeaveBlank() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction("", "", "");
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']")));
	}
	
	@Test
	public void muaNgayThatBai_sdtInvalid() throws InterruptedException {
		muaNgay_TuBep = new Tubep_MuaNgayPageFactory(driver);
		muaNgay_TuBep.MuaNgayFunction(hoten, "0987", diaChi);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}
