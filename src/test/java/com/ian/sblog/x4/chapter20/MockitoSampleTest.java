package com.ian.sblog.x4.chapter20;

import com.ian.sblog.domain.User;
import com.ian.sblog.service.UserService;
import com.ian.sblog.service.impl.UserServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockitoSampleTest {

    UserService mockUserService = mock(UserService.class);

    UserServiceImpl mockUserServiceImpl = mock(UserServiceImpl.class);

    @Mock
    User mockUser;

    @BeforeClass
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockInterface(){
        when(mockUserService.logon("tom", "tom12345")).thenReturn(
                new User("tom", "tom12345")
        );

        User u = new User("John", "12345");
        doNothing().when(mockUserService).register(u);

        // execute
        User user = mockUserService.logon("tom", "tom12345");
        mockUserService.register(u);

        assertNotNull(user);
        assertEquals(user.getUsername(), "tom");

        verify(mockUserService).logon("tom", "tom12345");
        verify(mockUserService, atLeastOnce()).logon("tom", "tom12345");
        verify(mockUserService, atLeast(1)).logon("tom", "tom12345");
        verify(mockUserService, atMost(1)).logon("tom", "tom12345");
    }

    @Test
    public void testMockClass(){

        when(mockUserServiceImpl.logon("tom", "tom54321")).thenReturn(
                new User("tom", "tom54321")
        );
        User user = mockUserServiceImpl.logon("tom", "tom54321");
        assertNotNull(user);
        assertEquals(user.getUsername(), "tom");
    }

    @Test
    public void testMockUser(){
        when(mockUser.getId()).thenReturn(1);
        when(mockUser.getUsername()).thenReturn("tom");
        assertEquals(mockUser.getId(), new Integer(1));
        assertEquals(mockUser.getUsername(), "tom");
    }
}
