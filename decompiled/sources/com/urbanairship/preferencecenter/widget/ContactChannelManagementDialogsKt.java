package com.urbanairship.preferencecenter.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwnerKt;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.R;
import com.urbanairship.UALog;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.PreferenceCenterFragment;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel;
import com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001aD\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0000\u001a0\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0014H\u0002¨\u0006\u0015"}, d2 = {"showContactManagementAddConfirmDialog", "", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterFragment;", "message", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "showContactManagementAddDialog", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "onHandleAction", "Lkotlin/Function1;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "errors", "Lkotlinx/coroutines/flow/Flow;", "", "dismisses", "showContactManagementRemoveDialog", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "showContactManagementResentDialog", "themed", "Landroid/content/Context;", "urbanairship-preference-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactChannelManagementDialogs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannelManagementDialogs.kt\ncom/urbanairship/preferencecenter/widget/ContactChannelManagementDialogsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactChannelManagementDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementAddDialog$lambda$4(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementRemoveDialog$lambda$11(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementResentDialog$lambda$13(DialogInterface dialogInterface, int i) {
    }

    public static final void showContactManagementAddDialog(@NotNull final PreferenceCenterFragment preferenceCenterFragment, @NotNull final Item.ContactManagement item, @NotNull final Function1<? super PreferenceCenterViewModel.Action, Unit> onHandleAction, @NotNull final Flow<String> errors, @NotNull final Flow<Unit> dismisses) {
        String string;
        Intrinsics.checkNotNullParameter(preferenceCenterFragment, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onHandleAction, "onHandleAction");
        Intrinsics.checkNotNullParameter(errors, "errors");
        Intrinsics.checkNotNullParameter(dismisses, "dismisses");
        Context contextRequireContext = preferenceCenterFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Context contextThemed = themed(contextRequireContext);
        Item.ContactManagement.AddChannelPrompt prompt = item.getAddPrompt().getPrompt();
        String text = prompt.getSubmitButton().getText();
        Item.ContactManagement.LabeledButton cancelButton = prompt.getCancelButton();
        if (cancelButton == null || (string = cancelButton.getText()) == null) {
            string = contextThemed.getString(R.string.ua_cancel);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        String str = string;
        final ContactChannelDialogInputView contactChannelDialogInputView = new ContactChannelDialogInputView(contextThemed, null, 0, 6, null);
        contactChannelDialogInputView.setPlatform(item.getPlatform(), prompt.getDisplay());
        MaterialAlertDialogBuilder title = new MaterialAlertDialogBuilder(contextThemed).setTitle((CharSequence) prompt.getDisplay().getTitle());
        String description = prompt.getDisplay().getDescription();
        if (description != null) {
            title.setMessage((CharSequence) description);
        }
        final AlertDialog alertDialogCreate = title.setView((View) contactChannelDialogInputView).setNeutralButton((CharSequence) str, new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton((CharSequence) text, new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactChannelManagementDialogsKt.showContactManagementAddDialog$lambda$4(dialogInterface, i);
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        contactChannelDialogInputView.setOnSubmit(new Function0() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt.showContactManagementAddDialog.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m2943invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2943invoke() {
                ContactChannelManagementDialogsKt.showContactManagementAddDialog$onSubmit(contactChannelDialogInputView, item, onHandleAction);
            }
        });
        alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ContactChannelManagementDialogsKt.showContactManagementAddDialog$lambda$7(errors, preferenceCenterFragment, dismisses, contactChannelDialogInputView, alertDialogCreate, item, onHandleAction, dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementAddDialog$onSubmit(ContactChannelDialogInputView contactChannelDialogInputView, Item.ContactManagement contactManagement, Function1 function1) {
        PreferenceCenterViewModel.Action validateSmsChannel;
        ContactChannelDialogInputView.DialogResult result = contactChannelDialogInputView.getResult();
        if (result == null || StringsKt.isBlank(result.getAddress())) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$showContactManagementAddDialog$onSubmit$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Add contact channel dialog result was null!";
                }
            }, 1, null);
            contactChannelDialogInputView.setError(contactManagement.getPlatform().getErrorMessages$urbanairship_preference_center_release().getDefaultMessage());
            return;
        }
        if (result instanceof ContactChannelDialogInputView.DialogResult.Email) {
            validateSmsChannel = new PreferenceCenterViewModel.Action.ValidateEmailChannel(contactManagement, ((ContactChannelDialogInputView.DialogResult.Email) result).getAddress());
        } else if (result instanceof ContactChannelDialogInputView.DialogResult.Sms) {
            ContactChannelDialogInputView.DialogResult.Sms sms = (ContactChannelDialogInputView.DialogResult.Sms) result;
            validateSmsChannel = new PreferenceCenterViewModel.Action.ValidateSmsChannel(contactManagement, sms.getAddress(), sms.getSenderId(), sms.getPrefix());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        function1.invoke(validateSmsChannel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementAddDialog$lambda$7(Flow errors, PreferenceCenterFragment this_showContactManagementAddDialog, Flow dismisses, final ContactChannelDialogInputView inputView, final AlertDialog dialog, final Item.ContactManagement item, final Function1 onHandleAction, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(errors, "$errors");
        Intrinsics.checkNotNullParameter(this_showContactManagementAddDialog, "$this_showContactManagementAddDialog");
        Intrinsics.checkNotNullParameter(dismisses, "$dismisses");
        Intrinsics.checkNotNullParameter(inputView, "$inputView");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(onHandleAction, "$onHandleAction");
        FlowKt.launchIn(FlowKt.onEach(errors, new ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$1(inputView, null)), LifecycleOwnerKt.getLifecycleScope(this_showContactManagementAddDialog));
        FlowKt.launchIn(FlowKt.onEach(dismisses, new ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$2(dialog, null)), LifecycleOwnerKt.getLifecycleScope(this_showContactManagementAddDialog));
        inputView.setOnValidationChanged(new Function1() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$showContactManagementAddDialog$2$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    inputView.setError(null);
                }
                dialog.getButton(-1).setEnabled(z);
            }
        });
        Button button = dialog.getButton(-1);
        button.setEnabled(false);
        InstrumentationCallbacks.setOnClickListenerCalled(button, new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactChannelManagementDialogsKt.showContactManagementAddDialog$lambda$7$lambda$6$lambda$5(inputView, item, onHandleAction, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementAddDialog$lambda$7$lambda$6$lambda$5(ContactChannelDialogInputView inputView, Item.ContactManagement item, Function1 onHandleAction, View view) {
        Intrinsics.checkNotNullParameter(inputView, "$inputView");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(onHandleAction, "$onHandleAction");
        showContactManagementAddDialog$onSubmit(inputView, item, onHandleAction);
    }

    public static final void showContactManagementAddConfirmDialog(@NotNull PreferenceCenterFragment preferenceCenterFragment, @NotNull Item.ContactManagement.ActionableMessage message) {
        Intrinsics.checkNotNullParameter(preferenceCenterFragment, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Context contextRequireContext = preferenceCenterFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new MaterialAlertDialogBuilder(themed(contextRequireContext)).setTitle((CharSequence) message.getTitle()).setMessage((CharSequence) message.getDescription()).setPositiveButton((CharSequence) message.getButton().getText(), new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    public static final void showContactManagementRemoveDialog(@NotNull PreferenceCenterFragment preferenceCenterFragment, @NotNull Item.ContactManagement item, @NotNull final ContactChannel channel, @NotNull final Function1<? super PreferenceCenterViewModel.Action, Unit> onHandleAction) {
        String string;
        Intrinsics.checkNotNullParameter(preferenceCenterFragment, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(onHandleAction, "onHandleAction");
        Context contextRequireContext = preferenceCenterFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        Context contextThemed = themed(contextRequireContext);
        Item.ContactManagement.RemoveChannelPrompt prompt = item.getRemovePrompt().getPrompt();
        String text = prompt.getSubmitButton().getText();
        Item.ContactManagement.LabeledButton cancelButton = prompt.getCancelButton();
        if (cancelButton == null || (string = cancelButton.getText()) == null) {
            string = contextThemed.getString(R.string.ua_cancel);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        MaterialAlertDialogBuilder title = new MaterialAlertDialogBuilder(contextThemed).setTitle((CharSequence) prompt.getDisplay().getTitle());
        String description = prompt.getDisplay().getDescription();
        if (description != null) {
            title.setMessage((CharSequence) description);
        }
        title.setNeutralButton((CharSequence) string, new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactChannelManagementDialogsKt.showContactManagementRemoveDialog$lambda$11(dialogInterface, i);
            }
        }).setNegativeButton((CharSequence) text, new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactChannelManagementDialogsKt.showContactManagementRemoveDialog$lambda$12(onHandleAction, channel, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContactManagementRemoveDialog$lambda$12(Function1 onHandleAction, ContactChannel channel, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(onHandleAction, "$onHandleAction");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        onHandleAction.invoke(new PreferenceCenterViewModel.Action.UnregisterChannel(channel));
    }

    public static final void showContactManagementResentDialog(@NotNull PreferenceCenterFragment preferenceCenterFragment, @NotNull Item.ContactManagement.ActionableMessage message) {
        Intrinsics.checkNotNullParameter(preferenceCenterFragment, "<this>");
        Intrinsics.checkNotNullParameter(message, "message");
        Context contextRequireContext = preferenceCenterFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new MaterialAlertDialogBuilder(themed(contextRequireContext)).setTitle((CharSequence) message.getTitle()).setMessage((CharSequence) message.getDescription()).setPositiveButton((CharSequence) message.getButton().getText(), new DialogInterface.OnClickListener() { // from class: com.urbanairship.preferencecenter.widget.ContactChannelManagementDialogsKt$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ContactChannelManagementDialogsKt.showContactManagementResentDialog$lambda$13(dialogInterface, i);
            }
        }).show();
    }

    private static final Context themed(Context context) {
        return new ContextThemeWrapper(context, com.urbanairship.preferencecenter.R.style.UrbanAirship_PreferenceCenter_Fragment);
    }
}
