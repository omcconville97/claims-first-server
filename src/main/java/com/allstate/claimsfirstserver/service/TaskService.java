package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.exceptions.TaskNotFoundException;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();
    public Task getById(Integer id) throws TaskNotFoundException;
    public List<Task> getByTaskPolicyNo(String taskPolicyNo);
    public List<Task> getByCompleted(boolean completed);
    public Task saveTask(Task task);
    public void deleteTaskById(Integer id);
}
