package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.ClientDao;
import model.entities.Client;

public class ClientDaoJDBC implements ClientDao{

    
    private Connection conn;

    public ClientDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inset(Client obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inset'");
    }

    @Override
    public void update(Client obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Client selectById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectById'");
    }

    @Override
    public List<Client> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }
    
}
