package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Users,Long> {

    Optional<Users> findByUserIdAndPassword(String userid, String password);

}
