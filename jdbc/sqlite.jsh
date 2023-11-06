//usr/bin/env jshell --class-path=../jars/sqlite-jdbc-3.43.2.2.jar:../jars/slf4j-api-2.0.9.jar $0 $@; exit $?

/open PRINTING

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

Class.forName("org.sqlite.JDBC");

    public static Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            // String url = "jdbc:sqlite::memory:"; // for in-memory db
            String url = "jdbc:sqlite:mysqlite.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            // try {
            //     if (conn != null) {
            //         conn.close();
            //     }
            // } catch (SQLException ex) {
            //     System.out.println(ex.getMessage());
            // }
        }

        return conn;

    }

    public static void createTable(String tableName) {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS "+tableName+" (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        
        try (Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectAll(String tableName) {
        String sql = "SELECT id, name, capacity FROM " + tableName;
        
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(String tableName, String name, double capacity) {

String sql = "INSERT INTO "+tableName+"(name,capacity) VALUES(?,?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


var conn = connect();
println("Create Table")
createTable("topic");
println("Insert data 1")
insert("topic", "First name", 100);
println("Insert data 2")

insert("topic", "Second name", 200);

selectAll("topic");

/exit