package com.teach.toyrobot.Controller;

import com.teach.toyrobot.Classes.ToyRobot;
import com.teach.toyrobot.Service.ToyRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/toyrobots")
public class ToyRobotController {

    @Autowired
    private ToyRobotService toyRobotService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "TEST 123";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ToyRobot> getAllToyRobots(){
        return toyRobotService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ToyRobot getToyRobotById(@PathVariable("id") int id){
        return toyRobotService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteToyRobotById(@PathVariable("id") int id){
        toyRobotService.deleteToyRobotById(id);
    }

    @RequestMapping(value = "/{id}/report", method = RequestMethod.GET)
    public String report(@PathVariable("id") int id){
        return toyRobotService.report(id);
    }

    @RequestMapping(value = "/{id}/left", method = RequestMethod.POST)
    public void left(@PathVariable("id") int id){
        toyRobotService.turnLeft(id);
    }

    @RequestMapping(value = "/{id}/right", method = RequestMethod.POST)
    public void right(@PathVariable("id") int id){
        toyRobotService.turnRight(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void place(@RequestBody @Valid ToyRobot toyRobot, Errors errors){
        if(errors.hasErrors()){

        }
        else {
            toyRobotService.create(toyRobot);
        }
    }

    @RequestMapping(value = "/{id}/move", method = RequestMethod.POST)
    public void move(@PathVariable("id") int id){
        toyRobotService.move(id);
    }
}
