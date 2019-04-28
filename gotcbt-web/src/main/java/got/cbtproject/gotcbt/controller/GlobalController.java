package got.cbtproject.gotcbt.controller;

import got.cbtproject.gotcbt.model.Users;
import got.cbtproject.gotcbt.services.UsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * The GlobalController  Class
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * Date 4/27/2018.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalController {

    private UsersService userService;
    private Users loginUser;

    public GlobalController(UsersService userService) {
        this.userService = userService;
    }

    public Users getLoginUser() {
        if (loginUser == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUser = userService.findByUserId(auth.getName());
        }
        return loginUser;
    }
}
