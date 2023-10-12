package br.com.rbpolim.todolist.tasks;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
  List<TaskModel> findAllByIdUser(UUID idUser);
}
