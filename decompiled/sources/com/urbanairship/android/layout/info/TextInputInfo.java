package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.info.TextInputInfo;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.FormInputType;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.android.layout.property.TextInputTextAppearance;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002]^B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010&X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010)R\u0013\u0010-\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0013\u0010/\u001a\u0004\u0018\u000100¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u0010 R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0012\u00109\u001a\u00020\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u0004\u0018\u00010<X\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u0004\u0018\u00010@X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0014\u0010E\u001a\u0004\u0018\u00010@X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010BR\u0019\u0010G\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bI\u0010)R\u001a\u0010J\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010&X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010)R\u0011\u0010M\u001a\u00020N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0012\u0010Q\u001a\u00020RX\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0013\u0010U\u001a\u0004\u0018\u00010V¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010Y\u001a\u0004\u0018\u00010ZX\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006_"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo;", "Lcom/urbanairship/android/layout/info/ViewInfo;", "Lcom/urbanairship/android/layout/info/View;", "Lcom/urbanairship/android/layout/info/Identifiable;", "Lcom/urbanairship/android/layout/info/Accessible;", "Lcom/urbanairship/android/layout/info/Validatable;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", "attributeName", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "getAttributeName", "()Lcom/urbanairship/android/layout/reporting/AttributeName;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "contentDescription", "", "getContentDescription", "()Ljava/lang/String;", "emailRegistrationOptions", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "getEmailRegistrationOptions", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "enableBehaviors", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "()Ljava/util/List;", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "hintText", "getHintText", "iconEnd", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "getIconEnd", "()Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "identifier", "getIdentifier", "inputType", "Lcom/urbanairship/android/layout/property/FormInputType;", "getInputType", "()Lcom/urbanairship/android/layout/property/FormInputType;", "isRequired", "()Z", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "smsLocales", "Lcom/urbanairship/android/layout/property/SmsLocale;", "getSmsLocales", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "textAppearance", "Lcom/urbanairship/android/layout/property/TextInputTextAppearance;", "getTextAppearance", "()Lcom/urbanairship/android/layout/property/TextInputTextAppearance;", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "viewOverrides", "Lcom/urbanairship/android/layout/info/TextInputInfo$ViewOverrides;", "getViewOverrides", "()Lcom/urbanairship/android/layout/info/TextInputInfo$ViewOverrides;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "IconEnd", "ViewOverrides", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n44#2,15:945\n79#2,16:960\n44#2,15:976\n79#2,16:991\n1#3:1007\n1549#4:1008\n1620#4,3:1009\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo\n*L\n628#1:945,15\n629#1:960,16\n631#1:976,15\n633#1:991,16\n646#1:1008\n646#1:1009,3\n*E\n"})
/* loaded from: classes5.dex */
public final class TextInputInfo extends ViewInfo implements View, Identifiable, Accessible, Validatable {
    private final /* synthetic */ View $$delegate_0;
    private final /* synthetic */ Identifiable $$delegate_1;
    private final /* synthetic */ Accessible $$delegate_2;
    private final /* synthetic */ ValidatableInfo $$delegate_3;
    private final AttributeName attributeName;
    private final ThomasEmailRegistrationOptions emailRegistrationOptions;
    private final String hintText;
    private final IconEnd iconEnd;
    private final FormInputType inputType;
    private final List smsLocales;
    private final TextInputTextAppearance textAppearance;
    private final ViewOverrides viewOverrides;

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
        return this.$$delegate_1.getIdentifier();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public LocalizedContentDescription getLocalizedContentDescription() {
        return this.$$delegate_2.getLocalizedContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnEdit() {
        return this.$$delegate_3.getOnEdit();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnError() {
        return this.$$delegate_3.getOnError();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnValid() {
        return this.$$delegate_3.getOnValid();
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

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    public boolean isRequired() {
        return this.$$delegate_3.isRequired();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "", "type", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type;", "(Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type;)V", "getType", "()Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type;", "Companion", "Floating", "Type", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Floating;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class IconEnd {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Type type;

        public /* synthetic */ IconEnd(Type type, DefaultConstructorMarker defaultConstructorMarker) {
            this(type);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:961\n1#3:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Companion\n*L\n674#1:945,15\n678#1:961,15\n*E\n"})
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Type.values().length];
                    try {
                        iArr[Type.FLOATING.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final IconEnd fromJson(@NotNull JsonMap json) throws JsonException {
                String strOptString;
                JsonMap jsonMapOptMap;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonValue jsonValue = json.get("type");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                if (WhenMappings.$EnumSwitchMapping$0[Type.INSTANCE.fromJson(strOptString).ordinal()] != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                JsonValue jsonValue3 = json.get("icon");
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: 'icon" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue3.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue3.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue3.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue3.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'icon" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue4;
                }
                Image.Icon iconFromJson = Image.Icon.fromJson(jsonMapOptMap);
                Intrinsics.checkNotNullExpressionValue(iconFromJson, "fromJson(...)");
                return new Floating(iconFromJson);
            }

            private Companion() {
            }
        }

        private IconEnd(Type type) {
            this.type = type;
        }

        @NotNull
        public final Type getType() {
            return this.type;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Floating;", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "icon", "Lcom/urbanairship/android/layout/property/Image$Icon;", "(Lcom/urbanairship/android/layout/property/Image$Icon;)V", "getIcon", "()Lcom/urbanairship/android/layout/property/Image$Icon;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Floating extends IconEnd {
            private final Image.Icon icon;

            public static /* synthetic */ Floating copy$default(Floating floating, Image.Icon icon, int i, Object obj) {
                if ((i & 1) != 0) {
                    icon = floating.icon;
                }
                return floating.copy(icon);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Image.Icon getIcon() {
                return this.icon;
            }

            @NotNull
            public final Floating copy(@NotNull Image.Icon icon) {
                Intrinsics.checkNotNullParameter(icon, "icon");
                return new Floating(icon);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Floating) && Intrinsics.areEqual(this.icon, ((Floating) other).icon);
            }

            public int hashCode() {
                return this.icon.hashCode();
            }

            @NotNull
            public String toString() {
                return "Floating(icon=" + this.icon + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Floating(@NotNull Image.Icon icon) {
                super(Type.FLOATING, null);
                Intrinsics.checkNotNullParameter(icon, "icon");
                this.icon = icon;
            }

            @NotNull
            public final Image.Icon getIcon() {
                return this.icon;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FLOATING", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Type {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final Type FLOATING = new Type("FLOATING", 0, "floating");
            private final String value;

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{FLOATING};
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            public static Type valueOf(String str) {
                return (Type) Enum.valueOf(Type.class, str);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            private Type(String str, int i, String str2) {
                this.value = str2;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
                INSTANCE = new Companion(null);
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n288#2,2:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$IconEnd$Type$Companion\n*L\n665#1:945,2\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Type fromJson(@NotNull String value) throws JsonException {
                    Type next;
                    Intrinsics.checkNotNullParameter(value, "value");
                    Iterator<Type> it = Type.getEntries().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (StringsKt.equals(next.getValue(), value, true)) {
                            break;
                        }
                    }
                    Type type = next;
                    if (type != null) {
                        return type;
                    }
                    throw new JsonException("Invalid IconEnd type: " + value);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x054f  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInputInfo(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 1668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.TextInputInfo.<init>(com.urbanairship.json.JsonMap):void");
    }

    @NotNull
    public final FormInputType getInputType() {
        return this.inputType;
    }

    @Nullable
    public final String getHintText() {
        return this.hintText;
    }

    @NotNull
    public final TextInputTextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    @Nullable
    public final AttributeName getAttributeName() {
        return this.attributeName;
    }

    @Nullable
    public final IconEnd getIconEnd() {
        return this.iconEnd;
    }

    @Nullable
    public final ViewOverrides getViewOverrides() {
        return this.viewOverrides;
    }

    @Nullable
    public final ThomasEmailRegistrationOptions getEmailRegistrationOptions() {
        return this.emailRegistrationOptions;
    }

    @Nullable
    public final List<SmsLocale> getSmsLocales() {
        return this.smsLocales;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/info/TextInputInfo$ViewOverrides;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "iconEnd", "", "Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", "Lcom/urbanairship/android/layout/info/TextInputInfo$IconEnd;", "getIconEnd", "()Ljava/util/List;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$ViewOverrides\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n1549#2:945\n1620#2,3:946\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/TextInputInfo$ViewOverrides\n*L\n649#1:945\n649#1:946,3\n*E\n"})
    public static final class ViewOverrides {
        private final List iconEnd;

        public ViewOverrides(@NotNull JsonMap json) throws JsonException {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "icon_end");
            if (jsonListOptionalList != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
                for (JsonValue jsonValue : jsonListOptionalList) {
                    Intrinsics.checkNotNull(jsonValue);
                    arrayList.add(new ViewPropertyOverride(jsonValue, new Function1() { // from class: com.urbanairship.android.layout.info.TextInputInfo$ViewOverrides$iconEnd$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final TextInputInfo.IconEnd invoke(JsonValue value) {
                            Intrinsics.checkNotNullParameter(value, "value");
                            TextInputInfo.IconEnd.Companion companion = TextInputInfo.IconEnd.INSTANCE;
                            JsonMap jsonMapOptMap = value.optMap();
                            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                            return companion.fromJson(jsonMapOptMap);
                        }
                    }));
                }
            } else {
                arrayList = null;
            }
            this.iconEnd = arrayList;
        }

        @Nullable
        public final List<ViewPropertyOverride<IconEnd>> getIconEnd() {
            return this.iconEnd;
        }
    }
}
