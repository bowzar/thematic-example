package com.yulintu.thematic.example.employee;

import com.yulintu.thematic.data.Repository;

import java.util.List;

public interface RepositoryEmployee extends Repository {

    String echo(String val);

    List<User> all();

    int add(User user);

    int update(String name, User user);

    int delete(String name);
}
