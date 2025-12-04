package com.urbanairship.util;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0001H\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"airshipEmojiFlag", "", "getAirshipEmojiFlag", "(Ljava/lang/String;)Ljava/lang/String;", "countryFlag", "code", "airshipIsValidEmail", "", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStringExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExtensions.kt\ncom/urbanairship/util/StringExtensionsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,38:1\n970#2:39\n1041#2,3:40\n*S KotlinDebug\n*F\n+ 1 StringExtensions.kt\ncom/urbanairship/util/StringExtensionsKt\n*L\n34#1:39\n34#1:40,3\n*E\n"})
/* loaded from: classes5.dex */
public final class StringExtensionsKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean airshipIsValidEmail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("^[^@\\s]+@[^@\\s]+\\.[^@\\s.]+$").matches(str);
    }

    @Nullable
    public static final String getAirshipEmojiFlag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return countryFlag(str);
    }

    private static final String countryFlag(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String strReplace = new Regex("[^A-Z]").replace(upperCase, "");
        if (strReplace.length() != 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strReplace.length());
        for (int i = 0; i < strReplace.length(); i++) {
            arrayList.add(Integer.valueOf(strReplace.charAt(i) + 61861));
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, new Function1() { // from class: com.urbanairship.util.StringExtensionsKt.countryFlag.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final CharSequence invoke(int i2) {
                char[] chars = Character.toChars(i2);
                Intrinsics.checkNotNullExpressionValue(chars, "toChars(...)");
                return StringsKt.concatToString(chars);
            }
        }, 30, null);
    }
}
