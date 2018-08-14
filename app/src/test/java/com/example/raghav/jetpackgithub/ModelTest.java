package com.example.raghav.jetpackgithub;

import com.example.raghav.jetpackgithub.model.Repo;
import com.example.raghav.jetpackgithub.model.User;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void testUserModel() {
        User user = new User("0","1", "2");
        assertEquals(user.getUserId(), "0");
        assertEquals(user.getName(), "1");
        assertEquals(user.getAvatar_url(), "2");
    }

    @Test
    public void testRepoModel() {
        Repo repo = new Repo("0","1", "2", "3", 4, 5);
        assertEquals(repo.getUserId(), "0");
        assertEquals(repo.getName(), "1");
        assertEquals(repo.getDescription(), "2");
        assertEquals(repo.getUpdated_at(), "3");
        assertEquals(repo.getStargazers_count(), 4);
        assertEquals(repo.getForks(), 5);
    }
}
