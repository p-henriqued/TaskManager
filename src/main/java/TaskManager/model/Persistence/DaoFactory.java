package TaskManager.model.Persistence;

import TaskManager.model.Persistence.DataBase.ConnectionDB;
import TaskManager.model.Persistence.Implementation.TextFieldDaoImpl;

public class DaoFactory {

    public static TextFieldDAO TaskTextDAO(){
        return new TextFieldDaoImpl(ConnectionDB.recoverConnection());
    }

}
