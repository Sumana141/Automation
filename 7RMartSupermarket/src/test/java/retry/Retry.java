package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");
	private static final int maxTry = 2;
	private int count = 0;

	@Override //overrided from IRetryAnalyzer
	public boolean retry(final ITestResult iTestResult) {
	if (!iTestResult.isSuccess()) {
	if (this.count < maxTry) {
	LOG.info("Retrying test " + iTestResult.getName() + " with status "
	+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s)."); //give it chances of 2 retry.
	this.count++; //count variable declared to save and track the count of retry.
	return true;
	}
	}
	return false;
	}

	public String getResultStatusName(final int status) {
	String resultName = null;
	if (status == 1) {
	resultName = "SUCCESS";
	}
	if (status == 2) {
	resultName = "FAILURE";
	}
	if (status == 3) {
	resultName = "SKIP";
	}
	return resultName;
	}
}
