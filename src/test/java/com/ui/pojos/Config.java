package com.ui.pojos;

import com.constants.Env;

import java.util.Map;

public class Config {

    Map<Env, Environment> environments;
    public Map<Env, Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<Env, Environment> environments) {
        this.environments = environments;
    }



}
