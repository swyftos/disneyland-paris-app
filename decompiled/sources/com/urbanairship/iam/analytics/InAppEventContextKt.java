package com.urbanairship.iam.analytics;

import com.urbanairship.android.layout.reporting.FormInfo;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.reporting.PagerData;
import com.urbanairship.experiment.ExperimentResult;
import com.urbanairship.iam.analytics.InAppEventContext;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a6\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0012"}, d2 = {"makeButtonContext", "Lcom/urbanairship/iam/analytics/InAppEventContext$Button;", "Lcom/urbanairship/iam/analytics/InAppEventContext$Companion;", "context", "Lcom/urbanairship/android/layout/reporting/LayoutData;", "makeContext", "Lcom/urbanairship/iam/analytics/InAppEventContext;", "reportingContext", "Lcom/urbanairship/json/JsonValue;", "experimentResult", "Lcom/urbanairship/experiment/ExperimentResult;", "layoutContext", "displayContext", "Lcom/urbanairship/iam/analytics/InAppEventContext$Display;", "makeFormContext", "Lcom/urbanairship/iam/analytics/InAppEventContext$Form;", "makePagerContext", "Lcom/urbanairship/iam/analytics/InAppEventContext$Pager;", "urbanairship-automation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppEventContextKt {
    @Nullable
    public static final InAppEventContext makeContext(@NotNull InAppEventContext.Companion companion, @Nullable JsonValue jsonValue, @Nullable ExperimentResult experimentResult, @Nullable LayoutData layoutData, @Nullable InAppEventContext.Display display) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        InAppEventContext inAppEventContext = new InAppEventContext(makePagerContext(companion, layoutData), makeButtonContext(companion, layoutData), makeFormContext(companion, layoutData), display, jsonValue, experimentResult != null ? experimentResult.getAllEvaluatedExperimentsMetadata() : null);
        if (inAppEventContext.isValid$urbanairship_automation_release()) {
            return inAppEventContext;
        }
        return null;
    }

    private static final InAppEventContext.Button makeButtonContext(InAppEventContext.Companion companion, LayoutData layoutData) {
        String buttonIdentifier;
        if (layoutData == null || (buttonIdentifier = layoutData.getButtonIdentifier()) == null) {
            return null;
        }
        return new InAppEventContext.Button(buttonIdentifier);
    }

    private static final InAppEventContext.Form makeFormContext(InAppEventContext.Companion companion, LayoutData layoutData) {
        FormInfo formInfo;
        if (layoutData == null || (formInfo = layoutData.getFormInfo()) == null) {
            return null;
        }
        String identifier = formInfo.getIdentifier();
        Intrinsics.checkNotNullExpressionValue(identifier, "getIdentifier(...)");
        Boolean formSubmitted = formInfo.getFormSubmitted();
        if (formSubmitted == null) {
            formSubmitted = Boolean.FALSE;
        }
        boolean zBooleanValue = formSubmitted.booleanValue();
        String formType = formInfo.getFormType();
        Intrinsics.checkNotNullExpressionValue(formType, "getFormType(...)");
        return new InAppEventContext.Form(identifier, zBooleanValue, formType, formInfo.getFormResponseType());
    }

    private static final InAppEventContext.Pager makePagerContext(InAppEventContext.Companion companion, LayoutData layoutData) {
        PagerData pagerData;
        if (layoutData == null || (pagerData = layoutData.getPagerData()) == null) {
            return null;
        }
        return new InAppEventContext.Pager(pagerData.getIdentifier(), pagerData.getPageId(), pagerData.getIndex(), pagerData.isCompleted(), pagerData.getHistory(), pagerData.getCount());
    }
}
