package androidx.test.espresso.action;

import android.view.View;
import android.view.ViewConfiguration;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.Swiper;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;
import org.hamcrest.Matcher;

/* loaded from: classes2.dex */
public final class GeneralSwipeAction implements ViewAction {
    final CoordinatesProvider endCoordinatesProvider;
    final PrecisionDescriber precisionDescriber;
    final CoordinatesProvider startCoordinatesProvider;
    final Swiper swiper;

    public GeneralSwipeAction(Swiper swiper, CoordinatesProvider coordinatesProvider, CoordinatesProvider coordinatesProvider2, PrecisionDescriber precisionDescriber) {
        this.swiper = swiper;
        this.startCoordinatesProvider = coordinatesProvider;
        this.endCoordinatesProvider = coordinatesProvider2;
        this.precisionDescriber = precisionDescriber;
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return ViewMatchers.isDisplayingAtLeast(90);
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return String.valueOf(this.swiper.toString().toLowerCase()).concat(" swipe");
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        float[] fArrCalculateCoordinates = this.startCoordinatesProvider.calculateCoordinates(view);
        float[] fArrCalculateCoordinates2 = this.endCoordinatesProvider.calculateCoordinates(view);
        float[] fArrDescribePrecision = this.precisionDescriber.describePrecision();
        Swiper.Status statusSendSwipe = Swiper.Status.FAILURE;
        for (int i = 0; i < 3 && statusSendSwipe != Swiper.Status.SUCCESS; i++) {
            try {
                statusSendSwipe = this.swiper.sendSwipe(uiController, fArrCalculateCoordinates, fArrCalculateCoordinates2, fArrDescribePrecision);
                int pressedStateDuration = ViewConfiguration.getPressedStateDuration();
                if (pressedStateDuration > 0) {
                    uiController.loopMainThreadForAtLeast(pressedStateDuration);
                }
            } catch (RuntimeException e) {
                throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(e).build();
            }
        }
        if (statusSendSwipe == Swiper.Status.FAILURE) {
            throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(String.format(Locale.ROOT, "Couldn't swipe from: %s,%s to: %s,%s precision: %s, %s . Swiper: %s start coordinate provider: %s precision describer: %s. Tried %s times", Float.valueOf(fArrCalculateCoordinates[0]), Float.valueOf(fArrCalculateCoordinates[1]), Float.valueOf(fArrCalculateCoordinates2[0]), Float.valueOf(fArrCalculateCoordinates2[1]), Float.valueOf(fArrDescribePrecision[0]), Float.valueOf(fArrDescribePrecision[1]), this.swiper, this.startCoordinatesProvider, this.precisionDescriber, 3))).build();
        }
    }
}
