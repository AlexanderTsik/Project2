package ge.tbc.testautomation.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "searchData")
    public static Object[][] searchDataProvider() {
        return new Object[][] {
                {"ბარი"},
                {"კლუბი"},
                {"სდკგაკსჯგდჰკჯ"}
        };
    }
}

