package expo.modules.adapters.react.permissions;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import expo.modules.interfaces.permissions.PermissionsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u001d\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020#0\"0!H\u0016J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J)\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u0010*J)\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u0010*J)\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u000f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u0010.J)\u0010/\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u000f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u0010.J!\u00100\u001a\u00020\r2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0016¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u0012H\u0014J\u0010\u00107\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J1\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020:092\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010<\u001a\u00020=H\u0002¢\u0006\u0002\u0010>J\u0018\u0010?\u001a\u00020:2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010@\u001a\u000205H\u0002J%\u0010A\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0006\u0010B\u001a\u00020\u000fH\u0014¢\u0006\u0002\u0010CJ#\u0010D\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010B\u001a\u00020\u000fH\u0004¢\u0006\u0002\u0010CJ\b\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020\u001dH\u0002J\b\u0010H\u001a\u00020\rH\u0002J\b\u0010I\u001a\u00020\u001dH\u0016J\b\u0010J\u001a\u00020\u001dH\u0016J\b\u0010K\u001a\u00020\u001dH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R&\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000f0\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000¨\u0006L"}, m1836d2 = {"Lexpo/modules/adapters/react/permissions/PermissionsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/permissions/Permissions;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mActivityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "mWriteSettingsPermissionBeingAsked", "", "mAskAsyncListener", "Lexpo/modules/interfaces/permissions/PermissionsResponseListener;", "mAskAsyncRequestedPermissions", "", "", "[Ljava/lang/String;", "mPendingPermissionCalls", "Ljava/util/Queue;", "Lkotlin/Pair;", "mCurrentPermissionListener", "mAskedPermissionsCache", "Landroid/content/SharedPreferences;", "didAsk", "permission", "addToAskedPermissionsCache", "", "permissions", "([Ljava/lang/String;)V", "getExportedInterfaces", "", "Ljava/lang/Class;", "", "onCreate", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "getPermissionsWithPromise", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/core/Promise;", "(Lexpo/modules/core/Promise;[Ljava/lang/String;)V", "askForPermissionsWithPromise", "getPermissions", "responseListener", "(Lexpo/modules/interfaces/permissions/PermissionsResponseListener;[Ljava/lang/String;)V", "askForPermissions", "hasGrantedPermissions", "([Ljava/lang/String;)Z", "isPermissionPresentInManifest", "isPermissionGranted", "getManifestPermission", "", "getManifestPermissionFromContext", PermissionsResponse.CAN_ASK_AGAIN_KEY, "parseNativeResult", "", "Lexpo/modules/interfaces/permissions/PermissionsResponse;", "permissionsString", "grantResults", "", "([Ljava/lang/String;[I)Ljava/util/Map;", "getPermissionResponseFromNativeResponse", "result", "askForManifestPermissions", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "([Ljava/lang/String;Lexpo/modules/interfaces/permissions/PermissionsResponseListener;)V", "delegateRequestToActivity", "createListenerWithPendingPermissionsRequest", "Lcom/facebook/react/modules/core/PermissionListener;", "askForWriteSettingsPermissionFirst", "hasWriteSettingsPermission", "onHostResume", "onHostPause", "onHostDestroy", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nPermissionsService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionsService.kt\nexpo/modules/adapters/react/permissions/PermissionsService\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,356:1\n13409#2,2:357\n11165#2:359\n11500#2,3:360\n12371#2,2:366\n1#3:363\n37#4,2:364\n1863#5,2:368\n1863#5,2:379\n168#6,3:370\n168#6,3:373\n168#6,3:376\n*S KotlinDebug\n*F\n+ 1 PermissionsService.kt\nexpo/modules/adapters/react/permissions/PermissionsService\n*L\n46#1:357,2\n111#1:359\n111#1:360,3\n165#1:366,2\n130#1:364,2\n223#1:368,2\n286#1:379,2\n69#1:370,3\n70#1:373,3\n71#1:376,3\n*E\n"})
public class PermissionsService implements InternalModule, Permissions, LifecycleEventListener {
    private final Context context;
    private ActivityProvider mActivityProvider;
    private PermissionsResponseListener mAskAsyncListener;
    private String[] mAskAsyncRequestedPermissions;
    private SharedPreferences mAskedPermissionsCache;
    private PermissionsResponseListener mCurrentPermissionListener;
    private final Queue mPendingPermissionCalls;
    private boolean mWriteSettingsPermissionBeingAsked;

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostPause() {
    }

