package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nDependenciesScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DependenciesScanner.kt\ncom/contentsquare/android/internal/core/telemetry/collector/static/DependenciesScanner\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,83:1\n457#2:84\n403#2:85\n1238#3,2:86\n1241#3:92\n970#4:88\n1041#4,3:89\n*S KotlinDebug\n*F\n+ 1 DependenciesScanner.kt\ncom/contentsquare/android/internal/core/telemetry/collector/static/DependenciesScanner\n*L\n66#1:84\n66#1:85\n66#1:86,2\n66#1:92\n67#1:88\n67#1:89,3\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.b1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0632b1 {

    @NotNull
    public final ClassLoader a;

    @NotNull
    public final Logger b;

    @NotNull
    public final Map<String, Integer> c;

    public C0632b1(@NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.a = classLoader;
        this.b = new Logger("DependenciesCollector");
        this.c = MapsKt.mapOf(TuplesKt.to("oay.pmfmpas.mzpdaup.oadq.uzfqdzmx.pmfm.gbxamp.GbxampIadwqd", 2), TuplesKt.to("oay.saasxq.rudqnmeq.odmetxkfuoe.OdmetxkfuoeDqsuefdmd", 3), TuplesKt.to("oay.fqefrmudk.FqefRmudk", 5), TuplesKt.to("oay.uzefmngs.xundmdk.D", 6), TuplesKt.to("oay.zqidqxuo.msqzf.mzpdaup.ZqiDqxuo", 7), TuplesKt.to("ua.eqzfdk.mzpdaup.oadq.EqzfdkMzpdaupAbfuaze", 8), TuplesKt.to("oay.pkzmfdmoq.mzpdaup.mbb.Mbbxuomfuaz", 9), TuplesKt.to("oay.saasxq.rudqnmeq.bqdr.RudqnmeqBqdrDqsuefdmd", 10), TuplesKt.to("awtffb3.uzfqdzmx.bgnxuoegrruj.BgnxuoEgrrujPmfmnmeq", 11), TuplesKt.to("mzpdaupj.oaybaeq.gu.bxmfrady.MzpdaupOaybaeqHuqi", 12), TuplesKt.to("oay.oazfqzfecgmdq.NguxpOazrus", 13), TuplesKt.to("ua.tqmb.oazfqzfecgmdq.oendupsq.TqmbOazfqzfecgmdqUzfqsdmfuaz", 14), TuplesKt.to("ua.tqmb.oadq.Tqmb", 15));
    }
}
