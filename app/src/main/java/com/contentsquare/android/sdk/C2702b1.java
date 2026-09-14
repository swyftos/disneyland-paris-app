package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.b1 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nDependenciesScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DependenciesScanner.kt\ncom/contentsquare/android/internal/core/telemetry/collector/static/DependenciesScanner\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,83:1\n457#2:84\n403#2:85\n1238#3,2:86\n1241#3:92\n970#4:88\n1041#4,3:89\n*S KotlinDebug\n*F\n+ 1 DependenciesScanner.kt\ncom/contentsquare/android/internal/core/telemetry/collector/static/DependenciesScanner\n*L\n66#1:84\n66#1:85\n66#1:86,2\n66#1:92\n67#1:88\n67#1:89,3\n*E\n"})
public final class C2702b1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ClassLoader f2399a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f2400b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Map<String, Integer> f2401c;

    public C2702b1(@NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.f2399a = classLoader;
        this.f2400b = new Logger("DependenciesCollector");
        this.f2401c = MapsKt.mapOf(TuplesKt.m1842to("oay.pmfmpas.mzpdaup.oadq.uzfqdzmx.pmfm.gbxamp.GbxampIadwqd", 2), TuplesKt.m1842to("oay.saasxq.rudqnmeq.odmetxkfuoe.OdmetxkfuoeDqsuefdmd", 3), TuplesKt.m1842to("oay.fqefrmudk.FqefRmudk", 5), TuplesKt.m1842to("oay.uzefmngs.xundmdk.D", 6), TuplesKt.m1842to("oay.zqidqxuo.msqzf.mzpdaup.ZqiDqxuo", 7), TuplesKt.m1842to("ua.eqzfdk.mzpdaup.oadq.EqzfdkMzpdaupAbfuaze", 8), TuplesKt.m1842to("oay.pkzmfdmoq.mzpdaup.mbb.Mbbxuomfuaz", 9), TuplesKt.m1842to("oay.saasxq.rudqnmeq.bqdr.RudqnmeqBqdrDqsuefdmd", 10), TuplesKt.m1842to("awtffb3.uzfqdzmx.bgnxuoegrruj.BgnxuoEgrrujPmfmnmeq", 11), TuplesKt.m1842to("mzpdaupj.oaybaeq.gu.bxmfrady.MzpdaupOaybaeqHuqi", 12), TuplesKt.m1842to("oay.oazfqzfecgmdq.NguxpOazrus", 13), TuplesKt.m1842to("ua.tqmb.oazfqzfecgmdq.oendupsq.TqmbOazfqzfecgmdqUzfqsdmfuaz", 14), TuplesKt.m1842to("ua.tqmb.oadq.Tqmb", 15));
    }
}
