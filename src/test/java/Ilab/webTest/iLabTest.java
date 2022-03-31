package Ilab.webTest;

import Ilab.Database.DatabaseConnection;
import Ilab.GenerateNumber.RandomNumber;
import Ilab.Report.Reporting;
import Ilab.pageObject.webFunction;
import Ilab.webUtilities.WebUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class iLabTest {
    WebUtilities WebUtilities1 = new WebUtilities();
    RandomNumber RandomNumber1 = new RandomNumber();
    webFunction webFunction1 = new webFunction();
    String sURL, sBrowser;
    Reporting Reporting1 = new Reporting();
    ExtentReports ExtentReports1 ;
    DatabaseConnection DatabaseConnection1 = new DatabaseConnection();
    @Parameters({"ILABURL","Browser"})
    @BeforeTest
    public void initialiseBrowser(String suRL, String browser) {
        sURL = suRL;
        sBrowser = browser;
        WebUtilities1.setWebDriver(WebUtilities1.initializeWebDriver(sBrowser));
        ExtentReports1 = Reporting1.initializeExtentReports("Reports/iLabReports.html");
    }

    @Test

    public void Ilab() throws InterruptedException {
        ExtentTest test = ExtentReports1.createTest("iLabReports");
        test.assignAuthor("CarolMadibo");
        ExtentTest Node;
        ResultSet RS;
        try {
            RS = DatabaseConnection1.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/ilab",
                    "root", "carolThato12", "Select * from iLabData");
            int iRow = DatabaseConnection1.rowCount(RS);
            WebUtilities1.navigate(sURL);
            for (int i = 1; i <= iRow; i++) {
                if (RS.next()) {
                    WebUtilities1.navigate(sURL);
                    webFunction1.LandingPage(WebUtilities1.getWebDriver(), test);
                    webFunction1.Country(WebUtilities1.getWebDriver(), test);
                    webFunction1.InternOpenings(WebUtilities1.getWebDriver(), test);
                    webFunction1.Apply(WebUtilities1.getWebDriver(), test, RS.getString("Firstname"),RS.getString("Email"), RandomNumber1.RandomGenerator());

                }
            }
            RS.close();
        } catch (Exception e) {

        }
    }

        @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        WebUtilities.getWebDriver().quit();
        ExtentReports1.flush();
    }


}



