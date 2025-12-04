package com.urbanairship;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0016¨\u0006\r"}, d2 = {"Lcom/urbanairship/DefaultLogHandler;", "Lcom/urbanairship/AirshipLogHandler;", "()V", "log", "", "tag", "", "logLevel", "", "throwable", "", "message", "Lkotlin/Function0;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultLogHandler implements AirshipLogHandler {
    @Override // com.urbanairship.AirshipLogHandler
    public void log(@NotNull String tag, int logLevel, @Nullable Throwable throwable, @NotNull Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (throwable == null) {
            if (logLevel == 7) {
                Log.wtf(tag, message.invoke());
                return;
            } else {
                Log.println(logLevel, tag, message.invoke());
            }
        }
        switch (logLevel) {
            case 2:
                Log.v(tag, message.invoke(), throwable);
                break;
            case 3:
                Log.d(tag, message.invoke(), throwable);
                break;
            case 4:
                Log.i(tag, message.invoke(), throwable);
                break;
            case 5:
                Log.w(tag, message.invoke(), throwable);
                break;
            case 6:
                Log.e(tag, message.invoke(), throwable);
                break;
            case 7:
                Log.wtf(tag, message.invoke(), throwable);
                break;
        }
    }
}
