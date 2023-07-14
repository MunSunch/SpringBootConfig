package com.munsun.configuration_spring_boot.controllers;

import com.munsun.configuration_spring_boot.profile.SystemProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
    private SystemProfile profile;

    @Autowired
    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("/profile")
    public String profile() {
        return profile.getProfile();
    }
}
