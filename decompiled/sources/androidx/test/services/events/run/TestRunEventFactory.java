package androidx.test.services.events.run;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.test.services.events.run.TestRunEvent;

/* loaded from: classes2.dex */
final class TestRunEventFactory implements Parcelable.Creator<TestRunEvent> {
    TestRunEventFactory() {
    }

    /* renamed from: androidx.test.services.events.run.TestRunEventFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType;

        static {
            int[] iArr = new int[TestRunEvent.EventType.values().length];
            $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType = iArr;
            try {
                iArr[TestRunEvent.EventType.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.TEST_STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.TEST_FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.TEST_ASSUMPTION_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.TEST_FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.TEST_IGNORED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[TestRunEvent.EventType.FINISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestRunEvent createFromParcel(Parcel parcel) {
        TestRunEvent.EventType eventTypeValueOf = TestRunEvent.EventType.valueOf(parcel.readString());
        switch (AnonymousClass1.$SwitchMap$androidx$test$services$events$run$TestRunEvent$EventType[eventTypeValueOf.ordinal()]) {
            case 1:
                return new TestRunStartedEvent(parcel);
            case 2:
                return new TestStartedEvent(parcel);
            case 3:
                return new TestFinishedEvent(parcel);
            case 4:
                return new TestAssumptionFailureEvent(parcel);
            case 5:
                return new TestFailureEvent(parcel);
            case 6:
                return new TestIgnoredEvent(parcel);
            case 7:
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
    public TestRunEvent[] newArray(int i) {
        return new TestRunEvent[i];
    }
}
