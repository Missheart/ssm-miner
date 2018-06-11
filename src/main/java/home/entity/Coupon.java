package home.entity;


public class Coupon {

  private long id;
  private long userId;
  private double discount;
  private long orderId;
  private long state;
  private java.sql.Timestamp userTime;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;
  private long isremove;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getUserTime() {
    return userTime;
  }

  public void setUserTime(java.sql.Timestamp userTime) {
    this.userTime = userTime;
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


  public long getIsremove() {
    return isremove;
  }

  public void setIsremove(long isremove) {
    this.isremove = isremove;
  }

}
