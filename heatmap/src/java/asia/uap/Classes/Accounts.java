/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.uap.Classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sandro
 */
public class Accounts implements Serializable {
    private int uid;
    private String username;
    private String pass;
    private String email;
    private String address;
    private String sec_ques_ans;
    private int sec_ques_no;
    private int sq1;
    private int sq2;
    private int sq3;
    private int sq4;
    private String symptoms;
    private Date lastLogin;
    private boolean covidStatus;

    //getter methods

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getSecQuesAns() {
        return sec_ques_ans;
    }

    public int getSecQuesNo() {
        return sec_ques_no;
    }
    
    public int getSQ1() {
        return sq1;
    }
    
    public int getSQ2() {
        return sq2;
    }
    
    public int getSQ3() {
        return sq3;
    }
    
    public int getSQ4() {
        return sq4;
    }
    
    public String getSymptoms() {
        return symptoms;
    }
    
    public Date getLastLogin() {
        return lastLogin;
    }
    
    public boolean getCovidStatus() {
        setCovidStatus();
        return covidStatus;
    }

   //setter methods
   public void setUid(int u) {
       this.uid = u;
   }

   public void setUsername(String us) {
       this.username = us;
   }

   public void setPassword(String p) {
       this.pass = p;
   }

   public void setEmail(String e) {
       this.email = e;
   }

   public void setAddress(String a) {
       this.address = a;
   }

   public void setSecQuesAns(String sqa) {
       this.sec_ques_ans = sqa;
   }

   public void setSecQuesNo(int sqn) {
       this.sec_ques_no = sqn;
   }

   public void setSQ1(int s1) {
       this.sq1 = s1;
   }

   public void setSQ2(int s2) {
       this.sq1 = s2;
   }

   public void setSQ3(int s3) {
       this.sq1 = s3;
   }

   public void setSQ4(int s4) {
       this.sq1 = s4;
   }

   public void setSymptoms(String s) {
       this.symptoms = s;
   }

   public void setLastLogin(Date d) {
       this.lastLogin = d;
   }
   
   public void setCovidStatus() {
       boolean qStatus = false;
       qStatus = this.sq1 == 0 && this.sq2 == 0 && this.sq3 == 0 && this.sq4 == 0;
       this.covidStatus = !(qStatus = true && symptoms.equals("None"));
   }     
}
