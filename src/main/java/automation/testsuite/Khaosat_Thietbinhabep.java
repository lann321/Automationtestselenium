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

public class Khaosat_Thietbinhabep extends CommonBase{
	@BeforeMethod
	//public void openFireFox()
	//{
	//	driver = initFirefoxDriver(CT_PageURLs.URL_BEPANTOAN);
	//}
	@Parameters("browser")
	public void openBrowser(@Optional("firefox") String browserName) {
		setupDriver(browserName);
		driver.get(CT_PageURLs.URL_BEPANTOAN);
	}

	
	String hoten = "ABC Test";
	String sdt ="0362512542";
	String diachi ="Hà Nội";
	String loinhan  ="Nhận tư vấn";
	@Test
	public void NhanTuVanSuccess()
	{
		Function_bepantoan  khaosat;
		khaosat =  new Function_bepantoan(driver);
		khaosat.khaosat(hoten, sdt, diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//div[text()='Đăng ký thành công'])[2]")));
	}
	@Test
	public void NhanTuVanFail_leaveBlank()
	{
		Function_bepantoan  khaosat;
		khaosat =  new Function_bepantoan(driver);
		khaosat.khaosat("", "", "", "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[1]")));
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[1]")));
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[1]")));
	}
	@Test
	public void NhanTuVanFail_HotenBlank()
	{
		Function_bepantoan  khaosat;
		khaosat =  new Function_bepantoan(driver);
		khaosat.khaosat("", sdt, diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[1]")));
	}
	@Test
	public void NhanTuVanFail_SDTBlank()
	{
		Function_bepantoan  khaosat;
		khaosat =  new Function_bepantoan(driver);
		khaosat.khaosat(hoten, "", diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[1]")));
	}
	@Test
	public void NhanTuVanFail_DiachiBlank()
	{
		Function_bepantoan  khaosat;
		khaosat =  new Function_bepantoan(driver);
		khaosat.khaosat(hoten, sdt, "", loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[1]")));
	}
	
	@AfterMethod
	public void closeFirefox()
	{
		driver.close();
	}
}
