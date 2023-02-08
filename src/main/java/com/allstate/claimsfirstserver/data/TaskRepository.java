package com.allstate.claimsfirstserver.data;

import com.allstate.claimsfirstserver.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findAllByTaskPolicyNo(String taskPolicyNo);
}
