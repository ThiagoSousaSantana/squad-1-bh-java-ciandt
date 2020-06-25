package com.ciandt.errorcenter.domain.model;

public enum Environment {

    DEVELOPMENT(1),
    HOMOLOGATION(2),
    PRODUCTION(3);

    public Integer environment;

    Environment(Integer environment) {
        this.environment = environment;
    }
}
