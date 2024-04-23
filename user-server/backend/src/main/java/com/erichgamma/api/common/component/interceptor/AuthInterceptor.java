package com.erichgamma.api.common.component.interceptor;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.erichgamma.api.common.component.security.JwtProvider;
import com.erichgamma.api.user.model.User;
import com.erichgamma.api.user.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @SuppressWarnings("null")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return Stream.of(request)
        .map(i -> jwtProvider.extractTokenFromHeader(i))
        .filter(i -> !i.equals("undefined"))
        .map(i -> List.of(i, jwtProvider.getPayload(i).get("userid", Long.class)))
        .filter(i -> i.get(0).equals(userRepository.findById((Long)i.get(1)).orElseGet(User::new).getToken()))
        .map(i -> true).findAny()
        .orElseGet(() -> false);
    }

    @SuppressWarnings("null")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @SuppressWarnings("null")
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}