package com.urbanairship.preferencecenter.widget;

import android.R;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import ch.qos.logback.core.CoreConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.util.StringExtensionsKt;
import com.urbanairship.preferencecenter.util.ViewExtensionsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0002?@B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010.\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u000bH\u0002J\u0010\u00103\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u000bH\u0002J\u0016\u00104\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u00020(06H\u0002J\u0010\u00107\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0016\u0010<\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010=\u001a\u00020>R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001a\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010*\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00170 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Landroid/widget/ArrayAdapter;", "", "getAdapter", "()Landroid/widget/ArrayAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "countryPickerInputView", "Lcom/google/android/material/textfield/TextInputLayout;", "countryPickerTextView", "Landroid/widget/AutoCompleteTextView;", "footerView", "Landroid/widget/TextView;", "isValid", "", "onSubmit", "Lkotlin/Function0;", "", "getOnSubmit", "()Lkotlin/jvm/functions/Function0;", "setOnSubmit", "(Lkotlin/jvm/functions/Function0;)V", "onValidationChanged", "Lkotlin/Function1;", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function1;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function1;)V", DeferredApiClient.KEY_PLATFORM, "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "selectedSender", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo;", "textInputView", "validator", "Lkotlin/ParameterName;", "name", "input", "getFormattedAddress", "getResult", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "setAddressLabel", "text", "setAddressPlaceholder", "setCountryCodes", "senders", "", "setCountryPickerLabel", "setError", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "setFooter", "formattedText", "setPlatform", "display", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "Companion", "DialogResult", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactChannelDialogInputView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannelDialogInputView.kt\ncom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,225:1\n1#2:226\n1549#3:227\n1620#3,3:228\n256#4,2:231\n*S KotlinDebug\n*F\n+ 1 ContactChannelDialogInputView.kt\ncom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView\n*L\n172#1:227\n172#1:228,3\n188#1:231,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactChannelDialogInputView extends FrameLayout {
    private static final Companion Companion = new Companion(null);

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private final TextInputLayout countryPickerInputView;
    private final AutoCompleteTextView countryPickerTextView;
    private final TextView footerView;
    private boolean isValid;
    private Function0 onSubmit;
    private Function1 onValidationChanged;
    private Item.ContactManagement.Platform platform;
    private Item.ContactManagement.SmsSenderInfo selectedSender;
    private final TextInputLayout textInputView;
    private final Function1 validator;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContactChannelDialogInputView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContactChannelDialogInputView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContactChannelDialogInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ContactChannelDialogInputView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adapter = LazyKt.lazy(new Function0() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView$adapter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ArrayAdapter invoke() {
                return new ArrayAdapter(context, R.layout.simple_dropdown_item_1line);
            }
        });
        this.validator = new Function1() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView$validator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Item.ContactManagement.Platform platform = this.this$0.platform;
                boolean z = true;
                if (!(platform instanceof Item.ContactManagement.Platform.Email) ? !(platform instanceof Item.ContactManagement.Platform.Sms) || str == null || StringsKt.isBlank(str) : str == null || StringsKt.isBlank(str)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        View.inflate(context, com.urbanairship.preferencecenter.R.layout.ua_contact_channel_dialog_input, this);
        View viewFindViewById = findViewById(com.urbanairship.preferencecenter.R.id.text_input);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        TextInputLayout textInputLayout = (TextInputLayout) viewFindViewById;
        this.textInputView = textInputLayout;
        View viewFindViewById2 = findViewById(com.urbanairship.preferencecenter.R.id.footer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.footerView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(com.urbanairship.preferencecenter.R.id.country_picker_input);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.countryPickerInputView = (TextInputLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(com.urbanairship.preferencecenter.R.id.country_picker_text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.countryPickerTextView = (AutoCompleteTextView) viewFindViewById4;
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable s) {
                    ContactChannelDialogInputView contactChannelDialogInputView = ContactChannelDialogInputView.this;
                    contactChannelDialogInputView.isValid = ((Boolean) contactChannelDialogInputView.validator.invoke(s != null ? s.toString() : null)).booleanValue();
                    Function1<Boolean, Unit> onValidationChanged = ContactChannelDialogInputView.this.getOnValidationChanged();
                    if (onValidationChanged != null) {
                        onValidationChanged.invoke(Boolean.valueOf(ContactChannelDialogInputView.this.isValid));
                    }
                }
            });
        }
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null) {
            editText2.setImeOptions(6);
            editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return ContactChannelDialogInputView.lambda$2$lambda$0(this.f$0, textView, i2, keyEvent);
                }
            });
            editText2.setOnKeyListener(new View.OnKeyListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    return ContactChannelDialogInputView.lambda$2$lambda$1(this.f$0, view, i2, keyEvent);
                }
            });
        }
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnValidationChanged() {
        return this.onValidationChanged;
    }

    public final void setOnValidationChanged(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onValidationChanged = function1;
    }

    @Nullable
    public final Function0<Unit> getOnSubmit() {
        return this.onSubmit;
    }

    public final void setOnSubmit(@Nullable Function0<Unit> function0) {
        this.onSubmit = function0;
    }

    private final ArrayAdapter<String> getAdapter() {
        return (ArrayAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lambda$2$lambda$0(ContactChannelDialogInputView this$0, TextView textView, int i, KeyEvent keyEvent) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 6) {
            return false;
        }
        if (this$0.isValid && (function0 = this$0.onSubmit) != null) {
            function0.invoke();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lambda$2$lambda$1(ContactChannelDialogInputView this$0, View view, int i, KeyEvent keyEvent) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i != 66 || keyEvent.getAction() != 0) {
            return false;
        }
        if (this$0.isValid && (function0 = this$0.onSubmit) != null) {
            function0.invoke();
        }
        return true;
    }

    public final void setPlatform(@NotNull Item.ContactManagement.Platform platform, @NotNull Item.ContactManagement.PromptDisplay display) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(display, "display");
        this.platform = platform;
        if (platform instanceof Item.ContactManagement.Platform.Email) {
            Item.ContactManagement.Platform.Email email = (Item.ContactManagement.Platform.Email) platform;
            setAddressLabel(email.getRegistrationOptions().getAddressLabel());
            String placeholder = email.getRegistrationOptions().getPlaceholder();
            if (placeholder != null) {
                setAddressPlaceholder(placeholder);
            }
            EditText editText = this.textInputView.getEditText();
            if (editText != null) {
                editText.setInputType(32);
            }
        } else if (platform instanceof Item.ContactManagement.Platform.Sms) {
            Item.ContactManagement.Platform.Sms sms = (Item.ContactManagement.Platform.Sms) platform;
            setAddressLabel(sms.getRegistrationOptions().getPhoneLabel());
            setCountryPickerLabel(sms.getRegistrationOptions().getCountryLabel());
            setCountryCodes(sms.getRegistrationOptions().getSenders());
            EditText editText2 = this.textInputView.getEditText();
            if (editText2 != null) {
                editText2.setInputType(3);
            }
        }
        String footer = display.getFooter();
        if (footer != null) {
            setFooter(footer);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "Email", "Sms", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult$Email;", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult$Sms;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class DialogResult {
        public /* synthetic */ DialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract String getAddress();

        private DialogResult() {
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult$Email;", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "address", "", "(Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Email extends DialogResult {
            private final String address;

            public static /* synthetic */ Email copy$default(Email email, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = email.address;
                }
                return email.copy(str);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            public final Email copy(@NotNull String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                return new Email(address);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Email) && Intrinsics.areEqual(this.address, ((Email) other).address);
            }

            public int hashCode() {
                return this.address.hashCode();
            }

            @NotNull
            public String toString() {
                return "Email(address=" + this.address + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Email(@NotNull String address) {
                super(null);
                Intrinsics.checkNotNullParameter(address, "address");
                this.address = address;
            }

            @Override // com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView.DialogResult
            @NotNull
            public String getAddress() {
                return this.address;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult$Sms;", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "address", "", "senderId", "prefix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getPrefix", "getSenderId", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Sms extends DialogResult {
            private final String address;
            private final String prefix;
            private final String senderId;

            public static /* synthetic */ Sms copy$default(Sms sms, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sms.address;
                }
                if ((i & 2) != 0) {
                    str2 = sms.senderId;
                }
                if ((i & 4) != 0) {
                    str3 = sms.prefix;
                }
                return sms.copy(str, str2, str3);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getSenderId() {
                return this.senderId;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final String getPrefix() {
                return this.prefix;
            }

            @NotNull
            public final Sms copy(@NotNull String address, @NotNull String senderId, @NotNull String prefix) {
                Intrinsics.checkNotNullParameter(address, "address");
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                return new Sms(address, senderId, prefix);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Sms)) {
                    return false;
                }
                Sms sms = (Sms) other;
                return Intrinsics.areEqual(this.address, sms.address) && Intrinsics.areEqual(this.senderId, sms.senderId) && Intrinsics.areEqual(this.prefix, sms.prefix);
            }

            public int hashCode() {
                return (((this.address.hashCode() * 31) + this.senderId.hashCode()) * 31) + this.prefix.hashCode();
            }

            @NotNull
            public String toString() {
                return "Sms(address=" + this.address + ", senderId=" + this.senderId + ", prefix=" + this.prefix + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Override // com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView.DialogResult
            @NotNull
            public String getAddress() {
                return this.address;
            }

            @NotNull
            public final String getSenderId() {
                return this.senderId;
            }

            @NotNull
            public final String getPrefix() {
                return this.prefix;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Sms(@NotNull String address, @NotNull String senderId, @NotNull String prefix) {
                super(null);
                Intrinsics.checkNotNullParameter(address, "address");
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                this.address = address;
                this.senderId = senderId;
                this.prefix = prefix;
            }
        }
    }

    @Nullable
    public final DialogResult getResult() {
        Item.ContactManagement.SmsSenderInfo smsSenderInfo;
        String formattedAddress = getFormattedAddress();
        if (formattedAddress == null) {
            return null;
        }
        Item.ContactManagement.Platform platform = this.platform;
        if (platform instanceof Item.ContactManagement.Platform.Email) {
            return new DialogResult.Email(formattedAddress);
        }
        if (!(platform instanceof Item.ContactManagement.Platform.Sms) || (smsSenderInfo = this.selectedSender) == null) {
            return null;
        }
        return new DialogResult.Sms(formattedAddress, smsSenderInfo.getSenderId(), smsSenderInfo.getDialingCode());
    }

    public final void setError(@Nullable String error) {
        this.textInputView.setError(error);
        this.textInputView.setErrorEnabled(error != null);
        this.textInputView.invalidate();
        this.textInputView.requestLayout();
    }

    private final String getFormattedAddress() {
        Editable text;
        String string;
        EditText editText = this.textInputView.getEditText();
        if (editText == null || (text = editText.getText()) == null || (string = text.toString()) == null) {
            return null;
        }
        Item.ContactManagement.SmsSenderInfo smsSenderInfo = this.selectedSender;
        return smsSenderInfo != null ? Companion.formatPhone(smsSenderInfo.getDialingCode(), string) : Companion.formatEmail(string);
    }

    private final void setCountryCodes(final List<Item.ContactManagement.SmsSenderInfo> senders) {
        ArrayAdapter<String> adapter = getAdapter();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(senders, 10));
        for (Item.ContactManagement.SmsSenderInfo smsSenderInfo : senders) {
            arrayList.add(Companion.formatCountryPickerItem(smsSenderInfo.getDisplayName(), smsSenderInfo.getDialingCode()));
        }
        adapter.addAll(arrayList);
        this.countryPickerTextView.setAdapter(getAdapter());
        Item.ContactManagement.SmsSenderInfo smsSenderInfo2 = (Item.ContactManagement.SmsSenderInfo) CollectionsKt.first((List) senders);
        this.selectedSender = smsSenderInfo2;
        this.countryPickerTextView.setText((CharSequence) smsSenderInfo2.getDisplayName(), false);
        setAddressPlaceholder(smsSenderInfo2.getPlaceholderText());
        this.countryPickerTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView$$ExternalSyntheticLambda0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ContactChannelDialogInputView.setCountryCodes$lambda$7(senders, this, adapterView, view, i, j);
            }
        });
        this.countryPickerInputView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setCountryCodes$lambda$7(List senders, ContactChannelDialogInputView this$0, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(senders, "$senders");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Item.ContactManagement.SmsSenderInfo smsSenderInfo = (Item.ContactManagement.SmsSenderInfo) senders.get(i);
        this$0.selectedSender = smsSenderInfo;
        this$0.setAddressPlaceholder(smsSenderInfo.getPlaceholderText());
    }

    private final void setAddressLabel(String text) {
        this.textInputView.setHint(text);
    }

    private final void setAddressPlaceholder(String text) {
        this.textInputView.setPlaceholderText(text);
    }

    private final void setCountryPickerLabel(String text) {
        this.countryPickerInputView.setHint(text);
    }

    private final void setFooter(String formattedText) {
        ViewExtensionsKt.setHtml$default(this.footerView, StringExtensionsKt.markdownToHtml(formattedText), false, 2, null);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatEmail(String str) {
            if (str == null) {
                str = "";
            }
            return StringsKt.trim(str).toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatPhone(String str, String str2) throws IOException {
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str2.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str2.charAt(i);
                if (Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String formatCountryPickerItem(String str, String str2) {
            String airshipEmojiFlag = com.urbanairship.util.StringExtensionsKt.getAirshipEmojiFlag(str);
            if (airshipEmojiFlag == null) {
                return str2;
            }
            String str3 = airshipEmojiFlag + ' ' + str2;
            return str3 == null ? str2 : str3;
        }
    }
}
