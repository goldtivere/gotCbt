package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.LoginCommand;
import got.cbtproject.gotcbt.model.Users;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LoginCommandToUser implements Converter<LoginCommand, Users> {


    @Synchronized
    @Override
    public Users convert(LoginCommand source) {

        if(source == null)
        {
            return null;
        }
//        final Users users= new Users();
//        users.setUserId(source.getUserId());
//        users.setPassword(source.getPassword());

        return null;
    }
}
