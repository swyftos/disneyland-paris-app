package com.google.protobuf.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.GeneratedMessageLite;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u0001\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0003\"\u0012\b\u0001\u0010\u0004*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0005*\u0002H\u00042\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0007H\u0086\u0002¢\u0006\u0002\u0010\b\u001aX\u0010\t\u001a\u0002H\n\"\u0012\b\u0000\u0010\u0002*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0003\"\u0012\b\u0001\u0010\u000b*\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u0005\"\b\b\u0002\u0010\n*\u00020\f*\u0002H\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0007H\u0086\u0002¢\u0006\u0002\u0010\r\u001ad\u0010\u000e\u001a\u00020\u000f\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u0003\"\u0014\b\u0001\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00100\u0011\"\b\b\u0002\u0010\n*\u00020\f*\u0002H\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u00072\u0006\u0010\u0012\u001a\u0002H\nH\u0086\u0002¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"contains", "", "M", "Lcom/google/protobuf/GeneratedMessageLite$ExtendableMessage;", "MorBT", "Lcom/google/protobuf/GeneratedMessageLite$ExtendableMessageOrBuilder;", "extension", "Lcom/google/protobuf/ExtensionLite;", "(Lcom/google/protobuf/GeneratedMessageLite$ExtendableMessageOrBuilder;Lcom/google/protobuf/ExtensionLite;)Z", "get", ExifInterface.GPS_DIRECTION_TRUE, "MOrBT", "", "(Lcom/google/protobuf/GeneratedMessageLite$ExtendableMessageOrBuilder;Lcom/google/protobuf/ExtensionLite;)Ljava/lang/Object;", AttributeMutation.ATTRIBUTE_ACTION_SET, "", "B", "Lcom/google/protobuf/GeneratedMessageLite$ExtendableBuilder;", "value", "(Lcom/google/protobuf/GeneratedMessageLite$ExtendableBuilder;Lcom/google/protobuf/ExtensionLite;Ljava/lang/Object;)V", "java_kotlin-lite-lite_extensions"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExtendableMessageLiteExtensionsKt {
    @NotNull
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MOrBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>, T> T get(@NotNull MOrBT morbt, @NotNull ExtensionLite<M, T> extension) {
        Intrinsics.checkNotNullParameter(morbt, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        T t = (T) morbt.getExtension(extension);
        Intrinsics.checkNotNullExpressionValue(t, "getExtension(extension)");
        return t;
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, B>, B extends GeneratedMessageLite.ExtendableBuilder<M, B>, T> void set(@NotNull B b, @NotNull ExtensionLite<M, T> extension, @NotNull T value) {
        Intrinsics.checkNotNullParameter(b, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(value, "value");
        b.setExtension(extension, value);
    }

    public static final <M extends GeneratedMessageLite.ExtendableMessage<M, ?>, MorBT extends GeneratedMessageLite.ExtendableMessageOrBuilder<M, ?>> boolean contains(@NotNull MorBT morbt, @NotNull ExtensionLite<M, ?> extension) {
        Intrinsics.checkNotNullParameter(morbt, "<this>");
        Intrinsics.checkNotNullParameter(extension, "extension");
        return morbt.hasExtension(extension);
    }
}
