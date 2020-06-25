package com.ciandt.errorcenter.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Getter
public class CreatedRegisterEvent extends ApplicationEvent {

    private final HttpServletResponse response;
    private final UUID id;

    public CreatedRegisterEvent(Object source, HttpServletResponse response, UUID id) {
        super(source);
        this.response = response;
        this.id = id;
    }
}
