package backend.controller;

import java.util.List;

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

import backend.dto.TaskDto;
import backend.service.TaskService;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("api/tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    // Task add/create REST API build
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Task get REST API build
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long taskId) {
        TaskDto taskDto = taskService.getTask(taskId);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    // Task get ALL REST API build
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
        //return ResponseEntity.ok(tasks);
    }

    // Task update REST API build
    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto, @PathVariable("id") Long taskId) {
        TaskDto updatedTask = taskService.updateTask(taskDto, taskId);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Task delete REST API build
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully.");
    }
}
