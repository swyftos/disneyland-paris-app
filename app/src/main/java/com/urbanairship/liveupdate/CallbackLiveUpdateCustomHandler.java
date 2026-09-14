package com.urbanairship.liveupdate;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\rÀ\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/liveupdate/CallbackLiveUpdateCustomHandler;", "Lcom/urbanairship/liveupdate/CustomLiveUpdateHandler;", "onUpdate", "", "context", "Landroid/content/Context;", "event", "Lcom/urbanairship/liveupdate/LiveUpdateEvent;", "update", "Lcom/urbanairship/liveupdate/LiveUpdate;", "resultCallback", "Lcom/urbanairship/liveupdate/CallbackLiveUpdateCustomHandler$LiveUpdateResultCallback;", "LiveUpdateResultCallback", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface CallbackLiveUpdateCustomHandler extends CustomLiveUpdateHandler {

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/liveupdate/CallbackLiveUpdateCustomHandler$LiveUpdateResultCallback;", "", "cancel", "", "ok", "urbanairship-live-update_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public interface LiveUpdateResultCallback {
        void cancel();

        /* JADX INFO: renamed from: ok */
        void mo1770ok();
    }

    void onUpdate(@NotNull Context context, @NotNull LiveUpdateEvent event, @NotNull LiveUpdate update, @NotNull LiveUpdateResultCallback resultCallback);
}
