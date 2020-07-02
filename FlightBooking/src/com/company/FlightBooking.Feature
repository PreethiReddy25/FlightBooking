Feature: FLight Booking Portal

    Background:
      Given I prepare my CREED test in "QA" environment with Zephyr reporting "true"
          |ZephyrCycle        |  ZephyrVersion    | Browser     | Driver Version | YAML       |
          | We will provide cycle name here  | WeWill provide version here | Chrome | 3.4.0| FlightBooking.YAML     |


     Scenario:  Given we are checking the flights and booking based on the fare and fastest travel
        Given I launch the Flight Booking Portal
        When I navigate to Flights tab
        Then I will book a Flight based on the fastest and cheapest travel
          |Delhi India|Bangalore India|