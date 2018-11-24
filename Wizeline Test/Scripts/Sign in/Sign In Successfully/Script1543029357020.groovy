


url = 'http://testapp.galenframework.com'
username = 'testuser@example.com'
password = 'test123'

"Call a test case to login"
WebUiBuiltInKeywords.callTestCase(TestCaseFactory.findTestCase('Test Cases/Sign in/Common_Sign In'), ['url' : url, 'username': username, 'password' : password], FailureHandling.STOP_ON_FAILURE)
