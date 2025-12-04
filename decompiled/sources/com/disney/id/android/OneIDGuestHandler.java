package com.disney.id.android;

import com.google.gson.JsonElement;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000f\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/disney/id/android/OneIDGuestHandler;", "Lcom/disney/id/android/GuestHandler;", "()V", "externalRefreshToken", "", "guest", "Lcom/disney/id/android/Guest;", "stashedGuest", "Lkotlin/Pair;", "Lcom/google/gson/JsonElement;", "transientToken", "clearTransientValues", "", "get", "getExternalRefreshToken", "getStashed", "getTransientToken", AttributeMutation.ATTRIBUTE_ACTION_SET, "setExternalRefreshToken", "refreshToken", "setStashed", "guestJsonElement", "tokenJsonElement", "setTransientToken", "token", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDGuestHandler implements GuestHandler {
    private String externalRefreshToken;
    private Guest guest;
    private Pair stashedGuest;
    private JsonElement transientToken;

    @Override // com.disney.id.android.GuestHandler
    @Nullable
    public Guest get() {
        Guest guest = this.guest;
        if (guest != null) {
            return guest.copy$OneID_release();
        }
        return null;
    }

    @Override // com.disney.id.android.GuestHandler
    public void set(@Nullable Guest guest) {
        this.guest = guest;
    }

    @Override // com.disney.id.android.GuestHandler
    @Nullable
    public Pair<JsonElement, JsonElement> getStashed() {
        return this.stashedGuest;
    }

    @Override // com.disney.id.android.GuestHandler
    public void setStashed(@Nullable JsonElement guestJsonElement, @Nullable JsonElement tokenJsonElement) {
        this.stashedGuest = (guestJsonElement == null && tokenJsonElement == null) ? null : new Pair(guestJsonElement, tokenJsonElement);
    }

    @Override // com.disney.id.android.GuestHandler
    @Nullable
    public String getExternalRefreshToken() {
        return this.externalRefreshToken;
    }

    @Override // com.disney.id.android.GuestHandler
    public void setExternalRefreshToken(@Nullable String refreshToken) {
        this.externalRefreshToken = refreshToken;
    }

    @Override // com.disney.id.android.GuestHandler
    @Nullable
    public JsonElement getTransientToken() {
        return this.transientToken;
    }

    @Override // com.disney.id.android.GuestHandler
    public void setTransientToken(@Nullable JsonElement token) {
        this.transientToken = token;
    }

    @Override // com.disney.id.android.GuestHandler
    public void clearTransientValues() {
        setExternalRefreshToken(null);
        setTransientToken(null);
    }
}
