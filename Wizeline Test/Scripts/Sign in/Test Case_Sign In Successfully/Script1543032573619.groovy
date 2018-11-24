import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

url = internal.GlobalVariable.url
username = internal.GlobalVariable.username
password = internal.GlobalVariable.password

"Call a test case to login"
WebUiBuiltInKeywords.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sign in/Common_Sign In'), ['url' : url, 'username': username, 'password' : password], FailureHandling.STOP_ON_FAILURE)
"Verify user can login successfully"
WebUiBuiltInKeywords.verifyElementPresent(ObjectRepository.findTestObject('Page_Sign In/btn_Add note'), 5, FailureHandling.STOP_ON_FAILURE)

"Delay for a few seconds"
WebUiBuiltInKeywords.delay(5)

"Close browser"
WebUiBuiltInKeywords.closeBrowser()