package application;

import java.math.BigDecimal;
import java.sql.Date;

import model.dao.DaoFactory;
import model.dao.OrderDao;
import model.entities.Order;

public class ProgramOrder {
    public static void main(String[] args) {
        OrderDao orderDao = DaoFactory.creatOrderDao();

        Order newOrder = new Order();

        newOrder.setClientsId(1);
        newOrder.setBooksId(2);
        newOrder.setQuantityPurchased(2);
        newOrder.setDateApplication(Date.valueOf("2023-12-17"));
        newOrder.setOrderStatus("Pendente");
        newOrder.setUnitPrice(BigDecimal.valueOf(79.49));

        orderDao.insert(newOrder);
        System.out.println("New Book inserted with successfully! Id: " + newOrder.getID());

        System.out.println("===== TEST 1.2: Order INSERT INTO Orders =====");
    }
}
