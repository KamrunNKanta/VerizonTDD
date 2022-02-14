package verizon.qa.reporting;

public class Logger {
	public  static  void log(String msg) {
		JavaLogger.getLog(msg);
		TestNgLogger.getLog(msg);
	}

}
