package model.dao;

import java.util.List;

import model.entities.Client;

public interface ClientDao {

    void inset(Client obj);

    void update(Client obj);

    void deleteById(Integer id);

    Client selectById(Integer id);

    List<Client> selectAll();
}
