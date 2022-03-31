# SeleniumTesting
Ekşi Sözlük is a collaborative hypertext dictionary based on the concept of Web sites built up on user contribution. SeleniumTesting is conveyed on eksisozluk as a model based testing. 

## Tools
The tools used for the testing are graphwalker, maven, selenium and selenide. Model and testing data has been generated using graphwalker. Graphwalker studio may be used to display the model and test scenarios.

## Structure
There are 4 models in total that have been used in this testing project. These models cover homepage, profile, dictionary and log-in models of eksisozluk.com.

## Homepage
This testing model contains the starting vertex of the test. From the starting vertex, the test may go over to the login or dictionary models or use search or channel features.

## Login
Login model contains the login and authorization features of the website. It is reached from the homepage vertex. From here the test can attempt to login, reset password or register. If logged in, the test may go to the userpage model. To reach the homepage model the testing state should be logged out. The website uses captcha on its login page. Therefore, manual input is needed to solve captcha problems.

## Profile
Profile model is used for logged in users. The test can add a biography or a note. Those also have failed testing actions. Another testing is done for the entries. 

## Dictionary
Dictionary test handles the dictionary model of the website. Actions to sort the dictionary or go to a single entry could be made as well as to display share information.
