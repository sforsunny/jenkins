package testRunnerMain;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class RunnerSuite {

	public static void main(String[] args) {

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add(System.getProperty("user.dir")+"\\src\\main\\java\\testng.xml");//path to xml..
		testng.setTestSuites(suites);
		testng.run();
	}
}
