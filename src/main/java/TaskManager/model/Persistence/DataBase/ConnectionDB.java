package TaskManager.model.Persistence.DataBase;

import TaskManager.TaskManagerException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {

    /*Method without using a connection pool, in addition to having to manually close this connection.
    public Connection recoverConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager?username=root&password=Abc123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static Connection recoverConnection(){
        try{
            return createDataSource().getConnection();
        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
        try{
            if(statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet result){
        try{
            if(result != null){
                result.close();
            }
        }catch (SQLException e){
            throw new TaskManagerException(e.getMessage());
        }
    }


    //using a connection pool
    private static HikariDataSource createDataSource(){
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:mysql://localhost:3306/task_manager");
        config.setUsername("root");
        config.setPassword("Abc123");
        config.setMaximumPoolSize(20);

        return new HikariDataSource(config);
    }

}
