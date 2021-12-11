/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap.Classes;

/**
 *
 * @author Nofuente
 */
public class Reviews {
    private int uid;
    private int locID;
    private int userID;
    private boolean status;
    private String comment;
    private String locName;
    private String userName;

    //getter methods

    public int getUid() {
        return uid;
    }

    public int getLocID() {
        return locID;
    }

    public int getUserID() {
        return userID;
    }

    public String getComment() {
        return comment;
    }

    public String getLocName() {
        return locName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean getStatus() {
        return status;
    }

   //setter methods
   public void setUid(int u) {
       this.uid = u;
   }

   public void setLocID(int i) {
       this.locID = i;
   }

   public void setUserID(int i) {
       this.userID = i;
   }

   public void setComment(String c) {
       this.comment = c;
   }

   public void setUserName(String u) {
       this.userName = u;
   }

   public void setLocName(String l) {
       this.locName = l;
   }

   public void setStatus(boolean s) {
       this.status = s;
   }
}
