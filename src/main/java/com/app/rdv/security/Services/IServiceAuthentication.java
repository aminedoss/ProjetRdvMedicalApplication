package com.app.rdv.security.Services;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;

public interface IServiceAuthentication {
    public AppUser createAppUser(AppUser appUser);
    public AppRole createAppRole(AppRole appRole);
    public boolean addRoleToUser(String username, String roleName);
    public AppUser loadUserByUsername(String username);
}

