package com.urbanairship.messagecenter.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.messagecenter.MessageCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageCenterActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "messageCenterFragment", "Lcom/urbanairship/messagecenter/ui/MessageCenterFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageCenterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageCenterActivity.kt\ncom/urbanairship/messagecenter/ui/MessageCenterActivity\n+ 2 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,80:1\n50#2,12:81\n1#3:93\n*S KotlinDebug\n*F\n+ 1 MessageCenterActivity.kt\ncom/urbanairship/messagecenter/ui/MessageCenterActivity\n*L\n49#1:81,12\n*E\n"})
/* loaded from: classes5.dex */
public class MessageCenterActivity extends FragmentActivity {
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
    protected void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r6) {
        /*
            r5 = this;
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.onCreateCalled(r5, r6)
            r0 = 3
            r1 = 0
            androidx.activity.EdgeToEdge.enable$default(r5, r1, r1, r0, r1)
            android.view.Window r0 = r5.getWindow()
            r2 = 0
            r0.setNavigationBarContrastEnforced(r2)
            super.onCreate(r6)
            android.app.Application r0 = r5.getApplication()
            com.urbanairship.Autopilot.automaticTakeOff(r0)
            boolean r0 = com.urbanairship.UAirship.isTakingOff()
            if (r0 != 0) goto L31
            boolean r0 = com.urbanairship.UAirship.isFlying()
            if (r0 != 0) goto L31
            java.lang.String r6 = "MessageCenterActivity - unable to create activity, takeOff not called."
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.urbanairship.UALog.e(r6, r0)
            r5.finish()
            return
        L31:
            java.lang.String r0 = "MESSAGE_CENTER_FRAGMENT"
            if (r6 == 0) goto L44
            androidx.fragment.app.FragmentManager r6 = r5.getSupportFragmentManager()
            androidx.fragment.app.Fragment r6 = r6.findFragmentByTag(r0)
            boolean r2 = r6 instanceof com.urbanairship.messagecenter.ui.MessageCenterFragment
            if (r2 == 0) goto L44
            com.urbanairship.messagecenter.ui.MessageCenterFragment r6 = (com.urbanairship.messagecenter.ui.MessageCenterFragment) r6
            goto L45
        L44:
            r6 = r1
        L45:
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r6 != 0) goto L6d
            com.urbanairship.messagecenter.ui.MessageCenterFragment$Companion r6 = com.urbanairship.messagecenter.ui.MessageCenterFragment.INSTANCE
            com.urbanairship.messagecenter.MessageCenter$Companion r3 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            android.content.Intent r4 = r5.getIntent()
            java.lang.String r3 = r3.parseMessageId(r4)
            com.urbanairship.messagecenter.ui.MessageCenterFragment r6 = r6.newInstance(r3)
            androidx.fragment.app.FragmentManager r3 = r5.getSupportFragmentManager()
            java.lang.String r4 = "getSupportFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            androidx.fragment.app.FragmentTransaction r3 = r3.beginTransaction()
            r3.add(r2, r6, r0)
            r3.commitNow()
        L6d:
            r5.messageCenterFragment = r6
            if (r6 != 0) goto L77
            java.lang.String r6 = "messageCenterFragment"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L78
        L77:
            r1 = r6
        L78:
            com.urbanairship.messagecenter.MessageCenter$Companion r6 = com.urbanairship.messagecenter.MessageCenter.INSTANCE
            com.urbanairship.messagecenter.MessageCenter r6 = r6.shared()
            com.urbanairship.Predicate r6 = r6.getPredicate()
            r1.setListPredicate(r6)
            android.view.View r5 = r5.findViewById(r2)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            com.urbanairship.messagecenter.ui.MessageCenterActivity$$ExternalSyntheticLambda0 r6 = new com.urbanairship.messagecenter.ui.MessageCenterActivity$$ExternalSyntheticLambda0
            r6.<init>()
            androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener(r5, r6)
            androidx.core.view.ViewCompat.requestApplyInsets(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.ui.MessageCenterActivity.onCreate(android.os.Bundle):void");
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
