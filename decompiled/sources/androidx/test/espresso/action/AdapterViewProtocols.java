package androidx.test.espresso.action;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.AdapterViewFlipper;
import androidx.test.espresso.action.AdapterViewProtocol;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.collect.Lists;
import androidx.test.espresso.core.internal.deps.guava.collect.Range;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.util.EspressoOptional;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AdapterViewProtocols {
    private static final AdapterViewProtocol STANDARD_PROTOCOL = new StandardAdapterViewProtocol();

    private static final class StandardAdapterViewProtocol implements AdapterViewProtocol {

        private static final class StandardDataFunction implements AdapterViewProtocol.DataFunction {
            private final Object dataAtPosition;
            private final int position;

            private StandardDataFunction(Object obj, int i) {
                Preconditions.checkArgument(i >= 0, "position must be >= 0");
                this.dataAtPosition = obj;
                this.position = i;
            }

            @Override // androidx.test.espresso.action.AdapterViewProtocol.DataFunction
            public Object getData() {
                Object obj = this.dataAtPosition;
                if ((obj instanceof Cursor) && !((Cursor) obj).moveToPosition(this.position)) {
                    int i = this.position;
                    StringBuilder sb = new StringBuilder(43);
                    sb.append("Cannot move cursor to position: ");
                    sb.append(i);
                    Log.e("StdAdapterViewProtocol", sb.toString());
                }
                return this.dataAtPosition;
            }
        }

        private boolean isElementFullyRendered(AdapterView adapterView, int i) {
            return ViewMatchers.isDisplayingAtLeast(90).matches(adapterView.getChildAt(i));
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public Iterable getDataInAdapterView(AdapterView adapterView) {
            ArrayList arrayListNewArrayList = Lists.newArrayList();
            for (int i = 0; i < adapterView.getCount(); i++) {
                arrayListNewArrayList.add(new AdapterViewProtocol.AdaptedData.Builder().withDataFunction(new StandardDataFunction(adapterView.getItemAtPosition(i), i)).withOpaqueToken(Integer.valueOf(i)).build());
            }
            return arrayListNewArrayList;
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public EspressoOptional getDataRenderedByView(AdapterView adapterView, View view) {
            int positionForView;
            return (adapterView != view.getParent() || (positionForView = adapterView.getPositionForView(view)) == -1) ? EspressoOptional.absent() : EspressoOptional.of(new AdapterViewProtocol.AdaptedData.Builder().withDataFunction(new StandardDataFunction(adapterView.getItemAtPosition(positionForView), positionForView)).withOpaqueToken(Integer.valueOf(positionForView)).build());
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public boolean isDataRenderedWithinAdapterView(AdapterView adapterView, AdapterViewProtocol.AdaptedData adaptedData) {
            Preconditions.checkArgument(adaptedData.opaqueToken instanceof Integer, "Not my data: %s", adaptedData);
            Integer num = (Integer) adaptedData.opaqueToken;
            int iIntValue = num.intValue();
            boolean zIsElementFullyRendered = Range.closed(Integer.valueOf(adapterView.getFirstVisiblePosition()), Integer.valueOf(adapterView.getLastVisiblePosition())).contains(num) ? adapterView.getFirstVisiblePosition() == adapterView.getLastVisiblePosition() ? true : isElementFullyRendered(adapterView, iIntValue - adapterView.getFirstVisiblePosition()) : false;
            if (zIsElementFullyRendered) {
                adapterView.setSelection(iIntValue);
            }
            return zIsElementFullyRendered;
        }

        @Override // androidx.test.espresso.action.AdapterViewProtocol
        public void makeDataRenderedWithinAdapterView(AdapterView adapterView, AdapterViewProtocol.AdaptedData adaptedData) {
            Preconditions.checkArgument(adaptedData.opaqueToken instanceof Integer, "Not my data: %s", adaptedData);
            int iIntValue = ((Integer) adaptedData.opaqueToken).intValue();
            boolean z = true;
            boolean z2 = false;
            if (adapterView instanceof AbsListView) {
                ((AbsListView) adapterView).smoothScrollToPositionFromTop(iIntValue, adapterView.getPaddingTop(), 0);
                z2 = true;
            }
            if (adapterView instanceof AdapterViewAnimator) {
                if (adapterView instanceof AdapterViewFlipper) {
                    ((AdapterViewFlipper) adapterView).stopFlipping();
                }
                ((AdapterViewAnimator) adapterView).setDisplayedChild(iIntValue);
            } else {
                z = z2;
            }
            if (z) {
                return;
            }
            adapterView.setSelection(iIntValue);
        }
    }

    public static AdapterViewProtocol standardProtocol() {
        return STANDARD_PROTOCOL;
    }
}
