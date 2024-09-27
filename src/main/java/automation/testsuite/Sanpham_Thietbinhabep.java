package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.Function_bepantoan;

public class Sanpham_Thietbinhabep extends CommonBase{
	@BeforeMethod
	//public void openFireFox() {
	//	driver = initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	//}
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}

	@Test
	public void CheckBtnMuaNgay()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.Clickmuangay();
		assertTrue(isElementVisibility(By.xpath("//h1[text()='Đặt hàng']")));
	}
	@Test
	public void CheckBtnMuatragop()
	{
		Function_bepantoan muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.ClickMuatragop();
		assertTrue(isElementVisibility(By.xpath("//h3[text()='Đăng kí mua trả góp']")));
	}
	@Test
	public void CheckBtnKhaosat()
	{
		Function_bepantoan khaosat;
		khaosat = new Function_bepantoan(driver);
		khaosat.clickKhaosat();
		assertTrue(isElementVisibility(By.xpath("//h3[text()='Đăng kí tư vấn lắp đặt tại nhà']")));
	}
	public void CloseFireFox()
	{
		driver.close();
	}

}
