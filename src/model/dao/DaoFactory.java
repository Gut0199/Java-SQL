package model.dao;

import db.DB;
import model.dao.impl.BookDaoJDBC;
import model.dao.impl.ClientDaoJDBC;
import model.dao.impl.OrderDaoJDBC;

public class DaoFactory {

    public static BookDao createBookDao() {
        return new BookDaoJDBC(DB.getConnection());
    }

    public static ClientDao createClientDao() {
        return new ClientDaoJDBC(DB.getConnection());
    }

    public static OrderDao creatOrderDao() {
        return new OrderDaoJDBC(DB.getConnection());
    }
}
