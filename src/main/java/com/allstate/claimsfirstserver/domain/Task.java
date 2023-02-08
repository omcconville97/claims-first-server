package com.allstate.claimsfirstserver.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taskPolicyNo;
    private String taskNote;
    private Boolean completed;

    public Task(Integer id, String taskPolicyNo, String taskNote, Boolean completed) {
        this.id = id;
        this.taskPolicyNo = taskPolicyNo;
        this.taskNote = taskNote;
        this.completed = completed;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskPolicyNo() {
        return taskPolicyNo;
    }

    public void setTaskPolicyNo(String taskPolicyNo) {
        this.taskPolicyNo = taskPolicyNo;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(taskPolicyNo, task.taskPolicyNo) && Objects.equals(taskNote, task.taskNote) && Objects.equals(completed, task.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskPolicyNo, taskNote, completed);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskPolicyNo='" + taskPolicyNo + '\'' +
                ", taskNote='" + taskNote + '\'' +
                ", completed=" + completed +
                '}';
    }
}
