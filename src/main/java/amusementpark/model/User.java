package amusementpark.model;


/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:17
 */

public class User {

  private String uuid;
  private String type;
  private String username;
  private String password;
  private String newp;

  public User() {
  }

  public User(String uuid, String type, String username, String password, String newp) {
    this.uuid = uuid;
    this.type = type;
    this.username = username;
    this.password = password;
    this.newp = newp;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNewp() {
    return newp;
  }

  public void setNewp(String newp) {
    this.newp = newp;
  }

  @Override
  public String toString() {
    return "User{" +
            "uuid='" + uuid + '\'' +
            ", type='" + type + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", newp='" + newp + '\'' +
            '}';
  }
}
