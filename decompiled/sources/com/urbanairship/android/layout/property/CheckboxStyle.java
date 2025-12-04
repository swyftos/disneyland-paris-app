package com.urbanairship.android.layout.property;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.Image;
import com.urbanairship.android.layout.shape.Shape;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class CheckboxStyle extends ToggleStyle {
    private final Bindings bindings;

    public CheckboxStyle(@NonNull Bindings bindings) {
        super(ToggleType.CHECKBOX);
        this.bindings = bindings;
    }

    @NonNull
    public static CheckboxStyle fromJson(@NonNull JsonMap jsonMap) throws JsonException {
        return new CheckboxStyle(Bindings.fromJson(jsonMap.opt("bindings").optMap()));
    }

    public static class Bindings {
        private final Binding selected;
        private final Binding unselected;

        Bindings(Binding binding, Binding binding2) {
            this.selected = binding;
            this.unselected = binding2;
        }

        public static Bindings fromJson(@NonNull JsonMap jsonMap) throws JsonException {
            return new Bindings(Binding.fromJson(jsonMap.opt("selected").optMap()), Binding.fromJson(jsonMap.opt("unselected").optMap()));
        }

        @NonNull
        public Binding getSelected() {
            return this.selected;
        }

        @NonNull
        public Binding getUnselected() {
            return this.unselected;
        }
    }

    public static class Binding {
        private final Image.Icon icon;
        private final List shapes;

        public Binding(@NonNull List<Shape> list, @Nullable Image.Icon icon) {
            this.shapes = list;
            this.icon = icon;
        }

        @NonNull
        public static Binding fromJson(@NonNull JsonMap jsonMap) throws JsonException {
            JsonList jsonListOptList = jsonMap.opt("shapes").optList();
            JsonMap jsonMapOptMap = jsonMap.opt("icon").optMap();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jsonListOptList.size(); i++) {
                arrayList.add(Shape.fromJson(jsonListOptList.get(i).optMap()));
            }
            return new Binding(arrayList, jsonMapOptMap.isEmpty() ? null : Image.Icon.fromJson(jsonMapOptMap));
        }

        @NonNull
        public List<Shape> getShapes() {
            return this.shapes;
        }

        @Nullable
        public Image.Icon getIcon() {
            return this.icon;
        }
    }

    @NonNull
    public Bindings getBindings() {
        return this.bindings;
    }
}
