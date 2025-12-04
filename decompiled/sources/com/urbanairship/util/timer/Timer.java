package com.urbanairship.util.timer;

import androidx.annotation.RestrictTo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/util/timer/Timer;", "", "time", "Lkotlin/time/Duration;", "getTime-UwyO8pc", "()J", ViewProps.START, "", "stop", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface Timer {
    /* renamed from: getTime-UwyO8pc */
    long mo2960getTimeUwyO8pc();

    void start();

    void stop();
}
