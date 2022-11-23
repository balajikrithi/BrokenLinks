#Author: your.email@your.domain.com
Feature: Mobile

Background: 
		Given user login to flipkart

  Scenario: Mobile Purchase
    When user search mobile
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message

  Scenario: Mobile Purchase by one dimensional
    When user search mobile by using oneD list
    |Realme|Samsung|Oppo|Vivo|iPhone|OnePlus|
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
    
     Scenario: Mobile Purchase by one dimensional
    When user search mobile by using oneD map
    |phone1|Realme|
    |phone2|Samsung|
    |phone3|Oppo|
    |phone4|Vivo|
    |phone5|iPhone|
    |phone6|Oneplus|
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
    
    Scenario Outline: Mobile Purchase
    When user search mobile "<phone>"
    And user choose the mobile
    And user doing payment by using UPI
    Then user receives confirmation message
    
    Examples: 
    |phone|
    |Realme|
    |Samsung|
    |Oppo|
    |Vivo|
    |iPhone|
    |Oneplus|
    
    
    