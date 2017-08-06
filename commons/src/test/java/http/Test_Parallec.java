package http;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Parallec {

  private Utils_Parallec_Manger parallec;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {
    parallec = Utils_Parallec_Manger.singleton;
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void test() {
    parallec.prepareHttpGet("http://www.parallec.io/userdata/sample_target_hosts_top100_old.txt");
  }

}
