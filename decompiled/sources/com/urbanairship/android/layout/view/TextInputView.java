package com.urbanairship.android.layout.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewGroupKt;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.info.TextInputInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.TextInputModel;
import com.urbanairship.android.layout.property.FormInputType;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.widget.TappableView;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0000¢\u0006\u0002\b\"J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0 H\u0016J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00020%0 H\u0000¢\u0006\u0002\b&R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/android/layout/view/TextInputView;", "Landroid/widget/LinearLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/TextInputModel;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/TextInputModel;)V", "clicksChannel", "Lkotlinx/coroutines/channels/Channel;", "", "input", "Landroidx/appcompat/widget/AppCompatEditText;", "getInput", "()Landroidx/appcompat/widget/AppCompatEditText;", "input$delegate", "Lkotlin/Lazy;", "text", "Landroid/text/Editable;", "getText$urbanairship_layout_release", "()Landroid/text/Editable;", "touchListener", "Landroid/view/View$OnTouchListener;", "makeLocalePicker", "Landroid/view/View;", "makeTextInput", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onEditing", "Lkotlinx/coroutines/flow/Flow;", "", "onEditing$urbanairship_layout_release", "taps", "textChanges", "", "textChanges$urbanairship_layout_release", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TextInputView extends LinearLayout implements BaseView, TappableView {
    private final Channel clicksChannel;

    /* renamed from: input$delegate, reason: from kotlin metadata */
    private final Lazy input;
    private final View.OnTouchListener touchListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputView(@NotNull final Context context, @NotNull final TextInputModel model) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.clicksChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.input = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.layout.view.TextInputView$input$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AppCompatEditText invoke() {
                return this.this$0.makeTextInput(model);
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.urbanairship.android.layout.view.TextInputView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TextInputView.touchListener$lambda$0(this.f$0, view, motionEvent);
            }
        };
        this.touchListener = onTouchListener;
        setBackground(null);
        setClipToOutline(true);
        LayoutUtils.applyTextInputModel(getInput(), model);
        StringExtensionsKt.ifNotEmpty(model.contentDescription(context), new Function1() { // from class: com.urbanairship.android.layout.view.TextInputView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                TextInputView.this.setContentDescription(it);
            }
        });
        model.setListener$urbanairship_layout_release(new TextInputModel.Listener() { // from class: com.urbanairship.android.layout.view.TextInputView.2
            @Override // com.urbanairship.android.layout.model.TextInputModel.Listener
            public void restoreValue(@NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                Editable text = TextInputView.this.getInput().getText();
                if (text == null || text.length() == 0) {
                    TextInputView.this.getInput().setText(value);
                }
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                TextInputView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                TextInputView.this.setEnabled(enabled);
                Iterator<View> it = ViewGroupKt.getChildren(TextInputView.this).iterator();
                while (it.hasNext()) {
                    it.next().setEnabled(enabled);
                }
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background) {
                Intrinsics.checkNotNullParameter(background, "new");
                LayoutUtils.updateBackground(TextInputView.this, old, background);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void onStateUpdated(@NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                TextInputInfo.ViewOverrides viewOverrides = model.getViewInfo().getViewOverrides();
                TextInputInfo.IconEnd iconEnd = (TextInputInfo.IconEnd) state.resolveOptional(viewOverrides != null ? viewOverrides.getIconEnd() : null, model.getViewInfo().getIconEnd());
                Drawable drawable = iconEnd instanceof TextInputInfo.IconEnd.Floating ? ((TextInputInfo.IconEnd.Floating) iconEnd).getIcon().getDrawable(context, TextInputView.this.isEnabled()) : null;
                if (drawable != null) {
                    int iSpToPx = (int) ResourceUtils.spToPx(context, model.getViewInfo().getTextAppearance().getFontSize());
                    drawable.setBounds(0, 0, iSpToPx, iSpToPx);
                }
                if (ViewExtensionsKt.isLayoutRtl(TextInputView.this)) {
                    TextInputView.this.getInput().setCompoundDrawables(drawable, null, null, null);
                } else {
                    TextInputView.this.getInput().setCompoundDrawables(null, null, drawable, null);
                }
            }
        });
        setOnTouchListener(onTouchListener);
        if (model.getViewInfo().getInputType() == FormInputType.SMS && model.getViewInfo().getSmsLocales() != null) {
            addView(makeLocalePicker(context, model), new LinearLayout.LayoutParams(-2, -1));
        }
        addView(getInput(), new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatEditText getInput() {
        return (AppCompatEditText) this.input.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$0(TextInputView this$0, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        v.getParent().requestDisallowInterceptTouchEvent(true);
        if (ViewExtensionsKt.isActionUp(event)) {
            v.getParent().requestDisallowInterceptTouchEvent(false);
            this$0.clicksChannel.mo3620trySendJP2dKIU(Unit.INSTANCE);
        }
        return false;
    }

    @NotNull
    public final Flow<String> textChanges$urbanairship_layout_release() {
        return ViewExtensionsKt.m2745textChangesHG0u8IE$default(getInput(), 0L, 1, null);
    }

    @NotNull
    public final Flow<Boolean> onEditing$urbanairship_layout_release() {
        return ViewExtensionsKt.m2743onEditingHG0u8IE$default(getInput(), 0L, 1, null);
    }

    @Nullable
    public final Editable getText$urbanairship_layout_release() {
        return getInput().getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppCompatEditText makeTextInput(TextInputModel model) {
        AppCompatEditText appCompatEditText = new AppCompatEditText(getContext());
        appCompatEditText.setMovementMethod(new ScrollingMovementMethod());
        appCompatEditText.setBackground(null);
        appCompatEditText.setClipToOutline(true);
        return appCompatEditText;
    }

    private final View makeLocalePicker(Context context, final TextInputModel model) {
        List<SmsLocale> smsLocales = model.getViewInfo().getSmsLocales();
        if (smsLocales == null) {
            smsLocales = CollectionsKt.emptyList();
        }
        final SmsLocaleAdapter smsLocaleAdapter = new SmsLocaleAdapter(context, smsLocales, model.getViewInfo().getTextAppearance());
        Spinner spinner = new Spinner(context);
        spinner.setBackground(null);
        spinner.setBackgroundColor(R.color.transparent);
        spinner.setAdapter((SpinnerAdapter) smsLocaleAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbanairship.android.layout.view.TextInputView$makeLocalePicker$1$1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(@Nullable AdapterView<?> p0) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(@Nullable AdapterView<?> p0, @Nullable View p1, int p2, long p3) {
                SmsLocale item = smsLocaleAdapter.getItem(p2);
                AppCompatEditText input = this.getInput();
                String hintText = model.getViewInfo().getHintText();
                if (hintText == null) {
                    hintText = item.getPrefix();
                }
                input.setHint(hintText);
                model.onNewLocale$urbanairship_layout_release(item);
            }
        });
        return spinner;
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        outAttrs.imeOptions |= 301989888;
        return super.onCreateInputConnection(outAttrs);
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return FlowKt.receiveAsFlow(this.clicksChannel);
    }
}
