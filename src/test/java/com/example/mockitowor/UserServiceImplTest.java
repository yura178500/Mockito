package com.example.mockitowor;


import com.example.mockitowor.Model.User;
import com.example.mockitowor.Service.impl.DaoImpl;
import com.example.mockitowor.Service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private final DaoImpl daoImpl = Mockito.mock(DaoImpl.class);
    private final UserServiceImpl userService;

    public UserServiceImplTest() {
        userService = new UserServiceImpl(daoImpl);
    }

    @Test
    void checkExistUserMustReturnTrue() {
        User correctUser = new User("Tom", 33);
        when(daoImpl.getUserByName("Tom")).thenReturn(correctUser);
        boolean checkUser = userService.checkUserExist(correctUser);
        assertTrue(checkUser);
    }

    @Test
    void checkNonExistUserMustReturnFalse() {
        User wrongUser = null;
        when(daoImpl.getUserByName("Wrong Name")).thenReturn(wrongUser);
        boolean checkUser = userService.checkUserExist(wrongUser);
        assertFalse(checkUser);
    }
}