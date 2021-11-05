/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.uap;

import java.io.Serializable;

/**
 *
 * @author Sandro
 */
public class Accounts implements Serializable {
    private int uid;
    private String username;
    private String pass;
    private String about_me;
    private String url_photo;
    private String sec_ques_ans;
    private int sec_ques_no;

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

    public String getAbout_Me() {
        return about_me;
    }

    public String getUrl_Photo() {
        return url_photo;
    }

    public String getSecQuesAns() {
        return sec_ques_ans;
    }

    public int getSecQuesNo() {
        return sec_ques_no;
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

   public void setAboutMe(String ab) {
       this.about_me = ab;
   }

   public void setUrlPhoto(String url) {
       this.url_photo = url;
   }

   public void setSecQuesAns(String sqa) {
       this.sec_ques_ans = sqa;
   }

   public void setSecQuesNo(int sqn) {
       this.sec_ques_no = sqn;
   }
}
