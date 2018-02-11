package io.acode.itrain.db;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assume.assumeTrue;

public class HibernateConnectionTest {
    private HibernateConnectionImpl connection;

    @Before
    public void setUp() {
        connection = new HibernateConnectionImpl();
        assumeTrue(connection.isConnected());
    }

    @Test
    public void testDisconnect() {
        connection.disconnect();
        assert !connection.isConnected();
    }

    @Test
    public void testGetSession() {
        Session session = connection.getSession();
        assert session != null;
        session.close();
    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testRemove() {

    }
}
