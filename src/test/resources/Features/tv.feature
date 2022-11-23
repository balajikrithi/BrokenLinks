#Author: your.email@your.domain.com
Feature: Tv

Background: 
		Given user login to flipkart

    Scenario: Tv Purchase
    When user search tv
    And user choose the tv
    And user doing payment by using UPI
    Then user receives confirmation message
    
    Scenario: Tv Purchase by one dimensional
    When user search tv by using oneD list
    |Samsung Tv|Sony Tv|
    And user choose the tv
    And user doing payment by using UPI
    Then user receives confirmation message  
    
    Scenario: Tv Purchase by one dimensional
    When user search tv by using oneD map
    |tv1|LG Tv|
    |tv2|OnePlus Tv|
    And user choose the tv
    And user doing payment by using UPI
    Then user receives confirmation message 
    
    Scenario Outline: Tv Purchase
    When user search tv "<Tv>"
    And user choose the tv
    And user doing payment by using UPI
    Then user receives confirmation message
    
    Examples:
    |Tv|
    |Samsung Tv|
    |OnePlus Tv|