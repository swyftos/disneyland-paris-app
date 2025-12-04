package androidx.test.espresso.action;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.AdapterViewProtocol;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.ArrayList;
import java.util.Locale;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;

/* loaded from: classes2.dex */
public final class AdapterDataLoaderAction implements ViewAction {
    private AdapterViewProtocol.AdaptedData adaptedData;
    final AdapterViewProtocol adapterViewProtocol;
    final EspressoOptional atPosition;
    final Matcher dataToLoadMatcher;
    private boolean performed = false;
    private final Object dataLock = new Object();

    public AdapterDataLoaderAction(Matcher<? extends Object> matcher, EspressoOptional<Integer> espressoOptional, AdapterViewProtocol adapterViewProtocol) {
        this.dataToLoadMatcher = (Matcher) Preconditions.checkNotNull(matcher);
        this.atPosition = (EspressoOptional) Preconditions.checkNotNull(espressoOptional);
        this.adapterViewProtocol = (AdapterViewProtocol) Preconditions.checkNotNull(adapterViewProtocol);
    }

    public AdapterViewProtocol.AdaptedData getAdaptedData() {
        AdapterViewProtocol.AdaptedData adaptedData;
        synchronized (this.dataLock) {
            Preconditions.checkState(this.performed, "perform hasn't beenViewFinderImpl called yet!");
            adaptedData = this.adaptedData;
        }
        return adaptedData;
    }

    @Override // androidx.test.espresso.ViewAction
    public Matcher<View> getConstraints() {
        return Matchers.allOf(ViewMatchers.isAssignableFrom(AdapterView.class), ViewMatchers.isDisplayed());
    }

    @Override // androidx.test.espresso.ViewAction
    public String getDescription() {
        return "load adapter data";
    }

    @Override // androidx.test.espresso.ViewAction
    public void perform(UiController uiController, View view) {
        int i;
        AdapterView<? extends Adapter> adapterView = (AdapterView) view;
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        for (AdapterViewProtocol.AdaptedData adaptedData : this.adapterViewProtocol.getDataInAdapterView(adapterView)) {
            if (this.dataToLoadMatcher.matches(adaptedData.getData())) {
                arrayListNewArrayList.add(adaptedData);
            }
        }
        if (arrayListNewArrayList.size() == 0) {
            StringDescription stringDescription = new StringDescription();
            this.dataToLoadMatcher.describeTo(stringDescription);
            if (arrayListNewArrayList.isEmpty()) {
                stringDescription.appendText(" contained values: ");
                stringDescription.appendValue(this.adapterViewProtocol.getDataInAdapterView(adapterView));
                PerformException.Builder builderWithViewDescription = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
                String strValueOf = String.valueOf(stringDescription);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("No data found matching: ");
                sb.append(strValueOf);
                throw builderWithViewDescription.withCause(new RuntimeException(sb.toString())).build();
            }
        }
        synchronized (this.dataLock) {
            try {
                Preconditions.checkState(!this.performed, "perform called 2x!");
                this.performed = true;
                i = 0;
                if (this.atPosition.isPresent()) {
                    int size = arrayListNewArrayList.size() - 1;
                    if (((Integer) this.atPosition.get()).intValue() > size) {
                        throw new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view)).withCause(new RuntimeException(String.format(Locale.ROOT, "There are only %d elements that matched but requested %d element.", Integer.valueOf(size), this.atPosition.get()))).build();
                    }
                    this.adaptedData = (AdapterViewProtocol.AdaptedData) arrayListNewArrayList.get(((Integer) this.atPosition.get()).intValue());
                } else {
                    if (arrayListNewArrayList.size() != 1) {
                        StringDescription stringDescription2 = new StringDescription();
                        this.dataToLoadMatcher.describeTo(stringDescription2);
                        PerformException.Builder builderWithViewDescription2 = new PerformException.Builder().withActionDescription(getDescription()).withViewDescription(HumanReadables.describe(view));
                        String strValueOf2 = String.valueOf(stringDescription2);
                        String strValueOf3 = String.valueOf(arrayListNewArrayList);
                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 44 + strValueOf3.length());
                        sb2.append("Multiple data elements matched: ");
                        sb2.append(strValueOf2);
                        sb2.append(". Elements: ");
                        sb2.append(strValueOf3);
                        throw builderWithViewDescription2.withCause(new RuntimeException(sb2.toString())).build();
                    }
                    this.adaptedData = (AdapterViewProtocol.AdaptedData) arrayListNewArrayList.get(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        while (!this.adapterViewProtocol.isDataRenderedWithinAdapterView(adapterView, this.adaptedData)) {
            if (i <= 1) {
                this.adapterViewProtocol.makeDataRenderedWithinAdapterView(adapterView, this.adaptedData);
            } else if (i % 50 == 0) {
                adapterView.invalidate();
                this.adapterViewProtocol.makeDataRenderedWithinAdapterView(adapterView, this.adaptedData);
            }
            uiController.loopMainThreadForAtLeast(100L);
            i++;
        }
    }
}
