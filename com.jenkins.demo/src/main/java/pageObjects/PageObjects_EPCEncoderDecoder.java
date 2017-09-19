package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects_EPCEncoderDecoder {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='epcContainer']/table/tbody/tr/td/div/div[3]/input")
	public WebElement EPC_Pure_Identity_URI;

	@FindBy(xpath = "//*[@id='epcContainer']/table/tbody/tr/td/div/table[2]/tbody/tr/td[4]/div[1]/div[2]/select[1]")
	public WebElement Tag_Size;

	@FindBy(xpath = "//*[@id='epcContainer']/table/tbody/tr/td/div/table[2]/tbody/tr/td[4]/div[1]/div[2]/select[2]")
	public WebElement Filter_Value;

	@FindBy(xpath="//*[@id='epcContainer']/table/tbody/tr/td/div/div[5]/input")
	public WebElement RFID_Tag_EPC_Memory_Bank_Contents;

	public PageObjects_EPCEncoderDecoder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
