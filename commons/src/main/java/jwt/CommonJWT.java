package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class CommonJWT {
  
  private final String key = "ezTravel";
  
  public String doJwtEnc(Object content){
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = "";
    try {
      json = ow.writeValueAsString(content);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String jwtString = Jwts.builder()
                        .setSubject(json)
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();

    System.out.println("jwtString : " + jwtString);
    return jwtString;
  }
  
  
  public String doJwtEncPayload(Object content){
    
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = "";
    try {
      json = ow.writeValueAsString(content);
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    String jwtString = Jwts.builder()
                        .setPayload(json)
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();

    System.out.println("jwtString : " + jwtString);
    System.out.println("-----------------------------");
    return jwtString;
  }
  
  
  public String doJwtDec(String jwtString){
    Jws<Claims> result = null;
    Claims originResult = null;
    String sub = "";
    try {
      result = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtString);
      System.out.println("header : " + result.getHeader());
      System.out.println("body : " + result.getBody());
      System.out.println("signature : " + result.getSignature());
      originResult =  result.getBody();
      System.out.println("--------body result--------");
      for(String key : originResult.keySet()){
        System.out.println("key : " + key + " , value : " + originResult.get(key));
      }
      sub = originResult.getSubject();
    } catch (SignatureException e) {

    }
    System.out.println("------------------------------");
    return sub;
  }
}
