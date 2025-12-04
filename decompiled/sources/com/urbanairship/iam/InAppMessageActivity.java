package com.urbanairship.iam;

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.content.IntentCompat;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.Autopilot;
import com.urbanairship.UALog;
import com.urbanairship.activity.ThemedActivity;
import com.urbanairship.iam.adapter.InAppDisplayArgs;
import com.urbanairship.iam.adapter.InAppDisplayArgsLoader;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.assets.EmptyAirshipCachedAssets;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 !*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH$J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\b\u0010\u001e\u001a\u00020\u0019H\u0014J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010 \u001a\u00020\u0019H\u0014R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006@BX\u0084.¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/urbanairship/iam/InAppMessageActivity;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "Lcom/urbanairship/activity/ThemedActivity;", "()V", "<set-?>", "Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", "args", "getArgs", "()Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "assets", "getAssets", "()Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "displayContent", "getDisplayContent", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "displayListener", "getDisplayListener", "()Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "loader", "Lcom/urbanairship/iam/adapter/InAppDisplayArgsLoader;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateMessage", "onDestroy", "onPause", "onPostCreate", "onResume", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInAppMessageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageActivity.kt\ncom/urbanairship/iam/InAppMessageActivity\n+ 2 ActivityExtensions.kt\ncom/urbanairship/util/ActivityExtensionsKt\n*L\n1#1,117:1\n15#2:118\n*S KotlinDebug\n*F\n+ 1 InAppMessageActivity.kt\ncom/urbanairship/iam/InAppMessageActivity\n*L\n45#1:118\n*E\n"})
/* loaded from: classes5.dex */
public abstract class InAppMessageActivity<T extends InAppMessageDisplayContent> extends ThemedActivity {

    @NotNull
    public static final String EXTRA_DISPLAY_ARGS_LOADER = "com.urbanairship.automation.EXTRA_DISPLAY_ARGS_LOADER";
    private InAppDisplayArgs args;
    private AirshipCachedAssets assets;
    private InAppMessageDisplayContent displayContent;
    private InAppMessageDisplayListener displayListener;
    private InAppDisplayArgsLoader loader;

    protected abstract void onCreateMessage(@Nullable Bundle savedInstanceState);

    @NotNull
    protected final InAppDisplayArgs<T> getArgs() {
        InAppDisplayArgs<T> inAppDisplayArgs = this.args;
        if (inAppDisplayArgs != null) {
            return inAppDisplayArgs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("args");
        return null;
    }

    @Nullable
    protected final T getDisplayContent() {
        return (T) this.displayContent;
    }

    @Nullable
    protected final InAppMessageDisplayListener getDisplayListener() {
        return this.displayListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public final AirshipCachedAssets getAssets() {
        return this.assets;
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Autopilot.automaticTakeOff(getApplicationContext());
        super.onCreate(savedInstanceState);
        if (getIntent() == null || getIntent().getExtras() == null) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.InAppMessageActivity.onCreate.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Starting message activity with no intent";
                }
            }, 1, null);
            finish();
            return;
        }
        InAppDisplayArgsLoader inAppDisplayArgsLoader = (InAppDisplayArgsLoader) IntentCompat.getParcelableExtra(getIntent(), EXTRA_DISPLAY_ARGS_LOADER, InAppDisplayArgsLoader.class);
        if (inAppDisplayArgsLoader == null) {
            UALog.e("Missing layout args loader", new Object[0]);
            finish();
            return;
        }
        this.loader = inAppDisplayArgsLoader;
        try {
            this.args = inAppDisplayArgsLoader.load();
            AirshipCachedAssets assets = getArgs().getAssets();
            if (assets == null) {
                assets = new EmptyAirshipCachedAssets();
            }
            this.assets = assets;
            this.displayListener = getArgs().getDisplayListener();
            this.displayContent = getArgs().getDisplayContent();
            InAppMessageDisplayListener inAppMessageDisplayListener = this.displayListener;
            if (inAppMessageDisplayListener != null && !inAppMessageDisplayListener.isDisplaying()) {
                finish();
                return;
            }
            onCreateMessage(savedInstanceState);
            OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
            Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
            OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1() { // from class: com.urbanairship.iam.InAppMessageActivity.onCreate.4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((OnBackPressedCallback) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(OnBackPressedCallback addCallback) {
                    Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                    InAppMessageDisplayListener displayListener = InAppMessageActivity.this.getDisplayListener();
                    if (displayListener != null) {
                        displayListener.onUserDismissed();
                    }
                    InAppMessageActivity.this.finish();
                }
            }, 2, null);
            InAppMessageDisplayListener inAppMessageDisplayListener2 = this.displayListener;
            if (inAppMessageDisplayListener2 != null) {
                inAppMessageDisplayListener2.onAppear();
            }
        } catch (InAppDisplayArgsLoader.LoadException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.InAppMessageActivity.onCreate.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to load in-app message display args!";
                }
            });
            finish();
        }
    }

    @Override // com.urbanairship.activity.ThemedActivity, android.app.Activity
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        InAppMessageDisplayListener inAppMessageDisplayListener = this.displayListener;
        if (inAppMessageDisplayListener == null || inAppMessageDisplayListener.isDisplaying()) {
            return;
        }
        finish();
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        InAppMessageDisplayListener inAppMessageDisplayListener = this.displayListener;
        if (inAppMessageDisplayListener != null) {
            inAppMessageDisplayListener.onResume();
        }
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        InAppMessageDisplayListener inAppMessageDisplayListener = this.displayListener;
        if (inAppMessageDisplayListener != null) {
            inAppMessageDisplayListener.onPause();
        }
    }

    @Override // com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        InAppDisplayArgsLoader inAppDisplayArgsLoader;
        super.onDestroy();
        if (!isFinishing() || (inAppDisplayArgsLoader = this.loader) == null) {
            return;
        }
        if (inAppDisplayArgsLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loader");
            inAppDisplayArgsLoader = null;
        }
        inAppDisplayArgsLoader.dispose();
    }
}
