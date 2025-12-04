package com.disney.id.android.lightbox;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.disney.id.android.SCALPController;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.databinding.OneidBrowserPromptBinding;
import com.disney.id.android.logging.Logger;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/disney/id/android/lightbox/BrowserPromptDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/disney/id/android/databinding/OneidBrowserPromptBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/lightbox/BrowserPromptDialog$BrowserPromptListener;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "scalpController", "Lcom/disney/id/android/SCALPController;", "getScalpController$OneID_release", "()Lcom/disney/id/android/SCALPController;", "setScalpController$OneID_release", "(Lcom/disney/id/android/SCALPController;)V", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "BrowserPromptListener", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BrowserPromptDialog extends DialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = BrowserPromptDialog.class.getSimpleName();
    private OneidBrowserPromptBinding binding;
    private BrowserPromptListener listener;

    @Inject
    public Logger logger;

    @Inject
    public SCALPController scalpController;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/disney/id/android/lightbox/BrowserPromptDialog$BrowserPromptListener;", "", "onApprove", "", "onDeny", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface BrowserPromptListener {
        void onApprove();

        void onDeny();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        InstrumentationCallbacks.onPauseCalled(this);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        InstrumentationCallbacks.onResumeCalled(this);
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    public BrowserPromptDialog() {
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final SCALPController getScalpController$OneID_release() {
        SCALPController sCALPController = this.scalpController;
        if (sCALPController != null) {
            return sCALPController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpController");
        return null;
    }

    public final void setScalpController$OneID_release(@NotNull SCALPController sCALPController) {
        Intrinsics.checkNotNullParameter(sCALPController, "<set-?>");
        this.scalpController = sCALPController;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/disney/id/android/lightbox/BrowserPromptDialog$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "URI_KEY", "getDialog", "Lcom/disney/id/android/lightbox/BrowserPromptDialog;", "targetUri", "Landroid/net/Uri;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/lightbox/BrowserPromptDialog$BrowserPromptListener;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return BrowserPromptDialog.TAG;
        }

        @NotNull
        public final BrowserPromptDialog getDialog(@NotNull Uri targetUri, @NotNull BrowserPromptListener listener) {
            Intrinsics.checkNotNullParameter(targetUri, "targetUri");
            Intrinsics.checkNotNullParameter(listener, "listener");
            BrowserPromptDialog browserPromptDialog = new BrowserPromptDialog();
            Logger logger$OneID_release = browserPromptDialog.getLogger$OneID_release();
            String tAG$OneID_release = getTAG$OneID_release();
            Intrinsics.checkNotNullExpressionValue(tAG$OneID_release, "<get-TAG>(...)");
            Logger.DefaultImpls.d$default(logger$OneID_release, tAG$OneID_release, "Getting dialog for URI // " + targetUri, null, 4, null);
            Bundle bundle = new Bundle();
            bundle.putParcelable(ReactNativeBlobUtilConst.DATA_ENCODE_URI, targetUri);
            browserPromptDialog.setArguments(bundle);
            browserPromptDialog.listener = listener;
            return browserPromptDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        BrowserPromptListener browserPromptListener = this.listener;
        if (browserPromptListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            browserPromptListener = null;
        }
        browserPromptListener.onDeny();
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.Theme.Material.Light.Dialog);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        OneidBrowserPromptBinding oneidBrowserPromptBindingInflate = OneidBrowserPromptBinding.inflate(inflater, container, false);
        this.binding = oneidBrowserPromptBindingInflate;
        LinearLayout root = oneidBrowserPromptBindingInflate != null ? oneidBrowserPromptBindingInflate.getRoot() : null;
        if (root != null) {
            return root;
        }
        throw new NullPointerException("Expression 'binding' must not be null");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Button button;
        Button button2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        OneidBrowserPromptBinding oneidBrowserPromptBinding = this.binding;
        if (oneidBrowserPromptBinding != null && (button2 = oneidBrowserPromptBinding.okButton) != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button2, new View.OnClickListener() { // from class: com.disney.id.android.lightbox.BrowserPromptDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BrowserPromptDialog.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        OneidBrowserPromptBinding oneidBrowserPromptBinding2 = this.binding;
        if (oneidBrowserPromptBinding2 != null && (button = oneidBrowserPromptBinding2.cancelButton) != null) {
            InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.disney.id.android.lightbox.BrowserPromptDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BrowserPromptDialog.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        Bundle arguments = getArguments();
        Uri uri = arguments != null ? (Uri) arguments.getParcelable(ReactNativeBlobUtilConst.DATA_ENCODE_URI) : null;
        if (uri != null) {
            OneidBrowserPromptBinding oneidBrowserPromptBinding3 = this.binding;
            TextView textView = oneidBrowserPromptBinding3 != null ? oneidBrowserPromptBinding3.target : null;
            if (textView != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.US, "%s://%s", Arrays.copyOf(new Object[]{uri.getScheme(), uri.getHost()}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                textView.setText(str);
            }
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setTitle(getScalpController$OneID_release().getMessage("DIALOG_OPEN_IN_WEB_BROWSER"));
        }
        OneidBrowserPromptBinding oneidBrowserPromptBinding4 = this.binding;
        Button button3 = oneidBrowserPromptBinding4 != null ? oneidBrowserPromptBinding4.okButton : null;
        if (button3 != null) {
            button3.setText(getScalpController$OneID_release().getMessage("DIALOG_OK"));
        }
        OneidBrowserPromptBinding oneidBrowserPromptBinding5 = this.binding;
        Button button4 = oneidBrowserPromptBinding5 != null ? oneidBrowserPromptBinding5.cancelButton : null;
        if (button4 == null) {
            return;
        }
        button4.setText(getScalpController$OneID_release().getMessage("DIALOG_CANCEL"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(BrowserPromptDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BrowserPromptListener browserPromptListener = this$0.listener;
        if (browserPromptListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            browserPromptListener = null;
        }
        browserPromptListener.onApprove();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(BrowserPromptDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BrowserPromptListener browserPromptListener = this$0.listener;
        if (browserPromptListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            browserPromptListener = null;
        }
        browserPromptListener.onDeny();
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.45f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
        return dialogOnCreateDialog;
    }
}
