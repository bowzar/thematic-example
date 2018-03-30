package com.yulintu.thematic.example.employee;

import com.yulintu.thematic.data.Trackable;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Trackable
public class EmployeeController {

    @Autowired
    private ServiceEmployee service;

    @Value("${spring.application.version}")
    private String version;

    @ApiOperation(value = "Show version", notes = "")
    @GetMapping("/ver")
    public String ver() {
        return version + " from HIDE";
    }

    @ApiOperation(value = "print some message", notes = "")
    @ApiImplicitParam(name = "val", value = "message", required = true, dataType = "String")
    @GetMapping("/echo/{val}")
    public String echo(@PathVariable String val) {
        return service.echo(val);
    }

    @ApiOperation(value = "Clear all cache", notes = "")
    @GetMapping("/clear")
    public int clear() {
        return service.clear();
    }

    @ApiOperation(value = "Get all User", notes = "")
    @GetMapping("/all")
    public List<User> all() {
        return service.all();
    }

    @ApiOperation(value = "Clear user cache", notes = "")
    @GetMapping("/all/clear")
    public int clearAll() {
        return service.clearAll();
    }

    @ApiOperation(value = "添加一个用户")
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    @PostMapping("/add")
    public int add(@RequestBody User user) {
        return service.add(user);
    }

    @ApiOperation(value = "添加一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")})
    @PostMapping("/update/{name}")
    public int update(@PathVariable String name, @RequestBody User user) {
        return service.add(user);
    }

    @ApiOperation(value = "删除一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")})
    @PostMapping("/delete/{name}")
    public int delete(@PathVariable String name) {
        return service.delete(name);
    }
}
