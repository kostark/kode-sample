package kode.boot.testjar;

import kode.boot.testjar.controller.HomeControllerTest;
import kode.boot.testjar.domain.AppAuthTest;
import kode.boot.testjar.service.AppUserServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试组
 *
 * @author Stark
 * @since 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AppUserServiceImplTest.class, HomeControllerTest.class, AppAuthTest.class})
public class ApplicationTestSuit {
}
