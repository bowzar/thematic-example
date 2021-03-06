package com.yulintu.thematic.example.employee;

import com.yulintu.thematic.data.Service;

import java.util.List;

public interface ServiceEmployee extends Service {

    String echo(String val);

    List<User> all();

    int clear();

    int clearAll();

    int add(User user);

    int update(String name, User user);

    int delete(String name);
}
