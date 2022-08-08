#### INTRODUCTION

This document is designed to detail the scope, approach, resources, and schedule of all testing activities of SHOP-APOTHEKE project.

#### SCOPE

Login feature

##### In Scope
The features to be tested are listed bellow:

| MODULE NAME  | APPLICABLE ROLES | DESCRIPTION                                                               	 |
|--------------|------------------|------------------------------------------------------------------------------|
| LOGIN        | USER             | A user log in with valid credentials (email and password)                   |
| LOGIN   	    | USER             | A user does not log in with invalid credentials (email and/or password)   	 |
| LOGIN        | USER             | A user does not log in without required credentials (email and password)  	 |

#### DETAILED TEST CASE DESCRIPTION

- [Login feature](login.feature)

#### QUALITY OBJECTIVE

The test objectives are to verify the functionality of LOGIN on SHOP-APOTHEKE project focus on user interactions to guarantee the feature described on the scope can work as expected.

#### TEST METHODOLOGY

##### TEST LEVELS

The testing types should be conducted on based on:

+ Exploratory Testing (manual testing to explorer features and cover scenarios that could not be automated);
+ Functional Automated Testing (focus on automated test scenarios of features described on the scope).

##### TEST COMPLETENESS

+ One exploratory test should last at least 30 minutes
+ Run rate is mandatory to be 100% unless a clear reason is given
+ Defects found on automated tests should be reproduced by manual tests