    public PermissionsService(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mPendingPermissionCalls = new LinkedList();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    private final boolean didAsk(String permission) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(permission, false);
    }

    private final void addToAskedPermissionsCache(String[] permissions) {
        SharedPreferences sharedPreferences = this.mAskedPermissionsCache;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAskedPermissionsCache");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        for (String str : permissions) {
            editorEdit.putBoolean(str, true);
        }
        editorEdit.apply();
    }

    @Override // expo.modules.core.interfaces.InternalModule
    @NotNull
    public List<Class<? extends Object>> getExportedInterfaces() {
        return CollectionsKt.listOf(Permissions.class);
    }

    @Override // expo.modules.core.interfaces.RegistryLifecycleListener
    public void onCreate(@NotNull ModuleRegistry moduleRegistry) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        ActivityProvider activityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
        if (activityProvider == null) {
            throw new IllegalStateException("Couldn't find implementation for ActivityProvider.");
        }
        this.mActivityProvider = activityProvider;
        ((UIManager) moduleRegistry.getModule(UIManager.class)).registerLifecycleEventListener(this);
        this.mAskedPermissionsCache = this.context.getApplicationContext().getSharedPreferences("expo.modules.permissions.asked", 0);
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissionsWithPromise(@NotNull final Promise promise, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        getPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda3
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.getPermissionsWithPromise$lambda$6(promise, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissionsWithPromise(@NotNull final Promise promise, @NotNull final String... permissions) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        askForPermissions(new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda0
            @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
            public final void onResult(Map map) {
                PermissionsService.askForPermissionsWithPromise$lambda$7(this.f$0, promise, permissions, map);
            }
        }, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissionsWithPromise$lambda$7(PermissionsService permissionsService, Promise promise, String[] strArr, Map map) {
        permissionsService.getPermissionsWithPromise(promise, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void askForPermissions(@NotNull final PermissionsResponseListener responseListener, @NotNull String... permissions) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (permissions.length == 0) {
            responseListener.onResult(new LinkedHashMap());
            return;
        }
        if (ArraysKt.contains(permissions, "android.permission.WRITE_SETTINGS")) {
            List mutableList = ArraysKt.toMutableList(permissions);
            mutableList.remove("android.permission.WRITE_SETTINGS");
            String[] strArr = (String[]) mutableList.toArray(new String[0]);
            PermissionsResponseListener permissionsResponseListener = new PermissionsResponseListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda1
                @Override // expo.modules.interfaces.permissions.PermissionsResponseListener
                public final void onResult(Map map) {
                    PermissionsService.askForPermissions$lambda$10(this.f$0, responseListener, map);
                }
            };
            if (!hasWriteSettingsPermission()) {
                if (this.mAskAsyncListener != null) {
                    throw new IllegalStateException("Another permissions request is in progress. Await the old request and then try again.");
                }
                this.mAskAsyncListener = permissionsResponseListener;
                this.mAskAsyncRequestedPermissions = strArr;
                addToAskedPermissionsCache(new String[]{"android.permission.WRITE_SETTINGS"});
                askForWriteSettingsPermissionFirst();
                return;
            }
            if (strArr.length == 0) {
                permissionsResponseListener.onResult(new LinkedHashMap());
                return;
            } else {
                askForManifestPermissions(strArr, permissionsResponseListener);
                return;
            }
        }
        askForManifestPermissions(permissions, responseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askForPermissions$lambda$10(PermissionsService permissionsService, PermissionsResponseListener permissionsResponseListener, Map map) {
        int i = permissionsService.hasWriteSettingsPermission() ? 0 : -1;
        Intrinsics.checkNotNull(map);
        map.put("android.permission.WRITE_SETTINGS", permissionsService.getPermissionResponseFromNativeResponse("android.permission.WRITE_SETTINGS", i));
        permissionsResponseListener.onResult(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPermissionsWithPromise$lambda$6(Promise promise, Map permissionsMap) {
        boolean z;
        boolean z2;
        String status;
        Intrinsics.checkNotNullParameter(permissionsMap, "permissionsMap");
        boolean z3 = false;
        if (!permissionsMap.isEmpty()) {
            Iterator it = permissionsMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((PermissionsResponse) ((Map.Entry) it.next()).getValue()).getStatus() != PermissionsStatus.GRANTED) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (permissionsMap.isEmpty()) {
            z2 = false;
        } else {
            if (!permissionsMap.isEmpty()) {
                Iterator it2 = permissionsMap.entrySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((PermissionsResponse) ((Map.Entry) it2.next()).getValue()).getStatus() != PermissionsStatus.DENIED) {
                            z2 = false;
                        }
                    }
                }
            }
            z2 = true;
        }
        if (!permissionsMap.isEmpty()) {
            Iterator it3 = permissionsMap.entrySet().iterator();
            do {
                if (!it3.hasNext()) {
                    z3 = true;
                    break;
                }
            } while (((PermissionsResponse) ((Map.Entry) it3.next()).getValue()).getCanAskAgain());
        } else {
            z3 = true;
            break;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        if (z) {
            status = PermissionsStatus.GRANTED.getStatus();
        } else if (z2) {
            status = PermissionsStatus.DENIED.getStatus();
        } else {
            status = PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", status);
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, z3);
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, z);
        promise.resolve(bundle);
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean isPermissionPresentInManifest(@NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 4096);
            if (packageInfo != null) {
                String[] strArr = packageInfo.requestedPermissions;
                Intrinsics.checkNotNull(strArr);
                return ArraysKt.contains(strArr, permission);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    private final boolean isPermissionGranted(String permission) {
        if (Intrinsics.areEqual(permission, "android.permission.WRITE_SETTINGS")) {
            return hasWriteSettingsPermission();
        }
        return getManifestPermission(permission) == 0;
    }

    private final int getManifestPermission(String permission) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null && (currentActivity instanceof PermissionAwareActivity)) {
            return ContextCompat.checkSelfPermission(currentActivity, permission);
        }
        return getManifestPermissionFromContext(permission);
    }

    protected int getManifestPermissionFromContext(@NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(this.context, permission);
    }

    private final boolean canAskAgain(String permission) {
        Activity currentActivity;
        ActivityProvider activityProvider = this.mActivityProvider;
        return (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null || !ActivityCompat.shouldShowRequestPermissionRationale(currentActivity, permission)) ? false : true;
    }

    private final Map parseNativeResult(String[] permissionsString, int[] grantResults) {
        HashMap map = new HashMap();
        for (Pair pair : ArraysKt.zip(grantResults, (Object[]) permissionsString)) {
            int iIntValue = ((Number) pair.component1()).intValue();
            String str = (String) pair.component2();
            map.put(str, getPermissionResponseFromNativeResponse(str, iIntValue));
        }
        return map;
    }

    private final PermissionsResponse getPermissionResponseFromNativeResponse(String permission, int result) {
        PermissionsStatus permissionsStatus;
        if (result == 0) {
            permissionsStatus = PermissionsStatus.GRANTED;
        } else {
            permissionsStatus = didAsk(permission) ? PermissionsStatus.DENIED : PermissionsStatus.UNDETERMINED;
        }
        return new PermissionsResponse(permissionsStatus, permissionsStatus == PermissionsStatus.DENIED ? canAskAgain(permission) : true);
    }

    protected void askForManifestPermissions(@NotNull String[] permissions, @NotNull PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        delegateRequestToActivity((String[]) Arrays.copyOf(permissions, permissions.length), listener);
    }

    protected final void delegateRequestToActivity(@NotNull String[] permissions, @NotNull PermissionsResponseListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(listener, "listener");
        addToAskedPermissionsCache(permissions);
        ActivityProvider activityProvider = this.mActivityProvider;
        ComponentCallbacks2 currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity instanceof PermissionAwareActivity) {
            synchronized (this) {
                try {
                    if (this.mCurrentPermissionListener != null) {
                        this.mPendingPermissionCalls.add(TuplesKt.m1842to(permissions, listener));
                    } else {
                        this.mCurrentPermissionListener = listener;
                        ((PermissionAwareActivity) currentActivity).requestPermissions(permissions, 13, createListenerWithPendingPermissionsRequest());
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        int length = permissions.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = -1;
        }
        listener.onResult(parseNativeResult(permissions, iArr));
    }

    private final PermissionListener createListenerWithPendingPermissionsRequest() {
        return new PermissionListener() { // from class: expo.modules.adapters.react.permissions.PermissionsService$$ExternalSyntheticLambda2
            @Override // com.facebook.react.modules.core.PermissionListener
            public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                return PermissionsService.createListenerWithPendingPermissionsRequest$lambda$21(this.f$0, i, strArr, iArr);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createListenerWithPendingPermissionsRequest$lambda$21(PermissionsService permissionsService, int i, String[] receivePermissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(receivePermissions, "receivePermissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i != 13) {
            return false;
        }
        synchronized (permissionsService) {
            try {
                PermissionsResponseListener permissionsResponseListener = permissionsService.mCurrentPermissionListener;
                if (permissionsResponseListener == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                permissionsResponseListener.onResult(permissionsService.parseNativeResult(receivePermissions, grantResults));
                permissionsService.mCurrentPermissionListener = null;
                Pair pair = (Pair) permissionsService.mPendingPermissionCalls.poll();
                if (pair != null) {
                    ActivityProvider activityProvider = permissionsService.mActivityProvider;
                    Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
                    PermissionAwareActivity permissionAwareActivity = currentActivity instanceof PermissionAwareActivity ? (PermissionAwareActivity) currentActivity : null;
                    if (permissionAwareActivity == null) {
                        PermissionsResponseListener permissionsResponseListener2 = (PermissionsResponseListener) pair.getSecond();
                        String[] strArr = (String[]) pair.getFirst();
                        int length = ((Object[]) pair.getFirst()).length;
                        int[] iArr = new int[length];
                        for (int i2 = 0; i2 < length; i2++) {
                            iArr[i2] = -1;
                        }
                        permissionsResponseListener2.onResult(permissionsService.parseNativeResult(strArr, iArr));
                        for (Pair pair2 : permissionsService.mPendingPermissionCalls) {
                            PermissionsResponseListener permissionsResponseListener3 = (PermissionsResponseListener) pair2.getSecond();
                            String[] strArr2 = (String[]) pair2.getFirst();
                            int length2 = ((Object[]) pair2.getFirst()).length;
                            int[] iArr2 = new int[length2];
                            for (int i3 = 0; i3 < length2; i3++) {
                                iArr2[i3] = -1;
                            }
                            permissionsResponseListener3.onResult(permissionsService.parseNativeResult(strArr2, iArr2));
                        }
                        permissionsService.mPendingPermissionCalls.clear();
                    } else {
                        permissionsService.mCurrentPermissionListener = (PermissionsResponseListener) pair.getSecond();
                        permissionAwareActivity.requestPermissions((String[]) pair.getFirst(), 13, permissionsService.createListenerWithPendingPermissionsRequest());
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void askForWriteSettingsPermissionFirst() {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        intent.addFlags(268435456);
        this.mWriteSettingsPermissionBeingAsked = true;
        this.context.startActivity(intent);
    }

    private final boolean hasWriteSettingsPermission() {
        return Settings.System.canWrite(this.context.getApplicationContext());
    }

    @Override // expo.modules.core.interfaces.LifecycleEventListener
    public void onHostResume() {
        if (this.mWriteSettingsPermissionBeingAsked) {
            this.mWriteSettingsPermissionBeingAsked = false;
            PermissionsResponseListener permissionsResponseListener = this.mAskAsyncListener;
            Intrinsics.checkNotNull(permissionsResponseListener);
            String[] strArr = this.mAskAsyncRequestedPermissions;
            Intrinsics.checkNotNull(strArr);
            this.mAskAsyncListener = null;
            this.mAskAsyncRequestedPermissions = null;
            if (!(strArr.length == 0)) {
                askForManifestPermissions(strArr, permissionsResponseListener);
            } else {
                permissionsResponseListener.onResult(new LinkedHashMap());
            }
        }
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public void getPermissions(@NotNull PermissionsResponseListener responseListener, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        ArrayList arrayList = new ArrayList(permissions.length);
        for (String str : permissions) {
            arrayList.add(Integer.valueOf(isPermissionGranted(str) ? 0 : -1));
        }
        responseListener.onResult(parseNativeResult(permissions, CollectionsKt.toIntArray(arrayList)));
    }

    @Override // expo.modules.interfaces.permissions.Permissions
    public boolean hasGrantedPermissions(@NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        for (String str : permissions) {
            if (!isPermissionGranted(str)) {
                return false;
            }
        }
        return true;
    }
}
