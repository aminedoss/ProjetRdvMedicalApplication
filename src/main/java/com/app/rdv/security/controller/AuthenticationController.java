package com.app.rdv.security.controller;

import com.app.rdv.security.Services.IServiceAuthentication;
import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final IServiceAuthentication service;

    @PostMapping("/register")
    public AppUser register(@RequestBody AppUser user) {
        return service.createAppUser(user);
    }

    @PostMapping("/role")
    public AppRole addRole(@RequestBody AppRole role) {
        return service.createAppRole(role);
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestParam String username, @RequestParam String roleName) {
        service.addRoleToUser(username, roleName);
    }
}

