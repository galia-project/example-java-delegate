package org.example;

import is.galia.resource.RequestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyJavaDelegateTest {

    private MyJavaDelegate delegate;

    @BeforeEach
    void setUp() {
        this.delegate = new MyJavaDelegate();
        delegate.setRequestContext(new RequestContext());
    }

    @Test
    void authorizeBeforeAccess() {
        assertTrue((boolean) delegate.authorizeBeforeAccess());
    }

    // etc.

}
