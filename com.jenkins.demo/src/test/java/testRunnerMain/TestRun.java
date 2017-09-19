package testRunnerMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestRun {

	public void runTestNGTest() {

		TestNG myTestNG = new TestNG();
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("Test Suite");
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("Test");
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		myClasses.add(new XmlClass("testCases.TC_Save_RFID_Tag"));
		myTest.setXmlClasses(myClasses);
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);
		mySuite.setTests(myTests);
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);
		myTestNG.setXmlSuites(mySuites);
		myTestNG.run();
	}

	public static void main(String args[]) {

		TestRun testrunobject = new TestRun();
		testrunobject.runTestNGTest();
	}
}
