package com.allstate.claimsfirstserver.control;

import com.allstate.claimsfirstserver.domain.Claim;
import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;
import com.allstate.claimsfirstserver.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

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
    public Task findById(@PathVariable Integer id) throws ClaimNotFoundException {
        return taskService.getById(id);
    }

    @PostMapping
    public Task saveNewTask(@RequestBody Task task) {
        System.out.println(task);
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) throws ClaimNotFoundException{
        taskService.deleteTaskById(id);
    }
}
