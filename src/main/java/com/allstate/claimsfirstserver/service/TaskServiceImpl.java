package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.data.TaskRepository;
import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        System.out.println("There were " + tasks.size() + " tasks found");
        return tasks;
    }

    @Override
    public Task getById(Integer id) throws TaskNotFoundException {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            throw new TaskNotFoundException("There is no task with id " +id);
        }
    }

    @Override
    public List<Task> getByTaskPolicyNo(String taskPolicyNo) {
        return taskRepository.findAllByTaskPolicyNo(taskPolicyNo);
    }

    @Override
    public List<Task> getByCompleted(boolean completed) {
        return taskRepository.findAllByCompleted(completed);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTaskById(Integer id) {
        taskRepository.deleteById(id);
    }
}
