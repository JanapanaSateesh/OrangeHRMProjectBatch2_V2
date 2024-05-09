package com.orangehrm.utilities;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShotCls {

	public String takeSnapShotOnFailure(WebDriver driver) {
		
		///BYTES 1's and 0's
		byte[] screenshotInBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		String screenshot=Base64.getEncoder().encodeToString(screenshotInBytes);
		return screenshot;
	}
}
