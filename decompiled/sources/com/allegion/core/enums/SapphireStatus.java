package com.allegion.core.enums;

import ch.qos.logback.core.CoreConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/allegion/core/enums/SapphireStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNCONFIGURED", "REN_REQUIRED", "NEAR_CONNECTIONS", "ANY_CONNECTIONS", "Parser", "AlBle_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum SapphireStatus {
    UNCONFIGURED(1),
    REN_REQUIRED(2),
    NEAR_CONNECTIONS(3),
    ANY_CONNECTIONS(4);


    /* renamed from: Parser, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    SapphireStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/allegion/core/enums/SapphireStatus$Parser;", "", "()V", CoreConstants.VALUE_OF, "Lcom/allegion/core/enums/SapphireStatus;", "value", "", "AlBle_release"}, k = 1, mv = {1, 1, 15})
    /* renamed from: com.allegion.core.enums.SapphireStatus$Parser, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final SapphireStatus valueOf(int value) {
            for (SapphireStatus sapphireStatus : SapphireStatus.values()) {
                if (sapphireStatus.getValue() == value) {
                    return sapphireStatus;
                }
            }
            return null;
        }
    }
}
