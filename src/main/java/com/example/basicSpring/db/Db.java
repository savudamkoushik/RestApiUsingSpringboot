package com.example.basicSpring.db;

import com.example.basicSpring.User.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class Db {
    private List<User> list=new ArrayList<User>();
    private HashMap<String,String> hm=new HashMap<String, String>();
    public Db() {
        hm.put("sachin","is awesome");
        hm.put("sehwag","is dangerous");
        list.add(new User(1,"koushik",23));
        list.add(new User(2,"savudam",23));
    }
    public List<User> getUsers(){
        return list;
    }
    public String searchAWord(String word){
        if(hm.containsKey(word))
            return hm.get(word);
        return "not found";
    }

    public boolean updateUser(User user) {
        for(User u:list){
            if(u.getId()==user.getId()){
                u.setAge(user.getAge());
                u.setName(user.getName());
                return true;
            }
        }
        return false;

    }

    public boolean addUser(User user) {
        list.add(user);
        return true;
    }

    public boolean deleteUser(int id) {
        for(User user:list){
            if(user.getId()==id){
                list.remove(user);
                return true;
            }
        }
        return false;
    }

    public User getUser(int id) {
        for(User user:list){
            if(user.getId()==id)
                return user;
        }
        return null;
    }
}
