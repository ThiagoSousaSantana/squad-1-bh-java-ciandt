package com.ciandt.errorcenter.domain.model;

public enum Level {

    ERROR(1),
    WARNING(2),
    DEBUG(3);

    public Integer level;

    Level(Integer level) {
        this.level = level;
    }
}
