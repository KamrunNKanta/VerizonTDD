package verizon.qa.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManger {
	private static ExtentReports extent;

	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			try {
				extent = new ExtentReports();
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./test-output/ExtentReport.html");
				sparkReporter.config().setReporter(sparkReporter);
				extent.attachReporter(sparkReporter);
				JavaLogger.getLog("Reporting is starting ...");
				extent.setSystemInfo("QA Team", "Avengers_Verizon");
				extent.setSystemInfo("Enviroment", "QA");
				extent.setSystemInfo("Assigned tester", System.getProperty("user.name"));
			} catch (Exception e) {
				e.printStackTrace();
				JavaLogger.getLog("Reporting can not started. \n" + e.getLocalizedMessage());
			}
		}

		return extent;
	}

}
