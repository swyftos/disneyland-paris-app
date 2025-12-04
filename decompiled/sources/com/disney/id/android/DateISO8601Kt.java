package com.disney.id.android;

import com.disney.id.android.utils.StringPatterns;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u0000\u001a\u0014\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00030\u0003*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toISO8601", "", "kotlin.jvm.PlatformType", "Ljava/util/Date;", "OneID_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DateISO8601Kt {
    public static final String toISO8601(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return new SimpleDateFormat(StringPatterns.dateFormatPattern, Locale.US).format(date);
    }

    public static final Date toISO8601(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new SimpleDateFormat(StringPatterns.dateFormatPattern, Locale.US).parse(str);
    }
}
