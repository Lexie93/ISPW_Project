package jUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ /*TestArticoloDao.class,*/ TestMyDataSource.class, TestUtenteDao.class })
public class TestDatabase {
	@BeforeClass
    public static void beforeClass() {
        System.out.println("Inizio test database");
    }
	
	@AfterClass
    public static void afterClass() {
        System.out.println("Fine test database");
    }
}
