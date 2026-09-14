package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.android.core.features.logging.Logger;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2504G7 extends AbstractC2730e {

    /* JADX INFO: renamed from: m */
    @NotNull
    public final JSONObject f1659m;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.G7$a */
    public static final class a extends AbstractC2730e.a<C2504G7> {

        /* JADX INFO: renamed from: k */
        @NotNull
        public JSONObject f1660k;

        public a() {
            super(16);
            this.f1660k = new JSONObject();
        }

        @Override // com.contentsquare.android.sdk.AbstractC2730e.a
        /* JADX INFO: renamed from: a */
        public final AbstractC2730e mo857a() {
            return new C2504G7(this);
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public final void m926a(@NotNull Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Logger logger = new Logger("TransactionEventBuilder");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vl", transaction.getValue());
                jSONObject.put("cu", transaction.getCurrency());
                if (transaction.getId() != null) {
                    jSONObject.put("id", transaction.getId());
                }
                this.f1660k = jSONObject;
            } catch (JSONException e) {
                C2599Q2.m1011a(logger, "Not valid transaction JSON", e);
                throw new IllegalArgumentException("Invalid transaction");
            }
        }
    }

    public C2504G7(a aVar) {
        super(aVar);
        this.f1659m = aVar.f1660k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2730e
    /* JADX INFO: renamed from: a */
    public final void mo856a() {
        double dOptDouble = this.f1659m.optDouble("vl", AudioStats.AUDIO_AMPLITUDE_NONE);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dOptDouble)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        int iOptInt = this.f1659m.optInt("cu", 0);
        String strOptString = this.f1659m.optString("id", "");
        AbstractC2730e.f2545l.m831i("Transaction - Value: " + str + " - Currency: " + iOptInt + " - ID: " + strOptString);
    }
}
