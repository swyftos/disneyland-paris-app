package com.contentsquare.android.sdk;

import androidx.camera.video.AudioStats;
import com.contentsquare.android.api.model.Transaction;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.AbstractC0660e;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class G7 extends AbstractC0660e {

    @NotNull
    public final JSONObject m;

    public static final class a extends AbstractC0660e.a<G7> {

        @NotNull
        public JSONObject k;

        public a() {
            super(16);
            this.k = new JSONObject();
        }

        @Override // com.contentsquare.android.sdk.AbstractC0660e.a
        public final AbstractC0660e a() {
            return new G7(this);
        }

        @NotNull
        public final void a(@NotNull Transaction transaction) {
            Intrinsics.checkNotNullParameter(transaction, "transaction");
            Logger logger = new Logger("TransactionEventBuilder");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vl", transaction.getValue());
                jSONObject.put("cu", transaction.getCurrency());
                if (transaction.getId() != null) {
                    jSONObject.put("id", transaction.getId());
                }
                this.k = jSONObject;
            } catch (JSONException e) {
                Q2.a(logger, "Not valid transaction JSON", e);
                throw new IllegalArgumentException("Invalid transaction");
            }
        }
    }

    public G7(a aVar) {
        super(aVar);
        this.m = aVar.k;
    }

    @Override // com.contentsquare.android.sdk.AbstractC0660e
    public final void a() {
        double dOptDouble = this.m.optDouble("vl", AudioStats.AUDIO_AMPLITUDE_NONE);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dOptDouble)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        int iOptInt = this.m.optInt("cu", 0);
        String strOptString = this.m.optString("id", "");
        AbstractC0660e.l.i("Transaction - Value: " + str + " - Currency: " + iOptInt + " - ID: " + strOptString);
    }
}
