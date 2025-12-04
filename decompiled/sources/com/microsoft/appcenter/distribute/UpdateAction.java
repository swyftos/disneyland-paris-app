package com.microsoft.appcenter.distribute;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface UpdateAction {
    public static final int POSTPONE = -2;
    public static final int UPDATE = -1;
}
