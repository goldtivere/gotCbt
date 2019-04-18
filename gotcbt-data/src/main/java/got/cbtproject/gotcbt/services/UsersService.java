package got.cbtproject.gotcbt.services;

import got.cbtproject.gotcbt.command.LoginCommand;

public interface UsersService{

    LoginCommand findUsernameAndPassword(LoginCommand loginCommand);

}
