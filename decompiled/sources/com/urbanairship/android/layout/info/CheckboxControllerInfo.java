package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u001a\u0010$\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0018R\u0012\u0010'\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010 R\u0012\u0010)\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u0004\u0018\u00010,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0014\u00105\u001a\u0004\u0018\u000106X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u00109\u001a\u0004\u0018\u000106X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00108R\u0014\u0010;\u001a\u0004\u0018\u000106X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u00108R\u001a\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010\u0018R\u0012\u0010@\u001a\u00020AX\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0012\u0010D\u001a\u00020EX\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u0004\u0018\u00010IX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Lcom/urbanairship/android/layout/info/CheckboxControllerInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "Lcom/urbanairship/android/layout/info/Controller;", "Lcom/urbanairship/android/layout/info/Validatable;", "Lcom/urbanairship/android/layout/info/Accessible;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "children", "", "getChildren", "()Ljava/util/List;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "enableBehaviors", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "identifier", "getIdentifier", "isRequired", "()Z", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "maxSelection", "", "getMaxSelection", "()I", "minSelection", "getMinSelection", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "view", "Lcom/urbanairship/android/layout/info/ViewInfo;", "getView", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CheckboxControllerInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n79#2,16:945\n79#2,16:961\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CheckboxControllerInfo\n*L\n921#1:945,16\n922#1:961,16\n*E\n"})
/* loaded from: classes5.dex */
public final class CheckboxControllerInfo extends ViewGroupInfo<ItemInfo.ViewItemInfo> implements Controller, Validatable, Accessible {
    private final /* synthetic */ Controller $$delegate_0;
    private final /* synthetic */ ValidatableInfo $$delegate_1;
    private final /* synthetic */ Accessible $$delegate_2;
    private final List children;
    private final int maxSelection;
    private final int minSelection;

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
    public CheckboxControllerInfo(@NotNull JsonMap json) throws JsonException {
        Integer numValueOf;
        Integer numValueOf2;
        Integer num;
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.controller(json);
        this.$$delegate_1 = ViewInfoKt.validatable(json);
        this.$$delegate_2 = ViewInfoKt.accessible(json);
        JsonValue jsonValue = json.get("min_selection");
        if (jsonValue == null) {
            numValueOf = null;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf = (Integer) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf = (Integer) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                numValueOf = (Integer) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf = (Integer) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf = (Integer) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf = (Integer) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf = Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf = (Integer) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf = (Integer) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'min_selection" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf = (Integer) jsonValue2;
            }
        }
        this.minSelection = numValueOf != null ? numValueOf.intValue() : isRequired() ? 1 : 0;
        JsonValue jsonValue3 = json.get("max_selection");
        if (jsonValue3 == null) {
            num = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString3 = jsonValue3.optString();
                if (objOptString3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf2 = (Integer) objOptString3;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString4 = jsonValue3.optString();
                if (objOptString4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf2 = (Integer) objOptString4;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                numValueOf2 = (Integer) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                numValueOf2 = (Integer) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                numValueOf2 = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                numValueOf2 = (Integer) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                numValueOf2 = (Integer) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                numValueOf2 = Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                numValueOf2 = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList2 = jsonValue3.optList();
                if (objOptList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf2 = (Integer) objOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap2 = jsonValue3.optMap();
                if (objOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf2 = (Integer) objOptMap2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'max_selection" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue4 = jsonValue3.getJsonValue();
                if (jsonValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                numValueOf2 = (Integer) jsonValue4;
            }
            num = numValueOf2;
        }
        this.maxSelection = num != null ? num.intValue() : Integer.MAX_VALUE;
        this.children = CollectionsKt.listOf(new ItemInfo.ViewItemInfo(getView()));
    }

    public final int getMinSelection() {
        return this.minSelection;
    }

    public final int getMaxSelection() {
        return this.maxSelection;
    }

    @Override // com.urbanairship.android.layout.info.ViewGroupInfo
    @NotNull
    public List<ItemInfo.ViewItemInfo> getChildren() {
        return this.children;
    }
}
