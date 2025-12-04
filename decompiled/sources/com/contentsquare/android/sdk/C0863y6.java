package com.contentsquare.android.sdk;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.contentsquare.android.sdk.y6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0863y6 extends Lambda implements Function1<File, String> {
    public static final C0863y6 a = new C0863y6();

    public C0863y6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(File file) {
        File it = file;
        Intrinsics.checkNotNullParameter(it, "it");
        String name = it.getName();
        Intrinsics.checkNotNullExpressionValue(name, "it.name");
        return name;
    }
}
