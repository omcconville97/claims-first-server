package com.allstate.claimsfirstserver;


import com.allstate.claimsfirstserver.data.TaskRepository;
import com.allstate.claimsfirstserver.domain.Task;
import com.allstate.claimsfirstserver.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void testFindAllTasksThatShouldBeReturned() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "CF101", "",true));
        tasks.add(new Task(2, "CF102", "",true));
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);

        assertNotNull(tasks);
        assertEquals(2, tasks.size());
    }

    @Test
    public void testFindByTaskPolicyNo() {
        Task task1 = new Task(1, "CF101", "",true);
        Task task2 = new Task(2, "CF102", "",true);

        assertEquals("CF101", task1.getTaskPolicyNo());
    }
    @Test
    public void testFindByTaskCompleted() {
        Task task1 = new Task(1, "CF101", "",true);
        Task task2 = new Task(2, "CF102", "",false);

        assertEquals(true, task1.getCompleted());
        assertNotEquals(true, task2.getCompleted());
    }
}
