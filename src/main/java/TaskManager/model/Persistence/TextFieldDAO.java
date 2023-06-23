package TaskManager.model.Persistence;

import TaskManager.model.Entities.TaskText;

import java.util.List;

public interface TextFieldDAO {

    void insert(TaskText task);
    void update(TaskText task);
    void delete(Integer id);
    List<TaskText> listAll();

}
