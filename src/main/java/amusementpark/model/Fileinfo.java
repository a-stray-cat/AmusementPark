package amusementpark.model;

/**
 * @author a-stray-cat
 * @version 1.0
 * @date 2022.02.26 13:17
 */

public class Fileinfo {

  private String uid;
  private String link;
  private String filename;
  private String fileimg;
  private String filemessage;
  private String filetag;

  public Fileinfo() {
  }

  public Fileinfo(String uid, String link, String filename, String fileimg, String filemessage, String filetag) {
    this.uid = uid;
    this.link = link;
    this.filename = filename;
    this.fileimg = fileimg;
    this.filemessage = filemessage;
    this.filetag = filetag;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }


  public String getFileimg() {
    return fileimg;
  }

  public void setFileimg(String fileimg) {
    this.fileimg = fileimg;
  }


  public String getFilemessage() {
    return filemessage;
  }

  public void setFilemessage(String filemessage) {
    this.filemessage = filemessage;
  }


  public String getFiletag() {
    return filetag;
  }

  public void setFiletag(String filetag) {
    this.filetag = filetag;
  }

  @Override
  public String toString() {
    return "Fileinfo{" +
            "uid='" + uid + '\'' +
            ", link='" + link + '\'' +
            ", filename='" + filename + '\'' +
            ", fileimg='" + fileimg + '\'' +
            ", filemessage='" + filemessage + '\'' +
            ", filetag='" + filetag + '\'' +
            '}';
  }
}
