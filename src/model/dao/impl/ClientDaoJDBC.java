package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ClientDao;
import model.entities.Client;

public class ClientDaoJDBC implements ClientDao {

    private Connection conn;

    public ClientDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inset(Client obj) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO clients" +
                            "(name, cpf, address, email, phoneNumber)" +
                            "VALUE" +
                            "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getAddress());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getPhoneNumber());

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
    public void update(Client obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE clients SET name = ?, cpf = ?, address = ?, email = ?, phoneNumber = ? WHERE id = ?");

            st.setString(1, obj.getName());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getAddress());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getPhoneNumber());
            st.setInt(6, obj.getID());

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

            st = conn.prepareStatement("DELETE FROM clients WHERE id = ?");
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
    public Client selectById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {

            st = conn.prepareStatement("SELECT * FROM clients WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                return instantiateClient(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }

    private Client instantiateClient(ResultSet rs) throws SQLException {

        Integer ID = rs.getInt("ID");
        String name = rs.getString("name");
        String cpf = rs.getString("cpf");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phoneNumber");

        return new Client(ID, name, cpf, address, email, phoneNumber);
    }

    @Override
    public List<Client> selectAll() {
        List<Client> clientList = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM clients");
            rs = st.executeQuery();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
        return clientList;
    }

}
