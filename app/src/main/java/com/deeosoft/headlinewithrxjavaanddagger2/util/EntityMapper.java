package com.deeosoft.headlinewithrxjavaanddagger2.util;

public interface EntityMapper<Entity, Domain> {

    Domain mapFromEntity(Entity entity);
}
