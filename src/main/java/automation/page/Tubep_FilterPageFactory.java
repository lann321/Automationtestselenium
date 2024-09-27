package automation.page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.dom.model.PhysicalAxes;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.common.CommonBase;

public class Tubep_FilterPageFactory extends CommonBase{

	private String menuClick = "//a[@class='menu-link' and normalize-space()='Tủ Bếp']";
	private String danhMuc = "//a[text()='Tủ Bếp Inox Cánh Kính']";
	private String mucGia = "//span[normalize-space()='< 3.000.000']";
	private String chatLieu = "//span[text()='Inox 201']";
	private String kichThuoc = "//span[text()='600 mm']";
	private String baoHanh = "//span[text()='3 năm']";
	
	public Tubep_FilterPageFactory(WebDriver _driver) {
		super.driver = _driver;
//		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	

	public void FilterFunction_DanhMuc() {
		click(By.xpath(menuClick));
		pause(2000);
		click(By.xpath(danhMuc));
	}
	
	public void FilterFunction_MucGia() {
		click(By.xpath(menuClick));
		pause(2000);
		click(By.xpath(mucGia));
	}
	
	public void FilterFunction_ChatLieu() {
		click(By.xpath(menuClick));
		pause(3000);
//		scrollToElement(By.xpath("//h3[text()='Kích Thước']"));
		click(By.xpath("(//div[@class='category-menus']//span[text()='Xem thêm'])[1]"));
		pause(3000);
		scrollToElement(By.xpath("//span[text()='Thu gọn']"));
		click(By.xpath(chatLieu));
	}
	
	public void FilterFunction_KichThuoc() {
		click(By.xpath(menuClick));
		pause(2000);
		click(By.xpath(kichThuoc));
	}
	
	public void FilterFunction_BaoHanh() {
		click(By.xpath(menuClick));
		pause(2000);
		click(By.xpath(baoHanh));
	}

}
