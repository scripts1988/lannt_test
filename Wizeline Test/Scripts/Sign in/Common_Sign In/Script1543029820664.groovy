import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



if (url != null){
	"Open browser and navigate to Core LIMS login page"
	WebUiBuiltInKeywords.openBrowser(url, FailureHandling.STOP_ON_FAILURE)
	"Maximize the browser window"
	WebUiBuiltInKeywords.maximizeWindow(FailureHandling.OPTIONAL)
}

"Wait for textbox username visible to make sure page is loaded completely"
isVisible = WebUiBuiltInKeywords.waitForElementVisible(ObjectRepository.findTestObject('Object Repository/Sign In Page/txt_UserName'), 15, FailureHandling.OPTIONAL)
"If login page is still not loaded completely -> navigate to this url again"
if(!isVisible && url != null ){
	WebUiBuiltInKeywords.navigateToUrl(url, FailureHandling.STOP_ON_FAILURE)
}

"Enter username into text field"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('bject Repository/Sign In Page/txt_UserName'), username, FailureHandling.STOP_ON_FAILURE)
"Enter password into text field"
WebUiBuiltInKeywords.setText(ObjectRepository.findTestObject('Object Repository/Sign In Page/txt_Password'), password, FailureHandling.STOP_ON_FAILURE)

"Click on Login button"
WebUiBuiltInKeywords.click(ObjectRepository.findTestObject('Object Repository/Sign In Page/btn_Login'), FailureHandling.STOP_ON_FAILURE)