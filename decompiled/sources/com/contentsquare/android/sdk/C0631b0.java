package com.contentsquare.android.sdk;

import androidx.collection.LruCache;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.b0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0631b0 {

    @NotNull
    public final a a = new a();

    /* renamed from: com.contentsquare.android.sdk.b0$a */
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
