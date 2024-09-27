	package automation.page;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import automation.common.CommonBase;

	public class Tubep_MuaTraGopPageFactory extends CommonBase{
		
		private String menuClick = "//a[@class='menu-link' and normalize-space()='Tủ Bếp']";
		private String sp04 = "//h4[text()='Tủ Bếp Inox Cánh Kính AT- 004']"; 
		private String btnMuaTG = "//div[@class='w-full px-1 md:w-1/2']//span[text()='Mua trả góp']";
		private String textHoTen = "(//input[@placeholder='Nhập họ và tên'])[2]";
		private String textSĐT = "(//input[@placeholder='Nhập số điện thoại'])[2]";
		private String textDiaChi = " (//input[@placeholder='Nhập địa chỉ'])[2]";
		private String btnNhanTuVan = "(//span[text()='Nhận tư vấn'])[2]";
		
		
		public Tubep_MuaTraGopPageFactory(WebDriver _driver) {
			super.driver = _driver;
//			this.driver = _driver;
			PageFactory.initElements(_driver, this);
		}
		
		public void MuaTGFunction(String hoTen, String SĐT, String diaChi) {
			click(By.xpath(menuClick));
			click(By.xpath(sp04));
			click(By.xpath(btnMuaTG));
			pause(2000);
			type(By.xpath(textHoTen), hoTen);
			type(By.xpath(textDiaChi), diaChi);
			type(By.xpath(textSĐT), SĐT);
			click(By.xpath(btnNhanTuVan));
			pause(1000);
		}
	}



