package com.jee.zad8_2;

import com.jee.zad8_2.domain.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class JdbcPersonRepository implements PersonRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcPersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");

            PreparedStatement psmt = con.prepareStatement("DROP TABLE IF EXISTS person");
            psmt.executeUpdate();

            PreparedStatement newTable = con.prepareStatement("CREATE TABLE person(id INT, firstName VARCHAR(255), surname VARCHAR(255))");
            newTable.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Person> findAll() {
        ArrayList<Person> persons = new ArrayList<>();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            psmt = con.prepareStatement("SELECT id, firstName, surname FROM person");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("surname"));
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return persons;
    }

    public Person findById(int id) {
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            psmt = con.prepareStatement("SELECT id, firstName, surname FROM person WHERE id = ?");
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Person person = new Person(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("surname"));
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        return null;
    }

    public void save(Person person) {
        Connection con = null;
        PreparedStatement psmt = null;
        int id = person.getId();
        String firstName = person.getFirstName();
        String surname = person.getSurname();
        try {
            con = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            psmt = con.prepareStatement("INSERT INTO person(id, firstName, surname) VALUES (?, ?, ?)");
            psmt.setInt(1, id);
            psmt.setString(2, firstName);
            psmt.setString(3, surname);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (psmt != null) {
                try {
                    psmt.close();
                } catch (SQLException e) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
