package org.hamcrest;

import org.hamcrest.core.IsEqual;
import org.hamcrest.integration.EasyMock2Adapter;

/* loaded from: classes6.dex */
public class EasyMock2Matchers {
    public static String equalTo(String str) {
        EasyMock2Adapter.adapt(IsEqual.equalTo(str));
        return null;
    }
}
