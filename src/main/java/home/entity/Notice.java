package home.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Notice {

  private long id;
  private String title;
  private String content;
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


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  @Override
  public String toString() {
    return "Notice{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", postDate=" + postDate +
            ", contentStateValue=" + contentStateValue +
            ", created=" + created +
            ", updated=" + updated +
            '}';
  }
}
