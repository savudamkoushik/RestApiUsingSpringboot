package com.example.basicSpring.Controller;

import com.example.basicSpring.User.User;
import com.example.basicSpring.db.Db;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicController {
    @Autowired
    private Db db;
//    private Db db=new Db();

    @GetMapping("/hi")
    public String Helo(){
        return "hello world";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return db.getUsers();
    }
//    http://localhost:8080/search?q=sehwag
    @GetMapping("/search")
    public String search(@RequestParam String q){
        return db.searchAWord(q);
    }
    @PostMapping("/users")
    public boolean addUser(@RequestBody User user){
        return db.addUser(user);
    }
    @PutMapping("/users")
    public boolean update(@RequestBody User user){
        return db.updateUser(user);
    }
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable int id){
        return db.deleteUser(id);
    }
//    inorder to change the response header i mean to addd our own values in the respoonse header
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        User user=db.getUser(id);
        MultiValueMap<String,String> headers=new LinkedMultiValueMap<String, String>();
        List<String> li=new ArrayList<>();
        li.add("first");
        li.add("second");
        List<String>l2=new ArrayList<>();
        l2.add("third");
        l2.add("fourth");
        headers.put("firstKey",li);
        headers.put("secondKey",l2);
        return new ResponseEntity<User>(user,headers, HttpStatus.CREATED);

    }
}
