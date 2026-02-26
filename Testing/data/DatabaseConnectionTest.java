package data;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;
import dal.DatabaseConnection;

class DatabaseConnectionTest {

    @Test
    void testSingletonReset() {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();

        assertSame(instance1, instance2, "Instances should be the same (Singleton)");

        // Reset
        DatabaseConnection.resetInstance();

        DatabaseConnection instance3 = DatabaseConnection.getInstance();
        assertNotSame(instance1, instance3, "After reset, a new instance should be created");
    }
}
