package home.entity;


public class Config {

  private long id;
  private String K;
  private String V;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getK() {
    return K;
  }

  public void setK(String K) {
    this.K = K;
  }


  public String getV() {
    return V;
  }

  public void setV(String V) {
    this.V = V;
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
