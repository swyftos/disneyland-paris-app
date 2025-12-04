package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.event.ReportingEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u0006R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "", "()V", "lastPagerPageEvent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;", "trackers", "Lcom/urbanairship/android/layout/environment/PagersViewTracker$Tracker;", "generateSummaryEvents", "", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData;", "onPageView", "", "pageEvent", "currentDisplayTime", "Lkotlin/time/Duration;", "onPageView-HG0u8IE", "(Lcom/urbanairship/android/layout/event/ReportingEvent$PageViewData;J)V", "stop", "pagerId", "stop-HG0u8IE", "(Ljava/lang/String;J)V", "stopAll", "stopAll-LRDsOJo", "(J)V", "viewedPages", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", "identifier", "Tracker", "ViewedPage", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagersViewTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagersViewTracker.kt\ncom/urbanairship/android/layout/environment/PagersViewTracker\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,98:1\n226#2,3:99\n229#2,2:103\n226#2,5:105\n1#3:102\n1855#4,2:110\n125#5:112\n152#5,3:113\n*S KotlinDebug\n*F\n+ 1 PagersViewTracker.kt\ncom/urbanairship/android/layout/environment/PagersViewTracker\n*L\n22#1:99,3\n22#1:103,2\n34#1:105,5\n42#1:110,2\n50#1:112\n50#1:113,3\n*E\n"})
/* loaded from: classes5.dex */
public final class PagersViewTracker {
    private final MutableStateFlow trackers = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());
    private final MutableStateFlow lastPagerPageEvent = StateFlowKt.MutableStateFlow(MapsKt.emptyMap());

    /* renamed from: onPageView-HG0u8IE, reason: not valid java name */
    public final void m2717onPageViewHG0u8IE(@NotNull ReportingEvent.PageViewData pageEvent, long currentDisplayTime) {
        Object value;
        Map mutableMap;
        Object value2;
        Map mutableMap2;
        Intrinsics.checkNotNullParameter(pageEvent, "pageEvent");
        Tracker tracker = (Tracker) ((Map) this.trackers.getValue()).get(pageEvent.getIdentifier());
        if (tracker == null) {
            Tracker tracker2 = new Tracker();
            MutableStateFlow mutableStateFlow = this.trackers;
            do {
                value2 = mutableStateFlow.getValue();
                mutableMap2 = MapsKt.toMutableMap((Map) value2);
                mutableMap2.put(pageEvent.getIdentifier(), tracker2);
            } while (!mutableStateFlow.compareAndSet(value2, mutableMap2));
            tracker = tracker2;
        }
        tracker.m2720startHG0u8IE(new ViewedPage(pageEvent.getPageIdentifier(), pageEvent.getPageIndex()), currentDisplayTime);
        MutableStateFlow mutableStateFlow2 = this.lastPagerPageEvent;
        do {
            value = mutableStateFlow2.getValue();
            mutableMap = MapsKt.toMutableMap((Map) value);
            mutableMap.put(pageEvent.getIdentifier(), pageEvent);
        } while (!mutableStateFlow2.compareAndSet(value, mutableMap));
    }

    /* renamed from: stop-HG0u8IE, reason: not valid java name */
    public final void m2718stopHG0u8IE(@NotNull String pagerId, long currentDisplayTime) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Tracker tracker = (Tracker) ((Map) this.trackers.getValue()).get(pagerId);
        if (tracker != null) {
            tracker.m2721stopLRDsOJo(currentDisplayTime);
        }
    }

    /* renamed from: stopAll-LRDsOJo, reason: not valid java name */
    public final void m2719stopAllLRDsOJo(long currentDisplayTime) {
        Iterator it = ((Map) this.trackers.getValue()).values().iterator();
        while (it.hasNext()) {
            ((Tracker) it.next()).m2721stopLRDsOJo(currentDisplayTime);
        }
    }

    @Nullable
    public final List<ReportingEvent.PageSummaryData.PageView> viewedPages(@NotNull String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Tracker tracker = (Tracker) ((Map) this.trackers.getValue()).get(identifier);
        if (tracker != null) {
            return tracker.getViewHistory();
        }
        return null;
    }

    @NotNull
    public final List<ReportingEvent.PageSummaryData> generateSummaryEvents() {
        List listEmptyList;
        Map map = (Map) this.lastPagerPageEvent.getValue();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            ReportingEvent.PageViewData pageViewData = (ReportingEvent.PageViewData) entry.getValue();
            Tracker tracker = (Tracker) ((Map) this.trackers.getValue()).get(str);
            if (tracker == null || (listEmptyList = tracker.getViewHistory()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            arrayList.add(new ReportingEvent.PageSummaryData(str, listEmptyList, pageViewData.getPageCount(), pageViewData.getCompleted()));
        }
        return arrayList;
    }

    private static final class Tracker {
        private ViewedPage currentPage;
        private Duration currentPageViewStartedTime;
        private final List viewHistory = new ArrayList();

        public final List getViewHistory() {
            return this.viewHistory;
        }

        /* renamed from: start-HG0u8IE, reason: not valid java name */
        public final void m2720startHG0u8IE(ViewedPage page, long j) {
            Intrinsics.checkNotNullParameter(page, "page");
            if (Intrinsics.areEqual(this.currentPage, page)) {
                return;
            }
            m2721stopLRDsOJo(j);
            this.currentPage = page;
            this.currentPageViewStartedTime = Duration.m3465boximpl(j);
        }

        /* renamed from: stop-LRDsOJo, reason: not valid java name */
        public final void m2721stopLRDsOJo(long j) {
            Duration duration = this.currentPageViewStartedTime;
            if (duration != null) {
                long rawValue = duration.getRawValue();
                ViewedPage viewedPage = this.currentPage;
                if (viewedPage == null) {
                    return;
                }
                if (Duration.m3466compareToLRDsOJo(j, rawValue) < 0) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.android.layout.environment.PagersViewTracker$Tracker$stop$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Current display time is less than start time.";
                        }
                    }, 1, null);
                }
                this.viewHistory.add(new ReportingEvent.PageSummaryData.PageView(viewedPage.getIdentifier(), viewedPage.getIndex(), Duration.m3473getAbsoluteValueUwyO8pc(Duration.m3501minusLRDsOJo(j, rawValue)), null));
                this.currentPageViewStartedTime = null;
                this.currentPage = null;
            }
        }
    }

    private static final class ViewedPage {
        private final String identifier;
        private final int index;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewedPage)) {
                return false;
            }
            ViewedPage viewedPage = (ViewedPage) obj;
            return Intrinsics.areEqual(this.identifier, viewedPage.identifier) && this.index == viewedPage.index;
        }

        public int hashCode() {
            return (this.identifier.hashCode() * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "ViewedPage(identifier=" + this.identifier + ", index=" + this.index + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ViewedPage(String identifier, int i) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
            this.index = i;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final int getIndex() {
            return this.index;
        }
    }
}
