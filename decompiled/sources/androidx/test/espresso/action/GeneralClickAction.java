package androidx.test.espresso.action;

import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.Tapper;
import androidx.test.espresso.core.internal.deps.guava.base.Optional;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/* loaded from: classes2.dex */
public final class GeneralClickAction implements ViewAction {
    private final int buttonState;
    final CoordinatesProvider coordinatesProvider;
    private final int inputDevice;
    final PrecisionDescriber precisionDescriber;
    private final Optional rollbackAction;
    final Tapper tapper;

    @Deprecated
    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber) {
        this(tapper, coordinatesProvider, precisionDescriber, 0, 0, null);
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        Matcher<View> matcherIsDisplayingAtLeast = ViewMatchers.isDisplayingAtLeast(90);
        return this.rollbackAction.isPresent() ? Matchers.allOf(matcherIsDisplayingAtLeast, ((ViewAction) this.rollbackAction.get()).getConstraints()) : matcherIsDisplayingAtLeast;
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.valueOf(this.tapper.toString().toLowerCase()).concat(" click");
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        float[] fArrCalculateCoordinates = this.coordinatesProvider.calculateCoordinates(view);
        float[] fArrDescribePrecision = this.precisionDescriber.describePrecision();
        Tapper.Status statusSendTap = Tapper.Status.FAILURE;
        char c = 0;
        int i = 0;
        while (statusSendTap != Tapper.Status.SUCCESS && i < 3) {
            try {
                statusSendTap = this.tapper.sendTap(uiController, fArrCalculateCoordinates, fArrDescribePrecision, this.inputDevice, this.buttonState);
                if (Log.isLoggable("GeneralClickAction", 3)) {
                    String str = String.format(Locale.ROOT, "%s - At Coordinates: %d, %d and precision: %d, %d", getDescription(), Integer.valueOf((int) fArrCalculateCoordinates[c]), Integer.valueOf((int) fArrCalculateCoordinates[1]), Integer.valueOf((int) fArrDescribePrecision[c]), Integer.valueOf((int) fArrDescribePrecision[1]));
                    Log.d("GeneralClickAction", str.length() != 0 ? "perform: ".concat(str) : new String("perform: "));
                }
                int pressedStateDuration = ViewConfiguration.getPressedStateDuration();
                if (pressedStateDuration > 0) {
                    uiController.loopMainThreadForAtLeast(pressedStateDuration);
                }
                if (statusSendTap == Tapper.Status.WARNING) {
                    if (!this.rollbackAction.isPresent()) {
                        break;
                    } else {
                        ((ViewAction) this.rollbackAction.get()).perform(uiController, view);
                    }
                }
                i++;
                c = 0;
            } catch (RuntimeException e) {
                throw new PerformException.Builder().withActionDescription(String.format(Locale.ROOT, "%s - At Coordinates: %d, %d and precision: %d, %d", getDescription(), Integer.valueOf((int) fArrCalculateCoordinates[0]), Integer.valueOf((int) fArrCalculateCoordinates[1]), Integer.valueOf((int) fArrDescribePrecision[0]), Integer.valueOf((int) fArrDescribePrecision[1]))).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
            }
        }
        if (statusSendTap == Tapper.Status.FAILURE) {
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(String.format(Locale.ROOT, "Couldn't click at: %s,%s precision: %s, %s . Tapper: %s coordinate provider: %s precision describer: %s. Tried %s times. With Rollback? %s", Float.valueOf(fArrCalculateCoordinates[0]), Float.valueOf(fArrCalculateCoordinates[1]), Float.valueOf(fArrDescribePrecision[0]), Float.valueOf(fArrDescribePrecision[1]), this.tapper, this.coordinatesProvider, this.precisionDescriber, Integer.valueOf(i), Boolean.valueOf(this.rollbackAction.isPresent())))).build();
        }
        if (this.tapper == Tap.SINGLE && (view instanceof WebView)) {
            uiController.loopMainThreadForAtLeast(ViewConfiguration.getDoubleTapTimeout());
        }
    }

    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, int i, int i2) {
        this(tapper, coordinatesProvider, precisionDescriber, i, i2, null);
    }

    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, int i, int i2, ViewAction viewAction) {
        this.coordinatesProvider = coordinatesProvider;
        this.tapper = tapper;
        this.precisionDescriber = precisionDescriber;
        this.inputDevice = i;
        this.buttonState = i2;
        this.rollbackAction = Optional.fromNullable(viewAction);
    }

    @Deprecated
    public GeneralClickAction(Tapper tapper, CoordinatesProvider coordinatesProvider, PrecisionDescriber precisionDescriber, ViewAction viewAction) {
        this(tapper, coordinatesProvider, precisionDescriber, 0, 0, viewAction);
    }
}
