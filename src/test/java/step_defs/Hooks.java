package step_defs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.MainPage;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    MainPage mainPage = new MainPage();

    @Before
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

   @After
   public void tearDown(){
        mainPage.logout();
        Driver.closeDriver();
    }
}
