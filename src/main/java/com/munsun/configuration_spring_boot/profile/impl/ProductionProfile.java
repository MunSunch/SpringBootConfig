package com.munsun.configuration_spring_boot.profile.impl;

import com.munsun.configuration_spring_boot.profile.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}