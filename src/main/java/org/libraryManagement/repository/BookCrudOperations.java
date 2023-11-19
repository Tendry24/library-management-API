package org.libraryManagement.repository;

import org.libraryManagement.ConnectionDB.ConnectionDB;
import org.libraryManagement.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    ConnectionDB Connection = new ConnectionDB();
    @Override
    public Book save(Book book) {
        try {
            String query = "insert into Book (bookName , pageNumbers,topic,releaseDate,authorId) VALUES (?, ?,?,?,? )";
            PreparedStatement statement = Connection.getConnection().prepareStatement(query);

            statement.setString(1, book.getBookName());
            statement.setString(2, book.getTopic());
            statement.setInt(3, book.getPageNumbers());
            statement.setTimestamp(4, book.getReleaseDate());
            statement.setString(5,book.getAuthorId());

            statement.executeUpdate();
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return book;
    }


    @Override
    public List saveAll(List<Book> values) {
        List<Book> BookList = new ArrayList<>();

        for (Book book : values) {
            Book savedBook = this.save(book);

            if (savedBook != null) {
                BookList.add(savedBook);
            }
        }
        return BookList;
    }

    @Override
    public List findAll() {
        List<Book> book = new ArrayList<>();
        String sql = "SELECT * FROM Book";

        try (Statement statement = Connection.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Book newBook = extractBookFromResultSet(resultSet);
                book.add(newBook);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public Book delete(Book toDelete) {
        Book deleted = new Book();
        try {

            String sql = "DELETE FROM Book WHERE id = ?";

            PreparedStatement statement = Connection.getConnection().prepareStatement(sql);

            statement.setString(1, toDelete.getId());

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

    private  Book extractBookFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String Name = resultSet.getString("bookName");
        Integer pageNumbers = resultSet.getInt("pageNumbers");
        String topic = resultSet.getString("topic");
        Timestamp releaseDate = resultSet.getTimestamp("releaseDate");
        String authorId = resultSet.getString("authorId");

        return new Book(id,Name,pageNumbers,topic,releaseDate,authorId);
    }


}
