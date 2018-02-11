package io.acode.itrain.control.user;

import io.acode.itrain.models.User;
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
        assertEquals(1, control.getAllUsers().getResult().size());
        control.createUser(user);
        assertEquals(2, control.getAllUsers().getResult().size());
    }

    public void testGetAllUsers() {
        UserControl control = new UserControlImpl();
        User user = new User();
        user.setEmail("1111");
        user.setName("1111");

        for (int i = 0; i < 100; i++) {
            control.createUser(user);
        }
        assertEquals(100, control.getAllUsers().getResult().size());
    }

    public void testGetUserById() {
        UserControl control = new UserControlImpl();

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setEmail("1111");
            user.setName("1111");
            control.createUser(user);
        }

        assertEquals(50, control.getUser(50).getResult().getId());
    }

    public void testUpdateUser() {
        UserControl control = new UserControlImpl();

        User user = new User();
        user.setEmail("1111");
        user.setName("1111");
        control.createUser(user);

        assertEquals(1, control.getUser(1).getResult().getId());
        assertEquals("1111", control.getUser(1).getResult().getName());
        assertEquals("1111", control.getUser(1).getResult().getEmail());

        User updateUser = new User();
        updateUser.setId(1);
        updateUser.setName("2222");
        updateUser.setEmail("2222");

        control.updateUser(updateUser);

        assertEquals(1, control.getUser(1).getResult().getId());
        assertEquals("2222", control.getUser(1).getResult().getName());
        assertEquals("2222", control.getUser(1).getResult().getEmail());
    }

    public void testDeleteUser() {
        UserControl control = new UserControlImpl();

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setEmail("1111");
            user.setName("1111");
            control.createUser(user);
        }

        assertEquals(100, control.getAllUsers().getResult().size());
        control.deleteUser(50);

        assertEquals(99, control.getAllUsers().getResult().size());
        assertNull(control.getUser(50));
    }
}
