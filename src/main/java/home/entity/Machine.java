package home.entity;


public class Machine {

  private long id;
  private String machineName;
  private long categoryId;
  private double originalPrice;
  private double currentPrice;
  private long currencyType;
  private String icon;
  private String picUri;
  private long machineState;
  private String description;
  private long loanLimit;
  private double computeShare;
  private long contractSpan;
  private long minerId;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMachineName() {
    return machineName;
  }

  public void setMachineName(String machineName) {
    this.machineName = machineName;
  }


  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public double getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(double originalPrice) {
    this.originalPrice = originalPrice;
  }


  public double getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
  }


  public long getCurrencyType() {
    return currencyType;
  }

  public void setCurrencyType(long currencyType) {
    this.currencyType = currencyType;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public String getPicUri() {
    return picUri;
  }

  public void setPicUri(String picUri) {
    this.picUri = picUri;
  }


  public long getMachineState() {
    return machineState;
  }

  public void setMachineState(long machineState) {
    this.machineState = machineState;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(long loanLimit) {
    this.loanLimit = loanLimit;
  }


  public double getComputeShare() {
    return computeShare;
  }

  public void setComputeShare(double computeShare) {
    this.computeShare = computeShare;
  }


  public long getContractSpan() {
    return contractSpan;
  }

  public void setContractSpan(long contractSpan) {
    this.contractSpan = contractSpan;
  }


  public long getMinerId() {
    return minerId;
  }

  public void setMinerId(long minerId) {
    this.minerId = minerId;
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
