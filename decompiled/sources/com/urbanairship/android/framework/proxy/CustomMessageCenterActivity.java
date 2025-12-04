package com.urbanairship.android.framework.proxy;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.MessageCenterFragment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/framework/proxy/CustomMessageCenterActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "messageCenterFragment", "Lcom/urbanairship/messagecenter/ui/MessageCenterFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomMessageCenterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomMessageCenterActivity.kt\ncom/urbanairship/android/framework/proxy/CustomMessageCenterActivity\n+ 2 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,94:1\n50#2,12:95\n1#3:107\n*S KotlinDebug\n*F\n+ 1 CustomMessageCenterActivity.kt\ncom/urbanairship/android/framework/proxy/CustomMessageCenterActivity\n*L\n54#1:95,12\n*E\n"})
/* loaded from: classes2.dex */
public final class CustomMessageCenterActivity extends FragmentActivity {
    private MessageCenterFragment messageCenterFragment;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InstrumentationCallbacks.dispatchTouchEventCalled(this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        InstrumentationCallbacks.onConfigurationChangedCalled(this, configuration);
        super.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InstrumentationCallbacks.onDestroyCalled(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        InstrumentationCallbacks.onRestartCalled(this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r9) {
        /*
            r8 = this;
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.onCreateCalled(r8, r9)
            r0 = 3
            r1 = 0
            androidx.activity.EdgeToEdge.enable$default(r8, r1, r1, r0, r1)
            android.view.Window r0 = r8.getWindow()
            r2 = 0
            r0.setNavigationBarContrastEnforced(r2)
            super.onCreate(r9)
            android.app.Application r0 = r8.getApplication()
            com.urbanairship.Autopilot.automaticTakeOff(r0)
            boolean r0 = com.urbanairship.UAirship.isTakingOff()
            if (r0 != 0) goto L31
            boolean r0 = com.urbanairship.UAirship.isFlying()
            if (r0 != 0) goto L31
            java.lang.String r9 = "MessageCenterActivity - unable to create activity, takeOff not called."
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.urbanairship.UALog.e(r9, r0)
            r8.finish()
            return
        L31:
            java.lang.String r0 = "MESSAGE_CENTER_FRAGMENT"
            if (r9 == 0) goto L44
            androidx.fragment.app.FragmentManager r9 = r8.getSupportFragmentManager()
            androidx.fragment.app.Fragment r9 = r9.findFragmentByTag(r0)
            boolean r2 = r9 instanceof com.urbanairship.messagecenter.ui.MessageCenterFragment
            if (r2 == 0) goto L44
            com.urbanairship.messagecenter.ui.MessageCenterFragment r9 = (com.urbanairship.messagecenter.ui.MessageCenterFragment) r9
            goto L45
        L44:
            r9 = r1
        L45:
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r9 != 0) goto L6d
            com.urbanairship.messagecenter.ui.MessageCenterFragment$Companion r9 = com.urbanairship.messagecenter.ui.MessageCenterFragment.INSTANCE
            com.urbanairship.messagecenter.MessageCenter$Companion r3 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            android.content.Intent r4 = r8.getIntent()
            java.lang.String r3 = r3.parseMessageId(r4)
            com.urbanairship.messagecenter.ui.MessageCenterFragment r9 = r9.newInstance(r3)
            androidx.fragment.app.FragmentManager r3 = r8.getSupportFragmentManager()
            java.lang.String r4 = "getSupportFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            androidx.fragment.app.FragmentTransaction r3 = r3.beginTransaction()
            r3.add(r2, r9, r0)
            r3.commitNow()
        L6d:
            r8.messageCenterFragment = r9
            if (r9 != 0) goto L77
            java.lang.String r9 = "messageCenterFragment"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = r1
        L77:
            com.urbanairship.messagecenter.MessageCenter$Companion r0 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            com.urbanairship.messagecenter.MessageCenter r0 = r0.shared()
            com.urbanairship.Predicate r0 = r0.getPredicate()
            r9.setListPredicate(r0)
            android.view.View r9 = r8.findViewById(r2)
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            com.urbanairship.android.framework.proxy.CustomMessageCenterActivity$$ExternalSyntheticLambda0 r0 = new com.urbanairship.android.framework.proxy.CustomMessageCenterActivity$$ExternalSyntheticLambda0
            r0.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r9, r0)
            androidx.core.view.ViewCompat.requestApplyInsets(r9)
            com.urbanairship.android.framework.proxy.proxies.AirshipProxy$Companion r9 = com.urbanairship.android.framework.proxy.proxies.AirshipProxy.INSTANCE
            com.urbanairship.android.framework.proxy.proxies.AirshipProxy r9 = r9.shared(r8)
            com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy r9 = r9.getMessageCenter()
            androidx.lifecycle.LifecycleCoroutineScope r2 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r8)
            com.urbanairship.android.framework.proxy.CustomMessageCenterActivity$onCreate$3 r5 = new com.urbanairship.android.framework.proxy.CustomMessageCenterActivity$onCreate$3
            r5.<init>(r9, r8, r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.CustomMessageCenterActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$1(ViewGroup viewGroup, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        int i = insets2.left;
        viewGroup.setPadding(i, insets2.right, i, insets2.bottom);
        return insets;
    }

    /* renamed from: com.urbanairship.android.framework.proxy.CustomMessageCenterActivity$onCreate$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        final /* synthetic */ MessageCenterProxy $messageCenter;
        int label;
        final /* synthetic */ CustomMessageCenterActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MessageCenterProxy messageCenterProxy, CustomMessageCenterActivity customMessageCenterActivity, Continuation continuation) {
            super(2, continuation);
            this.$messageCenter = messageCenterProxy;
            this.this$0 = customMessageCenterActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.$messageCenter, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> displayState$airship_framework_proxy_release = this.$messageCenter.getDisplayState$airship_framework_proxy_release();
                final CustomMessageCenterActivity customMessageCenterActivity = this.this$0;
                FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.framework.proxy.CustomMessageCenterActivity.onCreate.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(boolean z, Continuation continuation) {
                        if (!z) {
                            customMessageCenterActivity.finish();
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (displayState$airship_framework_proxy_release.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String messageId = MessageCenter.INSTANCE.parseMessageId(intent);
        if (messageId != null) {
            MessageCenterFragment messageCenterFragment = this.messageCenterFragment;
            if (messageCenterFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageCenterFragment");
                messageCenterFragment = null;
            }
            MessageCenterFragment.showMessage$default(messageCenterFragment, messageId, null, 2, null);
        }
    }
}
