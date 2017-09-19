package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.PageActions_EPCEncoderDecoder;
import utilities.ExcelUtility;

public class TC_Save_RFID_Tag extends ExcelUtility{

	WebDriver driver;

	String URI;
	String Size;
	String Filter;
	public static String Browser = "Chrome";

	@BeforeTest
	public void setup() throws Exception {
		
		if (Browser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver",
		System.getProperty("user.dir") + "\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.kentraub.net/tools/tagxlate/EPCEncoderDecoder.html");
		} else if (Browser.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.kentraub.net/tools/tagxlate/EPCEncoderDecoder.html");
		}
	}

	@Test
	public void tc001_Save_RFID_Tag() throws Exception {
		String RFID_Contents = null;
		PageActions_EPCEncoderDecoder pa_EPCEncoderDecoder = new PageActions_EPCEncoderDecoder(driver);
		int last_row = getRowCount("Sheet1");
		for (int i = 1; i <= last_row; i++) {
			URI = readCellData(i, 0, "Sheet1");
			Size = readCellData(i, 1, "Sheet1");
			Filter = readCellData(i, 2, "Sheet1");
			pa_EPCEncoderDecoder.Enter_EPC_Pure_Identity_URI(URI);
			pa_EPCEncoderDecoder.Select_Tag_Size(Size);
			pa_EPCEncoderDecoder.Select_Filter_Value(Filter);
			RFID_Contents = pa_EPCEncoderDecoder.get_RFID_Tag_EPC_Memory_Bank_Contents();
			writeData(i, 3, "Sheet1", RFID_Contents);
			String s = readCellData(i, 3, "Sheet1");
			System.out.println("the output is "+s);
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
