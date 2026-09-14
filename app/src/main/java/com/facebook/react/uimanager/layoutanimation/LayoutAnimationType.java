package com.facebook.react.uimanager.layoutanimation;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m1836d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "UPDATE", "DELETE", "Companion", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum LayoutAnimationType {
    CREATE,
    UPDATE,
    DELETE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<LayoutAnimationType> getEntries() {
        return $ENTRIES;
    }

    @JvmStatic
    @NotNull
    public static final String toString(@NotNull LayoutAnimationType layoutAnimationType) {
        return INSTANCE.toString(layoutAnimationType);
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1836d2 = {"Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType$Companion;", "", "<init>", "()V", "toString", "", "type", "Lcom/facebook/react/uimanager/layoutanimation/LayoutAnimationType;", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LayoutAnimationType.values().length];
                try {
                    iArr[LayoutAnimationType.CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutAnimationType.UPDATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LayoutAnimationType.DELETE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final String toString(@NotNull LayoutAnimationType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i == 1) {
                return "create";
            }
            if (i == 2) {
                return "update";
            }
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return "delete";
        }
    }
}
