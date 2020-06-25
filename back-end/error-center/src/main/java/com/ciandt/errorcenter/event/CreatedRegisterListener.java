package com.ciandt.errorcenter.event;

import lombok.var;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class CreatedRegisterListener implements ApplicationListener<CreatedRegisterEvent> {

    @Override
    public void onApplicationEvent(CreatedRegisterEvent createdRegisterEvent) {
        var response = createdRegisterEvent.getResponse();
        var id = createdRegisterEvent.getId();
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{id}").buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
