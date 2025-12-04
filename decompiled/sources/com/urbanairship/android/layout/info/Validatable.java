package com.urbanairship.android.layout.info;

import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/info/Validatable;", "", "isRequired", "", "()Z", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface Validatable {
    @Nullable
    ValidationAction getOnEdit();

    @Nullable
    ValidationAction getOnError();

    @Nullable
    ValidationAction getOnValid();

    boolean isRequired();
}
