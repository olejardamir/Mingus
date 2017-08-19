package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long actionid;
    private String contact;
    private String address;


    public Long getId() {
        return id;
    }

    public void setActionid(Long actionid) {
        this.actionid = actionid;
    }

    public Long getActionid() {
        return actionid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}