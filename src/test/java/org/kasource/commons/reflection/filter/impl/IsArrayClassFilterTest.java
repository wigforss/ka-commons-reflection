package org.kasource.commons.reflection.filter.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsArrayClassFilterTest {


    private IsArrayClassFilter filter = new IsArrayClassFilter();

    @Test
    public void passTrue() {
        assertThat(filter.apply(Integer[].class), is(true));
    }

    @Test
    public void passFalse() {
        assertThat(filter.apply(Integer.class), is(false));
    }
}
