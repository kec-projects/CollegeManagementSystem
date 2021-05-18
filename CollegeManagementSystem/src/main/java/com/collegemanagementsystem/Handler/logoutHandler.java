package com.collegemanagementsystem.Handler;

import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class logoutHandler implements LogoutHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @SneakyThrows
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {

       // redirectStrategy.sendRedirect(request,response,"/users/logout");

    }
}
