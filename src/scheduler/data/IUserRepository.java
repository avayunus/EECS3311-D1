package scheduler.data;

import java.util.List;

import scheduler.model.User;

public interface IUserRepository {
    List<User> findAll();

    User findById(String id);

    User findByEmail(String email);

    void save(User user);
}
