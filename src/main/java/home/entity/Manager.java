package home.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Manager {

  private long id;
  private long roleId;
  private String nickname;
  private String username;
  private String password;
  private String salt;
  private String phone;
  private long supperMaster;
  private long enable;
  private long createTime;
  private long lastLoginTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
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


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public long getSupperMaster() {
    return supperMaster;
  }

  public void setSupperMaster(long supperMaster) {
    this.supperMaster = supperMaster;
  }


  public long getEnable() {
    return enable;
  }

  public void setEnable(long enable) {
    this.enable = enable;
  }


  public long getCreateTime() {
    return createTime;
  }

  public void setCreateTime(long createTime) {
    this.createTime = createTime;
  }


  public long getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(long lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  @Override
  public String toString() {
    return "Manager{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", nickname='" + nickname + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", salt='" + salt + '\'' +
            ", phone='" + phone + '\'' +
            ", supperMaster=" + supperMaster +
            ", enable=" + enable +
            ", createTime=" + createTime +
            ", lastLoginTime=" + lastLoginTime +
            '}';
  }
}
