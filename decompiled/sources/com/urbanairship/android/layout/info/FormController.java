package com.urbanairship.android.layout.info;

import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.FormBehaviorType;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/info/FormController;", "Lcom/urbanairship/android/layout/info/Controller;", "formEnabled", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getFormEnabled", "()Ljava/util/List;", "responseType", "", "getResponseType", "()Ljava/lang/String;", "submitBehavior", "Lcom/urbanairship/android/layout/property/FormBehaviorType;", "getSubmitBehavior", "()Lcom/urbanairship/android/layout/property/FormBehaviorType;", "validationMode", "Lcom/urbanairship/android/layout/info/FormValidationMode;", "getValidationMode", "()Lcom/urbanairship/android/layout/info/FormValidationMode;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FormController extends Controller {
    @Nullable
    List<EnableBehaviorType> getFormEnabled();

    @Nullable
    String getResponseType();

    @Nullable
    FormBehaviorType getSubmitBehavior();

    @NotNull
    FormValidationMode getValidationMode();
}
