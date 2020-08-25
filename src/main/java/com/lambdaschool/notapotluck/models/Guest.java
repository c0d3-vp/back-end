package com.lambdaschool.notapotluck.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guests")
public class Guest
//    implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guestid;

    private String fname;

    private String lname;

    private String primaryemail;

    @Transient
    public boolean hasvalueforresponded = false;
    private boolean responded;

    @Transient
    public boolean hasvalueforattending = false;
    private boolean attending;

//    /**
//     * A foreign key to the potluck table
//     * Many to One relationship between guests and potlucks.
//     * A potluck can have many guests.
//     */
//    @ManyToOne
//    @JoinColumn(name = "potluckid")
//    @JsonIgnoreProperties(value = "guests", allowSetters = true)
//    private Potluck potluck;
//
//    /**
//     Many to One relationship between guests and potlucks.
//     A potluck can have many guests.
//     */
//    @ManyToOne
//    @JoinColumn(name = "guestid", nullable = false)
//    @JsonIgnoreProperties(value = "foods", allowSetters = true)
//    private Guest guest;

    /**
     * connects guest to the potluck guest combination
     */
    @OneToMany(mappedBy = "guest",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JsonIgnoreProperties(value = "guest", allowSetters = true)
    private Set<PotluckGuests> potlucks = new HashSet<>();

    public Guest()
    {
    }

    public Guest(
//        Potluck potluck,
        String fname,
        String lname,
        String primaryemail)
    {
//        this.potluck = potluck;
        this.fname = fname;
        this.lname = lname;
        this.primaryemail = primaryemail;
        this.responded = false;
        this.attending = false;
    }

    public long getGuestid()
    {
        return guestid;
    }

    public void setGuestid(long guestid)
    {
        this.guestid = guestid;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public String getPrimaryemail()
    {
        return primaryemail;
    }

    public void setPrimaryemail(String primaryemail)
    {
        this.primaryemail = primaryemail;
    }

    public boolean isResponded()
    {
        return responded;
    }

    public void setResponded(boolean responded)
    {
        hasvalueforresponded = true;
        this.responded = responded;
    }

    public boolean isAttending()
    {
        return attending;
    }

    public void setAttending(boolean attending)
    {
        hasvalueforattending = true;
        this.attending = attending;
    }
//
//    public Potluck getPotluck()
//    {
//        return potluck;
//    }
//
//    public void setPotluck(Potluck potluck)
//    {
//        this.potluck = potluck;
//    }

    public Set<PotluckGuests> getPotlucks()
    {
        return potlucks;
    }

    public void setPotlucks(Set<PotluckGuests> potlucks)
    {
        this.potlucks = potlucks;
    }
}
