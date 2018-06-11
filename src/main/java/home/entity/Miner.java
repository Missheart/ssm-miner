package home.entity;


public class Miner {

  private long id;
  private String minerName;
  private long totalCompute;
  private String description;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMinerName() {
    return minerName;
  }

  public void setMinerName(String minerName) {
    this.minerName = minerName;
  }


  public long getTotalCompute() {
    return totalCompute;
  }

  public void setTotalCompute(long totalCompute) {
    this.totalCompute = totalCompute;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
