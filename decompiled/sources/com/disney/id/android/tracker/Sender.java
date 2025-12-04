package com.disney.id.android.tracker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/tracker/Sender;", "", "send", "Lcom/disney/id/android/tracker/Sender$SenderResponse;", "event", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "SenderResponse", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Sender {
    @NotNull
    SenderResponse send(@NotNull OneIDTrackerEvent event);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/disney/id/android/tracker/Sender$SenderResponse;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "FAILURE_PERMANENT", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SenderResponse {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SenderResponse[] $VALUES;
        public static final SenderResponse SUCCESS = new SenderResponse("SUCCESS", 0);
        public static final SenderResponse FAILURE = new SenderResponse("FAILURE", 1);
        public static final SenderResponse FAILURE_PERMANENT = new SenderResponse("FAILURE_PERMANENT", 2);

        private static final /* synthetic */ SenderResponse[] $values() {
            return new SenderResponse[]{SUCCESS, FAILURE, FAILURE_PERMANENT};
        }

        @NotNull
        public static EnumEntries<SenderResponse> getEntries() {
            return $ENTRIES;
        }

        public static SenderResponse valueOf(String str) {
            return (SenderResponse) Enum.valueOf(SenderResponse.class, str);
        }

        public static SenderResponse[] values() {
            return (SenderResponse[]) $VALUES.clone();
        }

        private SenderResponse(String str, int i) {
        }

        static {
            SenderResponse[] senderResponseArr$values = $values();
            $VALUES = senderResponseArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(senderResponseArr$values);
        }
    }
}
