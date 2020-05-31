package Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectTest {
    static DBConnect db = new DBConnect();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getConnection() {
    }

    @Test
    void getPS() {
    }

    @Test
    void executeQuery() {
    }

    @Test
    void executeUpdate() {
        String sql = "insert into customer (username,userpwd) values ('zhou1','123')";
        int result = db.executeUpdate(sql);
        assert result == 1;
    }

    @Test
    void free() {
    }
}