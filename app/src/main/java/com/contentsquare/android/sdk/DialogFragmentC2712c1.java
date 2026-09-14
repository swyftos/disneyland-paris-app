package com.contentsquare.android.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.C2362R;
import com.contentsquare.android.core.features.logging.Logger;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c1 */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ValidFragment"})
public final class DialogFragmentC2712c1 extends DialogFragment {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final Logger f2422a = new Logger("DialogManager");

    /* JADX INFO: renamed from: b */
    @Nullable
    public View f2423b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public View f2424c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public TextView f2425d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public ProgressBar f2426e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public ProgressBar f2427f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public ImageView f2428g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public TextView f2429h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public View f2430i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Button f2431j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public Button f2432k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C2722d1 f2433l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public b f2434m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public InterfaceC2732e1 f2435n;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c1$a */
    public static final class a extends Lambda implements Function1<C2722d1, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(C2722d1 c2722d1) {
            C2722d1 it = c2722d1;
            Intrinsics.checkNotNullParameter(it, "it");
            DialogFragmentC2712c1.this.m1107a(it);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c1$b */
    public static final class b extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Continuation<Unit> f2437a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SafeContinuation safeContinuation) {
            super(0);
            this.f2437a = safeContinuation;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Continuation<Unit> continuation = this.f2437a;
            Result.Companion companion = Result.INSTANCE;
            Unit unit = Unit.INSTANCE;
            continuation.resumeWith(Result.m5277constructorimpl(unit));
            return unit;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1106a() {
        View view = this.f2423b;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.contentsquare.android.sdk.c1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DialogFragmentC2712c1.m1102a(this.f$0);
                }
            }, 1500L);
        }
    }

    @Override // android.app.DialogFragment
    public final void dismiss() {
        this.f2433l = null;
        TextView textView = this.f2425d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.f2429h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view = this.f2430i;
        if (view != null) {
            view.setVisibility(8);
        }
        Button button = this.f2431j;
        if (button != null) {
            button.setVisibility(8);
        }
        Button button2 = this.f2432k;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        ProgressBar progressBar = this.f2426e;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ProgressBar progressBar2 = this.f2427f;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        ImageView imageView = this.f2428g;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ProgressBar progressBar3 = this.f2426e;
        if (progressBar3 != null) {
            progressBar3.setProgress(0);
        }
        if (isAdded()) {
            try {
                super.dismiss();
            } catch (IllegalStateException e) {
                C2599Q2.m1011a(this.f2422a, "Dismiss of DialogManager failed", e);
            }
        }
    }

    @Override // android.app.DialogFragment
    @NotNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        final Dialog dialogOnCreateDialog = super.onCreateDialog(bundle);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCancelable(false);
        dialogOnCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.contentsquare.android.sdk.c1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogFragmentC2712c1.m1103a(this.f$0, dialogOnCreateDialog, dialogInterface);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…)\n            }\n        }");
        return dialogOnCreateDialog;
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(inflater.getContext(), C2362R.style.contentsquare_AppTheme)).inflate(C2362R.layout.contentsquare_dialog, viewGroup, true);
        View viewFindViewById = viewInflate.findViewById(C2362R.id.dialog_container);
        viewFindViewById.setVisibility(4);
        this.f2424c = viewFindViewById;
        this.f2425d = (TextView) viewInflate.findViewById(C2362R.id.title);
        this.f2426e = (ProgressBar) viewInflate.findViewById(C2362R.id.linear_progress_bar);
        this.f2427f = (ProgressBar) viewInflate.findViewById(C2362R.id.circular_progress_bar);
        this.f2428g = (ImageView) viewInflate.findViewById(C2362R.id.icon);
        this.f2429h = (TextView) viewInflate.findViewById(C2362R.id.summary);
        this.f2430i = viewInflate.findViewById(C2362R.id.buttons_container);
        this.f2431j = (Button) viewInflate.findViewById(C2362R.id.primary_button);
        this.f2432k = (Button) viewInflate.findViewById(C2362R.id.secondary_button);
        this.f2423b = viewInflate;
        C2722d1 c2722d1 = this.f2433l;
        if (c2722d1 != null) {
            m1107a(c2722d1);
        }
        return this.f2423b;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        InterfaceC2732e1 interfaceC2732e1 = this.f2435n;
        if (interfaceC2732e1 != null) {
            interfaceC2732e1.mo992a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        InstrumentationCallbacks.onStartCalled(this);
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        InstrumentationCallbacks.onStopCalled(this);
        super.onStop();
    }

    /* JADX INFO: renamed from: a */
    public static final void m1102a(DialogFragmentC2712c1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: renamed from: a */
    public static final void m1103a(DialogFragmentC2712c1 this$0, Dialog dialog, DialogInterface dialogInterface) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.f2434m;
        if (bVar != null) {
            bVar.invoke();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1107a(C2722d1 c2722d1) {
        this.f2433l = c2722d1;
        AbstractC2898u7 abstractC2898u7 = c2722d1.f2486a;
        if (abstractC2898u7 instanceof AbstractC2898u7.a) {
            TextView textView = this.f2425d;
            if (textView != null) {
                textView.setText(((AbstractC2898u7.a) abstractC2898u7).f3158a);
            }
        } else if (abstractC2898u7 instanceof AbstractC2898u7.b) {
            TextView textView2 = this.f2425d;
            if (textView2 != null) {
                textView2.setText(((AbstractC2898u7.b) abstractC2898u7).f3159a);
            }
        } else {
            TextView textView3 = this.f2425d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = this.f2425d;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        AbstractC2898u7 abstractC2898u8 = c2722d1.f2487b;
        if (abstractC2898u8 instanceof AbstractC2898u7.a) {
            TextView textView5 = this.f2429h;
            if (textView5 != null) {
                textView5.setText(((AbstractC2898u7.a) abstractC2898u8).f3158a);
            }
        } else if (abstractC2898u8 instanceof AbstractC2898u7.b) {
            TextView textView6 = this.f2429h;
            if (textView6 != null) {
                textView6.setText(((AbstractC2898u7.b) abstractC2898u8).f3159a);
            }
        } else {
            TextView textView7 = this.f2429h;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        TextView textView8 = this.f2429h;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        AbstractC2725d4 abstractC2725d4 = c2722d1.f2488c;
        if (abstractC2725d4 instanceof AbstractC2725d4.a) {
            ProgressBar progressBar = this.f2426e;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ImageView imageView = this.f2428g;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ProgressBar progressBar2 = this.f2427f;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        } else if (abstractC2725d4 instanceof AbstractC2725d4.c) {
            ProgressBar progressBar3 = this.f2427f;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
            ImageView imageView2 = this.f2428g;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ProgressBar progressBar4 = this.f2426e;
            if (progressBar4 != null) {
                progressBar4.setVisibility(0);
            }
            ProgressBar progressBar5 = this.f2426e;
            if (progressBar5 != null) {
                progressBar5.setProgress(((AbstractC2725d4.c) abstractC2725d4).f2498a);
            }
        } else if (abstractC2725d4 instanceof AbstractC2725d4.b) {
            ProgressBar progressBar6 = this.f2426e;
            if (progressBar6 != null) {
                progressBar6.setVisibility(8);
            }
            ProgressBar progressBar7 = this.f2427f;
            if (progressBar7 != null) {
                progressBar7.setVisibility(8);
            }
            ImageView imageView3 = this.f2428g;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.f2428g;
            if (imageView4 != null) {
                imageView4.setImageResource(((AbstractC2725d4.b) abstractC2725d4).f2497a);
            }
        } else {
            ProgressBar progressBar8 = this.f2426e;
            if (progressBar8 != null) {
                progressBar8.setVisibility(8);
            }
            ProgressBar progressBar9 = this.f2427f;
            if (progressBar9 != null) {
                progressBar9.setVisibility(8);
            }
            ImageView imageView5 = this.f2428g;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        }
        C2801l0 c2801l0 = c2722d1.f2489d;
        C2801l0 c2801l1 = c2722d1.f2490e;
        m1101a(this.f2431j, c2801l0);
        m1101a(this.f2432k, c2801l1);
        if (c2801l0 == null && c2801l1 == null) {
            View view = this.f2430i;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            View view2 = this.f2430i;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        View view3 = this.f2424c;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final Object m1105a(@NotNull Activity activity, @NotNull InterfaceC2732e1 interfaceC2732e1, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        if (!isAdded()) {
            this.f2435n = interfaceC2732e1;
            show(activity.getFragmentManager(), "ContentSquare Dialog");
            interfaceC2732e1.mo993a(new a());
            this.f2434m = new b(safeContinuation);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: a */
    public static void m1101a(Button button, final C2801l0 c2801l0) {
        Unit unit;
        if (c2801l0 != null) {
            if (button != null) {
                button.setText(c2801l0.f2841a);
            }
            if (button != null) {
                InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.c1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogFragmentC2712c1.m1104a(c2801l0, view);
                    }
                });
            }
            if (button != null) {
                button.setVisibility(0);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit != null || button == null) {
            return;
        }
        button.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    public static final void m1104a(C2801l0 config, View view) {
        Intrinsics.checkNotNullParameter(config, "$config");
        config.f2842b.invoke();
    }
}
