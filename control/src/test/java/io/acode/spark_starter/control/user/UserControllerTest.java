package io.acode.spark_starter.control.user;

import io.acode.spark_starter.models.User;
import junit.framework.TestCase;

public class UserControllerTest extends TestCase {
    public void testInit() {
        UserControl control = new UserControlImpl();
        assertNotNull(control);
    }

    public void testCreateUser() {
        UserControl control = new UserControlImpl();
        User user = new User();
        user.setEmail("1111");
        user.setName("1111");
        control.createUser(user);
        assertEquals(1, control.getAllUsers().size());
        control.createUser(user);
        assertEquals(2, control.getAllUsers().size());
    }

    public void testGetAllUsers() {
        UserControl control = new UserControlImpl();
        User user = new User();
        user.setEmail("1111");
        user.setName("1111");

        for (int i = 0; i < 100; i++) {
            control.createUser(user);
        }
        assertEquals(100, control.getAllUsers().size());
    }

    public void testGetUserById() {
        UserControl control = new UserControlImpl();

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setEmail("1111");
            user.setName("1111");
            control.createUser(user);
        }

        assertEquals(50, control.getUser(50).getId());
    }

    public void testUpdateUser() {
        UserControl control = new UserControlImpl();

        User user = new User();
        user.setEmail("1111");
        user.setName("1111");
        control.createUser(user);

        assertEquals(1, control.getUser(1).getId());
        assertEquals("1111", control.getUser(1).getName());
        assertEquals("1111", control.getUser(1).getEmail());

        User updateUser = new User();
        updateUser.setId(1);
        updateUser.setName("2222");
        updateUser.setEmail("2222");

        control.updateUser(updateUser);

        assertEquals(1, control.getUser(1).getId());
        assertEquals("2222", control.getUser(1).getName());
        assertEquals("2222", control.getUser(1).getEmail());
    }

    public void testDeleteUser() {
        UserControl control = new UserControlImpl();

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setEmail("1111");
            user.setName("1111");
            control.createUser(user);
        }

        assertEquals(100, control.getAllUsers().size());
        control.deleteUser(50);

        assertEquals(99, control.getAllUsers().size());
        assertNull(control.getUser(50));
    }
}
