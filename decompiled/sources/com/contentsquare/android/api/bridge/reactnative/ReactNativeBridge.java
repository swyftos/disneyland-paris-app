package com.contentsquare.android.api.bridge.reactnative;

import com.contentsquare.android.core.communication.error.ErrorAnalysisInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C0644c3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/api/bridge/reactnative/ReactNativeBridge;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "sendError", "", ErrorBundle.DETAIL_ENTRY, "", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReactNativeBridge {

    @NotNull
    public static final ReactNativeBridge INSTANCE = new ReactNativeBridge();

    @NotNull
    private static final Logger logger = new Logger("ReactNativeBridge");

    private ReactNativeBridge() {
    }

    @JvmStatic
    public static final void sendError(@NotNull Map<String, ? extends Object> details) {
        Intrinsics.checkNotNullParameter(details, "details");
        ArrayList arrayList = C0644c3.b;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next != null ? next instanceof ErrorAnalysisInterface : true) {
                arrayList2.add(next);
            }
        }
        ErrorAnalysisInterface errorAnalysisInterface = (ErrorAnalysisInterface) CollectionsKt.firstOrNull((List) arrayList2);
        if (errorAnalysisInterface != null) {
            errorAnalysisInterface.sendReactNativeError(details);
        } else {
            logger.e("Unable to send React Native error - Error Analysis module is not available");
        }
    }
}
