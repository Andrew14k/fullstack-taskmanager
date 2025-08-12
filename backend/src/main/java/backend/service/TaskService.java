package backend.service;

import java.util.List;

import backend.dto.TaskDto;

public interface TaskService {

    TaskDto createTask(TaskDto taskDto);

    TaskDto getTask(Long id);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(TaskDto taskDto, Long id);

    void deleteTask(Long id);
}
