package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.api.bridge.xpf.XpfMasker;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.VersionMatcher;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.U1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2637U1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2472D5 f2168a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final C2920x f2169b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final XpfMasker f2170c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f2171d;

    public C2637U1(C2472D5 sessionReplayConfiguration, C2920x c2920x) {
        XpfMasker xpfMasker = XpfMasker.INSTANCE;
        Intrinsics.checkNotNullParameter(sessionReplayConfiguration, "sessionReplayConfiguration");
        Intrinsics.checkNotNullParameter(xpfMasker, "xpfMasker");
        this.f2168a = sessionReplayConfiguration;
        this.f2169b = c2920x;
        this.f2170c = xpfMasker;
        this.f2171d = new Logger("ForceMaskingResolver");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059  */
    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0073  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:69:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:? A[LOOP:0: B:32:0x0077->B:71:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:1: B:21:0x0053->B:74:?, LOOP_END, SYNTHETIC] */
    @NotNull
    /* JADX INFO: renamed from: a */
    public final int m1042a(@NotNull View view) {
        boolean z;
        int i;
        String str;
        JsonConfig.SessionReplay sessionReplay;
        List<String> app;
        Iterator<T> it;
        boolean z2;
        List<String> sdk;
        Iterator<T> it2;
        Intrinsics.checkNotNullParameter(view, "view");
        C2472D5 c2472d5 = this.f2168a;
        JsonConfig.ProjectConfiguration projectConfig = c2472d5.f1520b.getProjectConfig();
        boolean z3 = false;
        if (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) {
            z = false;
        } else {
            JsonConfig.MaskingRulesFullMasking fullMasking = sessionReplay.getMaskingRules().getFullMasking();
            String applicationVersion = c2472d5.f1521c.getApplicationVersion();
            String sdkVersion = c2472d5.f1521c.getSdkVersion();
            int iHashCode = fullMasking.hashCode();
            C2472D5.a aVar = c2472d5.f1522d;
            if (aVar == null) {
                app = fullMasking.getApp();
                if (app == null && app.isEmpty()) {
                    sdk = fullMasking.getSdk();
                    if (sdk != null) {
                        it2 = sdk.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                    z2 = true;
                                }
                            }
                        }
                    } else {
                        it2 = sdk.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                    z2 = true;
                                }
                            }
                        }
                    }
                    z2 = false;
                } else {
                    it = app.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            sdk = fullMasking.getSdk();
                            if (sdk != null || !sdk.isEmpty()) {
                                it2 = sdk.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                        }
                                    }
                                }
                            }
                            z2 = false;
                        } else if (VersionMatcher.match((String) it.next(), applicationVersion)) {
                        }
                        z2 = true;
                    }
                }
                c2472d5.f1522d = new C2472D5.a(iHashCode, z2);
                z = z2;
            } else {
                if (aVar.f1524b != iHashCode) {
                    aVar = null;
                }
                if (aVar != null) {
                    z = aVar.f1523a;
                } else {
                    app = fullMasking.getApp();
                    if (app == null) {
                        it = app.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                sdk = fullMasking.getSdk();
                                if (sdk != null) {
                                    it2 = sdk.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                            }
                                        }
                                    }
                                } else {
                                    it2 = sdk.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                            }
                                        }
                                    }
                                }
                                z2 = false;
                                c2472d5.f1522d = new C2472D5.a(iHashCode, z2);
                                z = z2;
                            } else if (VersionMatcher.match((String) it.next(), applicationVersion)) {
                            }
                        }
                    } else {
                        it = app.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                sdk = fullMasking.getSdk();
                                if (sdk != null) {
                                    it2 = sdk.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                            }
                                        }
                                    }
                                } else {
                                    it2 = sdk.iterator();
                                    while (true) {
                                        if (it2.hasNext()) {
                                            if (VersionMatcher.match((String) it2.next(), sdkVersion)) {
                                            }
                                        }
                                    }
                                }
                                z2 = false;
                                c2472d5.f1522d = new C2472D5.a(iHashCode, z2);
                                z = z2;
                            } else if (VersionMatcher.match((String) it.next(), applicationVersion)) {
                            }
                        }
                    }
                    z2 = true;
                    c2472d5.f1522d = new C2472D5.a(iHashCode, z2);
                    z = z2;
                }
            }
        }
        if (z) {
            i = 4;
        } else if (this.f2170c.isForceMaskEnabled()) {
            i = 3;
        } else {
            C2920x c2920x = this.f2169b;
            if (c2920x != null && c2920x.m1229a(view)) {
                z3 = true;
            }
            i = z3 ? 2 : 1;
        }
        if (i != 1) {
            Logger logger = this.f2171d;
            if (i == 1) {
                str = "No force masking detected";
            } else if (i == 2) {
                str = "Animation Detected";
            } else if (i == 3) {
                str = "XPF Bridge force masking";
            } else {
                if (i != 4) {
                    throw null;
                }
                str = "Remote Force Masking";
            }
            logger.m831i("Force Masking is enabled. Reason: ".concat(str));
        }
        if (i == 4) {
            Telemetry.INSTANCE.collect$library_release("remote_force_masking", Boolean.TRUE);
        }
        return i;
    }
}
