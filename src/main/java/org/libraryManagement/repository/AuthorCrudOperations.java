package org.libraryManagement.repository;

import org.libraryManagement.ConnectionDB.ConnectionDB;
import org.libraryManagement.models.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {

    ConnectionDB Connection = new ConnectionDB();

    @Override
    public Author save(Author author) {
        try {
            String query = "insert into author (name , gender) VALUES (?, ? )";
            PreparedStatement statement = Connection.getConnection().prepareStatement(query);

            statement.setString(1, author.getName());
            statement.setString(2, String.valueOf(author.getGender()));

            statement.executeUpdate();
            System.out.println("Author added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return author;
    }


    @Override
    public List<Author> saveAll(List<Author> values) {
        List<Author> authorList = new ArrayList<>();

        for (Author author : values) {
            Author savedAuthor = this.save(author);

            if (savedAuthor != null) {
                authorList.add(savedAuthor);
            }
        }
        return authorList;
    }

    @Override
    public List findAll() {

        List<Author> author = new ArrayList<>();
        String sql = "SELECT * FROM author";

        try (Statement statement = Connection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Author newAuthor = extractAuthorFromResultSet(resultSet);
                author.add(newAuthor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return author;
    }

    @Override
    public Author delete(Author toDelete) {
        Author deleted = new Author();
        try {

            String sql = "DELETE FROM author WHERE id = ?";

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


    private Author extractAuthorFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String Name = resultSet.getString("name");
        String gender = resultSet.getString("gender");

        return new Author(id,Name,gender);
    }
}
