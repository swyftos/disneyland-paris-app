package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.sdk.C0721k0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.k0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0721k0 {

    @NotNull
    public final ExecutorService a;

    @NotNull
    public final C0867z1 b;

    @NotNull
    public final HttpConnection c;

    @NotNull
    public String d;

    @NotNull
    public final E1 e;

    @NotNull
    public final PreferencesStore f;

    @NotNull
    public final C0858y1 g;

    @NotNull
    public final A1 h;

    @NotNull
    public final Logger i;

    /* renamed from: com.contentsquare.android.sdk.k0$a */
    public final class a implements Callable<Pair<? extends Boolean, ? extends String>> {

        @NotNull
        public final c a;

        @NotNull
        public final b b;
        public final /* synthetic */ C0721k0 c;

        public /* synthetic */ a(C0721k0 c0721k0) {
            this(c0721k0, new c() { // from class: com.contentsquare.android.sdk.k0$a$$ExternalSyntheticLambda0
                @Override // com.contentsquare.android.sdk.C0721k0.c
                public final void a() {
                    C0721k0.a.a();
                }
            }, new b() { // from class: com.contentsquare.android.sdk.k0$a$$ExternalSyntheticLambda1
                @Override // com.contentsquare.android.sdk.C0721k0.b
                public final void a() {
                    C0721k0.a.b();
                }
            });
        }

        public static final void a() {
        }

        public static final void b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x035c  */
        /* JADX WARN: Removed duplicated region for block: B:122:0x0393 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x019a A[LOOP:4: B:51:0x0194->B:53:0x019a, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0250  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0279  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0288  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0295  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0307  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0326 A[LOOP:5: B:95:0x0320->B:97:0x0326, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean c() throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 961
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0721k0.a.c():boolean");
        }

        @Override // java.util.concurrent.Callable
        public final Pair<? extends Boolean, ? extends String> call() {
            Pair<? extends Boolean, ? extends String> pair;
            try {
                this.c.i.d("Fetching the unsent buckets...");
                if (c()) {
                    this.a.a();
                    pair = new Pair<>(Boolean.TRUE, "All buckets were processed");
                } else {
                    this.b.a();
                    pair = new Pair<>(Boolean.FALSE, "The process was interrupted due to a problem in the chain");
                }
                return pair;
            } catch (Exception e) {
                Q2.a(this.c.i, "An exception was thrown while trying to send the buckets", e);
                this.b.a();
                Boolean bool = Boolean.FALSE;
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                return new Pair<>(bool, message);
            }
        }

        public a(C0721k0 c0721k0, @NotNull c onSuccess, @NotNull b onError) {
            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
            Intrinsics.checkNotNullParameter(onError, "onError");
            this.c = c0721k0;
            this.a = onSuccess;
            this.b = onError;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.k0$b */
    public interface b {
        void a();
    }

    /* renamed from: com.contentsquare.android.sdk.k0$c */
    public interface c {
        void a();
    }

    public C0721k0(@NotNull ExecutorService threadExecutor, @NotNull C0867z1 eventStorageManager, @NotNull HttpConnection httpConnection, @NotNull String eventsEndpoint, @NotNull E1 eventsBuildersFactory, @NotNull PreferencesStore preferencesStore, @NotNull C0858y1 eventSendingManager, @NotNull A1 eventUrlGenerator) {
        Intrinsics.checkNotNullParameter(threadExecutor, "threadExecutor");
        Intrinsics.checkNotNullParameter(eventStorageManager, "eventStorageManager");
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(eventsEndpoint, "eventsEndpoint");
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(eventSendingManager, "eventSendingManager");
        Intrinsics.checkNotNullParameter(eventUrlGenerator, "eventUrlGenerator");
        this.a = threadExecutor;
        this.b = eventStorageManager;
        this.c = httpConnection;
        this.d = eventsEndpoint;
        this.e = eventsBuildersFactory;
        this.f = preferencesStore;
        this.g = eventSendingManager;
        this.h = eventUrlGenerator;
        this.i = new Logger("BucketsDispatcher");
    }
}
