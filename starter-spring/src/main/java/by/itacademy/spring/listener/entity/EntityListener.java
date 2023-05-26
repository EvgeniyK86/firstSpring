package by.itacademy.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {
    @EventListener(condition = "#p0.accessType.name=='DELETE'")
    public void acceptEntity (EntityEvent entityEvent){
        System.out.println("Entity: " + entityEvent);
    }
}
