package model.entities;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    // private String name, cpf, address, email, phoneNumber;
    // private Integer ID;

    private Integer ID;
    private String name;
    private String cpf;
    private String address;
    private String email;
    private String phoneNumber;

    public Client() {
    }

    public Client(Integer iD, String name, String cpf, String address, String email, String phoneNumber) {
        ID = iD;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        Client other = (Client) obj;
        if (ID == null) {
            if (other.ID != null)
                return false;
        } else if (!ID.equals(other.ID))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [ID=" + ID + ", name=" + name + ", cpf=" + cpf + ", address=" + address + ", email=" + email
                + ", phoneNumber=" + phoneNumber + "]";
    }

}
