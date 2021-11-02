package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class TaskRepositoryTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void cleaningUp() {
        taskRepository.deleteAll();
    }

    @Test
    void shouldFindAllTasks() {

        //Given
        Task task1 = new Task();
        Task task2 = new Task();
        taskRepository.save(task1);
        taskRepository.save(task2);

        //When
        List<Task> taskList = taskRepository.findAll();

        //Then
        assertEquals(2, taskList.size());
    }

    @Test
    void shouldSaveTask() {

        //Given
        Task task = new Task();
        taskRepository.save(task);

        //When
        Long taskId = task.getId();

        //Then
        assertTrue(taskRepository.existsById(taskId));
    }

    @Test
    void shouldFindTaskById() {

        //Given
        Task task1 = new Task();
        Task task2 = new Task();
        taskRepository.save(task1);
        taskRepository.save(task2);

        //When
        Long task1Id = task1.getId();
        Optional<Task> foundTask = taskRepository.findById(task1Id);

        //Then
        assertEquals(task1Id, foundTask.get().getId());
    }

    @Test
    void shouldDeleteTask() {

        //Given
        Task task1 = new Task();
        Task task2 = new Task();
        taskRepository.save(task1);
        taskRepository.save(task2);

        //When
        Long task1Id = task1.getId();
        taskRepository.deleteById(task1Id);
        Optional<Task> removedTask = taskRepository.findById(task1Id);
        int availableTasks = taskRepository.findAll().size();

        //Then
        assertEquals(Optional.empty(), removedTask);
        assertEquals(1, availableTasks);
    }
}