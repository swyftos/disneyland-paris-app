package com.contentsquare.android.sdk;

import androidx.collection.LruCache;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b0 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2701b0 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final a f2398a = new a();

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.b0$a */
    public static final class a extends LruCache<String, Boolean> {
        public a() {
            super(131072);
        }

        @Override // androidx.collection.LruCache
        public final int sizeOf(String str, Boolean bool) {
            String key = str;
            bool.booleanValue();
            Intrinsics.checkNotNullParameter(key, "key");
            return (key.length() * 2) + 16;
        }
    }
}
