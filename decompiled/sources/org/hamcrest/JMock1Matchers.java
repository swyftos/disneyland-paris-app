package org.hamcrest;

import org.hamcrest.core.IsEqual;
import org.hamcrest.integration.JMock1Adapter;
import org.jmock.core.Constraint;

/* loaded from: classes6.dex */
public class JMock1Matchers {
    public static Constraint equalTo(String str) {
        return JMock1Adapter.adapt(IsEqual.equalTo(str));
    }
}
