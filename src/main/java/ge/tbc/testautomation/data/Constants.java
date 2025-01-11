package ge.tbc.testautomation.data;

import java.util.List;


public class Constants {
    public final static String ALLY_TESTING_URL = "https://google.com";


    public final static String SAUCE_BASE_URL = "https://saucedemo.com";
    public final static String SWOOP_BASE_URL = "https://swoop.ge";

    public static final int USER_ID = 1;
    public static final int LOCKEDOUT_USER_ID = 2;

    public static final int FILTER_OPTION = 0;

    public static final String ERROR_MESSAGE = "Epic sadface: Sorry, this user has been locked out.";


    // Georgian Labels
    public static final List<String> GEORGIAN_LABELS = List.of(
            "კინო", "დასვენება", "გართობა", "კვება", "საბავშვო",
            "სპორტი", "ესთეტიკა", "ჯანმრთელობა", "კურსები", "ცხოველები"
    );

    // English Labels
    public static final List<String> ENGLISH_LABELS = List.of(
            "Movie", "Holiday", "Entertainment", "Eat & Drinks", "Kids Land",
            "Sport", "Esthetics", "Healthcare", "Courses", "Grooming"
    );
}
