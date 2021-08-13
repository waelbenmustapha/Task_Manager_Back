package com.angular.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/task")
public class TaskController {
private final TaskRepo taskRepo;
  @GetMapping("GetTasks")
  public ResponseEntity getalltasksk()
  {
    return new ResponseEntity<>(taskRepo.findAll(), HttpStatus.OK);

  } @DeleteMapping("DeleteTask/{id}")
  public void DeleteTask(@PathVariable Long id)
  {
    taskRepo.deleteById(id);
  }
  @PutMapping("/Update/{id}/{reminder}")
  public void updatetask(@PathVariable("id") Long id,@PathVariable("reminder") boolean reminder)
  {
   Task task = taskRepo.findById(id).get();
   task.setReminder(reminder);
   taskRepo.save(task);
  }
  @PostMapping("/Add")
  public void addtask(@RequestBody Task task)
  {
    taskRepo.save(task);
  }

}
