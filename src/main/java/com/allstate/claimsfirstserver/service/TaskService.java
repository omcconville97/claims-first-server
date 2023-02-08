package com.allstate.claimsfirstserver.service;

import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.exceptions.ClaimNotFoundException;

import java.util.List;

public interface TaskService {

    public List<Task> getAllTasks();
    public Task getById(Integer id) throws ClaimNotFoundException;
    public List<Task> getByTaskPolicyNo(String taskPolicyNo);
    public Task saveTask(Task task);
    public void deleteTaskById(Integer id);
}
