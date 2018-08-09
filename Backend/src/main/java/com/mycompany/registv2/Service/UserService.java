package com.mycompany.registv2.Service;

import com.mycompany.registv2.Dao.Type.User;
import java.io.IOException;
import java.util.ArrayList;


public interface UserService {
    
    public String insertUser(String login,
                            int age,
                            String name,
                            String surname,
                            String pass);
    
    public User getUserByPassAndLogin(String name,
                                      String pass) throws Exception;
    
    public ArrayList<User> getAll();
    
    public String deleteUser(String login,String pass);
    
    public String updateUser(String login,
                             String oldpass,
                             String newpass,
                             String name,
                             String surname,
                             int age);
    
    public User getUserForMainPage() throws Exception;
    
}
