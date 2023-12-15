package application;

import model.dao.ClientDao;
import model.dao.DaoFactory;
import model.entities.Client;

public class ProgramClient {
    public static void main(String[] args) {
        
        ClientDao clientDao = DaoFactory.createClientDao();

        System.out.println("===== TEST 1: Client INSERT INTO Clients =====");
        Client newClient = new Client();

        newClient.setName("José Augusto O. Vicente");
        newClient.setCpf("492.333.786-24");
        newClient.setAddress("Rua Paschoal Gianfrancesco, Jardim das palmeira, Várzea Paulista - SP");
        newClient.setEmail("guto188@outlook.com");
        newClient.setPhoneNumber("(11) 94260-4463");

        clientDao.inset(newClient);
        System.out.println("New Client inserted with successfully! Id: " + newClient.getID());

    }
}
