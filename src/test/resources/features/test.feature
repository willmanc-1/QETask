@test
Feature: Google Search
This feature verifies Google Searches

   Scenario: Testing that you can enter a search into google and Google will return results
       Given I navigate to Google home page
            When I search for "Flooid"
            Then The page should contain "Flooid"

    Scenario: List 10 top websites that contains the phone number of flooid coventry and validate details other than flooid
         Given I navigate to Google home page
               When I search for "Flooid PCMS +44 (0)24 7669 4455"
               Then I return the top ten website for "Flooid PCMS +44 (0)24 7669 4455"
      
