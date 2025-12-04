package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.util.Supplier;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.R;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/devsupport/PausedInDebuggerOverlayDialogManager;", "Lcom/facebook/react/devsupport/interfaces/PausedInDebuggerOverlayManager;", "contextSupplier", "Landroidx/core/util/Supplier;", "Landroid/content/Context;", "<init>", "(Landroidx/core/util/Supplier;)V", "pausedInDebuggerDialog", "Landroid/app/Dialog;", "showPausedInDebuggerOverlay", "", "message", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/devsupport/interfaces/DevSupportManager$PausedInDebuggerOverlayCommandListener;", "hidePausedInDebuggerOverlay", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PausedInDebuggerOverlayDialogManager implements PausedInDebuggerOverlayManager {

    @NotNull
    private final Supplier<Context> contextSupplier;

    @Nullable
    private Dialog pausedInDebuggerDialog;

    public PausedInDebuggerOverlayDialogManager(@NotNull Supplier<Context> contextSupplier) {
        Intrinsics.checkNotNullParameter(contextSupplier, "contextSupplier");
        this.contextSupplier = contextSupplier;
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void showPausedInDebuggerOverlay(@NotNull final String message, @NotNull final DevSupportManager.PausedInDebuggerOverlayCommandListener listener) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(listener, "listener");
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PausedInDebuggerOverlayDialogManager.showPausedInDebuggerOverlay$lambda$3(this.f$0, message, listener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPausedInDebuggerOverlay$lambda$3(PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager, String str, final DevSupportManager.PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener) {
        Dialog dialog = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Context context = pausedInDebuggerOverlayDialogManager.contextSupplier.get();
        if (context == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.paused_in_debugger_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        InstrumentationCallbacks.setOnClickListenerCalled(viewInflate.findViewById(R.id.button), new View.OnClickListener() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pausedInDebuggerOverlayCommandListener.onResume();
            }
        });
        ((TextView) viewInflate.findViewById(R.id.button_text)).setText(str);
        Dialog dialog2 = new Dialog(context, R.style.NoAnimationDialog);
        dialog2.setContentView(viewInflate);
        dialog2.setCancelable(false);
        pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog = dialog2;
        Window window = dialog2.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
            attributes.dimAmount = 0.2f;
            window.setAttributes(attributes);
            window.addFlags(2);
            window.setGravity(48);
            window.setElevation(BitmapDescriptorFactory.HUE_RED);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setBackgroundDrawableResource(R.drawable.paused_in_debugger_background);
        }
        Dialog dialog3 = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog3 != null) {
            dialog3.show();
        }
    }

    @Override // com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager
    public void hidePausedInDebuggerOverlay() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.devsupport.PausedInDebuggerOverlayDialogManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PausedInDebuggerOverlayDialogManager.hidePausedInDebuggerOverlay$lambda$4(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hidePausedInDebuggerOverlay$lambda$4(PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager) {
        Dialog dialog = pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        pausedInDebuggerOverlayDialogManager.pausedInDebuggerDialog = null;
    }
}
