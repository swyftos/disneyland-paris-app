package com.urbanairship.permission;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/permission/PermissionPromptFallback;", "", "()V", "Callback", "None", "SystemSettings", "Lcom/urbanairship/permission/PermissionPromptFallback$Callback;", "Lcom/urbanairship/permission/PermissionPromptFallback$None;", "Lcom/urbanairship/permission/PermissionPromptFallback$SystemSettings;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PermissionPromptFallback {
    public /* synthetic */ PermissionPromptFallback(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PermissionPromptFallback() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/permission/PermissionPromptFallback$SystemSettings;", "Lcom/urbanairship/permission/PermissionPromptFallback;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SystemSettings extends PermissionPromptFallback {

        @NotNull
        public static final SystemSettings INSTANCE = new SystemSettings();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof SystemSettings);
        }

        public int hashCode() {
            return -476246247;
        }

        @NotNull
        public String toString() {
            return "SystemSettings";
        }

        private SystemSettings() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\u0012\u001c\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\u0007R,\u0010\u0002\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/permission/PermissionPromptFallback$Callback;", "Lcom/urbanairship/permission/PermissionPromptFallback;", "callback", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "getCallback$urbanairship_core_release", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Callback extends PermissionPromptFallback {
        private final Function1 callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> callback) {
            super(null);
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
        }

        @NotNull
        public final Function1<Continuation<? super Unit>, Object> getCallback$urbanairship_core_release() {
            return this.callback;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/permission/PermissionPromptFallback$None;", "Lcom/urbanairship/permission/PermissionPromptFallback;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class None extends PermissionPromptFallback {

        @NotNull
        public static final None INSTANCE = new None();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof None);
        }

        public int hashCode() {
            return -1877942369;
        }

        @NotNull
        public String toString() {
            return "None";
        }

        private None() {
            super(null);
        }
    }
}
