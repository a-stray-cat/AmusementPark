package amusementpark.model;


public class Apkinfo {

  private String uid;
  private String apkname;
  private String apklink;
  private String apkmessage;
  private String apktag;
  private long id;

  public Apkinfo() {
  }

  public Apkinfo(String uid, String apkname, String apklink, String apkmessage, String apktag, long id) {
    this.uid = uid;
    this.apkname = apkname;
    this.apklink = apklink;
    this.apkmessage = apkmessage;
    this.apktag = apktag;
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getApkname() {
    return apkname;
  }

  public void setApkname(String apkname) {
    this.apkname = apkname;
  }


  public String getApklink() {
    return apklink;
  }

  public void setApklink(String apklink) {
    this.apklink = apklink;
  }


  public String getApkmessage() {
    return apkmessage;
  }

  public void setApkmessage(String apkmessage) {
    this.apkmessage = apkmessage;
  }


  public String getApktag() {
    return apktag;
  }

  public void setApktag(String apktag) {
    this.apktag = apktag;
  }


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Apkinfo{" +
            "uid='" + uid + '\'' +
            ", apkname='" + apkname + '\'' +
            ", apklink='" + apklink + '\'' +
            ", apkmessage='" + apkmessage + '\'' +
            ", apktag='" + apktag + '\'' +
            ", id=" + id +
            '}';
  }
}
