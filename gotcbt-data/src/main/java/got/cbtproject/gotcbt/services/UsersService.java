package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.model.Users;

public interface UsersService{

//LoginCommand findUsernameAndPassword(LoginCommand loginCommand);
    Users findByUserId(String id);

}
