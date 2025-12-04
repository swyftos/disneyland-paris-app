package com.urbanairship.android.layout.environment;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.environment.FormType;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.ViewPropertyOverride;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J5\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001H\u0015¢\u0006\u0002\u0010\u001aJ/\u0010\u001b\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u0002H\u0015¢\u0006\u0002\u0010\u001aJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasState;", "Lcom/urbanairship/json/JsonSerializable;", "layout", "Lcom/urbanairship/android/layout/environment/State$Layout;", PreferenceCenterPayload.KEY_FORM, "Lcom/urbanairship/android/layout/environment/State$Form;", "(Lcom/urbanairship/android/layout/environment/State$Layout;Lcom/urbanairship/android/layout/environment/State$Form;)V", "getForm", "()Lcom/urbanairship/android/layout/environment/State$Form;", "getLayout", "()Lcom/urbanairship/android/layout/environment/State$Layout;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "resolveOptional", ExifInterface.GPS_DIRECTION_TRUE, "overrides", "", "Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", "default", "(Ljava/util/List;Ljava/lang/Object;)Ljava/lang/Object;", "resolveRequired", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThomasState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasState.kt\ncom/urbanairship/android/layout/environment/ThomasState\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n288#2,2:98\n*S KotlinDebug\n*F\n+ 1 ThomasState.kt\ncom/urbanairship/android/layout/environment/ThomasState\n*L\n62#1:98,2\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class ThomasState implements JsonSerializable {

    @Deprecated
    @NotNull
    public static final String CURRENT = "current";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String DATA = "data";

    @Deprecated
    @NotNull
    public static final String FORMS = "$forms";

    @Deprecated
    @NotNull
    public static final String STATUS = "status";

    @Deprecated
    @NotNull
    public static final String TYPE = "type";
    private final State.Form form;
    private final State.Layout layout;

    public static /* synthetic */ ThomasState copy$default(ThomasState thomasState, State.Layout layout, State.Form form, int i, Object obj) {
        if ((i & 1) != 0) {
            layout = thomasState.layout;
        }
        if ((i & 2) != 0) {
            form = thomasState.form;
        }
        return thomasState.copy(layout, form);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final State.Layout getLayout() {
        return this.layout;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final State.Form getForm() {
        return this.form;
    }

    @NotNull
    public final ThomasState copy(@Nullable State.Layout layout, @Nullable State.Form form) {
        return new ThomasState(layout, form);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThomasState)) {
            return false;
        }
        ThomasState thomasState = (ThomasState) other;
        return Intrinsics.areEqual(this.layout, thomasState.layout) && Intrinsics.areEqual(this.form, thomasState.form);
    }

    public int hashCode() {
        State.Layout layout = this.layout;
        int iHashCode = (layout == null ? 0 : layout.hashCode()) * 31;
        State.Form form = this.form;
        return iHashCode + (form != null ? form.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ThomasState(layout=" + this.layout + ", form=" + this.form + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ThomasState(@Nullable State.Layout layout, @Nullable State.Form form) {
        this.layout = layout;
        this.form = form;
    }

    @Nullable
    public final State.Layout getLayout() {
        return this.layout;
    }

    @Nullable
    public final State.Form getForm() {
        return this.form;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        ThomasFormField nps;
        State.Layout layout = this.layout;
        if (layout == null) {
            JsonValue NULL = JsonValue.NULL;
            Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
            return NULL;
        }
        State.Form form = this.form;
        if (form == null) {
            JsonValue jsonValue = JsonExtensionsKt.toJsonMap(layout.getState()).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
        FormType formType = form.getFormType();
        if (Intrinsics.areEqual(formType, FormType.Form.INSTANCE)) {
            nps = new ThomasFormField.Form("current", null, CollectionsKt.toSet(form.getFilteredFields().values()), ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, SetsKt.emptySet(), null, null, null, 14, null));
        } else {
            if (!(formType instanceof FormType.Nps)) {
                throw new NoWhenBranchMatchedException();
            }
            nps = new ThomasFormField.Nps("current", ((FormType.Nps) form.getFormType()).getScoreId(), null, CollectionsKt.toSet(form.getFilteredFields().values()), ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, SetsKt.emptySet(), null, null, null, 14, null));
        }
        Map mutableMap = MapsKt.toMutableMap(layout.getState());
        JsonValue jsonValue2 = JsonExtensionsKt.jsonMapOf(TuplesKt.to("current", JsonExtensionsKt.jsonMapOf(TuplesKt.to("data", ThomasFormField.formData$urbanairship_layout_release$default(nps, false, 1, null)), TuplesKt.to("status", JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", form.getStatus())))))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue2, "toJsonValue(...)");
        mutableMap.put(FORMS, jsonValue2);
        JsonValue jsonValue3 = JsonExtensionsKt.toJsonMap(mutableMap).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue3, "toJsonValue(...)");
        return jsonValue3;
    }

    public static /* synthetic */ Object resolveOptional$default(ThomasState thomasState, List list, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return thomasState.resolveOptional(list, obj);
    }

    @Nullable
    public final <T> T resolveOptional(@Nullable List<ViewPropertyOverride<T>> overrides, @Nullable T t) {
        T next;
        T t2;
        JsonValue jsonValue = getJsonValue();
        if (overrides == null) {
            return t;
        }
        Iterator<T> it = overrides.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = (T) null;
                break;
            }
            next = it.next();
            JsonPredicate whenStateMatcher = ((ViewPropertyOverride) next).getWhenStateMatcher();
            if (whenStateMatcher != null ? whenStateMatcher.apply((JsonSerializable) jsonValue) : true) {
                break;
            }
        }
        ViewPropertyOverride viewPropertyOverride = next;
        return (viewPropertyOverride == null || (t2 = (T) viewPropertyOverride.getValue()) == null) ? t : t2;
    }

    public final <T> T resolveRequired(@Nullable List<ViewPropertyOverride<T>> overrides, T t) {
        T t2 = (T) resolveOptional$default(this, overrides, null, 2, null);
        return t2 == null ? t : t2;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
