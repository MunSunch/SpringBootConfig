package com.munsun.configuration_spring_boot.controllers;

import com.munsun.configuration_spring_boot.profile.SystemProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProfileController {
    private SystemProfile profile;

    @Autowired
    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("/profile")
    public String profile() {
        log.info("GET /profile");
        return profile.getProfile();
    }
}
