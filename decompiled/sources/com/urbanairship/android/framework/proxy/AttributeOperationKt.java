package com.urbanairship.android.framework.proxy;

import androidx.camera.video.AudioStats;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"applyOperation", "", "Lcom/urbanairship/android/framework/proxy/AttributeOperation;", "editor", "Lcom/urbanairship/channel/AttributeEditor;", "airship-framework-proxy_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AttributeOperationKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AttributeValueType.values().length];
            try {
                iArr[AttributeValueType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttributeValueType.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttributeValueType.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AttributeValueType.JSON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AttributeOperationAction.values().length];
            try {
                iArr2[AttributeOperationAction.REMOVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AttributeOperationAction.SET.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void applyOperation(@NotNull AttributeOperation attributeOperation, @NotNull AttributeEditor editor) throws IllegalArgumentException, JsonException {
        Intrinsics.checkNotNullParameter(attributeOperation, "<this>");
        Intrinsics.checkNotNullParameter(editor, "editor");
        int i = WhenMappings.$EnumSwitchMapping$1[attributeOperation.getAction().ordinal()];
        if (i == 1) {
            if (attributeOperation.getInstanceId() == null) {
                editor.removeAttribute(attributeOperation.getAttribute());
                return;
            } else {
                editor.removeAttribute(attributeOperation.getAttribute(), attributeOperation.getInstanceId());
                return;
            }
        }
        if (i != 2) {
            return;
        }
        AttributeValueType valueType = attributeOperation.getValueType();
        if (valueType == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[valueType.ordinal()];
        if (i2 == 1) {
            String attribute = attributeOperation.getAttribute();
            JsonValue value = attributeOperation.getValue();
            if (value != null) {
                editor.setAttribute(attribute, new Date(value.getLong(0L)));
                return;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        if (i2 == 2) {
            String attribute2 = attributeOperation.getAttribute();
            JsonValue value2 = attributeOperation.getValue();
            if (value2 != null) {
                String strRequireString = value2.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                editor.setAttribute(attribute2, strRequireString);
                return;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        if (i2 == 3) {
            String attribute3 = attributeOperation.getAttribute();
            JsonValue value3 = attributeOperation.getValue();
            if (value3 != null) {
                editor.setAttribute(attribute3, value3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                return;
            }
            throw new IllegalArgumentException("Required value was null.");
        }
        if (i2 != 4) {
            return;
        }
        String attribute4 = attributeOperation.getAttribute();
        String instanceId = attributeOperation.getInstanceId();
        if (instanceId == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        Date expiry = attributeOperation.getExpiry();
        JsonValue value4 = attributeOperation.getValue();
        if (value4 != null) {
            JsonMap jsonMapRequireMap = value4.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            editor.setAttribute(attribute4, instanceId, expiry, jsonMapRequireMap);
            return;
        }
        throw new IllegalArgumentException("Required value was null.");
    }
}
