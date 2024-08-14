package TestBase;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.GooglePage;
import pages.PersonalDetailsPage;
import pages.loginPage;

public class PageInitializer extends BaseClass{
	
	public static GooglePage google;
	public static loginPage login;
	public static DashboardPage dashboard;
	public static EmployeeListPage empListPage;
	public static AddEmployeePage addEmp;
	public static PersonalDetailsPage personalDetails;
 	
	public static void initialize() {
		google=new GooglePage();
		login=new loginPage();
		dashboard=new DashboardPage();
		empListPage=new EmployeeListPage();
		addEmp=new AddEmployeePage();
 		personalDetails=new PersonalDetailsPage();
 	}
 }
