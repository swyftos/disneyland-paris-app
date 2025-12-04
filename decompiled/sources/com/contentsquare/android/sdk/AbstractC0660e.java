package com.contentsquare.android.sdk;

import android.os.SystemClock;
import androidx.annotation.IntRange;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0660e {

    @NotNull
    public static final Logger l = new Logger(null, 1, 0 == true ? 1 : 0);

    @NotNull
    public final String a;
    public final int b;

    @NotNull
    public final String c;

    @IntRange(from = 0, to = 2147483647L)
    public final int d;

    @NotNull
    public final ConnectionType e;

    @NotNull
    public final String f;

    @NotNull
    public final DeviceInfo.Orientation g;

    @NotNull
    public final JSONObject h;

    @IntRange(from = 0, to = 2147483647L)
    public final int i;
    public final long j;
    public final long k;

    /* renamed from: com.contentsquare.android.sdk.e$a */
    public static abstract class a<T extends AbstractC0660e> {
        public final int a;

        @IntRange(from = 0, to = 2147483647L)
        public int c;

        @IntRange(from = 0, to = 2147483647L)
        public int h;

        @NotNull
        public String b = "";

        @NotNull
        public ConnectionType d = ConnectionType.CONNECTIVITY_ERROR;

        @NotNull
        public String e = "";

        @NotNull
        public DeviceInfo.Orientation f = DeviceInfo.Orientation.PORTRAIT;

        @NotNull
        public JSONObject g = new JSONObject();
        public long i = System.currentTimeMillis();
        public final long j = SystemClock.uptimeMillis();

        public a(int i) {
            this.a = i;
        }

        @NotNull
        public abstract T a();
    }

    public AbstractC0660e(@NotNull a<?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.a = string;
        this.b = builder.a;
        this.c = builder.b;
        this.d = builder.c;
        this.e = builder.d;
        this.f = builder.e;
        this.g = builder.f;
        this.h = builder.g;
        this.i = builder.h;
        this.j = builder.i;
        this.k = builder.j;
    }

    public abstract void a();
}
