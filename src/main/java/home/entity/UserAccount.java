package home.entity;


public class UserAccount {

  private long id;
  private long currencyType;
  private double balance;
  private String address;
  private long walletId;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getCurrencyType() {
    return currencyType;
  }

  public void setCurrencyType(long currencyType) {
    this.currencyType = currencyType;
  }


  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public long getWalletId() {
    return walletId;
  }

  public void setWalletId(long walletId) {
    this.walletId = walletId;
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
