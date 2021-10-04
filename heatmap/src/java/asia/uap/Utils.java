/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asia.uap;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nofuente
 */
public class Utils {
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
            return " ";
        }
        return str;
    }
}
