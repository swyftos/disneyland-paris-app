package com.urbanairship.preferencecenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RestrictTo;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfig;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import com.urbanairship.preferencecenter.p041ui.PreferenceCenterActivity;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.remotedata.RemoteDataPayload;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0002+,B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0017J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001fH\u0087@¢\u0006\u0002\u0010 J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m1836d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "inputValidator", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;)V", "getInputValidator$urbanairship_preference_center_release", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "isFeatureEnabled", "", "()Z", "openListener", "Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "getOpenListener", "()Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "setOpenListener", "(Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;)V", "pendingResultScope", "Lkotlinx/coroutines/CoroutineScope;", "getComponentGroup", "", "getConfig", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "preferenceCenterId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfigPendingResult", "Lcom/urbanairship/PendingResult;", "getJsonConfig", "Lcom/urbanairship/json/JsonValue;", "getJsonConfigPendingResult", "onAirshipDeepLink", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", AbstractCircuitBreaker.PROPERTY_NAME, "", "Companion", "OnOpenListener", "urbanairship-preference-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class PreferenceCenter extends AirshipComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String DEEP_LINK_HOST = "preferences";

    @NotNull
    public static final String KEY_PREFERENCE_FORMS = "preference_forms";

    @NotNull
    public static final String PAYLOAD_TYPE = "preference_forms";
    private final AirshipInputValidation.Validator inputValidator;
    private OnOpenListener openListener;
    private final CoroutineScope pendingResultScope;
    private final PrivacyManager privacyManager;
    private final RemoteData remoteData;

    @Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1836d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "", "onOpenPreferenceCenter", "", "preferenceCenterId", "", "urbanairship-preference-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public interface OnOpenListener {
        boolean onOpenPreferenceCenter(@NotNull String preferenceCenterId);
    }

    /* JADX INFO: renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getConfig$1 */
    static final class C56661 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C56661(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferenceCenter.this.getConfig(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfig$1 */
    static final class C56691 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C56691(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferenceCenter.this.getJsonConfig(null, this);
        }
    }

    @JvmStatic
    @NotNull
    public static final PreferenceCenter shared() {
        return INSTANCE.shared();
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 10;
    }

    @NotNull
    /* JADX INFO: renamed from: getInputValidator$urbanairship_preference_center_release, reason: from getter */
    public final AirshipInputValidation.Validator getInputValidator() {
        return this.inputValidator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceCenter(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull PrivacyManager privacyManager, @NotNull RemoteData remoteData, @NotNull AirshipInputValidation.Validator inputValidator) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(inputValidator, "inputValidator");
        this.privacyManager = privacyManager;
        this.remoteData = remoteData;
        this.inputValidator = inputValidator;
        this.pendingResultScope = CoroutineScopeKt.CoroutineScope(AirshipDispatchers.INSTANCE.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter$Companion;", "", "()V", "DEEP_LINK_HOST", "", "KEY_PREFERENCE_FORMS", "PAYLOAD_TYPE", "shared", "Lcom/urbanairship/preferencecenter/PreferenceCenter;", "urbanairship-preference-center_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final PreferenceCenter shared() {
            AirshipComponent airshipComponentRequireComponent = UAirship.shared().requireComponent(PreferenceCenter.class);
            Intrinsics.checkNotNullExpressionValue(airshipComponentRequireComponent, "requireComponent(...)");
            return (PreferenceCenter) airshipComponentRequireComponent;
        }
    }

    @Nullable
    public final OnOpenListener getOpenListener() {
        return this.openListener;
    }

    public final void setOpenListener(@Nullable OnOpenListener onOpenListener) {
        this.openListener = onOpenListener;
    }

    private final boolean isFeatureEnabled() {
        return this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES);
    }

    public final void open(@NotNull String preferenceCenterId) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        if (!isFeatureEnabled()) {
            UALog.m1754w("Unable to open Preference Center! FEATURE_TAGS_AND_ATTRIBUTES not enabled.", new Object[0]);
            return;
        }
        OnOpenListener onOpenListener = this.openListener;
        if (onOpenListener == null || !onOpenListener.onOpenPreferenceCenter(preferenceCenterId)) {
            UALog.m1751v("Launching PreferenceCenterActivity with id = " + preferenceCenterId, new Object[0]);
            Intent intentPutExtra = new Intent(getContext(), (Class<?>) PreferenceCenterActivity.class).addFlags(805306368).putExtra(PreferenceCenterActivity.EXTRA_ID, preferenceCenterId);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            getContext().startActivity(intentPutExtra);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object getConfig(@NotNull String str, @NotNull Continuation<? super PreferenceCenterConfig> continuation) {
        C56661 c56661;
        if (continuation instanceof C56661) {
            c56661 = (C56661) continuation;
            int i = c56661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c56661.label = i - Integer.MIN_VALUE;
            } else {
                c56661 = new C56661(continuation);
            }
        } else {
            c56661 = new C56661(continuation);
        }
        Object jsonConfig = c56661.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c56661.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(jsonConfig);
            c56661.label = 1;
            jsonConfig = getJsonConfig(str, c56661);
            if (jsonConfig == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(jsonConfig);
        }
        JsonValue jsonValue = (JsonValue) jsonConfig;
        if (jsonValue == null) {
            return null;
        }
        try {
            PreferenceCenterConfig.Companion companion = PreferenceCenterConfig.INSTANCE;
            JsonMap jsonMapOptMap = jsonValue.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return companion.parse$urbanairship_preference_center_release(jsonMapOptMap);
        } catch (Exception e) {
            UALog.m1757w(e, new Function0() { // from class: com.urbanairship.preferencecenter.PreferenceCenter.getConfig.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to parse preference center config";
                }
            });
            return null;
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getConfigPendingResult$1 */
    static final class C56681 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ String $preferenceCenterId;
        Object L$0;
        int label;
        final /* synthetic */ PreferenceCenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56681(PendingResult pendingResult, PreferenceCenter preferenceCenter, String str, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = preferenceCenter;
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C56681(this.$pendingResult, this.this$0, this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                PreferenceCenter preferenceCenter = this.this$0;
                String str = this.$preferenceCenterId;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object config = preferenceCenter.getConfig(str, this);
                if (config == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = config;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final PendingResult<PreferenceCenterConfig> getConfigPendingResult(@NotNull String preferenceCenterId) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        PendingResult<PreferenceCenterConfig> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C56681(pendingResult, this, preferenceCenterId, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final Object getJsonConfig(@NotNull String str, @NotNull Continuation<? super JsonValue> continuation) {
        C56691 c56691;
        if (continuation instanceof C56691) {
            c56691 = (C56691) continuation;
            int i = c56691.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c56691.label = i - Integer.MIN_VALUE;
            } else {
                c56691 = new C56691(continuation);
            }
        } else {
            c56691 = new C56691(continuation);
        }
        Object objPayloads = c56691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c56691.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objPayloads);
            RemoteData remoteData = this.remoteData;
            c56691.L$0 = str;
            c56691.label = 1;
            objPayloads = remoteData.payloads("preference_forms", c56691);
            if (objPayloads == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c56691.L$0;
            ResultKt.throwOnFailure(objPayloads);
        }
        Iterator it = ((List) objPayloads).iterator();
        while (it.hasNext()) {
            JsonList jsonListOptList = ((RemoteDataPayload) it.next()).getData().opt("preference_forms").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            Iterator<JsonValue> it2 = jsonListOptList.iterator();
            while (it2.hasNext()) {
                JsonMap jsonMapOptMap = it2.next().optMap().opt(PreferenceCenterPayload.KEY_FORM).optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                String strOptString = jsonMapOptMap.opt("id").optString();
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                if (Intrinsics.areEqual(str, strOptString)) {
                    return jsonMapOptMap.getJsonValue();
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfigPendingResult$1 */
    static final class C56701 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ String $preferenceCenterId;
        Object L$0;
        int label;
        final /* synthetic */ PreferenceCenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C56701(PendingResult pendingResult, PreferenceCenter preferenceCenter, String str, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = preferenceCenter;
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C56701(this.$pendingResult, this.this$0, this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C56701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                PreferenceCenter preferenceCenter = this.this$0;
                String str = this.$preferenceCenterId;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object jsonConfig = preferenceCenter.getJsonConfig(str, this);
                if (jsonConfig == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = jsonConfig;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            pendingResult.setResult(obj);
            return Unit.INSTANCE;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final PendingResult<JsonValue> getJsonConfigPendingResult(@NotNull String preferenceCenterId) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        PendingResult<JsonValue> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C56701(pendingResult, this, preferenceCenterId, null), 3, null);
        return pendingResult;
    }

    @Override // com.urbanairship.AirshipComponent
    public boolean onAirshipDeepLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        List<String> pathSegments = uri.getPathSegments();
        if (!Intrinsics.areEqual(DEEP_LINK_HOST, uri.getEncodedAuthority()) || pathSegments.size() != 1) {
            return false;
        }
        String str = pathSegments.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        open(str);
        return true;
    }
}
