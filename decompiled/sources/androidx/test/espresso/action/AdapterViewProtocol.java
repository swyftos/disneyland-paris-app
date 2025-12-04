package androidx.test.espresso.action;

import android.database.Cursor;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.util.EspressoOptional;
import androidx.test.espresso.util.HumanReadables;
import java.util.Locale;

/* loaded from: classes2.dex */
public interface AdapterViewProtocol {

    public static class AdaptedData {

        @Deprecated
        public final Object data;
        private final DataFunction dataFunction;
        public final Object opaqueToken;

        public static class Builder {
            private Object data;
            private DataFunction dataFunction;
            private Object opaqueToken;

            public AdaptedData build() {
                DataFunction dataFunction = this.dataFunction;
                if (dataFunction != null) {
                    this.data = dataFunction.getData();
                } else {
                    this.dataFunction = new DataFunction() { // from class: androidx.test.espresso.action.AdapterViewProtocol.AdaptedData.Builder.1
                        @Override // androidx.test.espresso.action.AdapterViewProtocol.DataFunction
                        public Object getData() {
                            return Builder.this.data;
                        }
                    };
                }
                return new AdaptedData(this.data, this.opaqueToken, this.dataFunction);
            }

            public Builder withData(Object obj) {
                this.data = obj;
                return this;
            }

            public Builder withDataFunction(DataFunction dataFunction) {
                this.dataFunction = dataFunction;
                return this;
            }

            public Builder withOpaqueToken(Object obj) {
                this.opaqueToken = obj;
                return this;
            }
        }

        private AdaptedData(Object obj, Object obj2, DataFunction dataFunction) {
            this.data = obj;
            this.opaqueToken = Preconditions.checkNotNull(obj2);
            this.dataFunction = (DataFunction) Preconditions.checkNotNull(dataFunction);
        }

        public Object getData() {
            return this.dataFunction.getData();
        }

        public String toString() {
            Object data = getData();
            String name = data == null ? "null" : data.getClass().getName();
            if (data instanceof Cursor) {
                data = HumanReadables.describe((Cursor) data);
            }
            return String.format(Locale.ROOT, "Data: %s (class: %s) token: %s", data, name, this.opaqueToken);
        }
    }

    public interface DataFunction {
        Object getData();
    }

    Iterable<AdaptedData> getDataInAdapterView(AdapterView<? extends Adapter> adapterView);

    EspressoOptional<AdaptedData> getDataRenderedByView(AdapterView<? extends Adapter> adapterView, View view);

    boolean isDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdaptedData adaptedData);

    void makeDataRenderedWithinAdapterView(AdapterView<? extends Adapter> adapterView, AdaptedData adaptedData);
}
