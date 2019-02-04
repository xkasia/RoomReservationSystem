package pl.hit.system.mvc.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pl.hit.system.core.services.UserService;
import pl.hit.system.dto.LoggedUserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

public class SessionInterceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            if (request.getSession().getAttribute("user") == null) {
                String login = userPrincipal.getName();
                LoggedUserDTO user = userService.getUserByLogin(login);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        return true;
    }
}
