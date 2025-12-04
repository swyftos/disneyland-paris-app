package com.urbanairship.actions;

import androidx.annotation.NonNull;
import com.urbanairship.UAirship;
import com.urbanairship.base.Supplier;
import com.urbanairship.channel.SubscriptionListEditor;
import com.urbanairship.contacts.Scope;
import com.urbanairship.contacts.ScopedSubscriptionListEditor;
import com.urbanairship.json.JsonException;

/* loaded from: classes4.dex */
public class SubscriptionListAction extends Action {

    @NonNull
    public static final String ALT_DEFAULT_REGISTRY_NAME = "edit_subscription_list_action";

    @NonNull
    public static final String ALT_DEFAULT_REGISTRY_SHORT_NAME = "^sl";

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "subscription_list_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^sla";
    private final Supplier channelEditorSupplier;
    private final Supplier contactEditorSupplier;

    public SubscriptionListAction() {
        this(new Supplier() { // from class: com.urbanairship.actions.SubscriptionListAction$$ExternalSyntheticLambda0
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return SubscriptionListAction.lambda$new$0();
            }
        }, new Supplier() { // from class: com.urbanairship.actions.SubscriptionListAction$$ExternalSyntheticLambda1
            @Override // com.urbanairship.base.Supplier
            public final Object get() {
                return SubscriptionListAction.lambda$new$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SubscriptionListEditor lambda$new$0() {
        return UAirship.shared().getChannel().editSubscriptionLists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ScopedSubscriptionListEditor lambda$new$1() {
        return UAirship.shared().getContact().editSubscriptionLists();
    }

    SubscriptionListAction(Supplier supplier, Supplier supplier2) {
        this.channelEditorSupplier = supplier;
        this.contactEditorSupplier = supplier2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    @Override // com.urbanairship.actions.Action
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.urbanairship.actions.ActionResult perform(@androidx.annotation.NonNull com.urbanairship.actions.ActionArguments r12) {
        /*
            r11 = this;
            com.urbanairship.base.Supplier r0 = r11.channelEditorSupplier
            java.lang.Object r0 = r0.get()
            com.urbanairship.channel.SubscriptionListEditor r0 = (com.urbanairship.channel.SubscriptionListEditor) r0
            java.lang.Object r0 = androidx.core.util.ObjectsCompat.requireNonNull(r0)
            com.urbanairship.channel.SubscriptionListEditor r0 = (com.urbanairship.channel.SubscriptionListEditor) r0
            com.urbanairship.base.Supplier r1 = r11.contactEditorSupplier
            java.lang.Object r1 = r1.get()
            com.urbanairship.contacts.ScopedSubscriptionListEditor r1 = (com.urbanairship.contacts.ScopedSubscriptionListEditor) r1
            java.lang.Object r1 = androidx.core.util.ObjectsCompat.requireNonNull(r1)
            com.urbanairship.contacts.ScopedSubscriptionListEditor r1 = (com.urbanairship.contacts.ScopedSubscriptionListEditor) r1
            com.urbanairship.actions.ActionValue r2 = r12.getValue()
            com.urbanairship.json.JsonValue r2 = r2.getJsonValue()
            com.urbanairship.json.JsonList r2 = r2.optList()
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto La5
            java.lang.Object r3 = r2.next()
            com.urbanairship.json.JsonValue r3 = (com.urbanairship.json.JsonValue) r3
            r4 = 0
            com.urbanairship.json.JsonMap r3 = r3.requireMap()     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r5 = "list"
            com.urbanairship.json.JsonValue r5 = r3.require(r5)     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r5 = r5.requireString()     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r6 = "type"
            com.urbanairship.json.JsonValue r6 = r3.require(r6)     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r6 = r6.requireString()     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r7 = "action"
            com.urbanairship.json.JsonValue r7 = r3.require(r7)     // Catch: com.urbanairship.json.JsonException -> L75
            java.lang.String r7 = r7.requireString()     // Catch: com.urbanairship.json.JsonException -> L75
            int r8 = r6.hashCode()     // Catch: com.urbanairship.json.JsonException -> L75
            r9 = 738950403(0x2c0b7d03, float:1.9822483E-12)
            r10 = 1
            if (r8 == r9) goto L77
            r9 = 951526432(0x38b72420, float:8.732849E-5)
            if (r8 == r9) goto L6b
            goto L81
        L6b:
            java.lang.String r8 = "contact"
            boolean r6 = r6.equals(r8)     // Catch: com.urbanairship.json.JsonException -> L75
            if (r6 == 0) goto L81
            r6 = r10
            goto L82
        L75:
            r11 = move-exception
            goto L99
        L77:
            java.lang.String r8 = "channel"
            boolean r6 = r6.equals(r8)     // Catch: com.urbanairship.json.JsonException -> L75
            if (r6 == 0) goto L81
            r6 = r4
            goto L82
        L81:
            r6 = -1
        L82:
            if (r6 == 0) goto L95
            if (r6 == r10) goto L87
            goto L2c
        L87:
            java.lang.String r6 = "scope"
            com.urbanairship.json.JsonValue r3 = r3.require(r6)     // Catch: com.urbanairship.json.JsonException -> L75
            com.urbanairship.contacts.Scope r3 = com.urbanairship.contacts.Scope.fromJson(r3)     // Catch: com.urbanairship.json.JsonException -> L75
            r11.applyContactOperation(r1, r5, r7, r3)     // Catch: com.urbanairship.json.JsonException -> L75
            goto L2c
        L95:
            r11.applyChannelOperation(r0, r5, r7)     // Catch: com.urbanairship.json.JsonException -> L75
            goto L2c
        L99:
            java.lang.String r12 = "Invalid argument"
            java.lang.Object[] r0 = new java.lang.Object[r4]
            com.urbanairship.UALog.e(r11, r12, r0)
            com.urbanairship.actions.ActionResult r11 = com.urbanairship.actions.ActionResult.newErrorResult(r11)
            return r11
        La5:
            r0.apply()
            r1.apply()
            com.urbanairship.actions.ActionValue r11 = r12.getValue()
            com.urbanairship.actions.ActionResult r11 = com.urbanairship.actions.ActionResult.newResult(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.actions.SubscriptionListAction.perform(com.urbanairship.actions.ActionArguments):com.urbanairship.actions.ActionResult");
    }

    private void applyContactOperation(ScopedSubscriptionListEditor scopedSubscriptionListEditor, String str, String str2, Scope scope) throws JsonException {
        str2.hashCode();
        if (str2.equals("subscribe")) {
            scopedSubscriptionListEditor.subscribe(str, scope);
        } else {
            if (str2.equals("unsubscribe")) {
                scopedSubscriptionListEditor.unsubscribe(str, scope);
                return;
            }
            throw new JsonException("Invalid action: " + str2);
        }
    }

    private void applyChannelOperation(SubscriptionListEditor subscriptionListEditor, String str, String str2) throws JsonException {
        str2.hashCode();
        if (str2.equals("subscribe")) {
            subscriptionListEditor.subscribe(str);
        } else {
            if (str2.equals("unsubscribe")) {
                subscriptionListEditor.unsubscribe(str);
                return;
            }
            throw new JsonException("Invalid action: " + str2);
        }
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        return (actionArguments.getValue().isNull() || actionArguments.getSituation() == 1) ? false : true;
    }
}
