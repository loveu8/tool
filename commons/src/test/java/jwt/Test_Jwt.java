package jwt;


import org.junit.runners.JUnit4;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnit4.class)
public class Test_Jwt {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {}

  @AfterClass
  public static void tearDownAfterClass() throws Exception {}

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void test() {
    CommonJWT jwt = new CommonJWT();
    String jwtToken = jwt.doJwtEnc("Hi");
    jwt.doJwtDec(jwtToken);
  }
  
  
  @Test
  public void test2() {
    CommonJWT jwt = new CommonJWT();
    CommonPayload payload = new CommonPayload();
    payload.setName("QK");
    payload.setHttpMethod("GET");
    payload.setSub("HI");
    payload.setUrl("https://www.test.com.tw/message=");
    String jwtToken = jwt.doJwtEncPayload(payload);
    jwt.doJwtDec(jwtToken);
  }
  
  
  @Test
  public void test3() {
    CommonJWT jwt = new CommonJWT();
    CommonPayload payload = new CommonPayload();
    User user = new User();
    user.setUserId("00001");
    user.setUserName("Lorn");
    payload.setName("QK");
    payload.setSub(user);
    payload.setHttpMethod("POST");
    payload.setUrl("https://www.test.com.tw/auth");
    String jwtToken = jwt.doJwtEncPayload(payload);
    jwt.doJwtDec(jwtToken);
  }
}
