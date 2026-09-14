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

/* JADX INFO: renamed from: com.contentsquare.android.sdk.e */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2730e {

    /* JADX INFO: renamed from: l */
    @NotNull
    public static final Logger f2545l = new Logger(null, 1, 0 == true ? 1 : 0);

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f2546a;

    /* JADX INFO: renamed from: b */
    public final int f2547b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final String f2548c;

    /* JADX INFO: renamed from: d */
    @IntRange(from = 0, m4to = 2147483647L)
    public final int f2549d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final ConnectionType f2550e;

    /* JADX INFO: renamed from: f */
    @NotNull
    public final String f2551f;

    /* JADX INFO: renamed from: g */
    @NotNull
    public final DeviceInfo.Orientation f2552g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final JSONObject f2553h;

    /* JADX INFO: renamed from: i */
    @IntRange(from = 0, m4to = 2147483647L)
    public final int f2554i;

    /* JADX INFO: renamed from: j */
    public final long f2555j;

    /* JADX INFO: renamed from: k */
    public final long f2556k;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.e$a */
    public static abstract class a<T extends AbstractC2730e> {

        /* JADX INFO: renamed from: a */
        public final int f2557a;

        /* JADX INFO: renamed from: c */
        @IntRange(from = 0, m4to = 2147483647L)
        public int f2559c;

        /* JADX INFO: renamed from: h */
        @IntRange(from = 0, m4to = 2147483647L)
        public int f2564h;

        /* JADX INFO: renamed from: b */
        @NotNull
        public String f2558b = "";

        /* JADX INFO: renamed from: d */
        @NotNull
        public ConnectionType f2560d = ConnectionType.CONNECTIVITY_ERROR;

        /* JADX INFO: renamed from: e */
        @NotNull
        public String f2561e = "";

        /* JADX INFO: renamed from: f */
        @NotNull
        public DeviceInfo.Orientation f2562f = DeviceInfo.Orientation.PORTRAIT;

        /* JADX INFO: renamed from: g */
        @NotNull
        public JSONObject f2563g = new JSONObject();

        /* JADX INFO: renamed from: i */
        public long f2565i = System.currentTimeMillis();

        /* JADX INFO: renamed from: j */
        public final long f2566j = SystemClock.uptimeMillis();

        public a(int i) {
            this.f2557a = i;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public abstract T mo857a();
    }

    public AbstractC2730e(@NotNull a<?> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        this.f2546a = string;
        this.f2547b = builder.f2557a;
        this.f2548c = builder.f2558b;
        this.f2549d = builder.f2559c;
        this.f2550e = builder.f2560d;
        this.f2551f = builder.f2561e;
        this.f2552g = builder.f2562f;
        this.f2553h = builder.f2563g;
        this.f2554i = builder.f2564h;
        this.f2555j = builder.f2565i;
        this.f2556k = builder.f2566j;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo856a();
}
