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
import automation.page.Tubep_FilterPageFactory;

public class Tubep_FilterTest extends CommonBase{
	
	private Tubep_FilterPageFactory filter_TuBep;
	
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
		filter_TuBep = new Tubep_FilterPageFactory(driver);
	}
	 
	@Test(priority = 1)
	public void filterByDanhMuc() {
		filter_TuBep.FilterFunction_DanhMuc();
		assertTrue(isElementVisibility(By.xpath("//h4[text()='Tủ Bếp Inox Cánh Kính AT- 004']")));
	}
	
	@Test(priority = 2)
	public void filterByMucGia() {
		filter_TuBep.FilterFunction_MucGia();
		assertTrue(isElementVisibility(By.xpath("//h4[text()='Tủ Bếp Cánh Kính AT - 002']")));
	}

	@Test(priority = 3)
	public void filterByChatLieu() {
		filter_TuBep.FilterFunction_ChatLieu();
		assertTrue(isElementVisibility(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}
	
	@Test(priority = 4)
	public void filterByKichThuoc() {
		filter_TuBep.FilterFunction_KichThuoc();
		assertTrue(isElementVisibility(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}
	
	@Test(priority = 5)
	public void filterByBaoHanh() {
		filter_TuBep.FilterFunction_BaoHanh();
		assertTrue(isElementVisibility(By.xpath("//span[text()='Rất tiếc, không tìm thấy sản phẩm phù hợp với lựa chọn của bạn']")));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
