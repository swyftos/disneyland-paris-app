package com.disney.id.android;

import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.extensions.JSONExtensionsKt;
import com.disney.id.android.localdata.LocalStorage;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0003R\"\u0010\u0015\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010 ¨\u0006'"}, d2 = {"Lcom/disney/id/android/OneIDRecoveryContext;", "Lcom/disney/id/android/RecoveryContext;", "<init>", "()V", "Ljava/util/Date;", OneIDRecoveryContext.CREATED_AT, "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", OneIDRecoveryContext.RECOVERY_CONTEXT, "(Ljava/util/Date;)Lorg/json/JSONObject;", "jsonObject", "", "saveRecoveryContext", "(Lorg/json/JSONObject;)V", "", OneIDRecoveryContext.ACCESS_TOKEN, "swid", "save", "(Ljava/lang/String;Ljava/lang/String;)V", "clear", "Lcom/disney/id/android/localdata/LocalStorage;", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "getRecoveryContextUpdated", "()Lorg/json/JSONObject;", "recoveryContextUpdated", "value", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", OneIDRecoveryContext.SESSION_ID, "getAccessToken", "getSwid", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRecoveryContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecoveryContext.kt\ncom/disney/id/android/OneIDRecoveryContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,103:1\n1#2:104\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDRecoveryContext implements RecoveryContext {

    @NotNull
    public static final String ACCESS_TOKEN = "accessToken";

    @NotNull
    public static final String CREATED_AT = "createdAt";

    @NotNull
    public static final String RECOVERY_CONTEXT = "recoveryContext";

    @NotNull
    public static final String SESSION_ID = "sessionId";

    @NotNull
    public static final String SWID = "swid";

    @NotNull
    public static final String UPDATED_AT = "updatedAt";

    @Inject
    public LocalStorage storage;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Object lock = new Object();

    public OneIDRecoveryContext() {
        OneIDDagger.getComponent().inject(this);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/disney/id/android/OneIDRecoveryContext$Companion;", "", "()V", "ACCESS_TOKEN", "", "CREATED_AT", "RECOVERY_CONTEXT", "SESSION_ID", "SWID", "UPDATED_AT", "lock", "getLock", "()Ljava/lang/Object;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Object getLock() {
            return OneIDRecoveryContext.lock;
        }
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    private final JSONObject recoveryContext(Date createdAt) {
        String str = getStorage$OneID_release().get(RECOVERY_CONTEXT);
        if (str != null) {
            return new JSONObject(str);
        }
        return new JSONObject().put(CREATED_AT, createdAt != null ? DateISO8601Kt.toISO8601(createdAt) : null);
    }

    static /* synthetic */ JSONObject recoveryContext$default(OneIDRecoveryContext oneIDRecoveryContext, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            date = new Date();
        }
        return oneIDRecoveryContext.recoveryContext(date);
    }

    private final void saveRecoveryContext(JSONObject jsonObject) {
        getStorage$OneID_release().put(RECOVERY_CONTEXT, jsonObject.toString());
    }

    private final JSONObject getRecoveryContextUpdated() throws JSONException {
        JSONObject jSONObjectPut = recoveryContext$default(this, null, 1, null).put(UPDATED_AT, DateISO8601Kt.toISO8601(new Date()));
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    @Override // com.disney.id.android.RecoveryContext
    @Nullable
    public String getSessionId() {
        JSONObject jSONObjectRecoveryContext$default = recoveryContext$default(this, null, 1, null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectRecoveryContext$default, "recoveryContext$default(...)");
        return JSONExtensionsKt.getStringSafely(jSONObjectRecoveryContext$default, SESSION_ID);
    }

    @Override // com.disney.id.android.RecoveryContext
    public void setSessionId(@Nullable String str) {
        synchronized (lock) {
            JSONObject jSONObjectPut = getRecoveryContextUpdated().put(SESSION_ID, str);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
            saveRecoveryContext(jSONObjectPut);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.disney.id.android.RecoveryContext
    @Nullable
    public String getAccessToken() {
        JSONObject jSONObjectRecoveryContext$default = recoveryContext$default(this, null, 1, null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectRecoveryContext$default, "recoveryContext$default(...)");
        return JSONExtensionsKt.getStringSafely(jSONObjectRecoveryContext$default, ACCESS_TOKEN);
    }

    @Override // com.disney.id.android.RecoveryContext
    @Nullable
    public String getSwid() {
        JSONObject jSONObjectRecoveryContext$default = recoveryContext$default(this, null, 1, null);
        Intrinsics.checkNotNullExpressionValue(jSONObjectRecoveryContext$default, "recoveryContext$default(...)");
        return JSONExtensionsKt.getStringSafely(jSONObjectRecoveryContext$default, "swid");
    }

    @Override // com.disney.id.android.RecoveryContext
    public void save(@NotNull String accessToken, @NotNull String swid) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(swid, "swid");
        synchronized (lock) {
            JSONObject jSONObjectPut = getRecoveryContextUpdated().put(ACCESS_TOKEN, accessToken).put("swid", swid);
            Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
            saveRecoveryContext(jSONObjectPut);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.disney.id.android.RecoveryContext
    public void clear() {
        synchronized (lock) {
            getStorage$OneID_release().remove(RECOVERY_CONTEXT);
            Unit unit = Unit.INSTANCE;
        }
    }
}
