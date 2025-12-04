package com.disney.id.android;

import com.urbanairship.util.Attributes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/disney/id/android/OneIDSCALPConfigHandler;", "Lcom/disney/id/android/SCALPConfigHandler;", "()V", "detectedCountry", "", "getDetectedCountry", "setDetectedCountry", "", Attributes.COUNTRY, "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDSCALPConfigHandler implements SCALPConfigHandler {
    private String detectedCountry;

    @Override // com.disney.id.android.SCALPConfigHandler
    @Nullable
    public String getDetectedCountry() {
        return this.detectedCountry;
    }

    @Override // com.disney.id.android.SCALPConfigHandler
    public void setDetectedCountry(@Nullable String country) {
        this.detectedCountry = country;
    }
}
