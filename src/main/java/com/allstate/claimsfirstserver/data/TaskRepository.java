package com.allstate.claimsfirstserver.data;

import com.allstate.claimsfirstserver.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findAllByTaskPolicyNo(String taskPolicyNo);
    public List<Task> findAllByCompleted(boolean completed);
}
