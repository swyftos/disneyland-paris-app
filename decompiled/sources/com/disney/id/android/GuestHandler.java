package com.disney.id.android;

import com.google.gson.JsonElement;
import com.urbanairship.channel.AttributeMutation;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\nH&¨\u0006\u0015"}, d2 = {"Lcom/disney/id/android/GuestHandler;", "", "clearTransientValues", "", "get", "Lcom/disney/id/android/Guest;", "getExternalRefreshToken", "", "getStashed", "Lkotlin/Pair;", "Lcom/google/gson/JsonElement;", "getTransientToken", AttributeMutation.ATTRIBUTE_ACTION_SET, "guest", "setExternalRefreshToken", "refreshToken", "setStashed", "guestJsonElement", "tokenJsonElement", "setTransientToken", "token", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GuestHandler {
    void clearTransientValues();

    @Nullable
    Guest get();

    @Nullable
    String getExternalRefreshToken();

    @Nullable
    Pair<JsonElement, JsonElement> getStashed();

    @Nullable
    JsonElement getTransientToken();

    void set(@Nullable Guest guest);

    void setExternalRefreshToken(@Nullable String refreshToken);

    void setStashed(@Nullable JsonElement guestJsonElement, @Nullable JsonElement tokenJsonElement);

    void setTransientToken(@Nullable JsonElement token);
}
