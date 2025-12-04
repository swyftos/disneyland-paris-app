package com.urbanairship.android.layout.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes5.dex */
final class ViewExtensionsKt$onEditing$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ long $idleDelay;
    final /* synthetic */ EditText $this_onEditing;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewExtensionsKt$onEditing$1(EditText editText, long j, Continuation continuation) {
        super(2, continuation);
        this.$this_onEditing = editText;
        this.$idleDelay = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ViewExtensionsKt$onEditing$1 viewExtensionsKt$onEditing$1 = new ViewExtensionsKt$onEditing$1(this.$this_onEditing, this.$idleDelay, continuation);
        viewExtensionsKt$onEditing$1.L$0 = obj;
        return viewExtensionsKt$onEditing$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((ViewExtensionsKt$onEditing$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.text.TextWatcher, com.urbanairship.android.layout.util.ViewExtensionsKt$onEditing$1$textWatcher$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            ViewExtensionsKt.checkMainThread();
            InstrumentationCallbacks.setOnFocusChangeListenerCalled(this.$this_onEditing, new View.OnFocusChangeListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$onEditing$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ViewExtensionsKt$onEditing$1.invokeSuspend$lambda$0(producerScope, view, z);
                }
            });
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
            final long j = this.$idleDelay;
            final ?? r9 = new TextWatcher() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$onEditing$1$textWatcher$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s, int start, int before, int count) {
                    Intrinsics.checkNotNullParameter(s, "s");
                }

                /* JADX WARN: Type inference failed for: r6v2, types: [T, kotlinx.coroutines.Job] */
                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s, int start, int count, int after) {
                    Intrinsics.checkNotNullParameter(s, "s");
                    producerScope.mo3620trySendJP2dKIU(Boolean.TRUE);
                    Job job = (Job) objectRef.element;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    objectRef.element = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new ViewExtensionsKt$onEditing$1$textWatcher$1$beforeTextChanged$1(j, producerScope, null), 3, null);
                }
            };
            this.$this_onEditing.addTextChangedListener(r9);
            this.$this_onEditing.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$onEditing$1$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return ViewExtensionsKt$onEditing$1.invokeSuspend$lambda$1(producerScope, objectRef, textView, i2, keyEvent);
                }
            });
            final EditText editText = this.$this_onEditing;
            Function0 function0 = new Function0() { // from class: com.urbanairship.android.layout.util.ViewExtensionsKt$onEditing$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2749invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2749invoke() {
                    InstrumentationCallbacks.setOnFocusChangeListenerCalled(editText, null);
                    editText.setOnEditorActionListener(null);
                    editText.removeTextChangedListener(r9);
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, View view, boolean z) {
        producerScope.mo3620trySendJP2dKIU(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$1(ProducerScope producerScope, Ref.ObjectRef objectRef, TextView textView, int i, KeyEvent keyEvent) {
        boolean z = i == 3 || i == 6;
        if ((keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66) && !z) {
            return false;
        }
        producerScope.mo3620trySendJP2dKIU(Boolean.FALSE);
        Job job = (Job) objectRef.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        return true;
    }
}
