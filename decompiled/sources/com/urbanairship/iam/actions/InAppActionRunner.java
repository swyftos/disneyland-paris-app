package com.urbanairship.iam.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.dlp.BluetoothManager;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionRunRequest;
import com.urbanairship.actions.ActionRunRequestExtender;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.AddCustomEventAction;
import com.urbanairship.actions.PermissionResultReceiver;
import com.urbanairship.actions.PromptPermissionAction;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.analytics.events.InAppPermissionResultEvent;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J=\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJE\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001cJ$\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/urbanairship/iam/actions/InAppActionRunner;", "Lcom/urbanairship/actions/ActionRunner;", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "trackPermissionResults", "", "actionRequestFactory", "Lkotlin/Function1;", "", "Lcom/urbanairship/actions/ActionRunRequest;", "(Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;ZLkotlin/jvm/functions/Function1;)V", "metadata", "Landroid/os/Bundle;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "run", "", "name", "value", "Lcom/urbanairship/json/JsonSerializable;", "situation", "", "extender", "Lcom/urbanairship/actions/ActionRunRequestExtender;", "callback", "Lcom/urbanairship/actions/ActionCompletionCallback;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lcom/urbanairship/actions/ActionCompletionCallback;)V", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;Ljava/lang/Integer;Lcom/urbanairship/actions/ActionRunRequestExtender;Lcom/urbanairship/actions/ActionCompletionCallback;Landroid/os/Bundle;)V", "actions", "", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppActionRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppActionRunner.kt\ncom/urbanairship/iam/actions/InAppActionRunner\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,100:1\n215#2,2:101\n*S KotlinDebug\n*F\n+ 1 InAppActionRunner.kt\ncom/urbanairship/iam/actions/InAppActionRunner\n*L\n41#1:101,2\n*E\n"})
/* loaded from: classes5.dex */
public final class InAppActionRunner implements ActionRunner, ThomasActionRunner {
    private final Function1 actionRequestFactory;
    private final InAppMessageAnalyticsInterface analytics;
    private final boolean trackPermissionResults;

    public InAppActionRunner(@NotNull InAppMessageAnalyticsInterface analytics, boolean z, @NotNull Function1<? super String, ? extends ActionRunRequest> actionRequestFactory) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(actionRequestFactory, "actionRequestFactory");
        this.analytics = analytics;
        this.trackPermissionResults = z;
        this.actionRequestFactory = actionRequestFactory;
    }

    public /* synthetic */ InAppActionRunner(InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inAppMessageAnalyticsInterface, z, (i & 4) != 0 ? new Function1() { // from class: com.urbanairship.iam.actions.InAppActionRunner.1
            @Override // kotlin.jvm.functions.Function1
            public final ActionRunRequest invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ActionRunRequest actionRunRequestCreateRequest = ActionRunRequest.createRequest(it);
                Intrinsics.checkNotNullExpressionValue(actionRunRequestCreateRequest, "createRequest(...)");
                return actionRunRequestCreateRequest;
            }
        } : function1);
    }

    @Override // com.urbanairship.actions.ActionRunner
    public void run(@NotNull String name, @Nullable JsonSerializable value, @Nullable Integer situation, @Nullable ActionRunRequestExtender extender, @Nullable ActionCompletionCallback callback) {
        Intrinsics.checkNotNullParameter(name, "name");
        run(name, value, situation, extender, callback, metadata(null));
    }

    @Override // com.urbanairship.android.layout.environment.ThomasActionRunner
    public void run(@NotNull Map<String, ? extends JsonValue> actions, @NotNull LayoutData state) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(state, "state");
        Bundle bundleMetadata = metadata(state);
        for (Map.Entry<String, ? extends JsonValue> entry : actions.entrySet()) {
            run(entry.getKey(), entry.getValue(), 6, null, null, bundleMetadata);
        }
    }

    private final void run(String name, JsonSerializable value, Integer situation, ActionRunRequestExtender extender, ActionCompletionCallback callback, Bundle metadata) {
        ActionRunRequest actionRunRequestExtend;
        ActionRunRequest metadata2 = ((ActionRunRequest) this.actionRequestFactory.invoke(name)).setValue(value).setMetadata(metadata);
        if (situation != null) {
            metadata2.setSituation(situation.intValue());
        }
        if (extender != null && (actionRunRequestExtend = extender.extend(metadata2)) != null) {
            metadata2 = actionRunRequestExtend;
        }
        metadata2.run(callback);
    }

    private final Bundle metadata(final LayoutData state) {
        Bundle bundle = new Bundle();
        if (this.trackPermissionResults) {
            final Handler handler = new Handler(Looper.getMainLooper());
            bundle.putParcelable(PromptPermissionAction.RECEIVER_METADATA, new PermissionResultReceiver(handler) { // from class: com.urbanairship.iam.actions.InAppActionRunner$metadata$receiver$1
                @Override // com.urbanairship.actions.PermissionResultReceiver
                public void onResult(@NotNull Permission permission, @NotNull PermissionStatus before, @NotNull PermissionStatus after) {
                    Intrinsics.checkNotNullParameter(permission, "permission");
                    Intrinsics.checkNotNullParameter(before, "before");
                    Intrinsics.checkNotNullParameter(after, "after");
                    this.this$0.analytics.recordEvent(new InAppPermissionResultEvent(permission, before, after), state);
                }
            });
        }
        bundle.putString(AddCustomEventAction.IN_APP_CONTEXT_METADATA_KEY, this.analytics.customEventContext(state).getJsonValue().toString());
        return bundle;
    }
}
