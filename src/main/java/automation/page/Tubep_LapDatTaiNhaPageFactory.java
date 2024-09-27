package automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class Tubep_LapDatTaiNhaPageFactory extends CommonBase{
	private String menuClick = "//a[@class='menu-link' and normalize-space()='Tủ Bếp']";
	private String sp02 = "//h4[text()='Tủ Bếp Cánh Kính AT - 002']"; 
	private String btnKSTV = "(//span[normalize-space()='khảo sát - tư vấn lắp đặt tại nhà'])[1]";
	private String textHoTen = "(//input[@placeholder='Nhập họ và tên'])[1]";
	private String textSĐT = "(//input[@placeholder='Nhập số điện thoại'])[1]";
	private String textDiaChi = " (//input[@placeholder='Nhập địa chỉ'])[1]";
	private String btnNhanTuVan = "(//span[text()='Nhận tư vấn'])[1]";
	
	
	public Tubep_LapDatTaiNhaPageFactory(WebDriver _driver) {
		super.driver = _driver;
//		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LapDatTNFunction(String hoTen, String SĐT, String diaChi) {
		click(By.xpath(menuClick));
		click(By.xpath(sp02));
		click(By.xpath(btnKSTV));
		pause(2000);
		type(By.xpath(textHoTen), hoTen);
		type(By.xpath(textDiaChi), diaChi);
		type(By.xpath(textSĐT), SĐT);
		click(By.xpath(btnNhanTuVan));
		pause(1000);
	}

}
