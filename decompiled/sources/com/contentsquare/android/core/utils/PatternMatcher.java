package com.contentsquare.android.core.utils;

import com.contentsquare.android.core.utils.Version;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/core/utils/PatternMatcher;", "", "()V", "match", "", "patternStr", "", "value", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PatternMatcher {

    @NotNull
    public static final PatternMatcher INSTANCE = new PatternMatcher();

    private PatternMatcher() {
    }

    @JvmStatic
    public static final boolean match(String patternStr, String value) {
        Intrinsics.checkNotNullParameter(patternStr, "patternStr");
        Intrinsics.checkNotNullParameter(value, "value");
        Version.Companion companion = Version.INSTANCE;
        Version versionFrom = companion.from(StringsKt.trim(patternStr).toString());
        Version versionFrom2 = companion.from(StringsKt.trim(value).toString());
        boolean zAreEqual = Intrinsics.areEqual(versionFrom, versionFrom2);
        companion.recycle(versionFrom);
        companion.recycle(versionFrom2);
        return zAreEqual;
    }
}
