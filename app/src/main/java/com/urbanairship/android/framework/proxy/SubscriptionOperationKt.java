package com.urbanairship.android.framework.proxy;

import com.urbanairship.channel.SubscriptionListEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, m1836d2 = {"applyOperation", "", "Lcom/urbanairship/android/framework/proxy/SubscriptionListOperation;", "editor", "Lcom/urbanairship/channel/SubscriptionListEditor;", "airship-framework-proxy_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class SubscriptionOperationKt {

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionListOperationAction.values().length];
            try {
                iArr[SubscriptionListOperationAction.SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubscriptionListOperationAction.UNSUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void applyOperation(@NotNull SubscriptionListOperation subscriptionListOperation, @NotNull SubscriptionListEditor editor) {
        Intrinsics.checkNotNullParameter(subscriptionListOperation, "<this>");
        Intrinsics.checkNotNullParameter(editor, "editor");
        int i = WhenMappings.$EnumSwitchMapping$0[subscriptionListOperation.getAction().ordinal()];
        if (i == 1) {
            editor.subscribe(subscriptionListOperation.getListId());
        } else {
            if (i != 2) {
                return;
            }
            editor.unsubscribe(subscriptionListOperation.getListId());
        }
    }
}
