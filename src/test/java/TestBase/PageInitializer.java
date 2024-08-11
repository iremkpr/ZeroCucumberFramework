package TestBase;

import pages.GooglePage;

public class PageInitializer extends BaseClass{
	
	public static GooglePage google;
	
	
	public static void initialize() {
		google=new GooglePage();

	}
 }
