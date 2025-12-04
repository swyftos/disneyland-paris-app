package com.contentsquare.android.error.analysis.apierror;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\u001a\u0010\t\u001a\u00020\u0007*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "urlsAllowed", "", "", "urlsExcluded", "isAccepted", "", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "isValidUrl", "validUrls", "error-analysis_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkEventFilter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkEventFilter.kt\ncom/contentsquare/android/error/analysis/apierror/NetworkEventFilterKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,55:1\n1747#2,3:56\n2624#2,3:59\n766#2:62\n857#2,2:63\n1747#2,3:65\n*S KotlinDebug\n*F\n+ 1 NetworkEventFilter.kt\ncom/contentsquare/android/error/analysis/apierror/NetworkEventFilterKt\n*L\n27#1:56,3\n31#1:59,3\n48#1:62\n48#1:63,2\n48#1:65,3\n*E\n"})
/* loaded from: classes2.dex */
public final class NetworkEventFilterKt {

    @NotNull
    private static final List<String> urlsExcluded = CollectionsKt.listOf((Object[]) new String[]{"csq.io", "contentsquare.net", "csqtrk.net"});

    @NotNull
    private static final List<String> urlsAllowed = CollectionsKt.listOf("qa-mock-server.contentsquare.net");

    @NotNull
    private static final Logger logger = new Logger("NetworkEventFilter");

    public static final boolean isAccepted(NetworkEvent networkEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        boolean z2 = true;
        try {
            List<String> list = urlsAllowed;
            if (list == null || !list.isEmpty()) {
                for (String str : list) {
                    String host = new URI(networkEvent.getUrl()).getHost();
                    if (host == null) {
                        host = "";
                    }
                    if (StringsKt.endsWith$default(host, str, false, 2, (Object) null)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            List<String> list2 = urlsExcluded;
            if (list2 == null || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    String host2 = new URI(networkEvent.getUrl()).getHost();
                    if (host2 == null) {
                        host2 = "";
                    }
                    if (StringsKt.endsWith$default(host2, str2, false, 2, (Object) null)) {
                        z2 = false;
                        break;
                    }
                }
            }
            return z2 | z;
        } catch (URISyntaxException e) {
            logger.d(e, "Cannot parse url: " + networkEvent.getUrl());
            return true;
        }
    }

    public static final boolean isValidUrl(NetworkEvent networkEvent, List<String> list) {
        Intrinsics.checkNotNullParameter(networkEvent, "<this>");
        if (list == null) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) UrlExtensionsKt.removeUrlParameters(networkEvent.getUrl()), (CharSequence) it.next(), false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        } catch (URISyntaxException e) {
            logger.d(e, "Cannot parse url: " + networkEvent.getUrl());
            return false;
        }
    }
}
