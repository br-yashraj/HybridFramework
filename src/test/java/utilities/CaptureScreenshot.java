package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public String captureScreenshot(WebDriver driver, String testName) {

		// Convert WebDriver into TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Destination path
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

	public void captureScreenshot1(WebDriver driver, String testName) {

		// Convert WebDriver into TakesScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Destination path
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
