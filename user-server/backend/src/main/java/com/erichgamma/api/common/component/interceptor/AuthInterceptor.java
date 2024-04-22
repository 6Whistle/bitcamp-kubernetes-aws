package com.erichgamma.api.common.component.interceptor;

import java.util.Optional;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.erichgamma.api.common.component.security.JwtProvider;
import com.erichgamma.api.user.model.User;
import com.erichgamma.api.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = jwtProvider.extractTokenFromHeader(request);
        log.info("request info : {}", token);
        if(token.equals("undefined")){
            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return true;
        }

        String payload = jwtProvider.getPayload(token);
        int index = payload.lastIndexOf("userid\":") + 8;
        Long id = Long.parseLong(payload.substring(index, payload.indexOf("}", index)));
        log.info("jwt info : {}", id);
        Optional<User> user = userRepository.findById(id);
        log.info("user info : {}", user);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}