package home.entity;


public class Banner {

  private long id;
  private String title;
  private String image;
  private String link;
  private java.sql.Timestamp postDate;
  private long contentStateValue;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


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


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }


  public java.sql.Timestamp getPostDate() {
    return postDate;
  }

  public void setPostDate(java.sql.Timestamp postDate) {
    this.postDate = postDate;
  }


  public long getContentStateValue() {
    return contentStateValue;
  }

  public void setContentStateValue(long contentStateValue) {
    this.contentStateValue = contentStateValue;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }


  public java.sql.Timestamp getUpdated() {
    return updated;
  }

  public void setUpdated(java.sql.Timestamp updated) {
    this.updated = updated;
  }

}
