package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.json.JsonValue;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u00060\fj\u0002`\r0\nJ \u0010\u000e\u001a\u00020\b*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\fj\u0002`\rH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/environment/AttributeHandler;", "", "contactEditorFactory", "Lkotlin/Function0;", "Lcom/urbanairship/channel/AttributeEditor;", "channelEditorFactory", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "", "attributes", "", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "setAttributeValue", "attribute", "", "value", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AttributeHandler {
    private final Function0 channelEditorFactory;
    private final Function0 contactEditorFactory;

    public AttributeHandler() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public AttributeHandler(@NotNull Function0<? extends AttributeEditor> contactEditorFactory, @NotNull Function0<? extends AttributeEditor> channelEditorFactory) {
        Intrinsics.checkNotNullParameter(contactEditorFactory, "contactEditorFactory");
        Intrinsics.checkNotNullParameter(channelEditorFactory, "channelEditorFactory");
        this.contactEditorFactory = contactEditorFactory;
        this.channelEditorFactory = channelEditorFactory;
    }

    public /* synthetic */ AttributeHandler(Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function0() { // from class: com.urbanairship.android.layout.environment.AttributeHandler.1
            @Override // kotlin.jvm.functions.Function0
            public final AttributeEditor invoke() {
                return UAirship.shared().getContact().editAttributes();
            }
        } : function0, (i & 2) != 0 ? new Function0() { // from class: com.urbanairship.android.layout.environment.AttributeHandler.2
            @Override // kotlin.jvm.functions.Function0
            public final AttributeEditor invoke() {
                return UAirship.shared().getChannel().editAttributes();
            }
        } : function02);
    }

    public final void update(@NotNull Map<AttributeName, ? extends JsonValue> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        AttributeEditor attributeEditor = (AttributeEditor) this.contactEditorFactory.invoke();
        AttributeEditor attributeEditor2 = (AttributeEditor) this.channelEditorFactory.invoke();
        for (Map.Entry<AttributeName, ? extends JsonValue> entry : attributes.entrySet()) {
            AttributeName key = entry.getKey();
            JsonValue value = entry.getValue();
            String contact = key.isContact() ? key.getContact() : key.getChannel();
            if (contact != null && !value.isNull()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting ");
                sb.append(key.isChannel() ? TCVideoEventPropertiesNames.TCV_CHANNEL : "contact");
                sb.append(" attribute: '");
                sb.append(contact);
                sb.append("' => '");
                sb.append(value);
                sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
                UALog.v(sb.toString(), new Object[0]);
                setAttributeValue(key.isContact() ? attributeEditor : attributeEditor2, contact, value);
            }
        }
        attributeEditor.apply();
        attributeEditor2.apply();
    }

    private final void setAttributeValue(AttributeEditor attributeEditor, String str, JsonValue jsonValue) throws IllegalArgumentException {
        if (jsonValue.isString()) {
            String strOptString = jsonValue.optString();
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            attributeEditor.setAttribute(str, strOptString);
        } else {
            if (jsonValue.isDouble()) {
                attributeEditor.setAttribute(str, jsonValue.getDouble(-1.0d));
                return;
            }
            if (jsonValue.isFloat()) {
                attributeEditor.setAttribute(str, jsonValue.getFloat(-1.0f));
            } else if (jsonValue.isInteger()) {
                attributeEditor.setAttribute(str, jsonValue.getInt(-1));
            } else if (jsonValue.isLong()) {
                attributeEditor.setAttribute(str, jsonValue.getLong(-1L));
            }
        }
    }
}
