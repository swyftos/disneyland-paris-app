package com.contentsquare.android.api.model;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m1836d2 = {"Lcom/contentsquare/android/api/model/DynamicVarLongValidator;", "Lcom/contentsquare/android/api/model/DynamicVarValidator;", "key", "", "value", "", "(Ljava/lang/String;J)V", "getValue", "()J", "Companion", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class DynamicVarLongValidator extends DynamicVarValidator {
    private static final long MAX_VALUE = 4294967295L;
    private static final long MIN_VALUE = 0;
    private final long value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicVarLongValidator(@NotNull String key, long j) {
        Logger logger$library_release;
        String str;
        super(key);
        Intrinsics.checkNotNullParameter(key, "key");
        long j2 = 0;
        if (j < 0) {
            logger$library_release = DynamicVarValidator.INSTANCE.getLogger$library_release();
            str = "Dynamic Variable value is negative. Dynamic Variable is sent but the value is set to 0";
        } else {
            j2 = 4294967295L;
            if (j <= 4294967295L) {
                this.value = j;
                return;
            }
            logger$library_release = DynamicVarValidator.INSTANCE.getLogger$library_release();
            str = "Dynamic Variable value is too big: the current input has a size of " + j + " while the limit is 4294967295. Dynamic Variable is sent but the value truncated";
        }
        logger$library_release.m831i(str);
        this.value = j2;
    }

    public final long getValue() {
        return this.value;
    }
}
