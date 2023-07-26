# WebTest

# Automated Test Cases

This repository contains automated test cases for the "Sauce Demo" website. The test cases are written using Selenium and are designed to check the functionality of the website's login process and the "add to cart" feature.

Note: Can use the next script to run the Selenium server before the test execution 

```
java -jar selenium-server-4.10.0.jar standalone
```
## Test Cases

| Feature Owner (Author) | #   | Name                   | Preconditions                                                                                                  | Step # | Description                                            | Expected Result        |
|------------------------|-----|------------------------|----------------------------------------------------------------------------------------------------------------|--------|--------------------------------------------------------|------------------------|
| Andres Garcia          | 1   | Check LogIn            | Active URL: https://www.saucedemo.com/                                                                         | 1      | Request URL                                           | Response Status: 200 OK |
|                        |     |                        | Accepted credentials: user - standard_user, password - secret_sauce                                            | 2      | Input username                                        | Insert text allowed    |
|                        |     |                        | Functional Selenium server at URL: http://192.168.200.1:4444                                                    | 3      | Input password                                        | Insert text allowed    |
|                        |     |                        | Google Chrome Version: 115.0.5790.99                                                                           | 4      | Click on logIn Button                                 | Redirect to product page|
| Andres Garcia          | 2   | Check add to card button | Active URL: https://www.saucedemo.com/                                                                         | 1      | Log in                                                | Redirect to product page|
|                        |     |                        | Product "Sauce Labs Onesie" exists                                                                              | 2      | Click on addToCart button on product "Sauce Labs Backpack" | Product added in cart  |
|                        |     |                        | Accepted credentials: user - standard_user, password - secret_sauce                                            |        | Functional Selenium server at URL: http://192.168.200.1:4444 |                        |
|                        |     |                        | Google Chrome Version: 115.0.5790.99                                                                           |        |                                                        |                        |
