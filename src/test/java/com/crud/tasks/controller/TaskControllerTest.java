package com.crud.tasks.controller;

import com.crud.tasks.domain.Dto.TaskDto;
import com.crud.tasks.domain.Task;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskController taskController;

    @Test
    void shouldGetTasks() throws Exception {

        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto(0L, "title", "content"));
        when(taskController.getTasks()).thenReturn(taskDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("content")));
    }

    @Test
    void shouldGetTask() throws Exception {

        //Given
        TaskDto taskDto = new TaskDto(0L, "title", "content");
        Long taskId = taskDto.getId();
        when(taskController.getTask(taskId)).thenReturn(taskDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks/" + taskId)
//                        .param("taskId", String.valueOf(taskId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", Matchers.is("content")));
    }

    @Test
    void shouldDeleteTask() {

        //Given
        Task task = new Task(0L, "title", "content");
        Long taskId = task.getId();

        //When
        taskController.deleteTask(taskId);

        //Then
        verify(taskController).deleteTask(taskId);
     }

    @Test
    void shouldUpdateTask() throws Exception {

        //Given
        TaskDto taskDto = new TaskDto(0L, "title", "content");
        when(taskController.updateTask(taskDto)).thenReturn(taskDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/tasks")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateTask() {

        //Given
        TaskDto taskDto = new TaskDto(0L, "title", "content");

        //When
        taskController.createTask(taskDto);

        //Then
        verify(taskController).createTask(taskDto);
    }
}