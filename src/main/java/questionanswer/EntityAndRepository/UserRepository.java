package questionanswer.EntityAndRepository;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
    public User findByCode(String code);
}
