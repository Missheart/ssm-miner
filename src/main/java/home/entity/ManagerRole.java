package home.entity;


public class ManagerRole {

  private long id;
  private String role;
  private String description;
  private String authAccess;
  private long createTime;
  private long updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getAuthAccess() {
    return authAccess;
  }

  public void setAuthAccess(String authAccess) {
    this.authAccess = authAccess;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }


  public long getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(long updateTime) {
    this.updateTime = updateTime;
  }

  @Override
  public String toString() {
    return "ManagerRole{" +
            "id=" + id +
            ", role='" + role + '\'' +
            ", description='" + description + '\'' +
            ", authAccess='" + authAccess + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
