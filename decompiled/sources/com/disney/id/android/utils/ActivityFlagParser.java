package com.disney.id.android.utils;

import android.content.Intent;
import com.disney.id.android.OneID;
import com.disney.id.android.logging.Logger;
import gherkin.GherkinLanguageConstants;
import java.lang.reflect.Field;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/disney/id/android/utils/ActivityFlagParser;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "getActivityFlags", "overrideFlags", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityFlagParser {
    private final String TAG = OneID.class.getSimpleName();

    @Inject
    public Logger logger;

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final String getActivityFlags(int overrideFlags) {
        Field[] declaredFields = Intent.class.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        StringBuilder sb = new StringBuilder("flagNames(");
        if (overrideFlags == 0) {
            sb.append("NO_FLAG)");
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
        for (Field field : declaredFields) {
            String name = field.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, "FLAG_", false, 2, (Object) null)) {
                try {
                    if ((field.getInt(null) | overrideFlags) == overrideFlags) {
                        sb.append(field.getName());
                        sb.append(GherkinLanguageConstants.TABLE_CELL_SEPARATOR);
                    }
                } catch (Exception e) {
                    Logger logger$OneID_release = getLogger$OneID_release();
                    String TAG = this.TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    logger$OneID_release.w(TAG, "Failed to get Activity Flags associated with id " + overrideFlags, e);
                }
            }
        }
        sb.replace(sb.length() - 1, sb.length(), ")");
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }
}
