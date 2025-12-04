package com.contentsquare.android.sdk;

import android.os.SystemClock;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nBatchDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BatchDispatcher.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/dispatcher/BatchDispatcher\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,68:1\n1295#2,2:69\n*S KotlinDebug\n*F\n+ 1 BatchDispatcher.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/dispatcher/BatchDispatcher\n*L\n32#1:69,2\n*E\n"})
/* loaded from: classes2.dex */
public final class S {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final D5 b;

    @NotNull
    public final U c;

    @NotNull
    public final C0784q3 d;

    @NotNull
    public final HttpConnection e;

    @NotNull
    public final Logger f;

    public S(DeviceInfo deviceInfo, D5 configuration, U batchStorageProcessor) {
        C0784q3 networkTracker = new C0784q3(new V6());
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(batchStorageProcessor, "batchStorageProcessor");
        Intrinsics.checkNotNullParameter(networkTracker, "networkTracker");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        this.a = deviceInfo;
        this.b = configuration;
        this.c = batchStorageProcessor;
        this.d = networkTracker;
        this.e = httpConnection;
        this.f = new Logger("SrEventsDispatcher");
    }

    public final void a() {
        Logger logger;
        String str;
        JsonConfig.SessionReplay sessionReplay;
        U u = this.c;
        u.getClass();
        for (Pair pair : SequencesKt.sequence(new T(u, null))) {
            long jLongValue = ((Number) pair.component1()).longValue();
            T6 t6 = (T6) pair.component2();
            String str2 = t6.a;
            byte[] bArr = t6.b;
            JsonConfig.ProjectConfiguration projectConfig = this.b.b.getProjectConfig();
            boolean z = (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null || sessionReplay.getRecordViaCellularNetwork()) ? false : true;
            ConnectionType activeConnectionType = this.a.getActiveConnectionType();
            if (z && activeConnectionType != ConnectionType.WIFI) {
                logger = this.f;
                str = "can't send data because connection is not on WIFI";
            } else if (z || activeConnectionType != ConnectionType.OFFLINE) {
                HttpResponse httpResponse = HttpConnection.performPostWithProto$default(this.e, str2, bArr, "1", null, 8, null);
                if (httpResponse.getException() == null) {
                    C0784q3 c0784q3 = this.d;
                    c0784q3.getClass();
                    Intrinsics.checkNotNullParameter(httpResponse, "httpResponse");
                    long timeSpentMsec = httpResponse.getTimeSpentMsec();
                    c0784q3.e += timeSpentMsec;
                    c0784q3.f = timeSpentMsec;
                    long dataSentBytes = httpResponse.getDataSentBytes();
                    c0784q3.c += dataSentBytes;
                    c0784q3.d = dataSentBytes;
                    c0784q3.g++;
                    Logger logger2 = this.f;
                    C0784q3 c0784q32 = this.d;
                    c0784q32.a.getClass();
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - c0784q32.b;
                    StringBuilder sb = new StringBuilder("statistics of http post private calls:\n\trun from = ");
                    sb.append(jElapsedRealtime);
                    sb.append(" ms\n\tlast request size = ");
                    sb.append(c0784q32.d);
                    sb.append(" bytes\n\ttotal sent = ");
                    sb.append(c0784q32.c);
                    sb.append(" bytes\n\ttotal time spent = ");
                    sb.append(c0784q32.e);
                    sb.append(" ms\n\taverage throughput = ");
                    long j = c0784q32.c;
                    long j2 = c0784q32.e;
                    sb.append(j2 == 0 ? 0L : j / j2);
                    sb.append(" KB/sec\n\tlast request throughput = ");
                    long j3 = c0784q32.d;
                    long j4 = c0784q32.f;
                    sb.append(j4 == 0 ? 0L : j3 / j4);
                    sb.append(" KB/sec\n\tdata usage = ");
                    long j5 = jElapsedRealtime / 60;
                    sb.append(j5 != 0 ? c0784q32.c / j5 : 0L);
                    sb.append(" KB/min\n\ttotal number of requests = ");
                    sb.append(c0784q32.g);
                    logger2.d(sb.toString());
                    this.c.a(jLongValue);
                }
            } else {
                logger = this.f;
                str = "can't send data because mobile connection is not available";
            }
            logger.i(str);
        }
    }
}
