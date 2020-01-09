package org.kasource.commons.reflection.filter.impl;


import java.lang.reflect.Field;

import org.kasource.commons.reflection.filter.ClassFilter;
import org.kasource.commons.reflection.filter.FieldFilter;


/**
 * Filters classes which are assignable from the supplied assignable class.
 * <p>
 * It is possible to cast all classes that passes this filter to the assignable class.
 * <p>
 * Note: It's not recommended to use this class directly, instead use builders from the se.hiq.oss.commons.reflection.filter.builder package
 * @author Rikard Wigforss
 **/
public class AssignableToTypeFilter implements ClassFilter, FieldFilter {

    /**
     * Interface or super class to test candidates with.
     **/
    private Class<?> assignable;

    public AssignableToTypeFilter(final Class<?> assignable) {
        this.assignable = assignable;
    }

    @Override
    public boolean apply(Class<?> clazz) {
        return clazz.isAssignableFrom(assignable);
    }

    @Override
    public boolean apply(Field field) {
        return field.getType().isAssignableFrom(assignable);
    }


    @Override
    public String describe() {
        return "is super class of " + assignable.getName();
    }
}
