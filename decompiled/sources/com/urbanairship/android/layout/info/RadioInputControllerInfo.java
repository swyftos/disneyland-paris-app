package com.urbanairship.android.layout.info;

import com.facebook.react.uimanager.ViewProps;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.json.JsonMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010\u001cR\u001a\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0012\u0010+\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010$R\u0012\u0010-\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0004\u0018\u000100X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0004\u0018\u000104X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u0004\u0018\u000104X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u0004\u0018\u000104X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00106R\u001a\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010\u001cR\u0012\u0010>\u001a\u00020?X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020CX\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u0004\u0018\u00010GX\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006J"}, d2 = {"Lcom/urbanairship/android/layout/info/RadioInputControllerInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "Lcom/urbanairship/android/layout/info/Controller;", "Lcom/urbanairship/android/layout/info/Validatable;", "Lcom/urbanairship/android/layout/info/Accessible;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", "attributeName", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "getAttributeName", "()Lcom/urbanairship/android/layout/reporting/AttributeName;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "children", "", "getChildren", "()Ljava/util/List;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "enableBehaviors", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "identifier", "getIdentifier", "isRequired", "()Z", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "view", "Lcom/urbanairship/android/layout/info/ViewInfo;", "getView", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RadioInputControllerInfo extends ViewGroupInfo<ItemInfo.ViewItemInfo> implements Controller, Validatable, Accessible {
    private final /* synthetic */ Controller $$delegate_0;
    private final /* synthetic */ ValidatableInfo $$delegate_1;
    private final /* synthetic */ Accessible $$delegate_2;
    private final AttributeName attributeName;
    private final List children;

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public Boolean getAccessibilityHidden() {
        return this.$$delegate_2.getAccessibilityHidden();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.$$delegate_0.getBackgroundColor();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.$$delegate_0.getBorder();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.$$delegate_0.getCommonViewOverrides();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public String getContentDescription() {
        return this.$$delegate_2.getContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.$$delegate_0.getEnableBehaviors();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.$$delegate_0.getEventHandlers();
    }

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.$$delegate_0.getIdentifier();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public LocalizedContentDescription getLocalizedContentDescription() {
        return this.$$delegate_2.getLocalizedContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnEdit() {
        return this.$$delegate_1.getOnEdit();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnError() {
        return this.$$delegate_1.getOnError();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnValid() {
        return this.$$delegate_1.getOnValid();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.$$delegate_0.getStateTriggers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.urbanairship.android.layout.info.Controller
    @NotNull
    public ViewInfo getView() {
        return this.$$delegate_0.getView();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    public boolean isRequired() {
        return this.$$delegate_1.isRequired();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioInputControllerInfo(@NotNull JsonMap json) {
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.controller(json);
        this.$$delegate_1 = ViewInfoKt.validatable(json);
        this.$$delegate_2 = ViewInfoKt.accessible(json);
        this.attributeName = AttributeName.attributeNameFromJson(json);
        this.children = CollectionsKt.listOf(new ItemInfo.ViewItemInfo(getView()));
    }

    @Nullable
    public final AttributeName getAttributeName() {
        return this.attributeName;
    }

    @Override // com.urbanairship.android.layout.info.ViewGroupInfo
    @NotNull
    public List<ItemInfo.ViewItemInfo> getChildren() {
        return this.children;
    }
}
