package amusementpark.model;


public class Discountinfo {

  private long id;
  private String title;
  private String img;
  private String description;
  private String link;
  private String uid;

  public Discountinfo() {
  }

  public Discountinfo(long id, String title, String img, String description, String link, String uid) {
    this.id = id;
    this.title = title;
    this.img = img;
    this.description = description;
    this.link = link;
    this.uid = uid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  @Override
  public String toString() {
    return "Discountinfo{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", img='" + img + '\'' +
            ", description='" + description + '\'' +
            ", link='" + link + '\'' +
            ", uid='" + uid + '\'' +
            '}';
  }
}
