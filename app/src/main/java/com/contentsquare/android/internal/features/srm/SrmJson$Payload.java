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

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class SrmJson$Payload {

    @NotNull
    public static final C2425a Companion = new C2425a();

    /* JADX INFO: renamed from: d */
    @JvmField
    @NotNull
    public static final KSerializer<Object>[] f1319d = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

    /* JADX INFO: renamed from: a */
    public final int f1320a;

    /* JADX INFO: renamed from: b */
    public final int f1321b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final List<String> f1322c;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.features.srm.SrmJson$Payload$a */
    public static final class C2425a {
        @NotNull
        public final KSerializer<SrmJson$Payload> serializer() {
            return SrmJson$Payload$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public SrmJson$Payload(int i, int i2, int i3, List list) {
        if (7 != (i & 7)) {
            SrmJson$Payload$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 7, SrmJson$Payload$$serializer.f1323a);
        }
        this.f1320a = i2;
        this.f1321b = i3;
        this.f1322c = list;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SrmJson$Payload)) {
            return false;
        }
        SrmJson$Payload srmJson$Payload = (SrmJson$Payload) obj;
        return this.f1320a == srmJson$Payload.f1320a && this.f1321b == srmJson$Payload.f1321b && Intrinsics.areEqual(this.f1322c, srmJson$Payload.f1322c);
    }

    public final int hashCode() {
        return this.f1322c.hashCode() + ((Integer.hashCode(this.f1321b) + (Integer.hashCode(this.f1320a) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "Payload(projectId=" + this.f1320a + ", filter=" + this.f1321b + ", hashes=" + this.f1322c + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public SrmJson$Payload(int i, @NotNull ArrayList hashes) {
        Intrinsics.checkNotNullParameter(hashes, "hashes");
        this.f1320a = i;
        this.f1321b = 2;
        this.f1322c = hashes;
    }
}
