package edu.hubu.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.hubu.learn.dao.UserDao;
import edu.hubu.learn.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(Long id) {
        return userDao.findById(id).get();
    }

    public List<User> getUsers() {
        User user = new User();
        user.setUsername("user");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("username", match->match.startsWith());
        Example<User> example = Example.of(user, matcher);
        Sort sort = new Sort(Direction.DESC, "id");
        return userDao.findAll(example, sort);
    }

    public User addUser(User user) {
        return userDao.save(user);
    }
}