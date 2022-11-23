#Author: your.email@your.domain.com

Feature: Fb 

  Scenario Outline: Fb account creation
   Given user wants to launch fb
   When user wants to click create an account
   And user should provide personal details"<firstname>" ,"<surname>" ,"<email>" ,"<reemail>" ,"<password>"
   And user should select the details"<day>" ,"<month>" ,"<year>"
   And user wants to click creat an account
   Then user account created succeessfully 

    Examples: 
     |firstname|surname|email|reemail|password|
     |bala|balaji|balakrithi8486@gmail.com|balakrithi8486@gmail.com|Balakrith84|
     |krithi|neha|krithineha8684@gmail.com|krithineha8684@gmail.com|Krithineha86|