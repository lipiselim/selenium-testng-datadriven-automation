System.out.println(hp.getButton().isDisplayed());
System.out.println(hp.getButton().isEnabled());

@AfterMethod
public void closeBrowser(ITestResult result) throws IOException {
    if (ITestResult.FAILURE == result.getStatus()) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("../megnum/target/" + result.getName() + ".png"));
    }
    driver.close();
}
