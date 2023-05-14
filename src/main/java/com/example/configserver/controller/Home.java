package com.example.configserver.controller;

import com.example.configserver.model.DBConnection;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Home {
    @Autowired
    DBConnection dbConnection;
    public int id = 1;
    @Value("${shanto.name}")
    public String name = "Shanto";
    @Value("Static+Dynamic message: ${shanto.message}")
    public String message = "Hello";
    @Value("${list.example}")
    public List<String> listExample;

    @Value("${list.example2}")
    public List<Integer> anotherList;

    @Value("#{${info.map}}")
    public Map infoMap;

    @GetMapping("/getInfo")
    public String getInfo(){
        return "id: "+id+", name: "+name+", message: "+message;
    }

    @GetMapping("/getList")
    public List<String> getList(){
        return listExample;
    }

    @GetMapping("/getAnotherList")
    public List<Integer> getAnotherList(){
        return anotherList;
    }

    @GetMapping("/getInfoMap")
    public Map getInfoMap(){
        return infoMap;
    }

    @GetMapping("/getDBInfo")
    public String getDBConnection(){
        return dbConnection.getUrl();
    }

}
