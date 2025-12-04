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
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfig;
import com.urbanairship.preferencecenter.ui.PreferenceCenterActivity;
import com.urbanairship.remotedata.RemoteData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
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

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0002+,B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0017J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\"2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001fH\u0087@¢\u0006\u0002\u0010 J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "inputValidator", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/remotedata/RemoteData;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;)V", "getInputValidator$urbanairship_preference_center_release", "()Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "isFeatureEnabled", "", "()Z", "openListener", "Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "getOpenListener", "()Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "setOpenListener", "(Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;)V", "pendingResultScope", "Lkotlinx/coroutines/CoroutineScope;", "getComponentGroup", "", "getConfig", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "preferenceCenterId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfigPendingResult", "Lcom/urbanairship/PendingResult;", "getJsonConfig", "Lcom/urbanairship/json/JsonValue;", "getJsonConfigPendingResult", "onAirshipDeepLink", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", AbstractCircuitBreaker.PROPERTY_NAME, "", "Companion", "OnOpenListener", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PreferenceCenter extends AirshipComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter$OnOpenListener;", "", "onOpenPreferenceCenter", "", "preferenceCenterId", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnOpenListener {
        boolean onOpenPreferenceCenter(@NotNull String preferenceCenterId);
    }

    /* renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getConfig$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferenceCenter.this.getConfig(null, this);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfig$1, reason: invalid class name and case insensitive filesystem */
    static final class C12801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12801(Continuation continuation) {
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
    /* renamed from: getInputValidator$urbanairship_preference_center_release, reason: from getter */
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

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/preferencecenter/PreferenceCenter$Companion;", "", "()V", "DEEP_LINK_HOST", "", "KEY_PREFERENCE_FORMS", "PAYLOAD_TYPE", "shared", "Lcom/urbanairship/preferencecenter/PreferenceCenter;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
            UALog.w("Unable to open Preference Center! FEATURE_TAGS_AND_ATTRIBUTES not enabled.", new Object[0]);
            return;
        }
        OnOpenListener onOpenListener = this.openListener;
        if (onOpenListener == null || !onOpenListener.onOpenPreferenceCenter(preferenceCenterId)) {
            UALog.v("Launching PreferenceCenterActivity with id = " + preferenceCenterId, new Object[0]);
            Intent intentPutExtra = new Intent(getContext(), (Class<?>) PreferenceCenterActivity.class).addFlags(805306368).putExtra(PreferenceCenterActivity.EXTRA_ID, preferenceCenterId);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            getContext().startActivity(intentPutExtra);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getConfig(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.preferencecenter.data.PreferenceCenterConfig> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.preferencecenter.PreferenceCenter$getConfig$1 r0 = (com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.preferencecenter.PreferenceCenter$getConfig$1 r0 = new com.urbanairship.preferencecenter.PreferenceCenter$getConfig$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.Object r6 = r4.getJsonConfig(r5, r0)
            if (r6 != r1) goto L3d
            return r1
        L3d:
            com.urbanairship.json.JsonValue r6 = (com.urbanairship.json.JsonValue) r6
            r4 = 0
            if (r6 != 0) goto L43
            return r4
        L43:
            com.urbanairship.preferencecenter.data.PreferenceCenterConfig$Companion r5 = com.urbanairship.preferencecenter.data.PreferenceCenterConfig.INSTANCE     // Catch: java.lang.Exception -> L53
            com.urbanairship.json.JsonMap r6 = r6.optMap()     // Catch: java.lang.Exception -> L53
            java.lang.String r0 = "optMap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)     // Catch: java.lang.Exception -> L53
            com.urbanairship.preferencecenter.data.PreferenceCenterConfig r4 = r5.parse$urbanairship_preference_center_release(r6)     // Catch: java.lang.Exception -> L53
            goto L59
        L53:
            r5 = move-exception
            com.urbanairship.preferencecenter.PreferenceCenter$getConfig$2 r6 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.preferencecenter.PreferenceCenter.getConfig.2
                static {
                    /*
                        com.urbanairship.preferencecenter.PreferenceCenter$getConfig$2 r0 = new com.urbanairship.preferencecenter.PreferenceCenter$getConfig$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.preferencecenter.PreferenceCenter$getConfig$2) com.urbanairship.preferencecenter.PreferenceCenter.getConfig.2.INSTANCE com.urbanairship.preferencecenter.PreferenceCenter$getConfig$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Failed to parse preference center config"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.AnonymousClass2.invoke():java.lang.String");
                }
            }
            com.urbanairship.UALog.w(r5, r6)
        L59:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.getConfig(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getConfigPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C12791 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ String $preferenceCenterId;
        Object L$0;
        int label;
        final /* synthetic */ PreferenceCenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12791(PendingResult pendingResult, PreferenceCenter preferenceCenter, String str, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = preferenceCenter;
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C12791(this.$pendingResult, this.this$0, this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C12791(pendingResult, this, preferenceCenterId, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getJsonConfig(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.json.JsonValue> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.preferencecenter.PreferenceCenter.C12801
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfig$1 r0 = (com.urbanairship.preferencecenter.PreferenceCenter.C12801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfig$1 r0 = new com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfig$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "preference_forms"
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L48
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.remotedata.RemoteData r5 = r5.remoteData
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.payloads(r3, r0)
            if (r7 != r1) goto L48
            return r1
        L48:
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r5 = r7.iterator()
        L4e:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto La8
            java.lang.Object r7 = r5.next()
            com.urbanairship.remotedata.RemoteDataPayload r7 = (com.urbanairship.remotedata.RemoteDataPayload) r7
            com.urbanairship.json.JsonMap r7 = r7.getData()
            com.urbanairship.json.JsonValue r7 = r7.opt(r3)
            com.urbanairship.json.JsonList r7 = r7.optList()
            java.lang.String r0 = "optList(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.util.Iterator r7 = r7.iterator()
        L6f:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L4e
            java.lang.Object r0 = r7.next()
            com.urbanairship.json.JsonValue r0 = (com.urbanairship.json.JsonValue) r0
            com.urbanairship.json.JsonMap r0 = r0.optMap()
            java.lang.String r1 = "form"
            com.urbanairship.json.JsonValue r0 = r0.opt(r1)
            com.urbanairship.json.JsonMap r0 = r0.optMap()
            java.lang.String r1 = "optMap(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "id"
            com.urbanairship.json.JsonValue r1 = r0.opt(r1)
            java.lang.String r1 = r1.optString()
            java.lang.String r2 = "optString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 == 0) goto L6f
            com.urbanairship.json.JsonValue r5 = r0.getJsonValue()
            return r5
        La8:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.PreferenceCenter.getJsonConfig(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.preferencecenter.PreferenceCenter$getJsonConfigPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C12811 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        final /* synthetic */ String $preferenceCenterId;
        Object L$0;
        int label;
        final /* synthetic */ PreferenceCenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12811(PendingResult pendingResult, PreferenceCenter preferenceCenter, String str, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = preferenceCenter;
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C12811(this.$pendingResult, this.this$0, this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(this.pendingResultScope, null, null, new C12811(pendingResult, this, preferenceCenterId, null), 3, null);
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
