package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class Tubep_MuaNgayPageFactory extends CommonBase{
	
	private String menuClick = "//a[@class='menu-link' and normalize-space()='Tủ Bếp']";
	private String sp03 = "(//img[@class='block object-contain w-full h-full'])[2]"; 
	private String btnMuaNgay = "(//span[text()='Mua ngay'])[1]";
	private String textHoTen = "//input[@placeholder='Nhập họ và tên']";
	private String textSĐT = "//input[@placeholder='Nhập số điện thoại']";
	private String textDiaChi = "//input[@placeholder='Nhập số nhà, tên đường, phường/ xã, quận/huyện, tỉnh/ thành phố']";
	private String btnThanhToan = "//span[text()='Thanh toán']";
	//@FindBy(xpath = "//h3[text()='Bảo hành']") WebElement menuBaoHanh;
	
	
	public Tubep_MuaNgayPageFactory(WebDriver _driver) {
		super.driver = _driver;
//		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void MuaNgayFunction(String hoTen, String SĐT, String diaChi) throws InterruptedException {
		click(By.xpath(menuClick));
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", menuBaoHanh);
		//scrollToElement(By.xpath("//h3[text()='Bảo hành']"));
		click(By.xpath(sp03));
		Thread.sleep(5000);
		click(By.xpath(btnMuaNgay));
		pause(2000);
		type(By.xpath(textHoTen), hoTen);
		type(By.xpath(textDiaChi), diaChi);
		type(By.xpath(textSĐT), SĐT);
		click(By.xpath(btnThanhToan));
		pause(2000);
	}

}
