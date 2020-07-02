package com.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightBooking {
        private StartTest myTestRunner = CucumberRunner.testRunner.get();
        private WebDriver driver;
        public WebDriverWait wait;
        private int waitTime = 30;
        public FLightBooking() throws Exception {
            StartTest myTestRunner = (StartTest) CucumberRunner.testRunner.get();
            this.selectedBrowser = myTestRunner.getBrowser();
            this.driver = myTestRunner.getUIOperation().getWebDriver();
            this.wait = new WebDriverWait(this.driver, timeOutInSeconds:10L);
            driver.manage().window().maximize();
        }
        //Establishing Database connection
            public static String executeSQLQuery(String query)
            {
                Connection conn;
                String resVal = "";
                ResultSet rset;
                String DB_QAURL= " Need to Provide the DB URL here";
                String DB_USERNAME = "provide user name here";
                String DB_PASSWORD = "provide db password here";
                boolean flag = false;
                try{
                    conn = DriverManager.getConnection(DB_QAURL,DB_USERNAME,DB_PASSWORD);
                    if(conn! = null)
                    {
                        System.out.println("Connected to DB");
                    }
                    else{
                        System.out.println("DataBase Connection failed");
                    }
                    Statement statement = conn.createStatement();
                    rset = statement.executeQuery(query);
                    try
                    {
                        while(rset.next())
                        {
                            if(rset == null)
                            {
                                resVal = "";
                            }
                            else
                            {
                                resVal = rset.getString("1".toString();

                            }
                        }
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            } catch (NullPointerException err)
                {
                    System.out.println("No records obtained");
                    err.printStackTrace();
                }
                conn.close();
            }
            catch( SQL Exception e)

    {
        System.out.println("SQL Exception" + e.getStackTrace());
    }

  @When("^I navigate to Flights tab$")
    public void navigate_to_Flights_tab(DataTable data) throws Exception {
      List<List<String>> input = data.raw();
      Random rand = new Random();
      UIOperation operation = myTestRunner.getUIOperation();
      try {
          operation.click("Login", "MainPage");
          //Login code to use if user is not having account

          operation.setText("MobNum_NewUser", "MainPage", "9999999999");
          operation.setText("Password_FrstUser", "MainPage", "xyzabc");
          operation.click("Policycheck", "MainPage");
          operation.click("VerifyCreate_PWD", "MainPage");
          operation.setText("OTP", "MainPage");
          operation.click("VerifyCreateAccount_OTP", "MainPage");
          String exptext = "Your Account was successfully created";
          Assert.assertEquals("Account is succesfully created", expectedText);
          // Login Code if an account is already present
          operation.setText("MobNum_NewUser", "8989898989");
          operation.click("Continue_Existinguser", "MainPage");
          operation.setText("OTP", "MainPage");
          operation.click("Login_ExistingUser", "MainPage");

          @Then("^I will book a Flight based on the fastest and cheapest travel$")
          public void Book_Flights (DataTable data) throws Exception {
              List<List<String>> input = data.raw();
              Random rand = new Random();
              UIOperation operation = myTestRunner.getUIOperation();
              try {
                  operation.click("OneWay", "MainPage");
                  operation.selectFromDropDownByText("FromPoint", "MainPage", input.get(0).get(0));
                  operation.selectFromDropDownByText("ToPoint", "MainPage", input.get(0).get(1));
                  operation.click("FLightSearch", "MainPage");
                  operation.click("DurationSort", "MainPage");
                  operation.click("DepartureSort", "MainPage");
                  int price;
                  int size;
                  int speed;
                  System.out.println(price.size());
                  for (int i = 0; i < price.size; i++) {
                      System.out.println(price.get(i).getText());
                  }
                  if (price < speed) {
                      System.out.println("Less fare high speed flight is booked");
                  } else {
                      System.out.println("No Flight is less fares and more speed are available");
                  }
              }
              Catch(Exception e)
              {
                  System.out.println(Booking Successfull);
              }
          }
      }
  }

}
