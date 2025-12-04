package com.brentvatne.common.api;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/brentvatne/common/api/SideLoadedTextTrackList;", "", "<init>", "()V", "tracks", "Ljava/util/ArrayList;", "Lcom/brentvatne/common/api/SideLoadedTextTrack;", "Lkotlin/collections/ArrayList;", "getTracks", "()Ljava/util/ArrayList;", "setTracks", "(Ljava/util/ArrayList;)V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SideLoadedTextTrackList {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private ArrayList tracks = new ArrayList();

    @NotNull
    public final ArrayList<SideLoadedTextTrack> getTracks() {
        return this.tracks;
    }

    public final void setTracks(@NotNull ArrayList<SideLoadedTextTrack> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.tracks = arrayList;
    }

    public boolean equals(@Nullable Object other) {
        if (other == null || !(other instanceof SideLoadedTextTrackList)) {
            return false;
        }
        return Intrinsics.areEqual(this.tracks, ((SideLoadedTextTrackList) other).tracks);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/brentvatne/common/api/SideLoadedTextTrackList$Companion;", "", "<init>", "()V", "parse", "Lcom/brentvatne/common/api/SideLoadedTextTrackList;", "src", "Lcom/facebook/react/bridge/ReadableArray;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final SideLoadedTextTrackList parse(@Nullable ReadableArray src) {
            if (src == null) {
                return null;
            }
            SideLoadedTextTrackList sideLoadedTextTrackList = new SideLoadedTextTrackList();
            int size = src.size();
            for (int i = 0; i < size; i++) {
                ReadableMap map = src.getMap(i);
                if (map != null) {
                    sideLoadedTextTrackList.getTracks().add(SideLoadedTextTrack.INSTANCE.parse(map));
                }
            }
            return sideLoadedTextTrackList;
        }
    }
}
