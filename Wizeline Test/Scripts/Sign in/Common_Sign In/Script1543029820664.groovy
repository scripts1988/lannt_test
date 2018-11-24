import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

	
if (url != null){
	"Open browser and navigate to Core LIMS login page"
	WebUiBuiltInKeywords.openBrowser(url, FailureHandling.STOP_ON_FAILURE)
	"Maximize the browser window"
	WebUiBuiltInKeywords.maximizeWindow(FailureHandling.OPTIONAL)
}

"Click on the Login button in the Welcome page"
WebUiBuiltInKeywords.click(ObjectRepository.findTestObject('Page_Sign In/btn_Login'), FailureHandling.STOP_ON_FAILURE)

"Wait for textbox username visible to make sure page is loaded completely"
isVisible = WebUiBuiltInKeywords.waitForElementVisible(ObjectRepository.findTestObject('Page_Sign In/txt_UserName'), 15, FailureHandling.OPTIONAL)

"Enter username into text field"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('Page_Sign In/txt_UserName'), username, FailureHandling.STOP_ON_FAILURE)
"Enter password into text field"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('Page_Sign In/txt_Password'), password, FailureHandling.STOP_ON_FAILURE)

"Click on Login button"
WebUiBuiltInKeywords.click(ObjectRepository.findTestObject('Page_Sign In/btn_Login'), FailureHandling.STOP_ON_FAILURE)