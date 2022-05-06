package jUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestArticoloDao.class, TestMyDataSource.class, TestControlloreDatiImmessiStringaNonVuota.class,TestControlloreDatiImmessiControlloLunghezza.class,
				TestControlloreDatiImmessiNumerici.class, TestControlloreDatiImmessiControlloEMail.class })

public class AllTests {
	
	@BeforeClass
    public static void beforeClass() {
        System.out.println("Starting Tests...");
    }
	
	@AfterClass
    public static void afterClass() {
        System.out.println("Ending Tests.");
    }

}
