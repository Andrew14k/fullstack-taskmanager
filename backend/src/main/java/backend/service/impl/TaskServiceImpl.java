package backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import backend.dto.TaskDto;
import backend.entity.Task;
import backend.exception.ResourceNotFoundException;
import backend.repository.TaskRepository;
import backend.service.TaskService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private ModelMapper modelMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {

        // convert TaskDto into Task Jpa entity
        // Task task = new Task();
        // task.setTaskName(taskDto.getTaskName());
        // task.setDescription(taskDto.getDescription());
        // task.setDeadline(taskDto.getDeadline());
        Task task = modelMapper.map(taskDto, Task.class);

        // Task Jpa entity
        Task savedTask = taskRepository.save(task);

        // converting savedtask Jpa entity object into TaskDto object
        // TaskDto savedTaskDto = new TaskDto();
        // savedTaskDto.setId(savedTask.getId());
        // savedTaskDto.setTaskName(savedTask.getTaskName());
        // savedTaskDto.setDescription(savedTask.getDescription());
        // savedTaskDto.setDeadline(savedTask.getDeadline());
        TaskDto savedTaskDto = modelMapper.map(savedTask, TaskDto.class);

        return savedTaskDto;
    }

    @Override
    public TaskDto getTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task) -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto, Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        task.setTaskName(taskDto.getTaskName());
        task.setDescription(taskDto.getDescription());
        task.setDeadline(taskDto.getDeadline());
        Task updatedTask = taskRepository.save(task);

        return modelMapper.map(updatedTask, TaskDto.class);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.deleteById(id);
    }
}
