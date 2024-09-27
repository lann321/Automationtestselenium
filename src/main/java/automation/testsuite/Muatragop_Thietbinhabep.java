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

public class Muatragop_Thietbinhabep extends CommonBase{
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

	Function_bepantoan  muatragop;

	String hoten = "ABC Test";
	String sdt ="0362512542";
	String diachi ="Hà Nội";
	String loinhan  ="Mua trả góp";
	@Test
	public void MuatragopSuccess()
	{
		Function_bepantoan  muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.Muatragop(hoten, sdt, diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//div[text()='Đăng ký thành công'])[2]")));
	}
	@Test
	public void MuatragopFail_leaveBlank()
	{
		Function_bepantoan  muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.Muatragop("", "", "", "");
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[2]")));
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[2]")));
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[2]")));
	}
	@Test
	public void MuatragopFail_HotenBlank()
	{
		Function_bepantoan  muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.Muatragop("", sdt, diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Họ và tên không hợp lệ'])[2]")));
	}
	@Test
	public void MuatragopFail_SDTBlank()
	{
		Function_bepantoan  muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.Muatragop(hoten, "", diachi, loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Số điện thoại không hợp lệ'])[2]")));
	}
	@Test
	public void muatragopFail_DiachiBlank()
	{
		Function_bepantoan  muatragop;
		muatragop = new Function_bepantoan(driver);
		muatragop.Muatragop(hoten, sdt, "", loinhan);
		assertTrue(isElementVisibility(By.xpath("(//small[normalize-space()='Địa chỉ không hợp lệ'])[2]")));
	}
	
	@AfterMethod
	public void closeFirefox()
	{
		driver.close();
	}
}
