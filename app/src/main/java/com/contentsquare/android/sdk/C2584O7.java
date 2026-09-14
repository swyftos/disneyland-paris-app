package com.contentsquare.android.sdk;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2584O7 extends Lambda implements Function1<Byte, CharSequence> {

    /* JADX INFO: renamed from: a */
    public static final C2584O7 f1946a = new C2584O7();

    public C2584O7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b.byteValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
        return str;
    }
}
