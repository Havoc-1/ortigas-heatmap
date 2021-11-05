/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.uap;

import java.security.SecureRandom;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nofuente
 */
public class Utils {
    public final String NO_VALUE = " ";
    public ArrayList<String> getArrayList(HttpSession session, String attribute){

        if (session.getAttribute(attribute) == null){
            ArrayList<String> list = new ArrayList<>();
            session.setAttribute(attribute, list);
        }

        ArrayList<String> user = (ArrayList<String>) session.getAttribute(attribute);

        return user;
    } 

    public String checkNull(HttpServletRequest request, String att){
        String str = request.getParameter(att);
        if(str == null || str.isEmpty()) {
            return NO_VALUE;
        }
        return str;
    }

    public String generateRandomPassword(int len)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }

}