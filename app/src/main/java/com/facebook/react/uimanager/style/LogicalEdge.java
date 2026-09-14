package com.facebook.react.uimanager.style;

import com.contentsquare.android.api.Currencies;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0013"}, m1836d2 = {"Lcom/facebook/react/uimanager/style/LogicalEdge;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "LEFT", "RIGHT", Currencies.AlphabeticCode.TOP_STR, "BOTTOM", "START", "END", "HORIZONTAL", "VERTICAL", "BLOCK_START", "BLOCK_END", "BLOCK", "toSpacingType", "", "Companion", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum LogicalEdge {
    ALL { // from class: com.facebook.react.uimanager.style.LogicalEdge.ALL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 8;
        }
    },
    LEFT { // from class: com.facebook.react.uimanager.style.LogicalEdge.LEFT
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 0;
        }
    },
    RIGHT { // from class: com.facebook.react.uimanager.style.LogicalEdge.RIGHT
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 2;
        }
    },
    TOP { // from class: com.facebook.react.uimanager.style.LogicalEdge.TOP
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 1;
        }
    },
    BOTTOM { // from class: com.facebook.react.uimanager.style.LogicalEdge.BOTTOM
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 3;
        }
    },
    START { // from class: com.facebook.react.uimanager.style.LogicalEdge.START
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 4;
        }
    },
    END { // from class: com.facebook.react.uimanager.style.LogicalEdge.END
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 5;
        }
    },
    HORIZONTAL { // from class: com.facebook.react.uimanager.style.LogicalEdge.HORIZONTAL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 6;
        }
    },
    VERTICAL { // from class: com.facebook.react.uimanager.style.LogicalEdge.VERTICAL
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 7;
        }
    },
    BLOCK_START { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_START
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 11;
        }
    },
    BLOCK_END { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK_END
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 10;
        }
    },
    BLOCK { // from class: com.facebook.react.uimanager.style.LogicalEdge.BLOCK
        @Override // com.facebook.react.uimanager.style.LogicalEdge
        public int toSpacingType() {
            return 9;
        }
    };

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* synthetic */ LogicalEdge(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final LogicalEdge fromSpacingType(int i) {
        return INSTANCE.fromSpacingType(i);
    }

    @NotNull
    public static EnumEntries<LogicalEdge> getEntries() {
        return $ENTRIES;
    }

    public abstract int toSpacingType();

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, m1836d2 = {"Lcom/facebook/react/uimanager/style/LogicalEdge$Companion;", "", "<init>", "()V", "fromSpacingType", "Lcom/facebook/react/uimanager/style/LogicalEdge;", "spacingType", "", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final LogicalEdge fromSpacingType(int spacingType) {
            switch (spacingType) {
                case 0:
                    return LogicalEdge.LEFT;
                case 1:
                    return LogicalEdge.TOP;
                case 2:
                    return LogicalEdge.RIGHT;
                case 3:
                    return LogicalEdge.BOTTOM;
                case 4:
                    return LogicalEdge.START;
                case 5:
                    return LogicalEdge.END;
                case 6:
                    return LogicalEdge.HORIZONTAL;
                case 7:
                    return LogicalEdge.VERTICAL;
                case 8:
                    return LogicalEdge.ALL;
                case 9:
                    return LogicalEdge.BLOCK;
                case 10:
                    return LogicalEdge.BLOCK_END;
                case 11:
                    return LogicalEdge.BLOCK_START;
                default:
                    throw new IllegalArgumentException("Unknown spacing type: " + spacingType);
            }
        }
    }
}
