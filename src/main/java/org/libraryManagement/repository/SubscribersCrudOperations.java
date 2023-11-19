package org.libraryManagement.repository;

import org.libraryManagement.ConnectionDB.ConnectionDB;
import org.libraryManagement.models.Book;
import org.libraryManagement.models.Subscriber;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudOperations implements CrudOperations<Subscriber>{
    ConnectionDB Connection = new ConnectionDB();

    @Override
    public List saveAll(List<Subscriber> subscriber) {
        List<Subscriber> subscribersList = new ArrayList<>();

        for (Subscriber subs : subscriber) {
            Subscriber savedSubscriber = this.save(subs);

            if (savedSubscriber != null) {
                subscribersList.add(savedSubscriber);
            }
        }
        return subscribersList;
    }

    @Override
    public Subscriber save(Subscriber subscriber) {
        try {
            String query = "insert into subscribers ( name ) VALUES (?)";
            PreparedStatement statement = Connection.getConnection().prepareStatement(query);

            statement.setString(1, subscriber.getName());

            statement.executeUpdate();
            System.out.println("subscriber added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return subscriber;
    }

    @Override
    public List findAll() {
        List<Subscriber> subscriber = new ArrayList<>();
        String sql = "SELECT * FROM subscribers";

        try (Statement statement = Connection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Subscriber newSubscriber = extractSubscriberFromResultSet(resultSet);
                subscriber.add(newSubscriber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscriber;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        Subscriber deleted = new Subscriber();
        try {

            String sql = "DELETE FROM subscriber WHERE id = ?";

            PreparedStatement statement = Connection.getConnection().prepareStatement(sql);

            statement.setInt(1, toDelete.getId());

            int row = statement.executeUpdate();

            if(row != 0){
                deleted = toDelete;
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleted;
    }

    private  Subscriber extractSubscriberFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String Name = resultSet.getString("name");
        String reference = resultSet.getString("reference");


        return new Subscriber(id,Name,reference);
    }

}
