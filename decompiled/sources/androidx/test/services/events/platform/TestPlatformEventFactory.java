package androidx.test.services.events.platform;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.test.services.events.platform.TestPlatformEvent;

/* loaded from: classes2.dex */
public final class TestPlatformEventFactory implements Parcelable.Creator<TestPlatformEvent> {

    /* renamed from: androidx.test.services.events.platform.TestPlatformEventFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType;

        static {
            int[] iArr = new int[TestPlatformEvent.EventType.values().length];
            $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType = iArr;
            try {
                iArr[TestPlatformEvent.EventType.TEST_RUN_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[TestPlatformEvent.EventType.TEST_RUN_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[TestPlatformEvent.EventType.TEST_CASE_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[TestPlatformEvent.EventType.TEST_CASE_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[TestPlatformEvent.EventType.TEST_CASE_FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[TestPlatformEvent.EventType.TEST_RUN_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestPlatformEvent createFromParcel(Parcel parcel) {
        TestPlatformEvent.EventType eventTypeValueOf = TestPlatformEvent.EventType.valueOf(parcel.readString());
        switch (AnonymousClass1.$SwitchMap$androidx$test$services$events$platform$TestPlatformEvent$EventType[eventTypeValueOf.ordinal()]) {
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
