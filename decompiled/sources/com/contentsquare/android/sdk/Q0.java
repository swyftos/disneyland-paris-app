package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCssUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CssUtil.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,122:1\n1#2:123\n1855#3,2:124\n*S KotlinDebug\n*F\n+ 1 CssUtil.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssUtil\n*L\n112#1:124,2\n*E\n"})
/* loaded from: classes2.dex */
public final class Q0 {

    public static final class a {

        @NotNull
        public final String a;
        public final int b;
        public final int c;

        public a(int i, int i2, @NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.a = value;
            this.b = i;
            this.c = i2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c;
        }

        public final int hashCode() {
            return Integer.hashCode(this.c) + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
        }

        @NotNull
        public final String toString() {
            return "URL(value=" + this.a + ", startIndex=" + this.b + ", endIndex=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public static a a(int i, String str, String str2, String str3) {
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
