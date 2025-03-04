package learning.java.bankApp.service.impl;

import learning.java.bankApp.domain.model.*;
import learning.java.bankApp.service.UserService;
import learning.java.bankApp.service.exception.UserServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest
{
    @Autowired
    UserService userService;

    @Test
    public void shouldThrowExceptionWithInvalidUserId()
    {
        assertThrows(UserServiceException.class, ()->userService.findById(-1l));
    }

    @Test
    public void shouldRecoverCorrectUser()
    {
        User user = new User();
        user.setName("Name");
        userService.create(user);

        User recoveredUser = assertDoesNotThrow(()->userService.findById(user.getId()));
        assertEquals(user.getName(), recoveredUser.getName());
        assertEquals(user.getId(), recoveredUser.getId());
    }

    @Test
    public void shouldCreateUser()
    {
        User user = makeFullUser();
        User createdUser = userService.create(user);

        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getName(), createdUser.getName());

        assertTrue(user.getAccount().equals(createdUser.getAccount()));

        assertTrue(user.getCard().equals(createdUser.getCard()));

        assertEquals(user.getNews().size(), createdUser.getNews().size());
        for(int i=0; i<user.getNews().size(); i++)
            assertTrue(user.getNews().get(i).equals(createdUser.getNews().get(i)));

        assertEquals(user.getFeatures().size(), createdUser.getFeatures().size());
        for(int i=0; i<user.getFeatures().size(); i++)
            assertTrue(user.getFeatures().get(i).equals(createdUser.getFeatures().get(i)));

        assertDoesNotThrow(()->userService.delete(createdUser.getId()));
    }

    @Test
    public void shouldDeleteUser()
    {
        List<User> users = userService.findAll();
        for(User user : users) {
            assertDoesNotThrow(()->userService.findById(user.getId()));
            assertDoesNotThrow(()->userService.delete(user.getId()));
            assertThrows(UserServiceException.class, () -> userService.findById(user.getId()));
        }
    }

    private User makeFullUser()
    {
        Account account = new Account();
        account.setAgency("1575");
        account.setNumber("92234");
        account.setBalance(BigDecimal.valueOf(1_000.00));
        account.setCreditLimit(BigDecimal.valueOf(1_500.00));

        Card card = new Card();
        card.setNumber("9899-2335-1239-8439");
        card.setCreditLimit(BigDecimal.valueOf(3_000.00));

        List<News> news = new ArrayList<>();

        News notice1 = new News();
        notice1.setIconUrl("notice1 iconUrl");
        notice1.setDescription("notice1 description");
        news.add(notice1);

        News notice2 = new News();
        notice2.setIconUrl("notice2 iconUrl");
        notice2.setDescription("notice2 description");
        news.add(notice2);

        List<Feature> features = new ArrayList<>();

        Feature feature1 = new Feature();
        feature1.setIconUrl("feature1 iconUrl");
        feature1.setDescription("feature1 description");
        features.add(feature1);

        Feature feature2 = new Feature();
        feature2.setIconUrl("feature2 iconUrl");
        feature2.setDescription("feature2 description");
        features.add(feature2);

        User user = new User();
        user.setName("UserName");
        user.setAccount(account);
        user.setCard(card);
        user.setNews(news);
        user.setFeatures(features);

        return user;
    }
}