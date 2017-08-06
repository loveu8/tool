package jwt;

public class CommonPayload {
  private Object sub;
  private String name;
  private String httpMethod;
  private String url;
  public Object getSub() {
    return sub;
  }
  public void setSub(Object sub) {
    this.sub = sub;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getHttpMethod() {
    return httpMethod;
  }
  public void setHttpMethod(String httpMethod) {
    this.httpMethod = httpMethod;
  }
  
}
