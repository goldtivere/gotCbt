package got.cbtproject.gotcbt.repositories;

import got.cbtproject.gotcbt.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {

    Users findByUserId(String userId);


}
