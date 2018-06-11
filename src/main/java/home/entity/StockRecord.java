package home.entity;


public class StockRecord {

  private long id;
  private long machineId;
  private long quantity;
  private long lockedInOrder;
  private long lockedBySystem;
  private long sold;
  private long available;
  private java.sql.Timestamp created;
  private java.sql.Timestamp updated;
  private long version;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMachineId() {
    return machineId;
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public long getLockedInOrder() {
    return lockedInOrder;
  }

  public void setLockedInOrder(long lockedInOrder) {
    this.lockedInOrder = lockedInOrder;
  }


  public long getLockedBySystem() {
    return lockedBySystem;
  }

  public void setLockedBySystem(long lockedBySystem) {
    this.lockedBySystem = lockedBySystem;
  }


  public long getSold() {
    return sold;
  }

  public void setSold(long sold) {
    this.sold = sold;
  }


  public long getAvailable() {
    return available;
  }

  public void setAvailable(long available) {
    this.available = available;
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


  public long getVersion() {
    return version;
  }

  public void setVersion(long version) {
    this.version = version;
  }

}
