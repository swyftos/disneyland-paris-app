package com.urbanairship.android.layout.info;

import com.rumax.reactnative.pdfviewer.PDFView;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/BasicToggleLayoutInfo;", "Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;", "Lcom/urbanairship/android/layout/info/Validatable;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "attributeName", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "getAttributeName", "()Lcom/urbanairship/android/layout/reporting/AttributeName;", "isRequired", "", "()Z", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BasicToggleLayoutInfo extends BaseToggleLayoutInfo implements Validatable {
    private final /* synthetic */ ValidatableInfo $$delegate_0;
    private final AttributeName attributeName;

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnEdit() {
        return this.$$delegate_0.getOnEdit();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnError() {
        return this.$$delegate_0.getOnError();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnValid() {
        return this.$$delegate_0.getOnValid();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    public boolean isRequired() {
        return this.$$delegate_0.isRequired();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicToggleLayoutInfo(@NotNull JsonMap json) {
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.validatable(json);
        this.attributeName = AttributeName.attributeNameFromJson(json);
    }

    @Nullable
    public final AttributeName getAttributeName() {
        return this.attributeName;
    }
}
