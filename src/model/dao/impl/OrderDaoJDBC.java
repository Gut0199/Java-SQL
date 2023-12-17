package model.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.OrderDao;
import model.entities.Order;

public class OrderDaoJDBC implements OrderDao {

    private Connection conn;

    public OrderDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Order obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement(
                    "INSERT INTO orders"
                            + "(ClientsId, BooksId, QuantityPurchased, DateApplication, OrderStatus, UnitPrice)"
                            + "VALUE" + "(?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getClientsId());
            st.setInt(2, obj.getBooksId());
            st.setInt(3, obj.getQuantityPurchased());
            st.setDate(4, obj.getDateApplication());
            st.setString(5, obj.getOrderStatus());
            st.setBigDecimal(6, obj.getUnitPrice());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setID(id);
                }
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Order obj) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement(
                    "UPDATE orders SET ClientsId = ?, BooksId = ?, QuantityPurchased = ?, DateApplication = ?, OrderStatus = ?, UnitPrice = ? WHERE ID = ?");

            st.setInt(1, obj.getClientsId());
            st.setInt(2, obj.getBooksId());
            st.setInt(3, obj.getQuantityPurchased());
            st.setDate(4, obj.getDateApplication());
            st.setString(5, obj.getOrderStatus());
            st.setBigDecimal(6, obj.getUnitPrice());
            st.setInt(7, obj.getID());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {

            st = conn.prepareStatement("DELETE FROM orders WHERE id = ?");
            st.setInt(1, id);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("No rows affected. No book found with Id: " + id);
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Order selectById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("SELECT * FROM orders WHERE id = ?");
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiateOrder(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }

    private Order instantiateOrder(ResultSet rs) throws SQLException {

        Integer ID = rs.getInt("ID");
        Integer clientsId = rs.getInt("ClientsId");
        Integer booksId = rs.getInt("BooksId");
        Integer quantityPurchased = rs.getInt("QuantityPurchased");
        Date dateApplication = rs.getDate("DateApplication");
        String orderStatus = rs.getString("OrderStatus");
        BigDecimal unitPrice = rs.getBigDecimal("UnitPrice");

        return new Order(ID, clientsId, booksId, quantityPurchased, dateApplication, orderStatus, unitPrice);
    }

    @Override
    public List<Order> selectAll() {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM orders");
            rs = st.executeQuery();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return orderList;
    }

}
