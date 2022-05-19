package com.example.springbootrest.controllers;

import com.example.springbootrest.DTO.User;
import com.example.springbootrest.DTO.UserHolder;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/ping")
public class PingController {
    private final Map<String, User> users = new ConcurrentHashMap<>();
    private HttpServletRequest req;
    private final UserHolder userHolder;

    public PingController(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    @SneakyThrows
    @PostMapping
    public void ping(@RequestBody User user) {
        users.putIfAbsent(req.getRemoteAddr(), user);
        if (userHolder.getCurrentUser() == null) {
            userHolder.setCurrentUser(user);
        }
    }

    @SneakyThrows
    @GetMapping
    public List<String> getAllUsers() {
        return users.entrySet()
                .stream()
                .map(e -> e.getValue() + "[" + e.getKey() + "]")
                .toList();
    }

    @GetMapping("/current")
    public User getCurrentUser(@SessionAttribute("scopedTarget.userHolder") UserHolder userHolder) {
        return userHolder.getCurrentUser();
    }

    @GetMapping
    public String getSessionId(@CookieValue("JSESSIONID") String sessionId) {
        return sessionId;
    }
}
