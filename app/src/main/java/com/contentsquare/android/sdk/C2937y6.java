package com.contentsquare.android.sdk;

import java.io.File;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.y6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2937y6 extends Lambda implements Function1<File, String> {

    /* JADX INFO: renamed from: a */
    public static final C2937y6 f3263a = new C2937y6();

    public C2937y6() {
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
