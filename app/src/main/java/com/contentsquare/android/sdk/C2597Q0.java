package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCssUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CssUtil.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n1#2:123\n1855#3,2:124\n*S KotlinDebug\n*F\n+ 1 CssUtil.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssUtil\n*L\n112#1:124,2\n*E\n"})
public final class C2597Q0 {

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q0$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f1985a;

        /* JADX INFO: renamed from: b */
        public final int f1986b;

        /* JADX INFO: renamed from: c */
        public final int f1987c;

        public a(int i, int i2, @NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.f1985a = value;
            this.f1986b = i;
            this.f1987c = i2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f1985a, aVar.f1985a) && this.f1986b == aVar.f1986b && this.f1987c == aVar.f1987c;
        }

        public final int hashCode() {
            return Integer.hashCode(this.f1987c) + ((Integer.hashCode(this.f1986b) + (this.f1985a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "URL(value=" + this.f1985a + ", startIndex=" + this.f1986b + ", endIndex=" + this.f1987c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    /* JADX INFO: renamed from: a */
    public static a m1005a(int i, String str, String str2, String str3) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, i, false, 4, (Object) null);
        Integer numValueOf = Integer.valueOf(iIndexOf$default);
        if (iIndexOf$default == -1) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        int length = str2.length() + numValueOf.intValue();
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str, str3, length, false, 4, (Object) null);
        Integer numValueOf2 = Integer.valueOf(iIndexOf$default2);
        if (iIndexOf$default2 == -1) {
            numValueOf2 = null;
        }
        if (numValueOf2 == null) {
            return null;
        }
        int iIntValue = numValueOf2.intValue();
        if (StringsKt.startsWith$default(str, "url(", length, false, 4, (Object) null)) {
            if (!StringsKt.startsWith$default(str, ")", iIntValue - 1, false, 4, (Object) null)) {
                return null;
            }
            length += 4;
            iIntValue--;
        }
        if (StringsKt.startsWith$default(str, "\"", length, false, 4, (Object) null) || StringsKt.startsWith$default(str, "'", length, false, 4, (Object) null)) {
            length++;
            iIntValue--;
        }
        if (length >= iIntValue) {
            return null;
        }
        String strSubstring = str.substring(length, iIntValue);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return new a(length, iIntValue, strSubstring);
    }
}
