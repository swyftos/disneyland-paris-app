package com.urbanairship.actions;

import androidx.annotation.NonNull;
import com.urbanairship.UAirship;
import com.urbanairship.actions.PromptPermissionAction;
import com.urbanairship.base.Supplier;
import com.urbanairship.json.JsonException;
import com.urbanairship.modules.location.AirshipLocationClient;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionsManager;

/* loaded from: classes4.dex */
public class EnableFeatureAction extends PromptPermissionAction {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "enable_feature";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^ef";

    @NonNull
    public static final String FEATURE_BACKGROUND_LOCATION = "background_location";

    @NonNull
    public static final String FEATURE_LOCATION = "location";

    @NonNull
    public static final String FEATURE_USER_NOTIFICATIONS = "user_notifications";
    private final Supplier locationClientSupplier;

    public EnableFeatureAction(@NonNull Supplier<PermissionsManager> supplier, @NonNull Supplier<AirshipLocationClient> supplier2) {
        super(supplier);
        this.locationClientSupplier = supplier2;
    }

    public EnableFeatureAction() {
        this(new Supplier() { // from class: com.urbanairship.actions.EnableFeatureAction$$ExternalSyntheticLambda0
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return EnableFeatureAction.lambda$new$0();
            }
        }, new Supplier() { // from class: com.urbanairship.actions.EnableFeatureAction$$ExternalSyntheticLambda1
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return EnableFeatureAction.lambda$new$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ PermissionsManager lambda$new$0() {
        return UAirship.shared().getPermissionsManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AirshipLocationClient lambda$new$1() {
        return UAirship.shared().getLocationClient();
    }

    @Override // com.urbanairship.actions.PromptPermissionAction
    protected PromptPermissionAction.Args parseArg(ActionArguments actionArguments) throws IllegalArgumentException, JsonException {
        String strRequireString = actionArguments.getValue().getJsonValue().requireString();
        strRequireString.hashCode();
        switch (strRequireString) {
            case "user_notifications":
                return new PromptPermissionAction.Args(Permission.DISPLAY_NOTIFICATIONS, true, true);
            case "background_location":
            case "location":
                return new PromptPermissionAction.Args(Permission.LOCATION, true, true);
            default:
                return super.parseArg(actionArguments);
        }
    }

    @Override // com.urbanairship.actions.Action
    public void onStart(@NonNull ActionArguments actionArguments) {
        AirshipLocationClient airshipLocationClient;
        super.onStart(actionArguments);
        if (!FEATURE_BACKGROUND_LOCATION.equalsIgnoreCase(actionArguments.getValue().getString("")) || (airshipLocationClient = (AirshipLocationClient) this.locationClientSupplier.get()) == null) {
            return;
        }
        airshipLocationClient.setBackgroundLocationAllowed(true);
    }
}
