package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/android/layout/info/ToggleInfo;", "Lcom/urbanairship/android/layout/info/CheckableInfo;", "Lcom/urbanairship/android/layout/info/Identifiable;", "Lcom/urbanairship/android/layout/info/Validatable;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "attributeName", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "getAttributeName", "()Lcom/urbanairship/android/layout/reporting/AttributeName;", "attributeValue", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "getAttributeValue", "()Lcom/urbanairship/json/JsonValue;", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "isRequired", "", "()Z", "onEdit", "Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", PDFView.EVENT_ON_ERROR, "getOnError", "onValid", "getOnValid", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ToggleInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n79#2,16:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ToggleInfo\n*L\n616#1:945,16\n*E\n"})
/* loaded from: classes5.dex */
public final class ToggleInfo extends CheckableInfo implements Identifiable, Validatable {
    private final /* synthetic */ Identifiable $$delegate_0;
    private final /* synthetic */ ValidatableInfo $$delegate_1;
    private final AttributeName attributeName;
    private final JsonValue attributeValue;

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.$$delegate_0.getIdentifier();
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

    @Override // com.urbanairship.android.layout.info.Validatable
    public boolean isRequired() {
        return this.$$delegate_1.isRequired();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleInfo(@NotNull JsonMap json) throws JsonException {
        JsonValue jsonValue;
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.identifiable(json);
        this.$$delegate_1 = ViewInfoKt.validatable(json);
        this.attributeName = AttributeName.attributeNameFromJson(json);
        JsonValue jsonValue2 = json.get("attribute_value");
        if (jsonValue2 == null) {
            jsonValue = null;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                jsonValue = (JsonValue) jsonValue2.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonValue = (JsonValue) jsonValue2.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonValue = (JsonValue) jsonValue2.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'attribute_value" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue2.getJsonValue();
            }
        }
        this.attributeValue = jsonValue;
    }

    @Nullable
    public final AttributeName getAttributeName() {
        return this.attributeName;
    }

    @Nullable
    public final JsonValue getAttributeValue() {
        return this.attributeValue;
    }
}
