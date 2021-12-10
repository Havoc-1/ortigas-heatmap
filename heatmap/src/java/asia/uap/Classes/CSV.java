/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.Classes;

import java.util.Date;

/**
 *
 * @author Nofuente
 */
public class CSV {
    private int uid;
    private String content;
    private Date dateTime;

    //getter methods

    public int getUid() {
        return uid;
    }

    public String getContent() {
        return content;
    }

    public Date getDateTime() {
        return dateTime;
    }

   //setter methods
   public void setUid(int u) {
       this.uid = u;
   }

   public void setContent(String c) {
       this.content = c;
   }

   public void setDateTime(Date d) {
       this.dateTime = d;
   }
}
