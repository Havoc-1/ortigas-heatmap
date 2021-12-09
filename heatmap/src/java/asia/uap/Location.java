/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Nofuente
 */
public class Location implements Serializable {
    private int uid;
    private String name;
    private String address;
    private float longitude;
    private float latitude;
    private float rating;
    private boolean status;

    //getter methods

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getLat() {
        return latitude;
    }

    public float getLong() {
        return longitude;
    }

    public float getRating() {
        return rating;
    }

    public boolean getStatus() {
        return status;
    }

   //setter methods
   public void setUid(int u) {
       this.uid = u;
   }

   public void setName(String n) {
       this.name = n;
   }

   public void setAddress(String a) {
       this.address = a;
   }

   public void setLat(float l) {
       this.latitude = l;
   }

   public void setLong(float l) {
       this.longitude = l;
   }

   public void setRating(float r) {
       this.rating = r;
   }

   public void setStatus(boolean s) {
       this.status = s;
   }
}
