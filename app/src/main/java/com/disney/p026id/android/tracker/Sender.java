package com.disney.p026id.android.tracker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m1836d2 = {"Lcom/disney/id/android/tracker/Sender;", "", "send", "Lcom/disney/id/android/tracker/Sender$SenderResponse;", "event", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "SenderResponse", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface Sender {

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/disney/id/android/tracker/Sender$SenderResponse;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "FAILURE_PERMANENT", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum SenderResponse {
        SUCCESS,
        FAILURE,
        FAILURE_PERMANENT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<SenderResponse> getEntries() {
            return $ENTRIES;
        }
    }

    @NotNull
    SenderResponse send(@NotNull OneIDTrackerEvent event);
}
