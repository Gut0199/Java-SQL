package model.entities;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    // private String orderStatus;
    // private Integer id, clientsId, booksId;
    // private Double unitPrice;
    // private Date dateApplication;

    private Integer ID;
    private Integer clientsId;
    private Integer booksId;
    private Date dateApplication;
    private String orderStatus;
    private Double unitPrice;

    public Order() {
    }

    public Order(Integer iD, Integer clientsId, Integer booksId, Date dateApplication, String orderStatus,
            Double unitPrice) {
        ID = iD;
        this.clientsId = clientsId;
        this.booksId = booksId;
        this.dateApplication = dateApplication;
        this.orderStatus = orderStatus;
        this.unitPrice = unitPrice;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getClientsId() {
        return clientsId;
    }

    public void setClientsId(Integer clientsId) {
        this.clientsId = clientsId;
    }

    public Integer getBooksId() {
        return booksId;
    }

    public void setBooksId(Integer booksId) {
        this.booksId = booksId;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [ID=" + ID + ", clientsId=" + clientsId + ", booksId=" + booksId + ", dateApplication="
                + dateApplication + ", orderStatus=" + orderStatus + ", unitPrice=" + unitPrice + "]";
    }

}
