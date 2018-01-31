Page Title: Login Page

#Object Definitions
==================================================================================================================================
//textBox_username            xpath               //android.webkit.WebView[@content-desc="TrueID - ไอดีเดียว เติมเต็มความสุขทุกไลฟ์สไตล์ ที่เดียวจบ ครบทุกความต้องการ"]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[3]/android.widget.EditText
textBox_username            xpath               //android.view.View[@resource-id="submitform"]/android.view.View[2]/android.view.View[3]/android.widget.EditText
textBox_password			id                  password
button_signIn				id                  submit
text_successfulMessage		xpath				//XCUIElementTypeStaticText[@name="Login Successful!"]
text_accountMissingError	xpath				//XCUIElementTypeStaticText[@name="account field is required."]
text_passwordMissingError	xpath				//XCUIElementTypeStaticText[@name="Password field is required."]
text_wrongPassword			xpath				//XCUIElementTypeStaticText[@name="Invalid account or password."]
button_cancel				name				Cancel
