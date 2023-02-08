package com.allstate.claimsfirstserver.control;

import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.exceptions.TaskNotFoundException;
import com.allstate.claimsfirstserver.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks(@RequestParam(value = "taskPolicyNo", required = false) String taskPolicyNo) {
        if (taskPolicyNo != null){
            return taskService.getByTaskPolicyNo(taskPolicyNo);
        }
        else {
            return taskService.getAllTasks();
        }
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Integer id) throws TaskNotFoundException {
        return taskService.getById(id);
    }

    @GetMapping("/status")
    public List<Task> getByCompleted(@RequestParam(value = "completed", required = false) boolean completed) {
        return taskService.getByCompleted(completed);
    }

    @PostMapping
    public Task saveNewTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) throws TaskNotFoundException{
        taskService.deleteTaskById(id);
    }
}
