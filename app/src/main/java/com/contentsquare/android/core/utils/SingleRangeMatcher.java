package com.contentsquare.android.core.utils;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, m1836d2 = {"Lcom/contentsquare/android/core/utils/SingleRangeMatcher;", "", "()V", "match", "", "patternStr", "", "value", "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
final class SingleRangeMatcher {

    @NotNull
    public static final SingleRangeMatcher INSTANCE = new SingleRangeMatcher();

    @Metadata(m1837k = 3, m1838mv = {1, 8, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RangeOperator.values().length];
            try {
                iArr[RangeOperator.LT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RangeOperator.LTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RangeOperator.GT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RangeOperator.GTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SingleRangeMatcher() {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0059  */
    /* JADX WARN: Code duplicated, block: B:20:0x005c  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x006c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0073  */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0080  */
    @JvmStatic
    public static final boolean match(String patternStr, String value) {
        RangeOperator rangeOperator;
        String strDrop;
        Version versionFrom;
        int i;
        Intrinsics.checkNotNullParameter(patternStr, "patternStr");
        Intrinsics.checkNotNullParameter(value, "value");
        Version.Companion companion = Version.INSTANCE;
        Version versionFrom2 = companion.from(value);
        String string = StringsKt.trim(patternStr).toString();
        boolean z = false;
        if (!StringsKt.startsWith$default(string, "<=", false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(string, "<", false, 2, (Object) null)) {
                rangeOperator = RangeOperator.LT;
            } else if (StringsKt.startsWith$default(string, ">=", false, 2, (Object) null)) {
                rangeOperator = RangeOperator.GTE;
            } else {
                rangeOperator = RangeOperator.GT;
            }
            strDrop = StringsKt.drop(string, 1);
            versionFrom = companion.from(strDrop);
            i = WhenMappings.$EnumSwitchMapping$0[rangeOperator.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (versionFrom2.compareTo(versionFrom, rangeOperator) >= 0) {
                            z = true;
                        }
                    } else if (versionFrom2.compareTo(versionFrom, rangeOperator) > 0) {
                        z = true;
                    }
                } else if (versionFrom2.compareTo(versionFrom, rangeOperator) <= 0) {
                    z = true;
                }
            } else if (versionFrom2.compareTo(versionFrom, rangeOperator) < 0) {
                z = true;
            }
            companion.recycle(versionFrom);
            companion.recycle(versionFrom2);
            return z;
        }
        rangeOperator = RangeOperator.LTE;
        strDrop = StringsKt.drop(string, 2);
        versionFrom = companion.from(strDrop);
        i = WhenMappings.$EnumSwitchMapping$0[rangeOperator.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (versionFrom2.compareTo(versionFrom, rangeOperator) >= 0) {
                        z = true;
                    }
                } else if (versionFrom2.compareTo(versionFrom, rangeOperator) > 0) {
                    z = true;
                }
            } else if (versionFrom2.compareTo(versionFrom, rangeOperator) <= 0) {
                z = true;
            }
        } else if (versionFrom2.compareTo(versionFrom, rangeOperator) < 0) {
            z = true;
        }
        companion.recycle(versionFrom);
        companion.recycle(versionFrom2);
        return z;
    }
}
