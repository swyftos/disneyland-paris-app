package com.facebook.react.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import gherkin.GherkinLanguageConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/util/JSStackTrace;", "", "<init>", "()V", "LINE_NUMBER_KEY", "", "FILE_KEY", "COLUMN_KEY", "METHOD_NAME_KEY", "FILE_ID_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "format", "message", "stack", "Lcom/facebook/react/bridge/ReadableArray;", "parseFileId", TypedValues.AttributesType.S_FRAME, "Lcom/facebook/react/bridge/ReadableMap;", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JSStackTrace {

    @NotNull
    public static final String COLUMN_KEY = "column";

    @NotNull
    public static final String FILE_KEY = "file";

    @NotNull
    public static final String LINE_NUMBER_KEY = "lineNumber";

    @NotNull
    public static final String METHOD_NAME_KEY = "methodName";

    @NotNull
    public static final JSStackTrace INSTANCE = new JSStackTrace();
    private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

    private JSStackTrace() {
    }

    @JvmStatic
    @NotNull
    public static final String format(@NotNull String message, @NotNull ReadableArray stack) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(stack, "stack");
        StringBuilder sb = new StringBuilder(message);
        sb.append(", stack:\n");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = stack.getMap(i);
            if (map != null) {
                sb.append(map.getString("methodName"));
                sb.append(GherkinLanguageConstants.TAG_PREFIX);
                sb.append(INSTANCE.parseFileId(map));
                if (map.hasKey("lineNumber") && !map.isNull("lineNumber") && map.getType("lineNumber") == ReadableType.Number) {
                    sb.append(map.getInt("lineNumber"));
                } else {
                    sb.append(-1);
                }
                if (map.hasKey("column") && !map.isNull("column") && map.getType("column") == ReadableType.Number) {
                    sb.append(":");
                    sb.append(map.getInt("column"));
                }
                sb.append("\n");
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String parseFileId(ReadableMap frame) {
        String string;
        if (frame.hasKey("file") && !frame.isNull("file") && frame.getType("file") == ReadableType.String && (string = frame.getString("file")) != null) {
            Matcher matcher = FILE_ID_PATTERN.matcher(string);
            if (matcher.find()) {
                return matcher.group(1) + ":";
            }
            return "";
        }
        return "";
    }
}
