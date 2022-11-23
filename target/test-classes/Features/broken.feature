#Author: your.email@your.domain.com

Feature: Find broken links in flipkart
 
  Scenario: Broken Link
    Given user login into flipkart
    When user get the list of links
    And user iterated the links list
    Then user verify the list with httpconnection api