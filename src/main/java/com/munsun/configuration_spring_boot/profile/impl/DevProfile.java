package com.munsun.configuration_spring_boot.profile.impl;

import com.munsun.configuration_spring_boot.profile.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
