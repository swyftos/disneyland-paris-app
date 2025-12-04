package com.urbanairship.actions;

import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.urbanairship.UAirship;
import com.urbanairship.base.Supplier;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionPromptFallback;
import com.urbanairship.permission.PermissionRequestResult;
import com.urbanairship.permission.PermissionStatus;
import com.urbanairship.permission.PermissionsManager;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
public class PromptPermissionAction extends Action {

    @NonNull
    public static final String AFTER_PERMISSION_STATUS_RESULT_KEY = "after";

    @NonNull
    public static final String BEFORE_PERMISSION_STATUS_RESULT_KEY = "before";

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "prompt_permission_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^pp";

    @NonNull
    public static final String ENABLE_AIRSHIP_USAGE_ARG_KEY = "enable_airship_usage";

    @NonNull
    public static final String FALLBACK_SYSTEM_SETTINGS_ARG_KEY = "fallback_system_settings";

    @NonNull
    public static final String PERMISSION_ARG_KEY = "permission";

    @NonNull
    public static final String PERMISSION_RESULT_KEY = "permission";
    public static final String RECEIVER_METADATA = "com.urbanairship.actions.PromptPermissionActionReceiver";
    private final Supplier permissionsManagerSupplier;

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    public PromptPermissionAction(@NonNull Supplier<PermissionsManager> supplier) {
        this.permissionsManagerSupplier = supplier;
    }

    @Keep
    public PromptPermissionAction() {
        this(new Supplier() { // from class: com.urbanairship.actions.PromptPermissionAction$$ExternalSyntheticLambda0
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return PromptPermissionAction.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PermissionsManager lambda$new$0() {
        return UAirship.shared().getPermissionsManager();
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        return situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public final ActionResult perform(@NonNull ActionArguments actionArguments) {
        try {
            prompt(parseArg(actionArguments), (ResultReceiver) actionArguments.getMetadata().getParcelable(RECEIVER_METADATA));
            return ActionResult.newEmptyResult();
        } catch (Exception e) {
            return ActionResult.newErrorResult(e);
        }
    }

    protected Args parseArg(ActionArguments actionArguments) throws IllegalArgumentException, JsonException {
        return Args.fromJson(actionArguments.getValue().getJsonValue());
    }

    protected void prompt(@NonNull final Args args, @Nullable final ResultReceiver resultReceiver) throws ExecutionException, InterruptedException {
        final PermissionsManager permissionsManager = (PermissionsManager) this.permissionsManagerSupplier.get();
        Objects.requireNonNull(permissionsManager);
        permissionsManager.checkPermissionStatus(args.permission, new Consumer() { // from class: com.urbanairship.actions.PromptPermissionAction$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$prompt$2(permissionsManager, args, resultReceiver, (PermissionStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prompt$2(PermissionsManager permissionsManager, final Args args, final ResultReceiver resultReceiver, final PermissionStatus permissionStatus) {
        permissionsManager.requestPermission(args.permission, args.enableAirshipUsage, args.fallbackSystemSettings ? PermissionPromptFallback.SystemSettings.INSTANCE : PermissionPromptFallback.None.INSTANCE, new Consumer() { // from class: com.urbanairship.actions.PromptPermissionAction$$ExternalSyntheticLambda2
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.lambda$prompt$1(args, permissionStatus, resultReceiver, (PermissionRequestResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prompt$1(Args args, PermissionStatus permissionStatus, ResultReceiver resultReceiver, PermissionRequestResult permissionRequestResult) {
        sendResult(args.permission, permissionStatus, permissionRequestResult.getPermissionStatus(), resultReceiver);
    }

    public void sendResult(@NonNull Permission permission, @NonNull PermissionStatus permissionStatus, @NonNull PermissionStatus permissionStatus2, @Nullable ResultReceiver resultReceiver) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("permission", permission.getJsonValue().toString());
            bundle.putString(BEFORE_PERMISSION_STATUS_RESULT_KEY, permissionStatus.getJsonValue().toString());
            bundle.putString(AFTER_PERMISSION_STATUS_RESULT_KEY, permissionStatus2.getJsonValue().toString());
            resultReceiver.send(-1, bundle);
        }
    }

    protected static class Args {
        public final boolean enableAirshipUsage;
        public final boolean fallbackSystemSettings;
        public final Permission permission;

        protected Args(@NonNull Permission permission, boolean z, boolean z2) {
            this.permission = permission;
            this.enableAirshipUsage = z;
            this.fallbackSystemSettings = z2;
        }

        @NonNull
        protected static Args fromJson(JsonValue jsonValue) throws JsonException {
            return new Args(Permission.fromJson(jsonValue.requireMap().opt("permission")), jsonValue.requireMap().opt(PromptPermissionAction.ENABLE_AIRSHIP_USAGE_ARG_KEY).getBoolean(false), jsonValue.requireMap().opt(PromptPermissionAction.FALLBACK_SYSTEM_SETTINGS_ARG_KEY).getBoolean(false));
        }
    }
}
