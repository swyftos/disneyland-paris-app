package com.disney.id.android;

import android.util.Log;
import androidx.annotation.Keep;
import com.google.gson.JsonElement;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001DB\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0014HÀ\u0003¢\u0006\u0002\b0J\u0010\u00101\u001a\u0004\u0018\u00010\u0016HÀ\u0003¢\u0006\u0002\b2J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\r\u0010;\u001a\u00020\u0000H\u0000¢\u0006\u0002\b<J\u009f\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\b\u0010B\u001a\u0004\u0018\u00010\u0016J\t\u0010C\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006E"}, d2 = {"Lcom/disney/id/android/Guest;", "", "profile", "Lcom/disney/id/android/Profile;", "linkedAccounts", "", "Lcom/disney/id/android/LinkedAccount;", "displayName", "Lcom/disney/id/android/DisplayName;", "geolocation", "Lcom/disney/id/android/Geolocation;", "marketing", "Lcom/disney/id/android/Marketing;", "entitlements", "Lcom/disney/id/android/Entitlement;", "s2", "", "payload", Guest.ETAG, "token", "Lcom/disney/id/android/Token;", "rawGuest", "Lcom/google/gson/JsonElement;", "(Lcom/disney/id/android/Profile;Ljava/util/List;Lcom/disney/id/android/DisplayName;Lcom/disney/id/android/Geolocation;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/disney/id/android/Token;Lcom/google/gson/JsonElement;)V", "getDisplayName", "()Lcom/disney/id/android/DisplayName;", "getEntitlements", "()Ljava/util/List;", "getEtag", "()Ljava/lang/String;", "getGeolocation", "()Lcom/disney/id/android/Geolocation;", "getLinkedAccounts", "getMarketing", "getPayload", "getProfile", "()Lcom/disney/id/android/Profile;", "getRawGuest$OneID_release", "()Lcom/google/gson/JsonElement;", "setRawGuest$OneID_release", "(Lcom/google/gson/JsonElement;)V", "getS2", "getToken$OneID_release", "()Lcom/disney/id/android/Token;", "setToken$OneID_release", "(Lcom/disney/id/android/Token;)V", "component1", "component10", "component10$OneID_release", "component11", "component11$OneID_release", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy$OneID_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "raw", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGuest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Guest.kt\ncom/disney/id/android/Guest\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,397:1\n1549#2:398\n1620#2,3:399\n1549#2:402\n1620#2,3:403\n*S KotlinDebug\n*F\n+ 1 Guest.kt\ncom/disney/id/android/Guest\n*L\n39#1:398\n39#1:399,3\n43#1:402\n43#1:403,3\n*E\n"})
/* loaded from: classes3.dex */
public final /* data */ class Guest {

    @NotNull
    public static final String DATA = "data";

    @NotNull
    public static final String ETAG = "etag";

    @NotNull
    public static final String PAYLOAD_FULL = "full";

    @NotNull
    public static final String PAYLOAD_REDUCED = "reduced";

    @NotNull
    public static final String PROFILE = "profile";

    @Nullable
    private final DisplayName displayName;

    @Nullable
    private final List<Entitlement> entitlements;

    @Nullable
    private final String etag;

    @Nullable
    private final Geolocation geolocation;

    @Nullable
    private final List<LinkedAccount> linkedAccounts;

    @Nullable
    private final List<Marketing> marketing;

    @Nullable
    private final String payload;

    @Nullable
    private final Profile profile;

    @Nullable
    private JsonElement rawGuest;

    @Nullable
    private final String s2;

    @Nullable
    private Token token;
    private static final String TAG = Guest.class.getSimpleName();

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Profile getProfile() {
        return this.profile;
    }

    @Nullable
    /* renamed from: component10$OneID_release, reason: from getter */
    public final Token getToken() {
        return this.token;
    }

    @Nullable
    /* renamed from: component11$OneID_release, reason: from getter */
    public final JsonElement getRawGuest() {
        return this.rawGuest;
    }

    @Nullable
    public final List<LinkedAccount> component2() {
        return this.linkedAccounts;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final DisplayName getDisplayName() {
        return this.displayName;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Geolocation getGeolocation() {
        return this.geolocation;
    }

    @Nullable
    public final List<Marketing> component5() {
        return this.marketing;
    }

    @Nullable
    public final List<Entitlement> component6() {
        return this.entitlements;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getS2() {
        return this.s2;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPayload() {
        return this.payload;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getEtag() {
        return this.etag;
    }

    @NotNull
    public final Guest copy(@Nullable Profile profile, @Nullable List<LinkedAccount> linkedAccounts, @Nullable DisplayName displayName, @Nullable Geolocation geolocation, @Nullable List<Marketing> marketing, @Nullable List<Entitlement> entitlements, @Nullable String s2, @Nullable String payload, @Nullable String etag, @Nullable Token token, @Nullable JsonElement rawGuest) {
        return new Guest(profile, linkedAccounts, displayName, geolocation, marketing, entitlements, s2, payload, etag, token, rawGuest);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Guest)) {
            return false;
        }
        Guest guest = (Guest) other;
        return Intrinsics.areEqual(this.profile, guest.profile) && Intrinsics.areEqual(this.linkedAccounts, guest.linkedAccounts) && Intrinsics.areEqual(this.displayName, guest.displayName) && Intrinsics.areEqual(this.geolocation, guest.geolocation) && Intrinsics.areEqual(this.marketing, guest.marketing) && Intrinsics.areEqual(this.entitlements, guest.entitlements) && Intrinsics.areEqual(this.s2, guest.s2) && Intrinsics.areEqual(this.payload, guest.payload) && Intrinsics.areEqual(this.etag, guest.etag) && Intrinsics.areEqual(this.token, guest.token) && Intrinsics.areEqual(this.rawGuest, guest.rawGuest);
    }

    public int hashCode() {
        Profile profile = this.profile;
        int iHashCode = (profile == null ? 0 : profile.hashCode()) * 31;
        List<LinkedAccount> list = this.linkedAccounts;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        DisplayName displayName = this.displayName;
        int iHashCode3 = (iHashCode2 + (displayName == null ? 0 : displayName.hashCode())) * 31;
        Geolocation geolocation = this.geolocation;
        int iHashCode4 = (iHashCode3 + (geolocation == null ? 0 : geolocation.hashCode())) * 31;
        List<Marketing> list2 = this.marketing;
        int iHashCode5 = (iHashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Entitlement> list3 = this.entitlements;
        int iHashCode6 = (iHashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str = this.s2;
        int iHashCode7 = (iHashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.payload;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.etag;
        int iHashCode9 = (iHashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Token token = this.token;
        int iHashCode10 = (iHashCode9 + (token == null ? 0 : token.hashCode())) * 31;
        JsonElement jsonElement = this.rawGuest;
        return iHashCode10 + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Guest(profile=" + this.profile + ", linkedAccounts=" + this.linkedAccounts + ", displayName=" + this.displayName + ", geolocation=" + this.geolocation + ", marketing=" + this.marketing + ", entitlements=" + this.entitlements + ", s2=" + this.s2 + ", payload=" + this.payload + ", etag=" + this.etag + ", token=" + this.token + ", rawGuest=" + this.rawGuest + ")";
    }

    public Guest(@Nullable Profile profile, @Nullable List<LinkedAccount> list, @Nullable DisplayName displayName, @Nullable Geolocation geolocation, @Nullable List<Marketing> list2, @Nullable List<Entitlement> list3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Token token, @Nullable JsonElement jsonElement) {
        this.profile = profile;
        this.linkedAccounts = list;
        this.displayName = displayName;
        this.geolocation = geolocation;
        this.marketing = list2;
        this.entitlements = list3;
        this.s2 = str;
        this.payload = str2;
        this.etag = str3;
        this.token = token;
        this.rawGuest = jsonElement;
    }

    @Nullable
    public final Profile getProfile() {
        return this.profile;
    }

    @Nullable
    public final List<LinkedAccount> getLinkedAccounts() {
        return this.linkedAccounts;
    }

    @Nullable
    public final DisplayName getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final Geolocation getGeolocation() {
        return this.geolocation;
    }

    @Nullable
    public final List<Marketing> getMarketing() {
        return this.marketing;
    }

    @Nullable
    public final List<Entitlement> getEntitlements() {
        return this.entitlements;
    }

    @Nullable
    public final String getS2() {
        return this.s2;
    }

    @Nullable
    public final String getPayload() {
        return this.payload;
    }

    @Nullable
    public final String getEtag() {
        return this.etag;
    }

    @Nullable
    public final Token getToken$OneID_release() {
        return this.token;
    }

    public final void setToken$OneID_release(@Nullable Token token) {
        this.token = token;
    }

    @Nullable
    public final JsonElement getRawGuest$OneID_release() {
        return this.rawGuest;
    }

    public final void setRawGuest$OneID_release(@Nullable JsonElement jsonElement) {
        this.rawGuest = jsonElement;
    }

    @NotNull
    public final Guest copy$OneID_release() {
        ArrayList arrayList;
        ArrayList arrayList2;
        Profile profile = this.profile;
        Profile profileCopy$OneID_release = profile != null ? profile.copy$OneID_release() : null;
        List<LinkedAccount> list = this.linkedAccounts;
        if (list != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((LinkedAccount) it.next()).copy$OneID_release());
            }
        } else {
            arrayList = null;
        }
        DisplayName displayName = this.displayName;
        DisplayName displayNameCopy$default = displayName != null ? DisplayName.copy$default(displayName, null, null, null, null, 15, null) : null;
        Geolocation geolocation = this.geolocation;
        Geolocation geolocationCopy$default = geolocation != null ? Geolocation.copy$default(geolocation, null, null, null, null, null, null, null, 127, null) : null;
        List<Marketing> list2 = this.marketing;
        List list3 = list2 != null ? CollectionsKt.toList(list2) : null;
        List<Entitlement> list4 = this.entitlements;
        if (list4 != null) {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator<T> it2 = list4.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Entitlement) it2.next()).copy$OneID_release());
            }
        } else {
            arrayList2 = null;
        }
        String str = this.s2;
        String str2 = this.payload;
        String str3 = this.etag;
        Token token = this.token;
        Token tokenCopy$OneID_release = token != null ? token.copy$OneID_release() : null;
        JsonElement jsonElement = this.rawGuest;
        return new Guest(profileCopy$OneID_release, arrayList, displayNameCopy$default, geolocationCopy$default, list3, arrayList2, str, str2, str3, tokenCopy$OneID_release, jsonElement != null ? jsonElement.deepCopy() : null);
    }

    @Nullable
    public final JsonElement raw() {
        JsonElement jsonElement = null;
        try {
            JsonElement jsonElement2 = copy$OneID_release().rawGuest;
            if (jsonElement2 != null) {
                jsonElement2.getAsJsonObject().get("token").getAsJsonObject().remove("refresh_token");
                jsonElement = jsonElement2;
            } else {
                Log.e(TAG, "Missing raw GC response in guest object");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error trying to remove refresh token from raw GC response in guest object", e);
        }
        return jsonElement;
    }
}
