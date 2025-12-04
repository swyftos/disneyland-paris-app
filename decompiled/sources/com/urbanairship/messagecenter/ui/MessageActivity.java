package com.urbanairship.messagecenter.ui;

import android.R;
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
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.firebase.messaging.Constants;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.messagecenter.ui.MessageCenterMessageFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0014J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "currentMessageId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "showMessage", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageActivity.kt\ncom/urbanairship/messagecenter/ui/MessageActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n*L\n1#1,138:1\n1#2:139\n50#3,12:140\n*S KotlinDebug\n*F\n+ 1 MessageActivity.kt\ncom/urbanairship/messagecenter/ui/MessageActivity\n*L\n93#1:140,12\n*E\n"})
/* loaded from: classes5.dex */
public class MessageActivity extends FragmentActivity {

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
        } else {
            showMessage(messageId);
            final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.content);
            ViewCompat.setOnApplyWindowInsetsListener(viewGroup, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.messagecenter.ui.MessageActivity$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return MessageActivity.onCreate$lambda$0(viewGroup, view, windowInsetsCompat);
                }
            });
            ViewCompat.requestApplyInsets(viewGroup);
        }
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
            fragmentTransactionBeginTransaction.replace(R.id.content, messageCenterMessageFragmentNewInstance$default, "MessageFragment");
            fragmentTransactionBeginTransaction.commitNow();
            messageCenterMessageFragmentNewInstance$default.setOnMessageDeletedListener(new MessageCenterMessageFragment.OnMessageDeletedListener() { // from class: com.urbanairship.messagecenter.ui.MessageActivity$$ExternalSyntheticLambda1
                @Override // com.urbanairship.messagecenter.ui.MessageCenterMessageFragment.OnMessageDeletedListener
                public final void onDeleteMessage(Message message) throws Resources.NotFoundException {
                    MessageActivity.showMessage$lambda$3(messageCenterMessageFragmentNewInstance$default, this, message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$3(MessageCenterMessageFragment fragment, MessageActivity this$0, Message it) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        fragment.deleteMessage(it);
        String quantityString = this$0.getResources().getQuantityString(com.urbanairship.messagecenter.R.plurals.ua_mc_description_deleted, 1, 1);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        Toast.makeText(this$0, quantityString, 0).show();
        this$0.finish();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/MessageActivity$Companion;", "", "()V", "FRAGMENT_TAG", "", "MESSAGE_ID_KEY", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
