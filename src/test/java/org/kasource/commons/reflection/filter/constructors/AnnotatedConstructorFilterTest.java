package org.kasource.commons.reflection.filter.constructors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class AnnotatedConstructorFilterTest {

    @TestedObject
    private AnnotatedConstructorFilter filter = new AnnotatedConstructorFilter(MyAnnotation.class);
    
    @Test
    public void passTrue() throws SecurityException, NoSuchMethodException {
    	Constructor<?>  cons = MyClass.class.getConstructor(null);
        assertTrue(filter.passFilter(cons));
    }
    
    @Test
    public void passFalse() throws SecurityException, NoSuchMethodException {
    	Constructor<?>  cons = MyClass.class.getConstructor(String.class);
        assertFalse(filter.passFilter(cons));
    }
    
    @Target(ElementType.CONSTRUCTOR)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation {
        
    }
    
    private static class MyClass {
        
    	@MyAnnotation
        public MyClass(){}
        
        public MyClass(String name){}
    }
}
