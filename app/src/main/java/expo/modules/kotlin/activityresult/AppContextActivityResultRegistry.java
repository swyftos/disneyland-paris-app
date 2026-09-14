package expo.modules.kotlin.activityresult;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00029:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JC\u0010\u001c\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010 \u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\"2\b\b\u0001\u0010#\u001a\u0002H\u001eH\u0007¢\u0006\u0002\u0010$J\\\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0&\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0\"2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f0+H\u0007J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u000bH\u0007J\"\u00101\u001a\u0002022\u0006\u0010 \u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000105H\u0007JH\u00106\u001a\u00020\u001d\"\b\b\u0000\u0010\u001e*\u00020\u0015\"\u0004\b\u0001\u0010\u001f2\u0006\u0010'\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u0001052\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u001f\u0018\u00010\u0013H\u0002J\b\u00108\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0010j\b\u0012\u0004\u0012\u00020\u000b`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00130\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006;"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry;", "", "currentActivityProvider", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "<init>", "(Lexpo/modules/kotlin/providers/CurrentActivityProvider;)V", "random", "Ljava/util/Random;", "requestCodeToKey", "", "", "", "keyToRequestCode", "keyToLifecycleContainers", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "launchedKeys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "keyToCallbacksAndContract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$CallbacksAndContract;", "keyToInputParam", "Ljava/io/Serializable;", "pendingResults", "Landroid/os/Bundle;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "onLaunch", "", "I", "O", "requestCode", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "input", "(ILexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Ljava/io/Serializable;)V", "register", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "key", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "persistInstanceState", "context", "Landroid/content/Context;", "restoreInstanceState", "unregister", "dispatchResult", "", "resultCode", "data", "Landroid/content/Intent;", "doDispatch", "callbacksAndContract", "generateRandomNumber", "CallbacksAndContract", "LifecycleContainer", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAppContextActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppContextActivityResultRegistry.kt\nexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 AndroidExtensions.kt\nexpo/modules/kotlin/AndroidExtensionsKt\n+ 4 KotlinUtilities.kt\nexpo/modules/core/utilities/KotlinUtilitiesKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,373:1\n1#2:374\n10#3,5:375\n19#3,5:390\n19#3,5:395\n12#4:380\n535#5:381\n520#5,6:382\n1863#6,2:388\n*S KotlinDebug\n*F\n+ 1 AppContextActivityResultRegistry.kt\nexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry\n*L\n121#1:375,5\n285#1:390,5\n192#1:395,5\n172#1:380\n250#1:381\n250#1:382,6\n267#1:388,2\n*E\n"})
public final class AppContextActivityResultRegistry {
    private final CurrentActivityProvider currentActivityProvider;
    private final Map keyToCallbacksAndContract;
    private final Map keyToInputParam;
    private final Map keyToLifecycleContainers;
    private final Map keyToRequestCode;
    private ArrayList launchedKeys;
    private final Bundle pendingResults;
    private Random random;
    private final Map requestCodeToKey;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AppContextActivityResultRegistry(@NotNull CurrentActivityProvider currentActivityProvider) {
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.currentActivityProvider = currentActivityProvider;
        this.random = new Random();
        this.requestCodeToKey = new HashMap();
        this.keyToRequestCode = new HashMap();
        this.keyToLifecycleContainers = new HashMap();
        this.launchedKeys = new ArrayList();
        this.keyToCallbacksAndContract = new HashMap();
        this.keyToInputParam = new HashMap();
        this.pendingResults = new Bundle();
    }

    private final AppCompatActivity getActivity() {
        Activity currentActivity = this.currentActivityProvider.getCurrentActivity();
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        throw new IllegalArgumentException("Current Activity is not available at the moment");
    }

