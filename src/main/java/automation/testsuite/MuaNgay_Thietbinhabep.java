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
import automation.page.Function_bepantoan;

public class MuaNgay_Thietbinhabep extends CommonBase{
	@BeforeMethod
	//public void openChrome()
	//{
	//	driver = initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	//}
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}

	
	String hoten ="testABCd";
	String sdt ="03621452143";
	String diachi ="ha noi";
	String loinhan = "Mua ngay";
	@Test
	public void MuangaySuccess()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay(hoten, sdt, diachi,loinhan );
		assertTrue(isElementVisibility(By.xpath("//h1[text()='Đặt Hàng Thành Công']")));
	}
	@Test
	public void MuangayFail_leaveBlank()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay("", "", "", "");
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']")));
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']")));
	}
	@Test
	public void MuangayFail_HotenBlank()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay("", sdt, diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Họ và tên không hợp lệ']")));		
	}
	@Test
	public void MuangayFail_SDTBlank()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay(hoten, "", diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
	}
	@Test
	public void MuangayFail_DiachiBlank()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay(hoten, sdt, "", loinhan);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Địa chỉ không hợp lệ']")));
	}
	@Test
	public void MuangayFail_SDTInvalid()
	{
		Function_bepantoan muangay;
		muangay = new Function_bepantoan(driver);
		muangay.muangay(hoten, "032", diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("//small[normalize-space()='Số điện thoại không hợp lệ']")));
	}
	@AfterMethod
	public void closerFireFox()
	{
		driver.close();
	}
}
