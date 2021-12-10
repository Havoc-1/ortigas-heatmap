/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.Classes;

import java.sql.Timestamp;

/**
 *
 * @author Nofuente
 */
public class History {
    private int uid;
    private String loc;
    private Timestamp  checkInDate;
    private Timestamp  checkOutDate;
    
    //getter methods

    public int getUid() {
        return uid;
    }

    public String getLoc() {
        return loc;
    }

    public Timestamp  getCheckInDate() {
        return checkInDate;
    }

    public Timestamp  getCheckOutDate() {
        return checkOutDate;
    }

   //setter methods
   public void setUid(int u) {
       this.uid = u;
   }

   public void setLoc(String s) {
       this.loc = s;
   }

   public void setCheckInDate(Timestamp  d) {
       this.checkInDate = d;
   }

   public void setCheckOutDate(Timestamp  d) {
       this.checkOutDate = d;
   }
}
