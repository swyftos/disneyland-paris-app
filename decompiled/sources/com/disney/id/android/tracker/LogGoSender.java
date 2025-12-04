package com.disney.id.android.tracker;

import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.LogGoService;
import com.disney.id.android.tracker.Sender;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/tracker/LogGoSender;", "Lcom/disney/id/android/tracker/Sender;", "()V", "logGoService", "Lcom/disney/id/android/services/LogGoService;", "getLogGoService$OneID_release", "()Lcom/disney/id/android/services/LogGoService;", "setLogGoService$OneID_release", "(Lcom/disney/id/android/services/LogGoService;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "send", "Lcom/disney/id/android/tracker/Sender$SenderResponse;", "event", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogGoSender implements Sender {
    private static final String TAG = LogGoSender.class.getSimpleName();

    @Inject
    public LogGoService logGoService;

    @Inject
    public Logger logger;

    public LogGoSender() {
        OneIDDagger.getComponent().inject(this);
    }

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
    public final LogGoService getLogGoService$OneID_release() {
        LogGoService logGoService = this.logGoService;
        if (logGoService != null) {
            return logGoService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logGoService");
        return null;
    }

    public final void setLogGoService$OneID_release(@NotNull LogGoService logGoService) {
        Intrinsics.checkNotNullParameter(logGoService, "<set-?>");
        this.logGoService = logGoService;
    }

    @Override // com.disney.id.android.tracker.Sender
    @NotNull
    public Sender.SenderResponse send(@NotNull OneIDTrackerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getCurrentStateParam$OneID_release().isEmpty()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "Provided event has no parameters", null, 4, null);
            return Sender.SenderResponse.FAILURE_PERMANENT;
        }
        event.getCurrentStateParam$OneID_release().put("appid", "DTCI-ONEID-UI");
        try {
            getLogGoService$OneID_release().sendEvent(event.getCurrentStateParam$OneID_release()).execute();
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.d$default(logger$OneID_release2, TAG3, "Event sent // " + ((Object) event.getCurrentStateParam$OneID_release().get(OneIDTrackerEvent.EVENT_PARAM_ACTION_NAME)), null, 4, null);
            return Sender.SenderResponse.SUCCESS;
        } catch (IOException e) {
            Logger logger$OneID_release3 = getLogger$OneID_release();
            String TAG4 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            logger$OneID_release3.e(TAG4, "Event send failed // " + ((Object) event.getCurrentStateParam$OneID_release().get(OneIDTrackerEvent.EVENT_PARAM_ACTION_NAME)), e);
            return Sender.SenderResponse.FAILURE;
        }
    }
}
