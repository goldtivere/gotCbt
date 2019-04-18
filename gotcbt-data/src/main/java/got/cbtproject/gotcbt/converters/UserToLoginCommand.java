package got.cbtproject.gotcbt.converters;

import got.cbtproject.gotcbt.command.LoginCommand;
import got.cbtproject.gotcbt.model.Users;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToLoginCommand implements Converter<Users, LoginCommand> {

    @Synchronized
    @Override
    public LoginCommand convert(Users source) {

        if(source == null) {
            return null;
        }

        final LoginCommand command= new LoginCommand();
        command.setUserId(source.getUserId());
        command.setPassword(source.getPassword());

        return command;
    }
}
