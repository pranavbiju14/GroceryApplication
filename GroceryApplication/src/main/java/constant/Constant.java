package constant;

public class Constant {

	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryTestData.xlsx";
	
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials.";
	public static final String VALIDANDINVALIDERROR = "User is able to login with correct username and incorrect password.";
	public static final String INVALIDANDVALIDERROR = "User is able to login with incorrect username and correct password.";
	public static final String INVALIDCREDENTIALERROR =	"User is able to login with invalid credentials.";
	public static final String ADDINGUSERERROR = "Username already exists";
	public static final String SEARCHINGUSERERROR = ".........RESULT NOT FOUND.......";
	public static final String ADDINGDELIVERYBOYERROR = "Delivery Boy Already Exists";
	public static final String ADDINGCATEGORYERROR = "Category Already Exists";
	public static final String SEARCHINGCATEGORYERROR = ".........RESULT NOT FOUND.......";
	public static final String LOGGINGOUTERROR = "User is unable to logout";
	
}
