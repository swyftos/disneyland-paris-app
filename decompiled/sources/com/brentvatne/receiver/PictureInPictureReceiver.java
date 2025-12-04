package com.brentvatne.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/brentvatne/receiver/PictureInPictureReceiver;", "Landroid/content/BroadcastReceiver;", "view", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "<init>", "(Lcom/brentvatne/exoplayer/ReactExoplayerView;Lcom/facebook/react/uimanager/ThemedReactContext;)V", "onReceive", "", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setListener", "removeListener", "getPipActionIntent", "Landroid/app/PendingIntent;", "isPaused", "", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PictureInPictureReceiver extends BroadcastReceiver {

    @NotNull
    public static final String ACTION_MEDIA_CONTROL = "rnv_media_control";
    public static final int CONTROL_TYPE_PAUSE = 2;
    public static final int CONTROL_TYPE_PLAY = 1;

    @NotNull
    public static final String EXTRA_CONTROL_TYPE = "rnv_control_type";
    public static final int REQUEST_PAUSE = 2;
    public static final int REQUEST_PLAY = 1;
    private final ThemedReactContext context;
    private final ReactExoplayerView view;

    public PictureInPictureReceiver(@NotNull ReactExoplayerView view, @NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = view;
        this.context = context;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent != null && Intrinsics.areEqual(intent.getAction(), ACTION_MEDIA_CONTROL)) {
            int intExtra = intent.getIntExtra(EXTRA_CONTROL_TYPE, 0);
            if (intExtra == 1) {
                this.view.setPausedModifier(false);
            } else {
                if (intExtra != 2) {
                    return;
                }
                this.view.setPausedModifier(true);
            }
        }
    }

    public final void setListener() {
        ContextCompat.registerReceiver(this.context, this, new IntentFilter(ACTION_MEDIA_CONTROL), 4);
    }

    public final void removeListener() {
        try {
            this.context.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    @NotNull
    public final PendingIntent getPipActionIntent(boolean isPaused) {
        int i = isPaused ? 1 : 2;
        Intent intentPutExtra = new Intent(ACTION_MEDIA_CONTROL).putExtra(EXTRA_CONTROL_TYPE, isPaused ? 1 : 2);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        intentPutExtra.setPackage(this.context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(this.context, i, intentPutExtra, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }
}
