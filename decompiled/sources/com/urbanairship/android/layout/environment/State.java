package com.urbanairship.android.layout.environment;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.dlp.BluetoothManager;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.environment.FormType;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.model.PageRequest;
import com.urbanairship.android.layout.property.PagerControllerBranching;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.android.layout.reporting.FormInfo;
import com.urbanairship.android.layout.reporting.PagerData;
import com.urbanairship.android.layout.reporting.ThomasFormField;
import com.urbanairship.android.layout.reporting.ThomasFormFieldStatus;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/environment/State;", "", "()V", "Checkbox", "Form", "Layout", "Pager", "Radio", "Score", "Lcom/urbanairship/android/layout/environment/State$Checkbox;", "Lcom/urbanairship/android/layout/environment/State$Form;", "Lcom/urbanairship/android/layout/environment/State$Layout;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "Lcom/urbanairship/android/layout/environment/State$Radio;", "Lcom/urbanairship/android/layout/environment/State$Score;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class State {
    public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private State() {
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0002\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u009b\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\bHÆ\u0001J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0015\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0005H\u0000¢\u0006\u0002\b<J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bJ\u0013\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\u0005HÖ\u0001J\u0014\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\nJ\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010 \u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010'\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006K"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Pager;", "Lcom/urbanairship/android/layout/environment/State;", "identifier", "", "pageIndex", "", "lastPageIndex", "completed", "", "pageIds", "", "durations", "progress", "isMediaPaused", "wasMediaPaused", "isStoryPaused", "isTouchExplorationEnabled", "branching", "Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "isScrollDisabled", "(Ljava/lang/String;IIZLjava/util/List;Ljava/util/List;IZZZZLcom/urbanairship/android/layout/property/PagerControllerBranching;Z)V", "getBranching", "()Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "getCompleted", "()Z", "currentPageId", "getCurrentPageId", "()Ljava/lang/String;", "getDurations", "()Ljava/util/List;", "hasNext", "getHasNext", "hasPrevious", "getHasPrevious", "getIdentifier", "getLastPageIndex", "()I", "getPageIds", "getPageIndex", "previousPageId", "getPreviousPageId", "getProgress", "getWasMediaPaused", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyWithMediaPaused", "copyWithPageIndex", "index", "copyWithPageIndex$urbanairship_layout_release", "copyWithPageRequest", "request", "Lcom/urbanairship/android/layout/model/PageRequest;", "copyWithStoryPaused", "copyWithTouchExplorationState", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "reportingContext", "Lcom/urbanairship/android/layout/reporting/PagerData;", "history", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Pager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,521:1\n1#2:522\n*E\n"})
    public static final /* data */ class Pager extends State {
        private final PagerControllerBranching branching;
        private final boolean completed;
        private final List durations;
        private final String identifier;
        private final boolean isMediaPaused;
        private final boolean isScrollDisabled;
        private final boolean isStoryPaused;
        private final boolean isTouchExplorationEnabled;
        private final int lastPageIndex;
        private final List pageIds;
        private final int pageIndex;
        private final int progress;
        private final boolean wasMediaPaused;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PageRequest.values().length];
                try {
                    iArr[PageRequest.NEXT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PageRequest.BACK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[PageRequest.FIRST.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public static /* synthetic */ Pager copy$default(Pager pager, String str, int i, int i2, boolean z, List list, List list2, int i3, boolean z2, boolean z3, boolean z4, boolean z5, PagerControllerBranching pagerControllerBranching, boolean z6, int i4, Object obj) {
            return pager.copy((i4 & 1) != 0 ? pager.identifier : str, (i4 & 2) != 0 ? pager.pageIndex : i, (i4 & 4) != 0 ? pager.lastPageIndex : i2, (i4 & 8) != 0 ? pager.completed : z, (i4 & 16) != 0 ? pager.pageIds : list, (i4 & 32) != 0 ? pager.durations : list2, (i4 & 64) != 0 ? pager.progress : i3, (i4 & 128) != 0 ? pager.isMediaPaused : z2, (i4 & 256) != 0 ? pager.wasMediaPaused : z3, (i4 & 512) != 0 ? pager.isStoryPaused : z4, (i4 & 1024) != 0 ? pager.isTouchExplorationEnabled : z5, (i4 & 2048) != 0 ? pager.branching : pagerControllerBranching, (i4 & 4096) != 0 ? pager.isScrollDisabled : z6);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getIsStoryPaused() {
            return this.isStoryPaused;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsTouchExplorationEnabled() {
            return this.isTouchExplorationEnabled;
        }

        @Nullable
        /* renamed from: component12, reason: from getter */
        public final PagerControllerBranching getBranching() {
            return this.branching;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getIsScrollDisabled() {
            return this.isScrollDisabled;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final int getLastPageIndex() {
            return this.lastPageIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCompleted() {
            return this.completed;
        }

        @NotNull
        public final List<String> component5() {
            return this.pageIds;
        }

        @NotNull
        public final List<Integer> component6() {
            return this.durations;
        }

        /* renamed from: component7, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsMediaPaused() {
            return this.isMediaPaused;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getWasMediaPaused() {
            return this.wasMediaPaused;
        }

        @NotNull
        public final Pager copy(@NotNull String identifier, int pageIndex, int lastPageIndex, boolean completed, @NotNull List<String> pageIds, @NotNull List<Integer> durations, int progress, boolean isMediaPaused, boolean wasMediaPaused, boolean isStoryPaused, boolean isTouchExplorationEnabled, @Nullable PagerControllerBranching branching, boolean isScrollDisabled) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIds, "pageIds");
            Intrinsics.checkNotNullParameter(durations, "durations");
            return new Pager(identifier, pageIndex, lastPageIndex, completed, pageIds, durations, progress, isMediaPaused, wasMediaPaused, isStoryPaused, isTouchExplorationEnabled, branching, isScrollDisabled);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pager)) {
                return false;
            }
            Pager pager = (Pager) other;
            return Intrinsics.areEqual(this.identifier, pager.identifier) && this.pageIndex == pager.pageIndex && this.lastPageIndex == pager.lastPageIndex && this.completed == pager.completed && Intrinsics.areEqual(this.pageIds, pager.pageIds) && Intrinsics.areEqual(this.durations, pager.durations) && this.progress == pager.progress && this.isMediaPaused == pager.isMediaPaused && this.wasMediaPaused == pager.wasMediaPaused && this.isStoryPaused == pager.isStoryPaused && this.isTouchExplorationEnabled == pager.isTouchExplorationEnabled && Intrinsics.areEqual(this.branching, pager.branching) && this.isScrollDisabled == pager.isScrollDisabled;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((((((this.identifier.hashCode() * 31) + Integer.hashCode(this.pageIndex)) * 31) + Integer.hashCode(this.lastPageIndex)) * 31) + Boolean.hashCode(this.completed)) * 31) + this.pageIds.hashCode()) * 31) + this.durations.hashCode()) * 31) + Integer.hashCode(this.progress)) * 31) + Boolean.hashCode(this.isMediaPaused)) * 31) + Boolean.hashCode(this.wasMediaPaused)) * 31) + Boolean.hashCode(this.isStoryPaused)) * 31) + Boolean.hashCode(this.isTouchExplorationEnabled)) * 31;
            PagerControllerBranching pagerControllerBranching = this.branching;
            return ((iHashCode + (pagerControllerBranching == null ? 0 : pagerControllerBranching.hashCode())) * 31) + Boolean.hashCode(this.isScrollDisabled);
        }

        @NotNull
        public String toString() {
            return "Pager(identifier=" + this.identifier + ", pageIndex=" + this.pageIndex + ", lastPageIndex=" + this.lastPageIndex + ", completed=" + this.completed + ", pageIds=" + this.pageIds + ", durations=" + this.durations + ", progress=" + this.progress + ", isMediaPaused=" + this.isMediaPaused + ", wasMediaPaused=" + this.wasMediaPaused + ", isStoryPaused=" + this.isStoryPaused + ", isTouchExplorationEnabled=" + this.isTouchExplorationEnabled + ", branching=" + this.branching + ", isScrollDisabled=" + this.isScrollDisabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final int getLastPageIndex() {
            return this.lastPageIndex;
        }

        public final boolean getCompleted() {
            return this.completed;
        }

        public /* synthetic */ Pager(String str, int i, int i2, boolean z, List list, List list2, int i3, boolean z2, boolean z3, boolean z4, boolean z5, PagerControllerBranching pagerControllerBranching, boolean z6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? CollectionsKt.emptyList() : list, (i4 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 64) != 0 ? 0 : i3, (i4 & 128) != 0 ? false : z2, (i4 & 256) != 0 ? false : z3, (i4 & 512) != 0 ? false : z4, (i4 & 1024) != 0 ? false : z5, (i4 & 2048) != 0 ? null : pagerControllerBranching, (i4 & 4096) == 0 ? z6 : false);
        }

        @NotNull
        public final List<String> getPageIds() {
            return this.pageIds;
        }

        @NotNull
        public final List<Integer> getDurations() {
            return this.durations;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isMediaPaused() {
            return this.isMediaPaused;
        }

        public final boolean getWasMediaPaused() {
            return this.wasMediaPaused;
        }

        public final boolean isStoryPaused() {
            return this.isStoryPaused;
        }

        public final boolean isTouchExplorationEnabled() {
            return this.isTouchExplorationEnabled;
        }

        @Nullable
        public final PagerControllerBranching getBranching() {
            return this.branching;
        }

        public final boolean isScrollDisabled() {
            return this.isScrollDisabled;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Pager(@NotNull String identifier, int i, int i2, boolean z, @NotNull List<String> pageIds, @NotNull List<Integer> durations, int i3, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable PagerControllerBranching pagerControllerBranching, boolean z6) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIds, "pageIds");
            Intrinsics.checkNotNullParameter(durations, "durations");
            this.identifier = identifier;
            this.pageIndex = i;
            this.lastPageIndex = i2;
            this.completed = z;
            this.pageIds = pageIds;
            this.durations = durations;
            this.progress = i3;
            this.isMediaPaused = z2;
            this.wasMediaPaused = z3;
            this.isStoryPaused = z4;
            this.isTouchExplorationEnabled = z5;
            this.branching = pagerControllerBranching;
            this.isScrollDisabled = z6;
        }

        public final boolean getHasNext() {
            return this.pageIndex < this.pageIds.size() - 1;
        }

        public final boolean getHasPrevious() {
            return this.pageIndex > 0;
        }

        @NotNull
        public final Pager copyWithPageIndex$urbanairship_layout_release(int index) {
            boolean z;
            boolean z2;
            int i = this.pageIndex;
            if (index == i) {
                return copy$default(this, null, 0, 0, false, null, null, 0, false, false, false, false, null, false, 8191, null);
            }
            if (this.branching == null) {
                z2 = true;
                if (!this.completed && index != this.pageIds.size() - 1) {
                    z = false;
                }
                return copy$default(this, null, index, i, z2, null, null, 0, false, false, false, false, null, false, 4017, null);
            }
            z = this.completed;
            z2 = z;
            return copy$default(this, null, index, i, z2, null, null, 0, false, false, false, false, null, false, 4017, null);
        }

        @NotNull
        public final Pager copyWithPageRequest(@NotNull PageRequest request) {
            int iMax;
            Intrinsics.checkNotNullParameter(request, "request");
            if (this.isScrollDisabled) {
                return copy$default(this, null, 0, 0, false, null, null, 0, false, false, false, false, null, false, 8127, null);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[request.ordinal()];
            if (i != 1) {
                iMax = 0;
                if (i == 2) {
                    iMax = Math.max(this.pageIndex - 1, 0);
                } else if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                iMax = this.pageIndex + 1;
            }
            int i2 = this.pageIndex;
            if (i2 >= 0 && i2 < this.pageIds.size()) {
                return copyWithPageIndex$urbanairship_layout_release(iMax);
            }
            return copy$default(this, null, 0, 0, false, null, null, 0, false, false, false, false, null, false, 8127, null);
        }

        @NotNull
        public final Pager copyWithMediaPaused(boolean isMediaPaused) {
            return copy$default(this, null, 0, 0, false, null, null, 0, isMediaPaused, this.isMediaPaused && !isMediaPaused, false, false, null, false, 7807, null);
        }

        @NotNull
        public final Pager copyWithStoryPaused(boolean isStoryPaused) {
            return copy$default(this, null, 0, 0, false, null, null, 0, false, false, isStoryPaused, false, null, false, 7679, null);
        }

        @NotNull
        public final Pager copyWithTouchExplorationState(boolean isTouchExplorationEnabled) {
            return copy$default(this, null, 0, 0, false, null, null, 0, false, false, false, isTouchExplorationEnabled, null, false, 7167, null);
        }

        @NotNull
        public final PagerData reportingContext(@NotNull List<ReportingEvent.PageSummaryData.PageView> history) {
            Intrinsics.checkNotNullParameter(history, "history");
            String str = this.identifier;
            int i = this.pageIndex;
            List list = this.pageIds;
            return new PagerData(str, i, (String) ((i < 0 || i > CollectionsKt.getLastIndex(list)) ? "NULL!" : list.get(i)), this.branching == null ? this.pageIds.size() : -1, history, this.completed);
        }

        @Nullable
        public final String getCurrentPageId() {
            int i = this.pageIndex;
            if (i < 0 || i >= this.pageIds.size()) {
                return null;
            }
            return (String) this.pageIds.get(this.pageIndex);
        }

        @Nullable
        public final String getPreviousPageId() {
            int i = this.lastPageIndex;
            if (i < 0 || i >= this.pageIds.size()) {
                return null;
            }
            return (String) this.pageIds.get(this.lastPageIndex);
        }
    }

    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0080\b\u0018\u00002\u00020\u0001:\u0001jBw\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00002\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0011¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001e\u001a\u00020\u00002\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\r\u0010'\u001a\u00020&¢\u0006\u0004\b'\u0010(J\r\u0010*\u001a\u00020)¢\u0006\u0004\b*\u0010+J'\u0010/\u001a\u0004\u0018\u00018\u0000\"\f\b\u0000\u0010,*\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b-\u0010.J\u001f\u00105\u001a\u0012\u0012\u0004\u0012\u000200\u0012\b\u0012\u000601j\u0002`20\u0011H\u0000¢\u0006\u0004\b3\u00104J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020706H\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010;\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b=\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010<J\u0010\u0010@\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020\tHÆ\u0003¢\u0006\u0004\bB\u0010CJ\u0016\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\bD\u0010EJ\u0010\u0010F\u001a\u00020\rHÆ\u0003¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\rHÆ\u0003¢\u0006\u0004\bH\u0010GJ\u0010\u0010I\u001a\u00020\rHÆ\u0003¢\u0006\u0004\bI\u0010GJ\u0088\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0001¢\u0006\u0004\bJ\u0010KJ\u0010\u0010L\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bL\u0010<J\u0010\u0010N\u001a\u00020MHÖ\u0001¢\u0006\u0004\bN\u0010OJ\u001a\u0010R\u001a\u00020\r2\b\u0010Q\u001a\u0004\u0018\u00010PHÖ\u0003¢\u0006\u0004\bR\u0010SJ+\u0010U\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010T\u001a\u00020\rH\u0002¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH\u0002¢\u0006\u0004\bX\u0010YR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010Z\u001a\u0004\b[\u0010<R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\\\u001a\u0004\b]\u0010>R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010Z\u001a\u0004\b^\u0010<R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010_\u001a\u0004\b`\u0010AR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010a\u001a\u0004\bb\u0010CR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010c\u001a\u0004\bd\u0010ER\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010e\u001a\u0004\b\u000e\u0010GR\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010e\u001a\u0004\b\u000f\u0010GR\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0010\u0010e\u001a\u0004\b\u0010\u0010GR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010fR\u0017\u0010g\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\bg\u0010e\u001a\u0004\bg\u0010GR!\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u00118F¢\u0006\u0006\u001a\u0004\bh\u00104¨\u0006k"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Form;", "Lcom/urbanairship/android/layout/environment/State;", "", "identifier", "Lcom/urbanairship/android/layout/environment/FormType;", "formType", "formResponseType", "Lcom/urbanairship/android/layout/info/FormValidationMode;", "validationMode", "Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "status", "", "displayedInputs", "", "isVisible", "isEnabled", "isDisplayReported", "", "Lcom/urbanairship/android/layout/environment/State$Form$Child;", "children", "<init>", "(Ljava/lang/String;Lcom/urbanairship/android/layout/environment/FormType;Ljava/lang/String;Lcom/urbanairship/android/layout/info/FormValidationMode;Lcom/urbanairship/android/layout/environment/ThomasFormStatus;Ljava/util/Set;ZZZLjava/util/Map;)V", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "results", "copyWithProcessResult", "(Ljava/util/Map;)Lcom/urbanairship/android/layout/environment/State$Form;", "value", "Lkotlin/Function0;", "Lcom/urbanairship/android/layout/environment/FormFieldFilterPredicate;", "predicate", "copyWithFormInput", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField;Lkotlin/jvm/functions/Function0;)Lcom/urbanairship/android/layout/environment/State$Form;", "isDisplayed", "copyWithDisplayState", "(Ljava/lang/String;Z)Lcom/urbanairship/android/layout/environment/State$Form;", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "lastProcessedStatus", "(Ljava/lang/String;)Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "formResult", "()Lcom/urbanairship/android/layout/event/ReportingEvent$FormResultData;", "Lcom/urbanairship/android/layout/reporting/FormInfo;", "reportingContext", "()Lcom/urbanairship/android/layout/reporting/FormInfo;", ExifInterface.GPS_DIRECTION_TRUE, "inputData$urbanairship_layout_release", "(Ljava/lang/String;)Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "inputData", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "attributes$urbanairship_layout_release", "()Ljava/util/Map;", "attributes", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "channels$urbanairship_layout_release", "()Ljava/util/List;", "channels", "component1", "()Ljava/lang/String;", "component2", "()Lcom/urbanairship/android/layout/environment/FormType;", "component3", "component4", "()Lcom/urbanairship/android/layout/info/FormValidationMode;", "component5", "()Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "component6", "()Ljava/util/Set;", "component7", "()Z", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/urbanairship/android/layout/environment/FormType;Ljava/lang/String;Lcom/urbanairship/android/layout/info/FormValidationMode;Lcom/urbanairship/android/layout/environment/ThomasFormStatus;Ljava/util/Set;ZZZLjava/util/Map;)Lcom/urbanairship/android/layout/environment/State$Form;", "toString", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "allowValid", "evaluateFormStatus", "(Ljava/util/Map;Z)Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "formData", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField$BaseForm;", "Ljava/lang/String;", "getIdentifier", "Lcom/urbanairship/android/layout/environment/FormType;", "getFormType", "getFormResponseType", "Lcom/urbanairship/android/layout/info/FormValidationMode;", "getValidationMode", "Lcom/urbanairship/android/layout/environment/ThomasFormStatus;", "getStatus", "Ljava/util/Set;", "getDisplayedInputs", "Z", "Ljava/util/Map;", "isSubmitted", "getFilteredFields", "filteredFields", "Child", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Form\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,521:1\n494#2,7:522\n453#2:529\n403#2:530\n494#2,7:537\n526#2:547\n511#2,6:548\n526#2:557\n511#2,6:558\n526#2:567\n511#2,6:568\n1238#3,4:531\n1603#3,9:574\n1855#3:583\n1856#3:585\n1612#3:586\n1855#3,2:587\n1603#3,9:589\n1855#3:598\n1856#3:600\n1612#3:601\n215#4,2:535\n187#4,3:544\n187#4,3:554\n187#4,3:564\n1#5:584\n1#5:599\n*S KotlinDebug\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Form\n*L\n284#1:522,7\n285#1:529\n285#1:530\n352#1:537,7\n355#1:547\n355#1:548,6\n358#1:557\n358#1:558,6\n361#1:567\n361#1:568,6\n285#1:531,4\n395#1:574,9\n395#1:583\n395#1:585\n395#1:586\n401#1:587,2\n408#1:589,9\n408#1:598\n408#1:600\n408#1:601\n293#1:535,2\n354#1:544,3\n357#1:554,3\n360#1:564,3\n395#1:584\n408#1:599\n*E\n"})
    public static final /* data */ class Form extends State {
        private final Map children;
        private final Set displayedInputs;
        private final String formResponseType;
        private final FormType formType;
        private final String identifier;
        private final boolean isDisplayReported;
        private final boolean isEnabled;
        private final boolean isSubmitted;
        private final boolean isVisible;
        private final ThomasFormStatus status;
        private final FormValidationMode validationMode;

        public static /* synthetic */ Form copy$default(Form form, String str, FormType formType, String str2, FormValidationMode formValidationMode, ThomasFormStatus thomasFormStatus, Set set, boolean z, boolean z2, boolean z3, Map map, int i, Object obj) {
            return form.copy((i & 1) != 0 ? form.identifier : str, (i & 2) != 0 ? form.formType : formType, (i & 4) != 0 ? form.formResponseType : str2, (i & 8) != 0 ? form.validationMode : formValidationMode, (i & 16) != 0 ? form.status : thomasFormStatus, (i & 32) != 0 ? form.displayedInputs : set, (i & 64) != 0 ? form.isVisible : z, (i & 128) != 0 ? form.isEnabled : z2, (i & 256) != 0 ? form.isDisplayReported : z3, (i & 512) != 0 ? form.children : map);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final FormType getFormType() {
            return this.formType;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getFormResponseType() {
            return this.formResponseType;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final FormValidationMode getValidationMode() {
            return this.validationMode;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final ThomasFormStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final Set<String> component6() {
            return this.displayedInputs;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getIsDisplayReported() {
            return this.isDisplayReported;
        }

        @NotNull
        public final Form copy(@NotNull String identifier, @NotNull FormType formType, @Nullable String formResponseType, @NotNull FormValidationMode validationMode, @NotNull ThomasFormStatus status, @NotNull Set<String> displayedInputs, boolean isVisible, boolean isEnabled, boolean isDisplayReported, @NotNull Map<String, Child> children) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(formType, "formType");
            Intrinsics.checkNotNullParameter(validationMode, "validationMode");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(displayedInputs, "displayedInputs");
            Intrinsics.checkNotNullParameter(children, "children");
            return new Form(identifier, formType, formResponseType, validationMode, status, displayedInputs, isVisible, isEnabled, isDisplayReported, children);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Form)) {
                return false;
            }
            Form form = (Form) other;
            return Intrinsics.areEqual(this.identifier, form.identifier) && Intrinsics.areEqual(this.formType, form.formType) && Intrinsics.areEqual(this.formResponseType, form.formResponseType) && this.validationMode == form.validationMode && this.status == form.status && Intrinsics.areEqual(this.displayedInputs, form.displayedInputs) && this.isVisible == form.isVisible && this.isEnabled == form.isEnabled && this.isDisplayReported == form.isDisplayReported && Intrinsics.areEqual(this.children, form.children);
        }

        public int hashCode() {
            int iHashCode = ((this.identifier.hashCode() * 31) + this.formType.hashCode()) * 31;
            String str = this.formResponseType;
            return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.validationMode.hashCode()) * 31) + this.status.hashCode()) * 31) + this.displayedInputs.hashCode()) * 31) + Boolean.hashCode(this.isVisible)) * 31) + Boolean.hashCode(this.isEnabled)) * 31) + Boolean.hashCode(this.isDisplayReported)) * 31) + this.children.hashCode();
        }

        @NotNull
        public String toString() {
            return "Form(identifier=" + this.identifier + ", formType=" + this.formType + ", formResponseType=" + this.formResponseType + ", validationMode=" + this.validationMode + ", status=" + this.status + ", displayedInputs=" + this.displayedInputs + ", isVisible=" + this.isVisible + ", isEnabled=" + this.isEnabled + ", isDisplayReported=" + this.isDisplayReported + ", children=" + this.children + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final FormType getFormType() {
            return this.formType;
        }

        @Nullable
        public final String getFormResponseType() {
            return this.formResponseType;
        }

        @NotNull
        public final FormValidationMode getValidationMode() {
            return this.validationMode;
        }

        public /* synthetic */ Form(String str, FormType formType, String str2, FormValidationMode formValidationMode, ThomasFormStatus thomasFormStatus, Set set, boolean z, boolean z2, boolean z3, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, formType, str2, formValidationMode, (i & 16) != 0 ? ThomasFormStatus.PENDING_VALIDATION : thomasFormStatus, (i & 32) != 0 ? SetsKt.emptySet() : set, (i & 64) != 0 ? false : z, (i & 128) != 0 ? true : z2, (i & 256) != 0 ? false : z3, (i & 512) != 0 ? MapsKt.emptyMap() : map);
        }

        @NotNull
        public final ThomasFormStatus getStatus() {
            return this.status;
        }

        @NotNull
        public final Set<String> getDisplayedInputs() {
            return this.displayedInputs;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isDisplayReported() {
            return this.isDisplayReported;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Form(@NotNull String identifier, @NotNull FormType formType, @Nullable String str, @NotNull FormValidationMode validationMode, @NotNull ThomasFormStatus status, @NotNull Set<String> displayedInputs, boolean z, boolean z2, boolean z3, @NotNull Map<String, Child> children) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(formType, "formType");
            Intrinsics.checkNotNullParameter(validationMode, "validationMode");
            Intrinsics.checkNotNullParameter(status, "status");
            Intrinsics.checkNotNullParameter(displayedInputs, "displayedInputs");
            Intrinsics.checkNotNullParameter(children, "children");
            this.identifier = identifier;
            this.formType = formType;
            this.formResponseType = str;
            this.validationMode = validationMode;
            this.status = status;
            this.displayedInputs = displayedInputs;
            this.isVisible = z;
            this.isEnabled = z2;
            this.isDisplayReported = z3;
            this.children = children;
            this.isSubmitted = status.isSubmitted();
        }

        @NotNull
        public final Map<String, ThomasFormField<?>> getFilteredFields() {
            Map map = this.children;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                Function0<Boolean> predicate = ((Child) entry.getValue()).getPredicate();
                if (predicate != null ? predicate.invoke().booleanValue() : true) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry2.getKey(), ((Child) entry2.getValue()).getField());
            }
            return linkedHashMap2;
        }

        /* renamed from: isSubmitted, reason: from getter */
        public final boolean getIsSubmitted() {
            return this.isSubmitted;
        }

        @NotNull
        public final Form copyWithProcessResult(@NotNull Map<String, ? extends ThomasFormField<?>> results) {
            Intrinsics.checkNotNullParameter(results, "results");
            Map mutableMap = MapsKt.toMutableMap(this.children);
            for (Map.Entry<String, ? extends ThomasFormField<?>> entry : results.entrySet()) {
                String key = entry.getKey();
                ThomasFormField<?> value = entry.getValue();
                Child child = (Child) mutableMap.get(key);
                if (child != null) {
                    mutableMap.put(key, Child.copy$default(child, null, null, value.getStatus$urbanairship_layout_release(), 3, null));
                }
            }
            return copy$default(this, null, null, null, null, evaluateFormStatus(mutableMap, true), null, false, false, false, mutableMap, 495, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Form copyWithFormInput$default(Form form, ThomasFormField thomasFormField, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            return form.copyWithFormInput(thomasFormField, function0);
        }

        @NotNull
        public final Form copyWithFormInput(@NotNull ThomasFormField<?> value, @Nullable Function0<Boolean> predicate) {
            ThomasFormFieldStatus<?> lastProcessStatus;
            ThomasFormField<?> field;
            ThomasFormField.FieldType<?> fieldType$urbanairship_layout_release;
            Intrinsics.checkNotNullParameter(value, "value");
            Child child = (Child) this.children.get(value.getIdentifier());
            if (child != null && (field = child.getField()) != null && (fieldType$urbanairship_layout_release = field.getFieldType$urbanairship_layout_release()) != null) {
                fieldType$urbanairship_layout_release.cancel$urbanairship_layout_release();
            }
            Map mutableMap = MapsKt.toMutableMap(this.children);
            Child child2 = (Child) mutableMap.get(value.getIdentifier());
            if (child2 == null || (lastProcessStatus = child2.getLastProcessStatus()) == null || !lastProcessStatus.isInvalid() || !value.getStatus$urbanairship_layout_release().isInvalid()) {
                mutableMap.put(value.getIdentifier(), new Child(value, predicate, value.getStatus$urbanairship_layout_release().makePending()));
            }
            return copy$default(this, null, null, null, null, evaluateFormStatus(mutableMap, false), null, false, false, false, mutableMap, 495, null);
        }

        @NotNull
        public final Form copyWithDisplayState(@NotNull String identifier, boolean isDisplayed) {
            Set setMinus;
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            if (isDisplayed) {
                setMinus = SetsKt.plus((Set<? extends String>) this.displayedInputs, identifier);
            } else {
                setMinus = SetsKt.minus((Set<? extends String>) this.displayedInputs, identifier);
            }
            return copy$default(this, null, null, null, null, null, setMinus, false, false, false, null, 991, null);
        }

        @Nullable
        public final ThomasFormFieldStatus<?> lastProcessedStatus(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Child child = (Child) this.children.get(identifier);
            if (child != null) {
                return child.getLastProcessStatus();
            }
            return null;
        }

        @NotNull
        public final ReportingEvent.FormResultData formResult() {
            return new ReportingEvent.FormResultData(formData());
        }

        @NotNull
        public final FormInfo reportingContext() {
            return new FormInfo(this.identifier, this.formType.getValue(), this.formResponseType, Boolean.valueOf(this.status.isSubmitted()));
        }

        @Nullable
        public final <T extends ThomasFormField<?>> T inputData$urbanairship_layout_release(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Child child = (Child) this.children.get(identifier);
            ThomasFormField<?> field = child != null ? child.getField() : null;
            if (field != null) {
                return (T) field;
            }
            return null;
        }

        private final ThomasFormField.BaseForm formData() {
            Set set = CollectionsKt.toSet(getFilteredFields().values());
            FormType formType = this.formType;
            if (formType instanceof FormType.Form) {
                return new ThomasFormField.Form(this.identifier, this.formResponseType, set, ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, set, null, null, null, 14, null));
            }
            if (formType instanceof FormType.Nps) {
                return new ThomasFormField.Nps(this.identifier, ((FormType.Nps) this.formType).getScoreId(), this.formResponseType, set, ThomasFormField.FieldType.Companion.just$default(ThomasFormField.FieldType.INSTANCE, set, null, null, null, 14, null));
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final Map<AttributeName, JsonValue> attributes$urbanairship_layout_release() {
            ThomasFormField.Result result;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Collection<ThomasFormField<?>> collectionValues = getFilteredFields().values();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ThomasFormField.FieldType fieldType$urbanairship_layout_release = ((ThomasFormField) it.next()).getFieldType$urbanairship_layout_release();
                if (fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Async) {
                    ThomasFormField.AsyncValueFetcher.PendingResult pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) ((ThomasFormField.FieldType.Async) fieldType$urbanairship_layout_release).getFetcher().getResults().getValue();
                    result = pendingResult != null ? pendingResult.getValue() : null;
                } else {
                    if (!(fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Instant)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    result = ((ThomasFormField.FieldType.Instant) fieldType$urbanairship_layout_release).getResult();
                }
                Map<AttributeName, JsonValue> attributes = result != null ? result.getAttributes() : null;
                if (attributes != null) {
                    arrayList.add(attributes);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap.putAll((Map) it2.next());
            }
            return MapsKt.toMap(linkedHashMap);
        }

        @NotNull
        public final List<ThomasChannelRegistration> channels$urbanairship_layout_release() {
            ThomasFormField.Result result;
            Collection<ThomasFormField<?>> collectionValues = getFilteredFields().values();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                ThomasFormField.FieldType fieldType$urbanairship_layout_release = ((ThomasFormField) it.next()).getFieldType$urbanairship_layout_release();
                if (fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Async) {
                    ThomasFormField.AsyncValueFetcher.PendingResult pendingResult = (ThomasFormField.AsyncValueFetcher.PendingResult) ((ThomasFormField.FieldType.Async) fieldType$urbanairship_layout_release).getFetcher().getResults().getValue();
                    result = pendingResult != null ? pendingResult.getValue() : null;
                } else {
                    if (!(fieldType$urbanairship_layout_release instanceof ThomasFormField.FieldType.Instant)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    result = ((ThomasFormField.FieldType.Instant) fieldType$urbanairship_layout_release).getResult();
                }
                List<ThomasChannelRegistration> channels = result != null ? result.getChannels() : null;
                if (channels != null) {
                    arrayList.add(channels);
                }
            }
            return CollectionsKt.flatten(arrayList);
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0002\u0010\nJ\r\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\tHÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\f\b\u0002\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Form$Child;", "", "field", "Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "predicate", "Lkotlin/Function0;", "", "Lcom/urbanairship/android/layout/environment/FormFieldFilterPredicate;", "lastProcessStatus", "Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "(Lcom/urbanairship/android/layout/reporting/ThomasFormField;Lkotlin/jvm/functions/Function0;Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;)V", "getField", "()Lcom/urbanairship/android/layout/reporting/ThomasFormField;", "getLastProcessStatus", "()Lcom/urbanairship/android/layout/reporting/ThomasFormFieldStatus;", "getPredicate", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Child {
            private final ThomasFormField field;
            private final ThomasFormFieldStatus lastProcessStatus;
            private final Function0 predicate;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Child copy$default(Child child, ThomasFormField thomasFormField, Function0 function0, ThomasFormFieldStatus thomasFormFieldStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    thomasFormField = child.field;
                }
                if ((i & 2) != 0) {
                    function0 = child.predicate;
                }
                if ((i & 4) != 0) {
                    thomasFormFieldStatus = child.lastProcessStatus;
                }
                return child.copy(thomasFormField, function0, thomasFormFieldStatus);
            }

            @NotNull
            public final ThomasFormField<?> component1() {
                return this.field;
            }

            @Nullable
            public final Function0<Boolean> component2() {
                return this.predicate;
            }

            @NotNull
            public final ThomasFormFieldStatus<?> component3() {
                return this.lastProcessStatus;
            }

            @NotNull
            public final Child copy(@NotNull ThomasFormField<?> field, @Nullable Function0<Boolean> predicate, @NotNull ThomasFormFieldStatus<?> lastProcessStatus) {
                Intrinsics.checkNotNullParameter(field, "field");
                Intrinsics.checkNotNullParameter(lastProcessStatus, "lastProcessStatus");
                return new Child(field, predicate, lastProcessStatus);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Child)) {
                    return false;
                }
                Child child = (Child) other;
                return Intrinsics.areEqual(this.field, child.field) && Intrinsics.areEqual(this.predicate, child.predicate) && Intrinsics.areEqual(this.lastProcessStatus, child.lastProcessStatus);
            }

            public int hashCode() {
                int iHashCode = this.field.hashCode() * 31;
                Function0 function0 = this.predicate;
                return ((iHashCode + (function0 == null ? 0 : function0.hashCode())) * 31) + this.lastProcessStatus.hashCode();
            }

            @NotNull
            public String toString() {
                return "Child(field=" + this.field + ", predicate=" + this.predicate + ", lastProcessStatus=" + this.lastProcessStatus + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Child(@NotNull ThomasFormField<?> field, @Nullable Function0<Boolean> function0, @NotNull ThomasFormFieldStatus<?> lastProcessStatus) {
                Intrinsics.checkNotNullParameter(field, "field");
                Intrinsics.checkNotNullParameter(lastProcessStatus, "lastProcessStatus");
                this.field = field;
                this.predicate = function0;
                this.lastProcessStatus = lastProcessStatus;
            }

            public /* synthetic */ Child(ThomasFormField thomasFormField, Function0 function0, ThomasFormFieldStatus thomasFormFieldStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(thomasFormField, (i & 2) != 0 ? null : function0, thomasFormFieldStatus);
            }

            @NotNull
            public final ThomasFormField<?> getField() {
                return this.field;
            }

            @Nullable
            public final Function0<Boolean> getPredicate() {
                return this.predicate;
            }

            @NotNull
            public final ThomasFormFieldStatus<?> getLastProcessStatus() {
                return this.lastProcessStatus;
            }
        }

        private final ThomasFormStatus evaluateFormStatus(Map children, boolean allowValid) {
            boolean z;
            boolean z2;
            boolean z3;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = children.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                Function0<Boolean> predicate = ((Child) entry.getValue()).getPredicate();
                if (predicate != null ? predicate.invoke().booleanValue() : true) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (linkedHashMap.isEmpty()) {
                z2 = false;
            } else {
                Iterator it2 = linkedHashMap.entrySet().iterator();
                while (it2.hasNext()) {
                    if (((Child) ((Map.Entry) it2.next()).getValue()).getLastProcessStatus().isInvalid()) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Updating status to invalid: ");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    if (((Child) entry2.getValue()).getLastProcessStatus().isInvalid()) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                sb.append(linkedHashMap2);
                UALog.v(sb.toString(), new Object[0]);
                return ThomasFormStatus.INVALID;
            }
            if (linkedHashMap.isEmpty()) {
                z3 = false;
            } else {
                Iterator it3 = linkedHashMap.entrySet().iterator();
                while (it3.hasNext()) {
                    if (((Child) ((Map.Entry) it3.next()).getValue()).getLastProcessStatus().isError()) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
            }
            if (z3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Updating status to error: ");
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                    if (((Child) entry3.getValue()).getLastProcessStatus().isError()) {
                        linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                    }
                }
                sb2.append(linkedHashMap3);
                UALog.v(sb2.toString(), new Object[0]);
                return ThomasFormStatus.ERROR;
            }
            if (linkedHashMap.isEmpty()) {
                z = false;
            } else {
                Iterator it4 = linkedHashMap.entrySet().iterator();
                while (it4.hasNext()) {
                    if (((Child) ((Map.Entry) it4.next()).getValue()).getLastProcessStatus().isPending()) {
                        break;
                    }
                }
                z = false;
            }
            if (z || !allowValid) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Updating status to pending_validation: ");
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                    if (((Child) entry4.getValue()).getLastProcessStatus().isPending()) {
                        linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                    }
                }
                sb3.append(linkedHashMap4);
                UALog.v(sb3.toString(), new Object[0]);
                return ThomasFormStatus.PENDING_VALIDATION;
            }
            UALog.v("Updating status to valid", new Object[0]);
            return ThomasFormStatus.VALID;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u001e\u0010\u001f\u001a\u00020\u000b2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Checkbox;", "Lcom/urbanairship/android/layout/environment/State;", "identifier", "", "minSelection", "", "maxSelection", "selectedItems", "", "Lcom/urbanairship/android/layout/environment/State$Checkbox$Selected;", "isEnabled", "", "(Ljava/lang/String;IILjava/util/Set;Z)V", "getIdentifier", "()Ljava/lang/String;", "()Z", "getMaxSelection", "()I", "getMinSelection", "getSelectedItems", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "isSelected", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Selected", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Checkbox\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,521:1\n1747#2,3:522\n1747#2,3:525\n*S KotlinDebug\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Checkbox\n*L\n443#1:522,3\n445#1:525,3\n*E\n"})
    public static final /* data */ class Checkbox extends State {
        private final String identifier;
        private final boolean isEnabled;
        private final int maxSelection;
        private final int minSelection;
        private final Set selectedItems;

        public static /* synthetic */ Checkbox copy$default(Checkbox checkbox, String str, int i, int i2, Set set, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = checkbox.identifier;
            }
            if ((i3 & 2) != 0) {
                i = checkbox.minSelection;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = checkbox.maxSelection;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                set = checkbox.selectedItems;
            }
            Set set2 = set;
            if ((i3 & 16) != 0) {
                z = checkbox.isEnabled;
            }
            return checkbox.copy(str, i4, i5, set2, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* renamed from: component2, reason: from getter */
        public final int getMinSelection() {
            return this.minSelection;
        }

        /* renamed from: component3, reason: from getter */
        public final int getMaxSelection() {
            return this.maxSelection;
        }

        @NotNull
        public final Set<Selected> component4() {
            return this.selectedItems;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public final Checkbox copy(@NotNull String identifier, int minSelection, int maxSelection, @NotNull Set<Selected> selectedItems, boolean isEnabled) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            return new Checkbox(identifier, minSelection, maxSelection, selectedItems, isEnabled);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Checkbox)) {
                return false;
            }
            Checkbox checkbox = (Checkbox) other;
            return Intrinsics.areEqual(this.identifier, checkbox.identifier) && this.minSelection == checkbox.minSelection && this.maxSelection == checkbox.maxSelection && Intrinsics.areEqual(this.selectedItems, checkbox.selectedItems) && this.isEnabled == checkbox.isEnabled;
        }

        public int hashCode() {
            return (((((((this.identifier.hashCode() * 31) + Integer.hashCode(this.minSelection)) * 31) + Integer.hashCode(this.maxSelection)) * 31) + this.selectedItems.hashCode()) * 31) + Boolean.hashCode(this.isEnabled);
        }

        @NotNull
        public String toString() {
            return "Checkbox(identifier=" + this.identifier + ", minSelection=" + this.minSelection + ", maxSelection=" + this.maxSelection + ", selectedItems=" + this.selectedItems + ", isEnabled=" + this.isEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final int getMinSelection() {
            return this.minSelection;
        }

        public final int getMaxSelection() {
            return this.maxSelection;
        }

        public /* synthetic */ Checkbox(String str, int i, int i2, Set set, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, (i3 & 8) != 0 ? SetsKt.emptySet() : set, (i3 & 16) != 0 ? true : z);
        }

        @NotNull
        public final Set<Selected> getSelectedItems() {
            return this.selectedItems;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Checkbox(@NotNull String identifier, int i, int i2, @NotNull Set<Selected> selectedItems, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
            this.identifier = identifier;
            this.minSelection = i;
            this.maxSelection = i2;
            this.selectedItems = selectedItems;
            this.isEnabled = z;
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Checkbox$Selected;", "", "identifier", "", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getIdentifier", "()Ljava/lang/String;", "getReportingValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Selected {
            private final String identifier;
            private final JsonValue reportingValue;

            public static /* synthetic */ Selected copy$default(Selected selected, String str, JsonValue jsonValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selected.identifier;
                }
                if ((i & 2) != 0) {
                    jsonValue = selected.reportingValue;
                }
                return selected.copy(str, jsonValue);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getIdentifier() {
                return this.identifier;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }

            @NotNull
            public final Selected copy(@Nullable String identifier, @NotNull JsonValue reportingValue) {
                Intrinsics.checkNotNullParameter(reportingValue, "reportingValue");
                return new Selected(identifier, reportingValue);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Selected)) {
                    return false;
                }
                Selected selected = (Selected) other;
                return Intrinsics.areEqual(this.identifier, selected.identifier) && Intrinsics.areEqual(this.reportingValue, selected.reportingValue);
            }

            public int hashCode() {
                String str = this.identifier;
                return ((str == null ? 0 : str.hashCode()) * 31) + this.reportingValue.hashCode();
            }

            @NotNull
            public String toString() {
                return "Selected(identifier=" + this.identifier + ", reportingValue=" + this.reportingValue + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Selected(@Nullable String str, @NotNull JsonValue reportingValue) {
                Intrinsics.checkNotNullParameter(reportingValue, "reportingValue");
                this.identifier = str;
                this.reportingValue = reportingValue;
            }

            @Nullable
            public final String getIdentifier() {
                return this.identifier;
            }

            @NotNull
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }
        }

        public static /* synthetic */ boolean isSelected$default(Checkbox checkbox, String str, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                jsonValue = null;
            }
            return checkbox.isSelected(str, jsonValue);
        }

        public final boolean isSelected(@Nullable String identifier, @Nullable JsonValue reportingValue) {
            if (reportingValue != null) {
                Selected selected = new Selected(identifier, reportingValue);
                Set set = this.selectedItems;
                if (set == null || !set.isEmpty()) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual((Selected) it.next(), selected)) {
                            return true;
                        }
                    }
                }
            } else {
                Set set2 = this.selectedItems;
                if (set2 == null || !set2.isEmpty()) {
                    Iterator it2 = set2.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.areEqual(((Selected) it2.next()).getIdentifier(), identifier)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u001e\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Radio;", "Lcom/urbanairship/android/layout/environment/State;", "identifier", "", "selectedItem", "Lcom/urbanairship/android/layout/environment/State$Radio$Selected;", "isEnabled", "", "(Ljava/lang/String;Lcom/urbanairship/android/layout/environment/State$Radio$Selected;Z)V", "getIdentifier", "()Ljava/lang/String;", "()Z", "getSelectedItem", "()Lcom/urbanairship/android/layout/environment/State$Radio$Selected;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "isSelected", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Selected", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Radio extends State {
        private final String identifier;
        private final boolean isEnabled;
        private final Selected selectedItem;

        public static /* synthetic */ Radio copy$default(Radio radio, String str, Selected selected, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = radio.identifier;
            }
            if ((i & 2) != 0) {
                selected = radio.selectedItem;
            }
            if ((i & 4) != 0) {
                z = radio.isEnabled;
            }
            return radio.copy(str, selected, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Selected getSelectedItem() {
            return this.selectedItem;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public final Radio copy(@NotNull String identifier, @Nullable Selected selectedItem, boolean isEnabled) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Radio(identifier, selectedItem, isEnabled);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Radio)) {
                return false;
            }
            Radio radio = (Radio) other;
            return Intrinsics.areEqual(this.identifier, radio.identifier) && Intrinsics.areEqual(this.selectedItem, radio.selectedItem) && this.isEnabled == radio.isEnabled;
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            Selected selected = this.selectedItem;
            return ((iHashCode + (selected == null ? 0 : selected.hashCode())) * 31) + Boolean.hashCode(this.isEnabled);
        }

        @NotNull
        public String toString() {
            return "Radio(identifier=" + this.identifier + ", selectedItem=" + this.selectedItem + ", isEnabled=" + this.isEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Radio(String str, Selected selected, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : selected, (i & 4) != 0 ? true : z);
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final Selected getSelectedItem() {
            return this.selectedItem;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Radio(@NotNull String identifier, @Nullable Selected selected, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.selectedItem = selected;
            this.isEnabled = z;
        }

        public static /* synthetic */ boolean isSelected$default(Radio radio, String str, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                jsonValue = null;
            }
            return radio.isSelected(str, jsonValue);
        }

        public final boolean isSelected(@Nullable String identifier, @Nullable JsonValue reportingValue) {
            if (identifier != null) {
                Selected selected = this.selectedItem;
                return Intrinsics.areEqual(selected != null ? selected.getIdentifier() : null, identifier);
            }
            Selected selected2 = this.selectedItem;
            return Intrinsics.areEqual(selected2 != null ? selected2.getReportingValue() : null, reportingValue);
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Radio$Selected;", "", "identifier", "", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "attributeValue", "Lcom/urbanairship/android/layout/property/AttributeValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonValue;)V", "getAttributeValue", "()Lcom/urbanairship/json/JsonValue;", "getIdentifier", "()Ljava/lang/String;", "getReportingValue", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Selected {
            private final JsonValue attributeValue;
            private final String identifier;
            private final JsonValue reportingValue;

            public static /* synthetic */ Selected copy$default(Selected selected, String str, JsonValue jsonValue, JsonValue jsonValue2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selected.identifier;
                }
                if ((i & 2) != 0) {
                    jsonValue = selected.reportingValue;
                }
                if ((i & 4) != 0) {
                    jsonValue2 = selected.attributeValue;
                }
                return selected.copy(str, jsonValue, jsonValue2);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getIdentifier() {
                return this.identifier;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final JsonValue getAttributeValue() {
                return this.attributeValue;
            }

            @NotNull
            public final Selected copy(@Nullable String identifier, @Nullable JsonValue reportingValue, @Nullable JsonValue attributeValue) {
                return new Selected(identifier, reportingValue, attributeValue);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Selected)) {
                    return false;
                }
                Selected selected = (Selected) other;
                return Intrinsics.areEqual(this.identifier, selected.identifier) && Intrinsics.areEqual(this.reportingValue, selected.reportingValue) && Intrinsics.areEqual(this.attributeValue, selected.attributeValue);
            }

            public int hashCode() {
                String str = this.identifier;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                JsonValue jsonValue = this.reportingValue;
                int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
                JsonValue jsonValue2 = this.attributeValue;
                return iHashCode2 + (jsonValue2 != null ? jsonValue2.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Selected(identifier=" + this.identifier + ", reportingValue=" + this.reportingValue + ", attributeValue=" + this.attributeValue + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Selected(@Nullable String str, @Nullable JsonValue jsonValue, @Nullable JsonValue jsonValue2) {
                this.identifier = str;
                this.reportingValue = jsonValue;
                this.attributeValue = jsonValue2;
            }

            @Nullable
            public final String getIdentifier() {
                return this.identifier;
            }

            @Nullable
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }

            @Nullable
            public final JsonValue getAttributeValue() {
                return this.attributeValue;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u001e\u0010\u0017\u001a\u00020\u00072\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Score;", "Lcom/urbanairship/android/layout/environment/State;", "identifier", "", "selectedItem", "Lcom/urbanairship/android/layout/environment/State$Score$Selected;", "isEnabled", "", "(Ljava/lang/String;Lcom/urbanairship/android/layout/environment/State$Score$Selected;Z)V", "getIdentifier", "()Ljava/lang/String;", "()Z", "getSelectedItem", "()Lcom/urbanairship/android/layout/environment/State$Score$Selected;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "isSelected", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Selected", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Score extends State {
        private final String identifier;
        private final boolean isEnabled;
        private final Selected selectedItem;

        public static /* synthetic */ Score copy$default(Score score, String str, Selected selected, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = score.identifier;
            }
            if ((i & 2) != 0) {
                selected = score.selectedItem;
            }
            if ((i & 4) != 0) {
                z = score.isEnabled;
            }
            return score.copy(str, selected, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Selected getSelectedItem() {
            return this.selectedItem;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public final Score copy(@NotNull String identifier, @Nullable Selected selectedItem, boolean isEnabled) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Score(identifier, selectedItem, isEnabled);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Score)) {
                return false;
            }
            Score score = (Score) other;
            return Intrinsics.areEqual(this.identifier, score.identifier) && Intrinsics.areEqual(this.selectedItem, score.selectedItem) && this.isEnabled == score.isEnabled;
        }

        public int hashCode() {
            int iHashCode = this.identifier.hashCode() * 31;
            Selected selected = this.selectedItem;
            return ((iHashCode + (selected == null ? 0 : selected.hashCode())) * 31) + Boolean.hashCode(this.isEnabled);
        }

        @NotNull
        public String toString() {
            return "Score(identifier=" + this.identifier + ", selectedItem=" + this.selectedItem + ", isEnabled=" + this.isEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Score(String str, Selected selected, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : selected, (i & 4) != 0 ? true : z);
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final Selected getSelectedItem() {
            return this.selectedItem;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Score(@NotNull String identifier, @Nullable Selected selected, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.selectedItem = selected;
            this.isEnabled = z;
        }

        public static /* synthetic */ boolean isSelected$default(Score score, String str, JsonValue jsonValue, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                jsonValue = null;
            }
            return score.isSelected(str, jsonValue);
        }

        public final boolean isSelected(@Nullable String identifier, @Nullable JsonValue reportingValue) {
            if (identifier != null) {
                Selected selected = this.selectedItem;
                return Intrinsics.areEqual(selected != null ? selected.getIdentifier() : null, identifier);
            }
            Selected selected2 = this.selectedItem;
            return Intrinsics.areEqual(selected2 != null ? selected2.getReportingValue() : null, reportingValue);
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Score$Selected;", "", "identifier", "", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "attributeValue", "Lcom/urbanairship/android/layout/property/AttributeValue;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonValue;)V", "getAttributeValue", "()Lcom/urbanairship/json/JsonValue;", "getIdentifier", "()Ljava/lang/String;", "getReportingValue", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Selected {
            private final JsonValue attributeValue;
            private final String identifier;
            private final JsonValue reportingValue;

            public static /* synthetic */ Selected copy$default(Selected selected, String str, JsonValue jsonValue, JsonValue jsonValue2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selected.identifier;
                }
                if ((i & 2) != 0) {
                    jsonValue = selected.reportingValue;
                }
                if ((i & 4) != 0) {
                    jsonValue2 = selected.attributeValue;
                }
                return selected.copy(str, jsonValue, jsonValue2);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getIdentifier() {
                return this.identifier;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final JsonValue getAttributeValue() {
                return this.attributeValue;
            }

            @NotNull
            public final Selected copy(@Nullable String identifier, @Nullable JsonValue reportingValue, @Nullable JsonValue attributeValue) {
                return new Selected(identifier, reportingValue, attributeValue);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Selected)) {
                    return false;
                }
                Selected selected = (Selected) other;
                return Intrinsics.areEqual(this.identifier, selected.identifier) && Intrinsics.areEqual(this.reportingValue, selected.reportingValue) && Intrinsics.areEqual(this.attributeValue, selected.attributeValue);
            }

            public int hashCode() {
                String str = this.identifier;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                JsonValue jsonValue = this.reportingValue;
                int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
                JsonValue jsonValue2 = this.attributeValue;
                return iHashCode2 + (jsonValue2 != null ? jsonValue2.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Selected(identifier=" + this.identifier + ", reportingValue=" + this.reportingValue + ", attributeValue=" + this.attributeValue + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Selected(@Nullable String str, @Nullable JsonValue jsonValue, @Nullable JsonValue jsonValue2) {
                this.identifier = str;
                this.reportingValue = jsonValue;
                this.attributeValue = jsonValue2;
            }

            @Nullable
            public final String getIdentifier() {
                return this.identifier;
            }

            @Nullable
            public final JsonValue getReportingValue() {
                return this.reportingValue;
            }

            @Nullable
            public final JsonValue getAttributeValue() {
                return this.attributeValue;
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Layout;", "Lcom/urbanairship/android/layout/environment/State;", "mutations", "", "", "Lcom/urbanairship/android/layout/environment/LayoutState$StateMutation;", "(Ljava/util/Map;)V", "getMutations", "()Ljava/util/Map;", "setMutations", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/json/JsonValue;", "getState", "setState", "component1", "copy", "copyWithState", "Lcom/urbanairship/json/JsonMap;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLayoutState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Layout\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,521:1\n453#2:522\n403#2:523\n1238#3,4:524\n1179#3,2:528\n1253#3,4:530\n*S KotlinDebug\n*F\n+ 1 LayoutState.kt\ncom/urbanairship/android/layout/environment/State$Layout\n*L\n503#1:522\n503#1:523\n503#1:524,4\n511#1:528,2\n511#1:530,4\n*E\n"})
    public static final /* data */ class Layout extends State {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final Layout DEFAULT = new Layout(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        private Map mutations;
        private Map state;

        public Layout() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Layout copy$default(Layout layout, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = layout.mutations;
            }
            return layout.copy(map);
        }

        @NotNull
        public final Map<String, LayoutState.StateMutation> component1() {
            return this.mutations;
        }

        @NotNull
        public final Layout copy(@NotNull Map<String, LayoutState.StateMutation> mutations) {
            Intrinsics.checkNotNullParameter(mutations, "mutations");
            return new Layout(mutations);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Layout) && Intrinsics.areEqual(this.mutations, ((Layout) other).mutations);
        }

        public int hashCode() {
            return this.mutations.hashCode();
        }

        @NotNull
        public String toString() {
            return "Layout(mutations=" + this.mutations + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Layout(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? MapsKt.emptyMap() : map);
        }

        @NotNull
        public final Map<String, LayoutState.StateMutation> getMutations() {
            return this.mutations;
        }

        public final void setMutations(@NotNull Map<String, LayoutState.StateMutation> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.mutations = map;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Layout(@NotNull Map<String, LayoutState.StateMutation> mutations) {
            super(null);
            Intrinsics.checkNotNullParameter(mutations, "mutations");
            this.mutations = mutations;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mutations.size()));
            Iterator<T> it = mutations.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), ((LayoutState.StateMutation) entry.getValue()).getValue());
            }
            this.state = linkedHashMap;
        }

        @NotNull
        public final Map<String, JsonValue> getState() {
            return this.state;
        }

        public final void setState(@NotNull Map<String, ? extends JsonValue> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.state = map;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/environment/State$Layout$Companion;", "", "()V", "DEFAULT", "Lcom/urbanairship/android/layout/environment/State$Layout;", "getDEFAULT", "()Lcom/urbanairship/android/layout/environment/State$Layout;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Layout getDEFAULT() {
                return Layout.DEFAULT;
            }
        }

        @NotNull
        public final Layout copyWithState(@NotNull JsonMap state) {
            Intrinsics.checkNotNullParameter(state, "state");
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(state, 10)), 16));
            for (Map.Entry<String, JsonValue> entry : state) {
                String key = entry.getKey();
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                String key2 = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                JsonValue value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                Pair pair = TuplesKt.to(key, new LayoutState.StateMutation(string, key2, value));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return copy(linkedHashMap);
        }
    }
}
