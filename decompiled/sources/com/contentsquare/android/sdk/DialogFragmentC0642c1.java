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
import com.contentsquare.android.R;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0655d4;
import com.contentsquare.android.sdk.AbstractC0827u7;
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

@SuppressLint({"ValidFragment"})
/* renamed from: com.contentsquare.android.sdk.c1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogFragmentC0642c1 extends DialogFragment {

    @NotNull
    public final Logger a = new Logger("DialogManager");

    @Nullable
    public View b;

    @Nullable
    public View c;

    @Nullable
    public TextView d;

    @Nullable
    public ProgressBar e;

    @Nullable
    public ProgressBar f;

    @Nullable
    public ImageView g;

    @Nullable
    public TextView h;

    @Nullable
    public View i;

    @Nullable
    public Button j;

    @Nullable
    public Button k;

    @Nullable
    public C0652d1 l;

    @Nullable
    public b m;

    @Nullable
    public InterfaceC0662e1 n;

    /* renamed from: com.contentsquare.android.sdk.c1$a */
    public static final class a extends Lambda implements Function1<C0652d1, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(C0652d1 c0652d1) {
            C0652d1 it = c0652d1;
            Intrinsics.checkNotNullParameter(it, "it");
            DialogFragmentC0642c1.this.a(it);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.c1$b */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Continuation<Unit> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SafeContinuation safeContinuation) {
            super(0);
            this.a = safeContinuation;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            Continuation<Unit> continuation = this.a;
            Result.Companion companion = Result.INSTANCE;
            Unit unit = Unit.INSTANCE;
            continuation.resumeWith(Result.m2968constructorimpl(unit));
            return unit;
        }
    }

    public final void a() {
        View view = this.b;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.contentsquare.android.sdk.c1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DialogFragmentC0642c1.a(this.f$0);
                }
            }, 1500L);
        }
    }

    @Override // android.app.DialogFragment
    public final void dismiss() {
        this.l = null;
        TextView textView = this.d;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        Button button = this.j;
        if (button != null) {
            button.setVisibility(8);
        }
        Button button2 = this.k;
        if (button2 != null) {
            button2.setVisibility(8);
        }
        ProgressBar progressBar = this.e;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        ProgressBar progressBar2 = this.f;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ProgressBar progressBar3 = this.e;
        if (progressBar3 != null) {
            progressBar3.setProgress(0);
        }
        if (isAdded()) {
            try {
                super.dismiss();
            } catch (IllegalStateException e) {
                Q2.a(this.a, "Dismiss of DialogManager failed", e);
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
                DialogFragmentC0642c1.a(this.f$0, dialogOnCreateDialog, dialogInterface);
            }
        });
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "super.onCreateDialog(sav…)\n            }\n        }");
        return dialogOnCreateDialog;
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(inflater.getContext(), R.style.contentsquare_AppTheme)).inflate(R.layout.contentsquare_dialog, viewGroup, true);
        View viewFindViewById = viewInflate.findViewById(R.id.dialog_container);
        viewFindViewById.setVisibility(4);
        this.c = viewFindViewById;
        this.d = (TextView) viewInflate.findViewById(R.id.title);
        this.e = (ProgressBar) viewInflate.findViewById(R.id.linear_progress_bar);
        this.f = (ProgressBar) viewInflate.findViewById(R.id.circular_progress_bar);
        this.g = (ImageView) viewInflate.findViewById(R.id.icon);
        this.h = (TextView) viewInflate.findViewById(R.id.summary);
        this.i = viewInflate.findViewById(R.id.buttons_container);
        this.j = (Button) viewInflate.findViewById(R.id.primary_button);
        this.k = (Button) viewInflate.findViewById(R.id.secondary_button);
        this.b = viewInflate;
        C0652d1 c0652d1 = this.l;
        if (c0652d1 != null) {
            a(c0652d1);
        }
        return this.b;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        InterfaceC0662e1 interfaceC0662e1 = this.n;
        if (interfaceC0662e1 != null) {
            interfaceC0662e1.a();
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

    public static final void a(DialogFragmentC0642c1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void a(DialogFragmentC0642c1 this$0, Dialog dialog, DialogInterface dialogInterface) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.m;
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

    public final void a(C0652d1 c0652d1) {
        this.l = c0652d1;
        AbstractC0827u7 abstractC0827u7 = c0652d1.a;
        if (abstractC0827u7 instanceof AbstractC0827u7.a) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(((AbstractC0827u7.a) abstractC0827u7).a);
            }
        } else if (abstractC0827u7 instanceof AbstractC0827u7.b) {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setText(((AbstractC0827u7.b) abstractC0827u7).a);
            }
        } else {
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = this.d;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
        AbstractC0827u7 abstractC0827u72 = c0652d1.b;
        if (abstractC0827u72 instanceof AbstractC0827u7.a) {
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.setText(((AbstractC0827u7.a) abstractC0827u72).a);
            }
        } else if (abstractC0827u72 instanceof AbstractC0827u7.b) {
            TextView textView6 = this.h;
            if (textView6 != null) {
                textView6.setText(((AbstractC0827u7.b) abstractC0827u72).a);
            }
        } else {
            TextView textView7 = this.h;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        TextView textView8 = this.h;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
        AbstractC0655d4 abstractC0655d4 = c0652d1.c;
        if (abstractC0655d4 instanceof AbstractC0655d4.a) {
            ProgressBar progressBar = this.e;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ProgressBar progressBar2 = this.f;
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        } else if (abstractC0655d4 instanceof AbstractC0655d4.c) {
            ProgressBar progressBar3 = this.f;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
            ImageView imageView2 = this.g;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ProgressBar progressBar4 = this.e;
            if (progressBar4 != null) {
                progressBar4.setVisibility(0);
            }
            ProgressBar progressBar5 = this.e;
            if (progressBar5 != null) {
                progressBar5.setProgress(((AbstractC0655d4.c) abstractC0655d4).a);
            }
        } else if (abstractC0655d4 instanceof AbstractC0655d4.b) {
            ProgressBar progressBar6 = this.e;
            if (progressBar6 != null) {
                progressBar6.setVisibility(8);
            }
            ProgressBar progressBar7 = this.f;
            if (progressBar7 != null) {
                progressBar7.setVisibility(8);
            }
            ImageView imageView3 = this.g;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageView imageView4 = this.g;
            if (imageView4 != null) {
                imageView4.setImageResource(((AbstractC0655d4.b) abstractC0655d4).a);
            }
        } else {
            ProgressBar progressBar8 = this.e;
            if (progressBar8 != null) {
                progressBar8.setVisibility(8);
            }
            ProgressBar progressBar9 = this.f;
            if (progressBar9 != null) {
                progressBar9.setVisibility(8);
            }
            ImageView imageView5 = this.g;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        }
        C0731l0 c0731l0 = c0652d1.d;
        C0731l0 c0731l02 = c0652d1.e;
        a(this.j, c0731l0);
        a(this.k, c0731l02);
        if (c0731l0 == null && c0731l02 == null) {
            View view = this.i;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            View view2 = this.i;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
        View view3 = this.c;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    @Nullable
    public final Object a(@NotNull Activity activity, @NotNull InterfaceC0662e1 interfaceC0662e1, @NotNull Continuation<? super Unit> continuation) throws Throwable {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        if (!isAdded()) {
            this.n = interfaceC0662e1;
            show(activity.getFragmentManager(), "ContentSquare Dialog");
            interfaceC0662e1.a(new a());
            this.m = new b(safeContinuation);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    public static void a(Button button, final C0731l0 c0731l0) {
        Unit unit;
        if (c0731l0 != null) {
            if (button != null) {
                button.setText(c0731l0.a);
            }
            if (button != null) {
                InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.contentsquare.android.sdk.c1$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DialogFragmentC0642c1.a(c0731l0, view);
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

    public static final void a(C0731l0 config, View view) {
        Intrinsics.checkNotNullParameter(config, "$config");
        config.b.invoke();
    }
}
