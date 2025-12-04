package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* loaded from: classes6.dex */
public class UninitializedMessageException extends RuntimeException {
    private final List missingFields;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
