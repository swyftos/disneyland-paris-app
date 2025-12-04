package com.brentvatne.common.api;

import com.allegion.accesssdk.BuildConfig;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0081\u0001\u0012\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J\u001b\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J\u0083\u0001\u0010\u0019\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\nHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/brentvatne/common/api/CMCDProps;", "", "cmcdObject", "", "Lkotlin/Pair;", "", "cmcdRequest", "cmcdSession", "cmcdStatus", "mode", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getCmcdObject", "()Ljava/util/List;", "getCmcdRequest", "getCmcdSession", "getCmcdStatus", "getMode", "()I", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CMCDProps {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List cmcdObject;
    private final List cmcdRequest;
    private final List cmcdSession;
    private final List cmcdStatus;
    private final int mode;

    public CMCDProps() {
        this(null, null, null, null, 0, 31, null);
    }

    public static /* synthetic */ CMCDProps copy$default(CMCDProps cMCDProps, List list, List list2, List list3, List list4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = cMCDProps.cmcdObject;
        }
        if ((i2 & 2) != 0) {
            list2 = cMCDProps.cmcdRequest;
        }
        List list5 = list2;
        if ((i2 & 4) != 0) {
            list3 = cMCDProps.cmcdSession;
        }
        List list6 = list3;
        if ((i2 & 8) != 0) {
            list4 = cMCDProps.cmcdStatus;
        }
        List list7 = list4;
        if ((i2 & 16) != 0) {
            i = cMCDProps.mode;
        }
        return cMCDProps.copy(list, list5, list6, list7, i);
    }

    @JvmStatic
    @Nullable
    public static final CMCDProps parse(@Nullable ReadableMap readableMap) {
        return INSTANCE.parse(readableMap);
    }

    @NotNull
    public final List<Pair<String, Object>> component1() {
        return this.cmcdObject;
    }

    @NotNull
    public final List<Pair<String, Object>> component2() {
        return this.cmcdRequest;
    }

    @NotNull
    public final List<Pair<String, Object>> component3() {
        return this.cmcdSession;
    }

    @NotNull
    public final List<Pair<String, Object>> component4() {
        return this.cmcdStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    @NotNull
    public final CMCDProps copy(@NotNull List<? extends Pair<String, ? extends Object>> cmcdObject, @NotNull List<? extends Pair<String, ? extends Object>> cmcdRequest, @NotNull List<? extends Pair<String, ? extends Object>> cmcdSession, @NotNull List<? extends Pair<String, ? extends Object>> cmcdStatus, int mode) {
        Intrinsics.checkNotNullParameter(cmcdObject, "cmcdObject");
        Intrinsics.checkNotNullParameter(cmcdRequest, "cmcdRequest");
        Intrinsics.checkNotNullParameter(cmcdSession, "cmcdSession");
        Intrinsics.checkNotNullParameter(cmcdStatus, "cmcdStatus");
        return new CMCDProps(cmcdObject, cmcdRequest, cmcdSession, cmcdStatus, mode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CMCDProps)) {
            return false;
        }
        CMCDProps cMCDProps = (CMCDProps) other;
        return Intrinsics.areEqual(this.cmcdObject, cMCDProps.cmcdObject) && Intrinsics.areEqual(this.cmcdRequest, cMCDProps.cmcdRequest) && Intrinsics.areEqual(this.cmcdSession, cMCDProps.cmcdSession) && Intrinsics.areEqual(this.cmcdStatus, cMCDProps.cmcdStatus) && this.mode == cMCDProps.mode;
    }

    public int hashCode() {
        return (((((((this.cmcdObject.hashCode() * 31) + this.cmcdRequest.hashCode()) * 31) + this.cmcdSession.hashCode()) * 31) + this.cmcdStatus.hashCode()) * 31) + Integer.hashCode(this.mode);
    }

    @NotNull
    public String toString() {
        return "CMCDProps(cmcdObject=" + this.cmcdObject + ", cmcdRequest=" + this.cmcdRequest + ", cmcdSession=" + this.cmcdSession + ", cmcdStatus=" + this.cmcdStatus + ", mode=" + this.mode + ")";
    }

    public CMCDProps(@NotNull List<? extends Pair<String, ? extends Object>> cmcdObject, @NotNull List<? extends Pair<String, ? extends Object>> cmcdRequest, @NotNull List<? extends Pair<String, ? extends Object>> cmcdSession, @NotNull List<? extends Pair<String, ? extends Object>> cmcdStatus, int i) {
        Intrinsics.checkNotNullParameter(cmcdObject, "cmcdObject");
        Intrinsics.checkNotNullParameter(cmcdRequest, "cmcdRequest");
        Intrinsics.checkNotNullParameter(cmcdSession, "cmcdSession");
        Intrinsics.checkNotNullParameter(cmcdStatus, "cmcdStatus");
        this.cmcdObject = cmcdObject;
        this.cmcdRequest = cmcdRequest;
        this.cmcdSession = cmcdSession;
        this.cmcdStatus = cmcdStatus;
        this.mode = i;
    }

    public /* synthetic */ CMCDProps(List list, List list2, List list3, List list4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list4, (i2 & 16) != 0 ? 1 : i);
    }

    @NotNull
    public final List<Pair<String, Object>> getCmcdObject() {
        return this.cmcdObject;
    }

    @NotNull
    public final List<Pair<String, Object>> getCmcdRequest() {
        return this.cmcdRequest;
    }

    @NotNull
    public final List<Pair<String, Object>> getCmcdSession() {
        return this.cmcdSession;
    }

    @NotNull
    public final List<Pair<String, Object>> getCmcdStatus() {
        return this.cmcdStatus;
    }

    public final int getMode() {
        return this.mode;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J$\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00100\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/brentvatne/common/api/CMCDProps$Companion;", "", "<init>", "()V", "PROP_CMCD_OBJECT", "", "PROP_CMCD_REQUEST", "PROP_CMCD_SESSION", "PROP_CMCD_STATUS", "PROP_CMCD_MODE", "parse", "Lcom/brentvatne/common/api/CMCDProps;", "src", "Lcom/facebook/react/bridge/ReadableMap;", "parseKeyValuePairs", "", "Lkotlin/Pair;", "array", "Lcom/facebook/react/bridge/ReadableArray;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCMCDProps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CMCDProps.kt\ncom/brentvatne/common/api/CMCDProps$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1611#2,9:53\n1863#2:62\n1864#2:64\n1620#2:65\n1#3:63\n*S KotlinDebug\n*F\n+ 1 CMCDProps.kt\ncom/brentvatne/common/api/CMCDProps$Companion\n*L\n38#1:53,9\n38#1:62\n38#1:64\n38#1:65\n38#1:63\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final CMCDProps parse(@Nullable ReadableMap src) {
            if (src == null) {
                return null;
            }
            return new CMCDProps(parseKeyValuePairs(src.getArray("object")), parseKeyValuePairs(src.getArray("request")), parseKeyValuePairs(src.getArray(BuildConfig.SESSION_KEY_REFERENCE)), parseKeyValuePairs(src.getArray("status")), ReactBridgeUtils.safeGetInt(src, "mode", 1));
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.util.List parseKeyValuePairs(com.facebook.react.bridge.ReadableArray r8) {
            /*
                r7 = this;
                if (r8 != 0) goto L7
                java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
                return r7
            L7:
                r7 = 0
                int r0 = r8.size()
                kotlin.ranges.IntRange r7 = kotlin.ranges.RangesKt.until(r7, r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r7 = r7.iterator()
            L19:
                boolean r1 = r7.hasNext()
                if (r1 == 0) goto L74
                r1 = r7
                kotlin.collections.IntIterator r1 = (kotlin.collections.IntIterator) r1
                int r1 = r1.nextInt()
                com.facebook.react.bridge.ReadableMap r1 = r8.getMap(r1)
                r2 = 0
                if (r1 == 0) goto L34
                java.lang.String r3 = "key"
                java.lang.String r3 = r1.getString(r3)
                goto L35
            L34:
                r3 = r2
            L35:
                java.lang.String r4 = "value"
                if (r1 == 0) goto L3f
                com.facebook.react.bridge.ReadableType r5 = r1.getType(r4)
                goto L40
            L3f:
                r5 = r2
            L40:
                if (r5 != 0) goto L44
                r5 = -1
                goto L4c
            L44:
                int[] r6 = com.brentvatne.common.api.CMCDProps.Companion.WhenMappings.$EnumSwitchMapping$0
                int r5 = r5.ordinal()
                r5 = r6[r5]
            L4c:
                r6 = 1
                if (r5 == r6) goto L5b
                r6 = 2
                if (r5 == r6) goto L54
            L52:
                r1 = r2
                goto L65
            L54:
                if (r1 == 0) goto L52
                java.lang.String r1 = r1.getString(r4)
                goto L65
            L5b:
                if (r1 == 0) goto L52
                double r4 = r1.getDouble(r4)
                java.lang.Double r1 = java.lang.Double.valueOf(r4)
            L65:
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L6e
                kotlin.Pair r2 = new kotlin.Pair
                r2.<init>(r3, r1)
            L6e:
                if (r2 == 0) goto L19
                r0.add(r2)
                goto L19
            L74:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.common.api.CMCDProps.Companion.parseKeyValuePairs(com.facebook.react.bridge.ReadableArray):java.util.List");
        }
    }
}
