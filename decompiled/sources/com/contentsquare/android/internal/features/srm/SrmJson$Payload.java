package com.contentsquare.android.internal.features.srm;

import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class SrmJson$Payload {

    @NotNull
    public static final a Companion = new a();

    @JvmField
    @NotNull
    public static final KSerializer<Object>[] d = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};
    public final int a;
    public final int b;

    @NotNull
    public final List<String> c;

    public static final class a {
        @NotNull
        public final KSerializer<SrmJson$Payload> serializer() {
            return SrmJson$Payload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public SrmJson$Payload(int i, int i2, int i3, List list) {
        if (7 != (i & 7)) {
            SrmJson$Payload$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 7, SrmJson$Payload$$serializer.a);
        }
        this.a = i2;
        this.b = i3;
        this.c = list;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SrmJson$Payload)) {
            return false;
        }
        SrmJson$Payload srmJson$Payload = (SrmJson$Payload) obj;
        return this.a == srmJson$Payload.a && this.b == srmJson$Payload.b && Intrinsics.areEqual(this.c, srmJson$Payload.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((Integer.hashCode(this.b) + (Integer.hashCode(this.a) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "Payload(projectId=" + this.a + ", filter=" + this.b + ", hashes=" + this.c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SrmJson$Payload(int i, @NotNull ArrayList hashes) {
        Intrinsics.checkNotNullParameter(hashes, "hashes");
        this.a = i;
        this.b = 2;
        this.c = hashes;
    }
}
