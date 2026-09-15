package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "LoginData")
	public Object[][] DataSet() {

		Object data[][] = { { "yashraj@yopmail.com", "Yash@123", "Valid" }, { "kishan", "Yash@", "Invalid" },
				{ "", "Yash@123", "Invalid" }, { "yashraj16@yopmail.com", "Yash@123", "Valid" } };

		return data;

	}

}
