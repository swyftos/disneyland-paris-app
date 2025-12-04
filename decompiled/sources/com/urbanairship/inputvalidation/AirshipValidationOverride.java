package com.urbanairship.inputvalidation;

import com.urbanairship.PendingResult;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/inputvalidation/AirshipValidationOverride;", "", "getOverrides", "Lcom/urbanairship/PendingResult;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Override;", "request", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Request;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AirshipValidationOverride {
    @NotNull
    PendingResult<AirshipInputValidation.Override> getOverrides(@NotNull AirshipInputValidation.Request request);
}
