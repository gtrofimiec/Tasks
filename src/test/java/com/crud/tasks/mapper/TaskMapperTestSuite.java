package com.crud.tasks.mapper;

import com.crud.tasks.domain.Dto.TaskDto;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskMapperTestSuite {

    private TaskMapper taskMapper;

    @BeforeEach
    public void setup() {
        taskMapper = new TaskMapper();
    }

    @Test
    void shouldMapTaskDtoToTask() {

        //Given
        TaskDto taskDto = new TaskDto(0L, "title", "content");

        //When
        Task task = taskMapper.mapToTask(taskDto);
        Long taskId = task.getId();
        String taskTitle = task.getTitle();
        String taskContent = task.getContent();

        //Then
        assertEquals(taskId, taskDto.getId());
        assertEquals(taskTitle, taskDto.getTitle());
        assertEquals(taskContent, taskDto.getContent());
    }

    @Test
    void shouldMapTaskToTaskDto() {

        //Given
        Task task = new Task(0L, "title", "content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        Long taskDtoId = taskDto.getId();
        String taskDtoTitle = taskDto.getTitle();
        String taskDtoContent = taskDto.getContent();

        //Then
        assertEquals(taskDtoId, task.getId());
        assertEquals(taskDtoTitle, task.getTitle());
        assertEquals(taskDtoContent, task.getContent());
    }

    @Test
    void shouldMapTaskListToTaskDtoList() {

        //Given
        List<Task> taskList = List.of(new Task(0L, "title", "content"));

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        Long taskDtoId = taskDtoList.get(0).getId();
        String taskDtoTitle = taskDtoList.get(0).getTitle();
        String taskDtoContent = taskDtoList.get(0).getContent();

        //Then
        assertEquals(taskDtoId, taskList.get(0).getId());
        assertEquals(taskDtoTitle, taskList.get(0).getTitle());
        assertEquals(taskDtoContent, taskList.get(0).getContent());
    }
}