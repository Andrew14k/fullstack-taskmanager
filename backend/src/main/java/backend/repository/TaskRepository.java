package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Task;

// TaskRepository will get CRUD methods from JpaRepository, so it can perform CRUD database operations
public interface TaskRepository extends JpaRepository<Task, Long> {

}
