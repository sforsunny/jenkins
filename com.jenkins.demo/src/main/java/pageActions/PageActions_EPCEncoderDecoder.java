package pageActions;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.PageObjects_EPCEncoderDecoder;

public class PageActions_EPCEncoderDecoder {

	WebDriver driver;
	// WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
	PageObjects_EPCEncoderDecoder po_EPCEncoderDecoder;

	public PageActions_EPCEncoderDecoder(WebDriver driver) {
		this.driver = driver;
	}

	public void Enter_EPC_Pure_Identity_URI(String URI) {
		po_EPCEncoderDecoder = new PageObjects_EPCEncoderDecoder(driver);
		// po_EPCEncoderDecoder.EPC_Pure_Identity_URI =
		// webDriverWait.until(ExpectedConditions.visibilityOf(po_EPCEncoderDecoder.EPC_Pure_Identity_URI));
		if (po_EPCEncoderDecoder.EPC_Pure_Identity_URI != null) {
			try {
				po_EPCEncoderDecoder.EPC_Pure_Identity_URI.clear();
				po_EPCEncoderDecoder.EPC_Pure_Identity_URI.sendKeys(URI);
			} catch (NoSuchElementException e) {
				System.out.println("Exception message: " + e.getMessage());
			}
		}
	}

	public void Select_Tag_Size(String Size) {
		// po_EPCEncoderDecoder.Tag_Size =
		// webDriverWait.until(ExpectedConditions.visibilityOf(po_EPCEncoderDecoder.Tag_Size));
		if (po_EPCEncoderDecoder.Tag_Size != null) {
			try {
				Select dropdown = new Select(po_EPCEncoderDecoder.Tag_Size);
				dropdown.selectByVisibleText(Size);
			} catch (NoSuchElementException e) {
				System.out.println("Exception message: " + e.getMessage());
			}
		}
	}

	public void Select_Filter_Value(String Filter) {
		// po_EPCEncoderDecoder.Filter_Value =
		// webDriverWait.until(ExpectedConditions.visibilityOf(po_EPCEncoderDecoder.Filter_Value));
		if (po_EPCEncoderDecoder.Filter_Value != null) {
			try {
				Select dropdown = new Select(po_EPCEncoderDecoder.Filter_Value);
				dropdown.selectByVisibleText(Filter);
			} catch (NoSuchElementException e) {
				System.out.println("Exception message: " + e.getMessage());
			}
		}
	}

	public String get_RFID_Tag_EPC_Memory_Bank_Contents() throws Exception {
		String Memory_Bank_Contents = null;
		if (po_EPCEncoderDecoder.RFID_Tag_EPC_Memory_Bank_Contents != null) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(10000);
				Memory_Bank_Contents = (String) js.executeScript("return arguments[0].value;",
						po_EPCEncoderDecoder.RFID_Tag_EPC_Memory_Bank_Contents);
			} catch (NoSuchElementException e) {
				System.out.println("Exception message: " + e.getMessage());
			}
		}
		return Memory_Bank_Contents;
	}

}
