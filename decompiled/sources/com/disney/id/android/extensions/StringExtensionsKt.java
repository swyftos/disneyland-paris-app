package com.disney.id.android.extensions;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a(\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u001a\u001e\u0010\b\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u001a\u001e\u0010\t\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004¨\u0006\n"}, d2 = {"capitalized", "", "truncate", "fromStart", "", "toLength", "", "showEllipses", "truncateFromStart", "truncateToEnd", "OneID_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/disney/id/android/extensions/StringExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
/* loaded from: classes3.dex */
public final class StringExtensionsKt {
    public static /* synthetic */ String truncate$default(String str, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 6;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        return truncate(str, z, i, z2);
    }

    @NotNull
    public static final String truncate(@NotNull String str, boolean z, int i, boolean z2) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 1 || str.length() <= i) {
            return str;
        }
        if (z2) {
            str2 = "...";
        } else {
            str2 = "";
        }
        if (z) {
            String strSubstring = str.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring + str2;
        }
        String strSubstring2 = str.substring(str.length() - i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        return str2 + strSubstring2;
    }

    public static /* synthetic */ String truncateFromStart$default(String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 6;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return truncateFromStart(str, i, z);
    }

    @NotNull
    public static final String truncateFromStart(@NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return truncate(str, true, i, z);
    }

    public static /* synthetic */ String truncateToEnd$default(String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 6;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        return truncateToEnd(str, i, z);
    }

    @NotNull
    public static final String truncateToEnd(@NotNull String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return truncate(str, false, i, z);
    }

    @NotNull
    public static final String capitalized(@NotNull String str) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strValueOf = CharsKt.titlecase(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
