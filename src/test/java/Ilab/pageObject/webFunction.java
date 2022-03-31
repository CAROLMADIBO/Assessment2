package Ilab.pageObject;

import Ilab.Report.Reporting;
import Ilab.webUtilities.WebAction;
import Ilab.webpageObject.Apply;
import Ilab.webpageObject.Country;
import Ilab.webpageObject.InternOpenings;
import Ilab.webpageObject.LandingPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

public class webFunction extends WebAction {
    Reporting Reporting1 = new Reporting();
    String fileName;

    public void LandingPage(WebDriver driver, ExtentTest test)
    {
        LandingPage LandingPage1 = new LandingPage(driver);
        Country Country1 = new Country(driver);
        try{ clickObject(LandingPage1.CareerLink,driver);
            fileName = Reporting1.CaptureScreenShot(driver);
        if(Country1.CountryLink.isDisplayed()){
        test.fail("successfully clicked career link", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());}
        else {
           test.pass("Unable to click career link",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());


        }
        }catch(Exception e){}


    }
    public void Country(WebDriver driver, ExtentTest test) {

        Country Country1 = new Country(driver);
        InternOpenings InternOpenings1 = new InternOpenings(driver);
        try {
            clickObject(Country1.CountryLink, driver);
            fileName = Reporting1.CaptureScreenShot(driver);

            if (InternOpenings1.InternOpeningsLink.isDisplayed()) {
                test.pass("successfully clicked country link",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
            } else {
                test.fail("Unable to click country link",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());


            }
        } catch (Exception e) {
        }
    }

        public void InternOpenings(WebDriver driver, ExtentTest test) {

            Country Country1 = new Country(driver);

            InternOpenings InternOpenings1 = new InternOpenings(driver);
            Apply Apply1 = new Apply(driver);
            try {
                clickObject(InternOpenings1.InternOpeningsLink,driver);
                fileName = Reporting1.CaptureScreenShot(driver);

                if (Apply1.Apply.isDisplayed()) {
                    test.pass("successfully clicked Intern link", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
                } else {
                    test.fail("Unable to click Intern link",MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());


                }
            } catch (Exception e) {
            }
        }

            public void Apply(WebDriver driver, ExtentTest test, String FirstName, String Email, String phone) {

                Apply Apply1 = new Apply(driver);

                try {
                    clickObject(Apply1.Apply,driver);
                    passData(Apply1.name,driver, FirstName);
                    passData(Apply1.email,driver,Email);
                    passData(Apply1.phone,driver, phone);
                    clickObject(Apply1.sendApplication,driver);
                    fileName = Reporting1.CaptureScreenShot(driver);

                    if (Apply1.errorMsg.isDisplayed()) {
                        test.pass("Application submission unsuccessful", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());
                    } else {
                        test.fail("Application submission successful", MediaEntityBuilder.createScreenCaptureFromBase64String(fileName).build());


                    }
                } catch (Exception e) {
                }
    }}
