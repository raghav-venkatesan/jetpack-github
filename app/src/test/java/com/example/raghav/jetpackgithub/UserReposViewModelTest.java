package com.example.raghav.jetpackgithub;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.MutableLiveData;

import com.example.raghav.jetpackgithub.model.User;
import com.example.raghav.jetpackgithub.model.Repo;
import com.example.raghav.jetpackgithub.repository.UserRepository;
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserReposViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void test1() {
        String userId = "abcd";
        UserRepository mockUserRepo = mock(UserRepository.class);

        MutableLiveData<User> userData = new MutableLiveData<>();
        User user1 = new User("d", "e", "f");
        userData.setValue(user1);

        MutableLiveData<List<Repo>> repoData = new MutableLiveData<>();
        Repo repo1 = new Repo("1", "2", "3", 4, 5);
        Repo repo2 = new Repo("6", "7", "8", 9, 10);
        ArrayList<Repo> reposList = new ArrayList<>();
        reposList.add(repo1);
        reposList.add(repo2);
        repoData.setValue(reposList);

        when(mockUserRepo.getUser(userId)).thenReturn(userData);
        when(mockUserRepo.listRepos(userId)).thenReturn(repoData);

        UserReposViewModel viewModel = new UserReposViewModel();
        viewModel.init(userId, mockUserRepo);

        assertEquals(viewModel.getUser(), userData);
        assertEquals(viewModel.getRepos(), repoData);
    }
}
