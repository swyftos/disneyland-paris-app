package com.urbanairship.android.framework.proxy;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.firebase.messaging.Constants;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.android.framework.proxy.proxies.AirshipProxy;
import com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.MessageActivity;
import com.urbanairship.messagecenter.ui.MessageCenterMessageFragment;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/framework/proxy/CustomMessageActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "currentMessageId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "showMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomMessageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomMessageActivity.kt\ncom/urbanairship/android/framework/proxy/CustomMessageActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n*L\n1#1,152:1\n1#2:153\n50#3,12:154\n*S KotlinDebug\n*F\n+ 1 CustomMessageActivity.kt\ncom/urbanairship/android/framework/proxy/CustomMessageActivity\n*L\n106#1:154,12\n*E\n"})
/* loaded from: classes2.dex */
public final class CustomMessageActivity extends FragmentActivity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private String currentMessageId;

    @JvmStatic
    @NotNull
    public static final Intent createIntent(@NotNull Context context, @NotNull String str) {
        return INSTANCE.createIntent(context, str);
    }

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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String messageId;
        InstrumentationCallbacks.onCreateCalled(this, savedInstanceState);
        EdgeToEdge.enable$default(this, null, null, 3, null);
        getWindow().setNavigationBarContrastEnforced(false);
        super.onCreate(savedInstanceState);
        Autopilot.automaticTakeOff(getApplication());
        if (!UAirship.isTakingOff() && !UAirship.isFlying()) {
            UALog.e("MessageActivity - unable to create Activity, takeOff not called.", new Object[0]);
            finish();
            return;
        }
        if (savedInstanceState == null || (messageId = savedInstanceState.getString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID)) == null) {
            messageId = MessageCenter.INSTANCE.parseMessageId(getIntent());
        }
        if (messageId == null) {
            UALog.w("MessageActivity - unable to display message, messageId is null!", new Object[0]);
            finish();
            return;
        }
        showMessage(messageId);
        final ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.framework.proxy.CustomMessageActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CustomMessageActivity.onCreate$lambda$0(viewGroup, view, windowInsetsCompat);
            }
        });
        ViewCompat.requestApplyInsets(viewGroup);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(AirshipProxy.INSTANCE.shared(this).getMessageCenter(), this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$0(ViewGroup viewGroup, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        int i = insets2.left;
        viewGroup.setPadding(i, insets2.right, i, insets2.bottom);
        return insets;
    }

    /* renamed from: com.urbanairship.android.framework.proxy.CustomMessageActivity$onCreate$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ MessageCenterProxy $messageCenter;
        int label;
        final /* synthetic */ CustomMessageActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MessageCenterProxy messageCenterProxy, CustomMessageActivity customMessageActivity, Continuation continuation) {
            super(2, continuation);
            this.$messageCenter = messageCenterProxy;
            this.this$0 = customMessageActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.$messageCenter, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> displayState$airship_framework_proxy_release = this.$messageCenter.getDisplayState$airship_framework_proxy_release();
                final CustomMessageActivity customMessageActivity = this.this$0;
                FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.framework.proxy.CustomMessageActivity.onCreate.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(boolean z, Continuation continuation) {
                        if (!z) {
                            customMessageActivity.finish();
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

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(Constants.FirelogAnalytics.PARAM_MESSAGE_ID, this.currentMessageId);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        String messageId = MessageCenter.INSTANCE.parseMessageId(intent);
        if (messageId != null) {
            showMessage(messageId);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    private final void showMessage(String messageId) {
        MessageCenterMessageFragment messageCenterMessageFragment = (MessageCenterMessageFragment) getSupportFragmentManager().findFragmentByTag("MessageFragment");
        if (messageCenterMessageFragment == null || !Intrinsics.areEqual(messageId, messageCenterMessageFragment.getMessageId())) {
            final MessageCenterMessageFragment messageCenterMessageFragmentNewInstance$default = MessageCenterMessageFragment.Companion.newInstance$default(MessageCenterMessageFragment.INSTANCE, messageId, null, Boolean.TRUE, 2, null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
            fragmentTransactionBeginTransaction.replace(android.R.id.content, messageCenterMessageFragmentNewInstance$default, "MessageFragment");
            fragmentTransactionBeginTransaction.commitNow();
            messageCenterMessageFragmentNewInstance$default.setOnMessageDeletedListener(new MessageCenterMessageFragment.OnMessageDeletedListener() { // from class: com.urbanairship.android.framework.proxy.CustomMessageActivity$$ExternalSyntheticLambda1
                @Override // com.urbanairship.messagecenter.ui.MessageCenterMessageFragment.OnMessageDeletedListener
                public final void onDeleteMessage(Message message) throws Resources.NotFoundException {
                    CustomMessageActivity.showMessage$lambda$3(messageCenterMessageFragmentNewInstance$default, this, message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$3(MessageCenterMessageFragment fragment, CustomMessageActivity this$0, Message it) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        fragment.deleteMessage(it);
        String quantityString = this$0.getResources().getQuantityString(com.urbanairship.messagecenter.R.plurals.ua_mc_description_deleted, 1, 1);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        Toast.makeText(this$0, quantityString, 0).show();
        this$0.finish();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/framework/proxy/CustomMessageActivity$Companion;", "", "()V", "FRAGMENT_TAG", "", "MESSAGE_ID_KEY", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Intent createIntent(@NotNull Context context, @NotNull String messageId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(messageId, "messageId");
            Intent data = new Intent().setPackage(context.getPackageName()).addFlags(805306368).setData(Uri.fromParts("message", messageId, null));
            Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
            data.setAction(MessageCenter.VIEW_MESSAGE_INTENT_ACTION);
            if (data.resolveActivity(context.getPackageManager()) == null) {
                data.setClass(context, MessageActivity.class);
            }
            return data;
        }
    }
}
