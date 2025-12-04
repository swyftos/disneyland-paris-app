package com.urbanairship.reactnative;

import android.content.Context;
import android.content.Intent;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.microsoft.appcenter.ingestion.models.StartServiceLog;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/reactnative/AirshipHeadlessEventService;", "Lcom/facebook/react/HeadlessJsTaskService;", "<init>", "()V", "getTaskConfig", "Lcom/facebook/react/jstasks/HeadlessJsTaskConfig;", "intent", "Landroid/content/Intent;", "onHeadlessJsTaskStart", "", "taskId", "", "onHeadlessJsTaskFinish", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipHeadlessEventService extends HeadlessJsTaskService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Override // com.facebook.react.HeadlessJsTaskService
    @Nullable
    protected HeadlessJsTaskConfig getTaskConfig(@Nullable Intent intent) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "createMap(...)");
        return new HeadlessJsTaskConfig("AirshipAndroidBackgroundEventTask", writableMapCreateMap, 60000L, true, null, 16, null);
    }

    @Override // com.facebook.react.HeadlessJsTaskService, com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int taskId) {
        ProxyLogger.verbose("AirshipHeadlessEventService - Started", new Object[0]);
        super.onHeadlessJsTaskStart(taskId);
    }

    @Override // com.facebook.react.HeadlessJsTaskService, com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int taskId) {
        super.onHeadlessJsTaskFinish(taskId);
        ProxyLogger.verbose("AirshipHeadlessEventService - Finished", new Object[0]);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/reactnative/AirshipHeadlessEventService$Companion;", "", "<init>", "()V", "TASK_TIMEOUT", "", "TASK_KEY", "", StartServiceLog.TYPE, "", "context", "Landroid/content/Context;", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean startService(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (context.startService(new Intent(context, (Class<?>) AirshipHeadlessEventService.class)) == null) {
                    return false;
                }
                HeadlessJsTaskService.INSTANCE.acquireWakeLockNow(context);
                return true;
            } catch (Exception e) {
                ProxyLogger.warn("AirshipHeadlessEventService - Failed to start service", e);
                return false;
            }
        }
    }
}
