package TestBase;

import pages.GooglePage;
import pages.loginPage;

public class PageInitializer extends BaseClass{
	
	public static GooglePage google;
	public static loginPage login;
	
	public static void initialize() {
		google=new GooglePage();
		login=new loginPage();
	}
 }