    @MainThread
    public final <I extends Serializable, O> void onLaunch(final int requestCode, @NotNull AppContextActivityResultContract<I, O> contract, @SuppressLint({"UnknownNullness"}) @NotNull I input) {
        Bundle bundleExtra;
        Parcelable parcelableExtra;
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent intentCreateIntent = contract.createIntent(getActivity(), input);
        if (intentCreateIntent.hasExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE)) {
            bundleExtra = intentCreateIntent.getBundleExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
            intentCreateIntent.removeExtra(ActivityResultContracts.StartActivityForResult.EXTRA_ACTIVITY_OPTIONS_BUNDLE);
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        String action = intentCreateIntent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1837081951) {
                if (iHashCode == -591152331 && action.equals(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST)) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelableExtra = (Parcelable) intentCreateIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST, IntentSenderRequest.class);
                    } else {
                        parcelableExtra = intentCreateIntent.getParcelableExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST);
                    }
                    Intrinsics.checkNotNull(parcelableExtra);
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) parcelableExtra;
                    try {
                        ActivityCompat.startIntentSenderForResult(getActivity(), intentSenderRequest.getIntentSender(), requestCode, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                        Unit unit = Unit.INSTANCE;
                        return;
                    } catch (IntentSender.SendIntentException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                AppContextActivityResultRegistry.onLaunch$lambda$1(this.f$0, requestCode, e);
                            }
                        });
                        return;
                    }
                }
            } else if (action.equals(ActivityResultContracts.RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS)) {
                String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra(ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                ActivityCompat.requestPermissions(getActivity(), stringArrayExtra, requestCode);
                return;
            }
        }
        ActivityCompat.startActivityForResult(getActivity(), intentCreateIntent, requestCode, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onLaunch$lambda$1(AppContextActivityResultRegistry appContextActivityResultRegistry, int i, IntentSender.SendIntentException sendIntentException) {
        appContextActivityResultRegistry.dispatchResult(i, 0, new Intent().setAction(ActivityResultContracts.StartIntentSenderForResult.ACTION_INTENT_SENDER_REQUEST).putExtra(ActivityResultContracts.StartIntentSenderForResult.EXTRA_SEND_INTENT_EXCEPTION, sendIntentException));
    }

    @MainThread
    @NotNull
    public final <I extends Serializable, O> AppContextActivityResultLauncher<I, O> register(@NotNull final String key, @NotNull LifecycleOwner lifecycleOwner, @NotNull AppContextActivityResultContract<I, O> contract, @NotNull AppContextActivityResultFallbackCallback<I, O> fallbackCallback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.keyToCallbacksAndContract.put(key, new CallbacksAndContract(fallbackCallback, null, contract));
        if (this.keyToRequestCode.get(key) == null) {
            int iGenerateRandomNumber = generateRandomNumber();
            this.requestCodeToKey.put(Integer.valueOf(iGenerateRandomNumber), key);
            this.keyToRequestCode.put(key, Integer.valueOf(iGenerateRandomNumber));
            Unit unit = Unit.INSTANCE;
        }
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                AppContextActivityResultRegistry.register$lambda$4(this.f$0, key, lifecycleOwner2, event);
            }
        };
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer == null) {
            lifecycleContainer = new LifecycleContainer(lifecycle);
        }
        lifecycleContainer.addObserver(lifecycleEventObserver);
        this.keyToLifecycleContainers.put(key, lifecycleContainer);
        return (AppContextActivityResultLauncher<I, O>) new AppContextActivityResultLauncher<I, O>(this, key, fallbackCallback) { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register.2
            final /* synthetic */ AppContextActivityResultFallbackCallback $fallbackCallback;
            final /* synthetic */ String $key;
            private final AppContextActivityResultContract contract;
            final /* synthetic */ AppContextActivityResultRegistry this$0;

            {
                this.this$0 = this;
                this.$key = key;
                this.$fallbackCallback = fallbackCallback;
                this.contract = this.$contract;
            }

            /* JADX WARN: Incorrect types in method signature: (TI;Landroidx/activity/result/ActivityResultCallback<TO;>;)V */
            @Override // expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
            public void launch(Serializable input, ActivityResultCallback callback) throws Exception {
                Intrinsics.checkNotNullParameter(input, "input");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Integer num = (Integer) this.this$0.keyToRequestCode.get(this.$key);
                if (num != null) {
                    int iIntValue = num.intValue();
                    this.this$0.keyToCallbacksAndContract.put(this.$key, new CallbacksAndContract(this.$fallbackCallback, callback, this.$contract));
                    this.this$0.keyToInputParam.put(this.$key, input);
                    this.this$0.launchedKeys.add(this.$key);
                    try {
                        this.this$0.onLaunch(iIntValue, this.$contract, input);
                        return;
                    } catch (Exception e) {
                        this.this$0.launchedKeys.remove(this.$key);
                        throw e;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + this.$contract + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch()");
            }

            @Override // expo.modules.kotlin.activityresult.AppContextActivityResultLauncher
            public AppContextActivityResultContract<I, O> getContract() {
                return this.contract;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void register$lambda$4(AppContextActivityResultRegistry appContextActivityResultRegistry, String str, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            appContextActivityResultRegistry.unregister(str);
            return;
        }
        CallbacksAndContract callbacksAndContract = (CallbacksAndContract) appContextActivityResultRegistry.keyToCallbacksAndContract.get(str);
        if (callbacksAndContract == null) {
            return;
        }
        Bundle bundle = appContextActivityResultRegistry.pendingResults;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, ActivityResult.class);
        } else {
            parcelable = bundle.getParcelable(str);
        }
        ActivityResult activityResult = (ActivityResult) parcelable;
        if (activityResult != null) {
            appContextActivityResultRegistry.pendingResults.remove(str);
            Object obj = appContextActivityResultRegistry.keyToInputParam.get(str);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.register");
            Serializable serializable = (Serializable) obj;
            Object result = callbacksAndContract.getContract().parseResult(serializable, activityResult.getResultCode(), activityResult.getData());
            if (callbacksAndContract.getMainCallback() != null) {
                callbacksAndContract.getMainCallback().onActivityResult(result);
            } else {
                callbacksAndContract.getFallbackCallback().onActivityResult(serializable, result);
            }
        }
    }

    public final void persistInstanceState(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistorAddStringToIntMap = new DataPersistor(context).addStringArrayList("launchedKeys", this.launchedKeys).addStringToIntMap("keyToRequestCode", this.keyToRequestCode);
        Map map = this.keyToInputParam;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (this.launchedKeys.contains((String) entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        dataPersistorAddStringToIntMap.addStringToSerializableMap("keyToParamsForFallbackCallback", linkedHashMap).addBundle("pendingResult", this.pendingResults).addSerializable("random", this.random).persist();
    }

    public final void restoreInstanceState(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DataPersistor dataPersistor = new DataPersistor(context);
        ArrayList<String> arrayListRetrieveStringArrayList = dataPersistor.retrieveStringArrayList("launchedKeys");
        if (arrayListRetrieveStringArrayList != null) {
            this.launchedKeys = arrayListRetrieveStringArrayList;
        }
        Map<String, Serializable> mapRetrieveStringToSerializableMap = dataPersistor.retrieveStringToSerializableMap("keyToParamsForFallbackCallback");
        if (mapRetrieveStringToSerializableMap != null) {
            this.keyToInputParam.putAll(mapRetrieveStringToSerializableMap);
        }
        Bundle bundleRetrieveBundle = dataPersistor.retrieveBundle("pendingResult");
        if (bundleRetrieveBundle != null) {
            this.pendingResults.putAll(bundleRetrieveBundle);
        }
        Serializable serializableRetrieveSerializable = dataPersistor.retrieveSerializable("random");
        if (serializableRetrieveSerializable != null) {
            this.random = (Random) serializableRetrieveSerializable;
        }
        Map<String, Integer> mapRetrieveStringToIntMap = dataPersistor.retrieveStringToIntMap("keyToRequestCode");
        if (mapRetrieveStringToIntMap != null) {
            Iterator<T> it = mapRetrieveStringToIntMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                int iIntValue = ((Number) entry.getValue()).intValue();
                this.keyToRequestCode.put(str, Integer.valueOf(iIntValue));
                this.requestCodeToKey.put(Integer.valueOf(iIntValue), str);
            }
        }
    }

    @MainThread
    public final void unregister(@NotNull String key) {
        Parcelable parcelable;
        Integer num;
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.launchedKeys.contains(key) && (num = (Integer) this.keyToRequestCode.remove(key)) != null) {
        }
        this.keyToCallbacksAndContract.remove(key);
        if (this.pendingResults.containsKey(key)) {
            Bundle bundle = this.pendingResults;
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable(key, ActivityResult.class);
            } else {
                parcelable = bundle.getParcelable(key);
            }
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + " : " + parcelable);
            this.pendingResults.remove(key);
        }
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(key);
        if (lifecycleContainer != null) {
            lifecycleContainer.clearObservers();
        }
    }

    @MainThread
    public final boolean dispatchResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str = (String) this.requestCodeToKey.get(Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        doDispatch(str, resultCode, data, (CallbacksAndContract) this.keyToCallbacksAndContract.get(str));
        return true;
    }

    private final void doDispatch(String key, int resultCode, Intent data, CallbacksAndContract callbacksAndContract) {
        Lifecycle lifecycle;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) this.keyToLifecycleContainers.get(key);
        Lifecycle.State state = (lifecycleContainer == null || (lifecycle = lifecycleContainer.getLifecycle()) == null) ? null : lifecycle.getState();
        if ((callbacksAndContract != null ? callbacksAndContract.getMainCallback() : null) != null && this.launchedKeys.contains(key)) {
            Object obj = this.keyToInputParam.get(key);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            callbacksAndContract.getMainCallback().onActivityResult(callbacksAndContract.getContract().parseResult((Serializable) obj, resultCode, data));
            this.launchedKeys.remove(key);
            return;
        }
        if (state != null && state.isAtLeast(Lifecycle.State.STARTED) && callbacksAndContract != null && this.launchedKeys.contains(key)) {
            Object obj2 = this.keyToInputParam.get(key);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type I of expo.modules.kotlin.activityresult.AppContextActivityResultRegistry.doDispatch");
            Serializable serializable = (Serializable) obj2;
            callbacksAndContract.getFallbackCallback().onActivityResult(serializable, callbacksAndContract.getContract().parseResult(serializable, resultCode, data));
            this.launchedKeys.remove(key);
            return;
        }
        this.pendingResults.putParcelable(key, new ActivityResult(resultCode, data));
    }

    private final int generateRandomNumber() {
        int iNextInt = this.random.nextInt(2147418112);
        while (true) {
            int i = iNextInt + 65536;
            if (!this.requestCodeToKey.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iNextInt = this.random.nextInt(2147418112);
        }
    }

    private static final class CallbacksAndContract {
        private final AppContextActivityResultContract contract;
        private final AppContextActivityResultFallbackCallback fallbackCallback;
        private final ActivityResultCallback mainCallback;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CallbacksAndContract)) {
                return false;
            }
            CallbacksAndContract callbacksAndContract = (CallbacksAndContract) obj;
            return Intrinsics.areEqual(this.fallbackCallback, callbacksAndContract.fallbackCallback) && Intrinsics.areEqual(this.mainCallback, callbacksAndContract.mainCallback) && Intrinsics.areEqual(this.contract, callbacksAndContract.contract);
        }

        public int hashCode() {
            int iHashCode = this.fallbackCallback.hashCode() * 31;
            ActivityResultCallback activityResultCallback = this.mainCallback;
            return ((iHashCode + (activityResultCallback == null ? 0 : activityResultCallback.hashCode())) * 31) + this.contract.hashCode();
        }

        public String toString() {
            return "CallbacksAndContract(fallbackCallback=" + this.fallbackCallback + ", mainCallback=" + this.mainCallback + ", contract=" + this.contract + ")";
        }

        public CallbacksAndContract(AppContextActivityResultFallbackCallback fallbackCallback, ActivityResultCallback activityResultCallback, AppContextActivityResultContract contract) {
            Intrinsics.checkNotNullParameter(fallbackCallback, "fallbackCallback");
            Intrinsics.checkNotNullParameter(contract, "contract");
            this.fallbackCallback = fallbackCallback;
            this.mainCallback = activityResultCallback;
            this.contract = contract;
        }

        public final AppContextActivityResultFallbackCallback getFallbackCallback() {
            return this.fallbackCallback;
        }

        public final ActivityResultCallback getMainCallback() {
            return this.mainCallback;
        }

        public final AppContextActivityResultContract getContract() {
            return this.contract;
        }
    }

    @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer;", "", TCEventPropertiesNames.TCL_LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "observers", "Ljava/util/ArrayList;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lkotlin/collections/ArrayList;", "addObserver", "", "observer", "clearObservers", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nAppContextActivityResultRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppContextActivityResultRegistry.kt\nexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,373:1\n1863#2,2:374\n*S KotlinDebug\n*F\n+ 1 AppContextActivityResultRegistry.kt\nexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry$LifecycleContainer\n*L\n368#1:374,2\n*E\n"})
    public static final class LifecycleContainer {
        private final Lifecycle lifecycle;
        private final ArrayList observers;

        public LifecycleContainer(@NotNull Lifecycle lifecycle) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new ArrayList();
        }

        @NotNull
        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final void addObserver(@NotNull LifecycleEventObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            this.lifecycle.addObserver(observer);
            this.observers.add(observer);
        }

        public final void clearObservers() {
            Iterator it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.removeObserver((LifecycleEventObserver) it.next());
            }
            this.observers.clear();
        }
    }
}
