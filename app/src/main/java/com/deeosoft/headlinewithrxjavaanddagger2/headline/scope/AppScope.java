package com.deeosoft.headlinewithrxjavaanddagger2.headline.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**Trying out @Documentation If this is what it means*/

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
