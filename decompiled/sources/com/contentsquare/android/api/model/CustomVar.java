package com.contentsquare.android.api.model;

import androidx.annotation.IntRange;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0010\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/contentsquare/android/api/model/CustomVar;", "", "index", "", "name", "", "value", "(ILjava/lang/String;Ljava/lang/String;)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "getValue", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "generateLogMessage", "generateLogMessage$library_release", "hashCode", "serializeToJson", "Lorg/json/JSONObject;", "serializeToJson$library_release", "toString", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomVar {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MIN_VALID_INDEX = 0;
    private final int index;

    @NotNull
    private final String name;

    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/api/model/CustomVar$Companion;", "", "()V", "MIN_VALID_INDEX", "", "generateCustomVarsLogMessage", "", "customVars", "", "Lcom/contentsquare/android/api/model/CustomVar;", "([Lcom/contentsquare/android/api/model/CustomVar;)Ljava/lang/String;", "serializeCustomVarsToJson", "Lorg/json/JSONObject;", "([Lcom/contentsquare/android/api/model/CustomVar;)Lorg/json/JSONObject;", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCustomVar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomVar.kt\ncom/contentsquare/android/api/model/CustomVar$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,110:1\n13579#2,2:111\n*S KotlinDebug\n*F\n+ 1 CustomVar.kt\ncom/contentsquare/android/api/model/CustomVar$Companion\n*L\n51#1:111,2\n*E\n"})
    public static final class Companion {

        public static final class a extends Lambda implements Function1<CustomVar, CharSequence> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(CustomVar customVar) {
                CustomVar it = customVar;
                Intrinsics.checkNotNullParameter(it, "it");
                return it.generateLogMessage$library_release();
            }
        }

        private Companion() {
        }

        @NotNull
        public final String generateCustomVarsLogMessage(@NotNull CustomVar[] customVars) {
            Intrinsics.checkNotNullParameter(customVars, "customVars");
            return ArraysKt.joinToString$default(customVars, " | ", "{ ", " }", 0, (CharSequence) null, a.a, 24, (Object) null);
        }

        @NotNull
        public final JSONObject serializeCustomVarsToJson(@NotNull CustomVar[] customVars) throws JSONException {
            Intrinsics.checkNotNullParameter(customVars, "customVars");
            JSONObject jSONObject = new JSONObject();
            for (CustomVar customVar : customVars) {
                jSONObject.put(String.valueOf(customVar.getIndex()), customVar.serializeToJson$library_release());
            }
            return jSONObject;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CustomVar(@IntRange(from = 0) int i, @NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        CustomVarValidator customVarValidator = new CustomVarValidator();
        this.index = i;
        this.name = customVarValidator.validateName(name);
        this.value = customVarValidator.validateValue(value);
    }

    public boolean equals(@Nullable Object other) {
        if (other instanceof CustomVar) {
            CustomVar customVar = (CustomVar) other;
            if (this.index == customVar.index && Intrinsics.areEqual(this.name, customVar.name) && Intrinsics.areEqual(this.value, customVar.value)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String generateLogMessage$library_release() {
        return "[" + this.index + "] " + this.name + ": " + this.value;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + ((this.name.hashCode() + (this.index * 31)) * 31);
    }

    @NotNull
    public final JSONObject serializeToJson$library_release() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(this.name, this.value);
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(name, value)");
        return jSONObjectPut;
    }

    @NotNull
    public String toString() {
        return "CustomVar(index=" + this.index + ", name=" + this.name + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
