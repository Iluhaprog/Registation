package com.mycompany.registv2.Service;

import com.mycompany.registv2.Dao.Type.User;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service 
@Transactional


public class UserServiceImpl implements UserService {
    
    ArrayList<User> user_arr = new ArrayList<>();
    
    @Override
    public String insertUser(String login,int age, String name, String surname, String pass) {
        User user = new User();
        String fulllogin = login + user_arr.size() + "@test";
        
        if(login != null && name != null && surname != null && pass != null && age >=10 ){
            
            user.setLogin(fulllogin);
            user.setAge(age);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(pass);
            
            user_arr.add(user);
        }
        else{
            return "you did not enter all the data or you are less than 10!";
        }
        
        return "registration completed successfully! \n YOUR LOGIN " + fulllogin;
    }

    @Override
    public User getUserByPassAndLogin(String login, String pass)  throws Exception{
        
        for(User us : user_arr){
            if(us.getLogin().equals(login) && us.getPassword().equals(pass)){
                //L O G I N
                FileWriter loginTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/login", false);
                    
                    loginTXT.write(login);
                    System.out.println("OK!");
                    
                loginTXT.close();
                 
                //P A S S W O R D
                FileWriter passTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/pass", false);
                    
                    passTXT.write(pass);
                    System.out.println("OK!");
                    
                passTXT.close();
                //N A M E
                FileWriter nameTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/name", false);
                                   
                    nameTXT.write(us.getName());
                    System.out.println("OK!");
                    
                nameTXT.close();
                //S U R N A M E
                FileWriter surnameTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/surname", false);
                                   
                    surnameTXT.write(us.getSurname());
                    System.out.println("OK!");
                    
                surnameTXT.close();
                //A G E
                FileWriter ageTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/age", false);
                                   
                    ageTXT.write(Integer.toString(us.getAge()));
                    System.out.println("OK!");
                    
                ageTXT.close();
               
            }
            else{
                System.out.println("FUCK YOU");
            }
        }
        return null;
    }
    
    public User getUserForMainPage() throws Exception{
        
        User userM = new User();
        //NAME
        FileReader nameRead = new FileReader("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/name");
            Scanner scnr = new Scanner(nameRead);
            String nameStrUs = "";
            while(scnr.hasNext()){
                nameStrUs += scnr.next();
            }
            System.out.println(nameStrUs);
            userM.setName(nameStrUs);
        nameRead.close();
        
        //SURNAME
        FileReader surnameRead = new FileReader("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/surname");
            Scanner scsnr = new Scanner(surnameRead);
            String surnameStrUs = "";
            while(scsnr.hasNext()){
                surnameStrUs += scsnr.next();
            }
            System.out.println(surnameStrUs);
            userM.setSurname(surnameStrUs);
           userM.setSurname(surnameStrUs);
        surnameRead.close();
        
        //AGE
        FileReader ageRead = new FileReader("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/age");
            Scanner scar = new Scanner(ageRead);
            String ageStrUs = "";
            while(scar.hasNext()){
                ageStrUs += scar.next();
            }
            System.out.println(ageStrUs);
            int age = Integer.parseInt(ageStrUs);
           userM.setAge(age);
        ageRead.close();
        
        //LOGIN
        FileReader loginRead = new FileReader("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/login");
            Scanner sclr = new Scanner(loginRead);
            String loginStrUs = "";
            while(sclr.hasNext()){
                loginStrUs += sclr.next();
            }
            System.out.println(loginStrUs);
            userM.setLogin(loginStrUs);
        loginRead.close();
        
        clearTxtFiles();
        
        return userM;
    }
    
    void clearTxtFiles() throws Exception{
        
         FileWriter loginTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/login", false);
         FileWriter passTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/pass", false);
         FileWriter nameTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/name", false);
         FileWriter surnameTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/surname", false);
         FileWriter ageTXT = new FileWriter("/home/mr/Документы/Projects/Main/Regist2/RegistV2/src/main/java/com/mycompany/registv2/Service/userData/age", false);
         
         loginTXT.write("");
         passTXT.write("");
         nameTXT.write("");
         surnameTXT.write("");
         ageTXT.write("");
         
         ageTXT.close();
         surnameTXT.close();
         nameTXT.close();
         passTXT.close();
         loginTXT.close();
         
    }

    @Override
    public String deleteUser(String login,String pass) {
        
        for (int i = 0; i < user_arr.size(); i++) {
            if(user_arr.get(i).getLogin().equals(login) && user_arr.get(i).getPassword().equals(pass)){
                user_arr.remove(i);
               System.out.println("delete");
                return "user delete!";
                
            }
        }
        
        return "user delete!";
    }

    @Override
    public String updateUser( String login ,String oldpass, String newpass, String name, String surname, int age) {
        for (User user : user_arr){
            if(user.getPassword().equals(oldpass) && user.getLogin().equals(login)){
                if(newpass.length() >= 5 && user.getPassword().equals(newpass) != true){
                    user.setAge(age);
                    user.setName(name);
                    user.setSurname(surname);
                    user.setPassword(newpass);
                    return "ok!";
                }
                else{
                    return "short password";
                }
                
            }
        }
        return "ok!all!";
    }
          
    public ArrayList<User> getAll(){
        
        ArrayList<User> ua = new ArrayList<>();
        ua.addAll(user_arr);
        
        for(int i = 0; i < ua.size();i++){
            ua.get(i).setPassword(null);
            ua.get(i).setLogin(null);
        }
        
        return ua;
    }
}
