package com.corejsf;

import com.sun.xml.internal.ws.message.saaj.SAAJHeader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
import microBlog.framework.LinksMicroblog;
   // or import javax.enterprise.context.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {
   private LinksMicroblog microBlog;
   
   
    public UserBean() {
       microBlog = new LinksMicroblog();
            
        
    }
    
    
   
   public String getCommit0(){
       System.out.println(microBlog.getLink());
       return microBlog.getLink();
   }
   public String getCommit1(){
       return microBlog.getTopTenLinks()[1];
   }
   public String getCommit2(){
       return microBlog.getTopTenLinks()[2];
   }
   public String getCommit3(){
       return microBlog.getTopTenLinks()[3];
   }
   public String getCommit4(){
       return microBlog.getTopTenLinks()[4];
   }
   public String getCommit5(){
       return microBlog.getTopTenLinks()[5];
   }
   public String getCommit6(){
       return microBlog.getTopTenLinks()[6];
   }
   public String getCommit7(){
       return microBlog.getTopTenLinks()[7];
   }
   public String getCommit8(){
       return microBlog.getTopTenLinks()[8];
   }
   public String getCommit9(){
       return microBlog.getTopTenLinks()[9];
   }

   
   public String getLinks() {
       return "";
   }
   
   public void setLinks(String newValue) { 
      
        try{
            microBlog.addLink(newValue);
        }catch(Exception ex){
           
        }
       
       
   }

   

   
   
   
}
