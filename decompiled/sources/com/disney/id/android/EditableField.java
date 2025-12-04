package com.disney.id.android;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0000H\u0002J\r\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/EditableField;", "", "id", "", "value", "required", "", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getId", "()Ljava/lang/String;", "isValid", "()Z", "name", "getName", "getRequired", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "checkIsValid", "field", "toJSONObject", "toJSONObject$OneID_release", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEditableField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EditableField.kt\ncom/disney/id/android/EditableField\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n800#2,11:172\n800#2,11:183\n*S KotlinDebug\n*F\n+ 1 EditableField.kt\ncom/disney/id/android/EditableField\n*L\n138#1:172,11\n161#1:183,11\n*E\n"})
/* loaded from: classes3.dex */
public final class EditableField {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final boolean required;
    private Object value;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u000e"}, d2 = {"Lcom/disney/id/android/EditableField$Companion;", "", "()V", "fromJSON", "", "Lcom/disney/id/android/EditableField;", "jsonString", "", "fromJSONArray", "jsonArray", "Lorg/json/JSONArray;", "toJSONArray", "fields", "toJSONString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String toJSONString(@NotNull List<EditableField> fields) {
            Intrinsics.checkNotNullParameter(fields, "fields");
            String string = toJSONArray(fields).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        @NotNull
        public final JSONArray toJSONArray(@NotNull List<EditableField> fields) {
            Intrinsics.checkNotNullParameter(fields, "fields");
            JSONArray jSONArray = new JSONArray();
            Iterator<EditableField> it = fields.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSONObject$OneID_release());
            }
            return jSONArray;
        }

        @NotNull
        public final List<EditableField> fromJSONArray(@NotNull JSONArray jsonArray) throws JSONException {
            Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jsonArray.get(i);
                JSONObject jSONObject = obj instanceof JSONObject ? (JSONObject) obj : null;
                if (jSONObject != null) {
                    arrayList.add(new EditableField(jSONObject));
                }
            }
            return CollectionsKt.toList(arrayList);
        }

        @NotNull
        public final List<EditableField> fromJSON(@NotNull String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            return fromJSONArray(new JSONArray(jsonString));
        }
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public final void setValue(@Nullable Object obj) {
        this.value = obj;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final boolean isValid() {
        return checkIsValid(this);
    }

    @NotNull
    public final String getName() {
        return (String) StringsKt.split$default((CharSequence) this.id, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null).get(r6.size() - 1);
    }

    public EditableField(@NotNull String id, @Nullable Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.value = obj;
        this.required = z;
    }

    public /* synthetic */ EditableField(String str, Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? false : z);
    }

    public EditableField(@NotNull JSONObject jsonObject) throws JSONException {
        Object obj;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        String string = jsonObject.getString(EditableFieldKeys.ID.getKey());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.id = string;
        this.required = jsonObject.getBoolean(EditableFieldKeys.REQUIRED.getKey());
        Object obj2 = jsonObject.get(EditableFieldKeys.VALUE.getKey());
        Unit unit = null;
        JSONArray jSONArray = obj2 instanceof JSONArray ? (JSONArray) obj2 : null;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                Object obj3 = jSONArray.get(i);
                JSONObject jSONObject = obj3 instanceof JSONObject ? (JSONObject) obj3 : null;
                if (jSONObject != null) {
                    arrayList.add(new EditableField(jSONObject));
                }
            }
            List list = CollectionsKt.toList(arrayList);
            unit = Unit.INSTANCE;
            obj = list;
        } else {
            obj = null;
        }
        this.value = unit == null ? Intrinsics.areEqual(obj2, JSONObject.NULL) ? obj : obj2 : obj;
    }

    private final boolean checkIsValid(EditableField field) {
        Object obj = field.value;
        Unit unit = null;
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (obj2 instanceof EditableField) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!checkIsValid((EditableField) it.next())) {
                    return false;
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            return (field.required && field.value == null) ? false : true;
        }
        return true;
    }

    @NotNull
    public final JSONObject toJSONObject$OneID_release() throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(EditableFieldKeys.ID.getKey(), this.id);
        jSONObject.put(EditableFieldKeys.REQUIRED.getKey(), this.required);
        Object obj2 = this.value;
        Unit unit = null;
        List list = obj2 instanceof List ? (List) obj2 : null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list) {
                if (obj3 instanceof EditableField) {
                    arrayList.add(obj3);
                }
            }
            JSONArray jSONArray = INSTANCE.toJSONArray(arrayList);
            unit = Unit.INSTANCE;
            obj = jSONArray;
        } else {
            obj = null;
        }
        if (unit == null) {
            obj = this.value;
        }
        String key = EditableFieldKeys.VALUE.getKey();
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        jSONObject.put(key, obj);
        return jSONObject;
    }
}
