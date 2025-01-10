package ge.tbc.testautomation.listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;

public class CustomTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test method " + result.getName() + " started at " + new Date());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logTestDuration(result, "succeeded");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.err.println("Test method " + result.getName() + " failed.");
        // Check if the failure is due to a SoftAssert
        if (result.getThrowable() instanceof AssertionError
                && result.getThrowable().getMessage().contains("The following asserts failed")) {
            System.err.println("Soft assertions failed in test: " + result.getName());
        }
        // Attach a screenshot for any failure
        attachScreenshot(result);
    }
    private void attachScreenshot(ITestResult result) {
        try {
            // Generate a unique name for the screenshot
            String screenshotName = result.getName() + "_" + System.currentTimeMillis();

            // Capture the screenshot
            String screenshotFilePath = Selenide.screenshot(screenshotName);

            // Check if the screenshot was successfully captured
            if (screenshotFilePath == null) {
                System.err.println("Failed to capture screenshot for test: " + result.getName());
                return;
            }

            // Convert the file path to a Path object
            Path screenshotPath = Paths.get(screenshotFilePath).toAbsolutePath();

            // Check if the file exists
            if (!Files.exists(screenshotPath)) {
                System.err.println("Screenshot file does not exist at path: " + screenshotPath);
                return;
            }

            // Attach the screenshot to Allure
            try (InputStream is = Files.newInputStream(screenshotPath)) {
                Allure.addAttachment(result.getName() + "_screenshot", "image/png", is, ".png");
                System.out.println("Screenshot successfully attached to Allure for test: " + result.getName());
            }
        } catch (IOException e) {
            System.err.println("Failed to attach screenshot for test: " + result.getName());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error while attaching screenshot for test: " + result.getName());
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        logTestDuration(result, "skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite execution finished at: " + new Date());
        System.out.println("Passed: " + context.getPassedTests().size());
        System.out.println("Failed: " + context.getFailedTests().size());
        System.out.println("Skipped: " + context.getSkippedTests().size());
    }

    private void logTestDuration(ITestResult result, String status) {
        long duration = System.currentTimeMillis() - result.getStartMillis();
        System.out.println("Test method " + result.getName() + " " + status + ". Duration: " + duration + "ms");
    }
}
