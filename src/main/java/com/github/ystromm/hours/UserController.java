package com.github.ystromm.hours;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Controller for getting the current user.
 */
@RestController
public class UserController {
    @RequestMapping("/api/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
