package com.example.raghav.jetpackgithub;

import com.example.raghav.jetpackgithub.repository.UserRepository;
import com.example.raghav.jetpackgithub.viewmodel.UserReposViewModel;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserReposViewModelTest {

    @Test
    public void test1() {
        String userId = "abcd";
        UserRepository mockUserRepo = mock(UserRepository.class);

        UserReposViewModel viewModel = new UserReposViewModel(mockUserRepo);
        viewModel.init(userId);

        verify(mockUserRepo, times(1)).getUser(eq(userId), any());
        verify(mockUserRepo, times(1)).listRepos(eq(userId), any());
    }
}
