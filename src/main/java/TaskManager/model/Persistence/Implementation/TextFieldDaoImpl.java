package TaskManager.model.Persistence.Implementation;

import TaskManager.TaskManagerException;
import TaskManager.model.Persistence.DataBase.ConnectionDB;
import TaskManager.model.Persistence.TextFieldDAO;
import TaskManager.model.Entities.TaskText;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TextFieldDaoImpl implements TextFieldDAO {

    private Connection conn;
    public TextFieldDaoImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(TaskText task) {
        PreparedStatement prepared = null;
        try{
            String sqlInsert = "INSERT INTO task_text(task_text_field) " +
                                "VALUES (?)";

            prepared = conn.prepareStatement(sqlInsert);
            prepared.setString(1, task.getText());
            prepared.execute();
        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }finally {
            ConnectionDB.closeStatement(prepared);
        }
    }

    @Override
    public void update(TaskText task) {
        PreparedStatement prepared = null;
        try{
            String sqlUpdate = "UPDATE task_text SET task_text_field = ? " +
                                "WHERE id = ?";

            prepared = conn.prepareStatement(sqlUpdate);
            prepared.setString(1, task.getText());
            prepared.setInt(2, task.getId());
            prepared.execute();
        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }finally {
            ConnectionDB.closeStatement(prepared);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement prepared = null;
        try{
            String sqlDelete = "DELETE FROM task_text WHERE id = ?";

            prepared = conn.prepareStatement(sqlDelete);
            prepared.setInt(1, id);
            Integer arrowsAffect = prepared.executeUpdate();

            if(arrowsAffect == 0){
                throw new TaskManagerException("ERROR! [task was not registered]");
            }

        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }finally {
            ConnectionDB.closeStatement(prepared);
        }
    }

    @Override
    public List<TaskText> listAll() {
        return null;
    }
}
