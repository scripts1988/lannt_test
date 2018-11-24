import org.apache.commons.lang.RandomStringUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable

url = internal.GlobalVariable.url
username = internal.GlobalVariable.username
password = internal.GlobalVariable.password
now = new Date()
noteTitle = 'Test Note' + now
noteDesc = "Test Descripption " + RandomStringUtils.randomAlphanumeric(120)

"Call a test case to login"
WebUiBuiltInKeywords.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sign in/Common_Sign In'), ['url' : url, 'username': username, 'password' : password], FailureHandling.STOP_ON_FAILURE)
"Verify user can login successfully"
WebUiBuiltInKeywords.verifyElementPresent(ObjectRepository.findTestObject('Object Repository/Page_Sign In/btn_Add note'), 5, FailureHandling.STOP_ON_FAILURE)

"Click on Add note button"
WebUiBuiltInKeywords.click(ObjectRepository.findTestObject('Object Repository/Page_Sign In/btn_Add note'), FailureHandling.STOP_ON_FAILURE)
"Verify the Add note page display"
WebUiBuiltInKeywords.verifyElementPresent(ObjectRepository.findTestObject('Object Repository/Page_Add Note/txt_Note Title'), 5, FailureHandling.STOP_ON_FAILURE)

"Input the title"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('Object Repository/Page_Add Note/txt_Note Title'), noteTitle , FailureHandling.STOP_ON_FAILURE)
"Input the note description"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('Object Repository/Page_Add Note/txb_Note Description'), noteDesc , FailureHandling.STOP_ON_FAILURE)
"Click on Add note button"
WebUiBuiltInKeywords.click(ObjectRepository.findTestObject('Object Repository/Page_Add Note/btn_Add Note'), FailureHandling.STOP_ON_FAILURE)
"Modify the xpath of the link to My Note"
newLinkObj = WebUiBuiltInKeywords.modifyObjectProperty(ObjectRepository.findTestObject('Object Repository/Page_My Notes/lnk_My Note'), "xpath", 'equals', "//div[@id='my-notes-page']//a/h4[text() = '$noteTitle']", true, FailureHandling.STOP_ON_FAILURE)
"Verify the note is added successfully"
WebUiBuiltInKeywords.verifyElementPresent(newLinkObj, 5, FailureHandling.STOP_ON_FAILURE)
"Click on my note link"
WebUiBuiltInKeywords.click(newLinkObj, FailureHandling.STOP_ON_FAILURE)
"Get text of the note description"
actualText = WebUiBuiltInKeywords.getText(ObjectRepository.findTestObject('Object Repository/Page_Add Note/txb_Note Description'), FailureHandling.STOP_ON_FAILURE)
"Verify the note description is saved correctly"
WebUiBuiltInKeywords.verifyMatch(actualText, noteDesc, false, FailureHandling.STOP_ON_FAILURE)

"Delay for a few seconds"
WebUiBuiltInKeywords.delay(5)

"Close the browser"
WebUiBuiltInKeywords.closeBrowser(FailureHandling.STOP_ON_FAILURE)