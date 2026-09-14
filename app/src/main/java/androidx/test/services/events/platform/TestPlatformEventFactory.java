package androidx.test.services.events.platform;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public final class TestPlatformEventFactory implements Parcelable.Creator<TestPlatformEvent> {

    /* JADX INFO: renamed from: androidx.test.services.events.platform.TestPlatformEventFactory$1 */
    static /* synthetic */ class C14891 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType */
        static final /* synthetic */ int[] f169xc4d5d4b0;

        static {
            int[] iArr = new int[TestPlatformEvent.EventType.values().length];
            f169xc4d5d4b0 = iArr;
            try {
                iArr[TestPlatformEvent.EventType.TEST_RUN_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f169xc4d5d4b0[TestPlatformEvent.EventType.TEST_RUN_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f169xc4d5d4b0[TestPlatformEvent.EventType.TEST_CASE_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f169xc4d5d4b0[TestPlatformEvent.EventType.TEST_CASE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f169xc4d5d4b0[TestPlatformEvent.EventType.TEST_CASE_FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f169xc4d5d4b0[TestPlatformEvent.EventType.TEST_RUN_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestPlatformEvent createFromParcel(Parcel parcel) {
        TestPlatformEvent.EventType eventTypeValueOf = TestPlatformEvent.EventType.valueOf(parcel.readString());
        switch (C14891.f169xc4d5d4b0[eventTypeValueOf.ordinal()]) {
            case 1:
                return new TestRunStartedEvent(parcel);
            case 2:
                return new TestRunErrorEvent(parcel);
            case 3:
                return new TestCaseStartedEvent(parcel);
            case 4:
                return new TestCaseErrorEvent(parcel);
            case 5:
                return new TestCaseFinishedEvent(parcel);
            case 6:
                return new TestRunFinishedEvent(parcel);
            default:
                String strValueOf = String.valueOf(eventTypeValueOf);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
                sb.append("Unhandled event type: ");
                sb.append(strValueOf);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestPlatformEvent[] newArray(int i) {
        return new TestPlatformEvent[i];
    }
}
