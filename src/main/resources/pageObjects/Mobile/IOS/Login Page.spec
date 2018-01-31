Page Title: Login Page

#Object Definitions
==================================================================================================================================
textBox_username            xpath               //XCUIElementTypeOther[@name="TrueID - ไอดีเดียว เติมเต็มความสุขทุกไลฟ์สไตล์ ที่เดียวจบ ครบทุกความต้องการ"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeTextField
textBox_password			xpath				//XCUIElementTypeOther[@name="TrueID - ไอดีเดียว เติมเต็มความสุขทุกไลฟ์สไตล์ ที่เดียวจบ ครบทุกความต้องการ"]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]/XCUIElementTypeSecureTextField
button_signIn				xpath				//XCUIElementTypeButton[@name="Log in"]
text_successfulMessage		xpath				//XCUIElementTypeStaticText[@name="Login Successful!"]
text_accountMissingError	xpath				//XCUIElementTypeStaticText[@name="account field is required."]
text_passwordMissingError	xpath				//XCUIElementTypeStaticText[@name="Password field is required."]
text_wrongPassword			xpath				//XCUIElementTypeStaticText[@name="Invalid account or password."]
button_cancel				name				Cancel
