package com.contentsquare.android.core.utils;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/core/utils/SingleRangeMatcher;", "", "()V", "match", "", "patternStr", "", "value", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SingleRangeMatcher {

    @NotNull
    public static final SingleRangeMatcher INSTANCE = new SingleRangeMatcher();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean match(java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "patternStr"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.contentsquare.android.core.utils.Version$Companion r0 = com.contentsquare.android.core.utils.Version.INSTANCE
            com.contentsquare.android.core.utils.Version r8 = r0.from(r8)
            java.lang.CharSequence r7 = kotlin.text.StringsKt.trim(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r1 = "<="
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r1, r2, r3, r4)
            r5 = 1
            if (r1 == 0) goto L30
            com.contentsquare.android.core.utils.RangeOperator r1 = com.contentsquare.android.core.utils.RangeOperator.LTE
        L27:
            java.lang.String r7 = kotlin.text.StringsKt.drop(r7, r3)
        L2b:
            com.contentsquare.android.core.utils.Version r7 = r0.from(r7)
            goto L4d
        L30:
            java.lang.String r1 = "<"
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r1, r2, r3, r4)
            if (r1 == 0) goto L3f
            com.contentsquare.android.core.utils.RangeOperator r1 = com.contentsquare.android.core.utils.RangeOperator.LT
        L3a:
            java.lang.String r7 = kotlin.text.StringsKt.drop(r7, r5)
            goto L2b
        L3f:
            java.lang.String r1 = ">="
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r7, r1, r2, r3, r4)
            if (r1 == 0) goto L4a
            com.contentsquare.android.core.utils.RangeOperator r1 = com.contentsquare.android.core.utils.RangeOperator.GTE
            goto L27
        L4a:
            com.contentsquare.android.core.utils.RangeOperator r1 = com.contentsquare.android.core.utils.RangeOperator.GT
            goto L3a
        L4d:
            int[] r4 = com.contentsquare.android.core.utils.SingleRangeMatcher.WhenMappings.$EnumSwitchMapping$0
            int r6 = r1.ordinal()
            r4 = r4[r6]
            if (r4 == r5) goto L7a
            if (r4 == r3) goto L73
            r3 = 3
            if (r4 == r3) goto L6c
            r3 = 4
            if (r4 != r3) goto L66
            int r1 = r8.compareTo(r7, r1)
            if (r1 < 0) goto L81
            goto L80
        L66:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L6c:
            int r1 = r8.compareTo(r7, r1)
            if (r1 <= 0) goto L81
            goto L80
        L73:
            int r1 = r8.compareTo(r7, r1)
            if (r1 > 0) goto L81
            goto L80
        L7a:
            int r1 = r8.compareTo(r7, r1)
            if (r1 >= 0) goto L81
        L80:
            r2 = r5
        L81:
            r0.recycle(r7)
            r0.recycle(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.core.utils.SingleRangeMatcher.match(java.lang.String, java.lang.String):boolean");
    }
}
