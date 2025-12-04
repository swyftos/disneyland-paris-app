package com.contentsquare.android.error.analysis.apierror;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/NetworkEventProcessor;", "", "processEvent", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "rawEvent", "setUrlMaskingPatterns", "", "patterns", "", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface NetworkEventProcessor {
    @Nullable
    NetworkEvent processEvent(NetworkEvent rawEvent);

    void setUrlMaskingPatterns(List<String> patterns);
}
