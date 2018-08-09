package com.mycompany.registv2.Controller;

import com.mycompany.registv2.Dao.Type.User;
import com.mycompany.registv2.Service.UserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping(value = "user")
@CrossOrigin

public class UserController {
    
    @Autowired
    UserService us;
    
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test(){
        return "hello";
    }
    
    @RequestMapping(value="/newuser",method = RequestMethod.POST)
    public String insertUser(String login,int age, String name, String surname, String pass){
        return us.insertUser(login,age, name, surname,pass);
    }
    
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public User getUserByPassAndName(String login,String pass) throws Exception{
        return us.getUserByPassAndLogin(login, pass);
    }
    @RequestMapping(value="/userpage",method = RequestMethod.GET)
    public User getUserForMainPage() throws Exception{
        return us.getUserForMainPage();
    }
    
    @RequestMapping(value="/udateuser",method = RequestMethod.PUT)
    public String updateUser(String login,String name,String oldpass ,String newpass,String surname,int age){
        return us.updateUser(login ,oldpass,newpass, name, surname, age);
    }
    
    @RequestMapping(value="/deleteuser",method = RequestMethod.DELETE)
    public String deleteUser(String login,String pass){
        return us.deleteUser(login, pass);
    }
    
    @RequestMapping(value="/alluser",method = RequestMethod.GET)
    public ArrayList<User> getAll(){
        return us.getAll();
    }
    
}
