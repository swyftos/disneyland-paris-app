package com.urbanairship.android.layout.widget;

import android.content.res.Resources;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.urbanairship.android.layout.widget.ShapeButton;

/* loaded from: classes5.dex */
public abstract class CheckableViewAdapter<V extends View> {
    protected final V view;

    public interface OnCheckedChangeListener {
        void onCheckedChange(View view, boolean z);
    }

    public abstract boolean isChecked();

    public abstract void setChecked(boolean z);

    public abstract void setEnabled(boolean z);

    public abstract void setOnCheckedChangeListener(@Nullable OnCheckedChangeListener onCheckedChangeListener);

    /* JADX WARN: Multi-variable type inference failed */
    private CheckableViewAdapter(View view) {
        this.view = view;
    }

    public void setContentDescription(@NonNull String str) {
        this.view.setContentDescription(str);
    }

    public void setId(@IdRes int i) {
        this.view.setId(i);
    }

    public static class Checkbox extends CheckableViewAdapter<ShapeButton> {
        public Checkbox(@NonNull ShapeButton shapeButton) {
            super(shapeButton);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setOnCheckedChangeListener(@Nullable final OnCheckedChangeListener onCheckedChangeListener) {
            ((ShapeButton) this.view).setOnCheckedChangeListener(onCheckedChangeListener != null ? new ShapeButton.OnCheckedChangeListener() { // from class: com.urbanairship.android.layout.widget.CheckableViewAdapter$Checkbox$$ExternalSyntheticLambda0
                @Override // com.urbanairship.android.layout.widget.ShapeButton.OnCheckedChangeListener
                public final void onCheckedChanged(View view, boolean z) {
                    onCheckedChangeListener.onCheckedChange(view, z);
                }
            } : null);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setChecked(boolean z) {
            ((ShapeButton) this.view).setChecked(z);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setEnabled(boolean z) {
            ((ShapeButton) this.view).setEnabled(z);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public boolean isChecked() {
            return ((ShapeButton) this.view).isChecked();
        }
    }

    public static class Switch extends CheckableViewAdapter<SwitchCompat> {
        public Switch(@NonNull SwitchCompat switchCompat) {
            super(switchCompat);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setOnCheckedChangeListener(@Nullable final OnCheckedChangeListener onCheckedChangeListener) {
            ((SwitchCompat) this.view).setOnCheckedChangeListener(onCheckedChangeListener != null ? new CompoundButton.OnCheckedChangeListener() { // from class: com.urbanairship.android.layout.widget.CheckableViewAdapter$Switch$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    onCheckedChangeListener.onCheckedChange(compoundButton, z);
                }
            } : null);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setChecked(boolean z) throws Resources.NotFoundException {
            ((SwitchCompat) this.view).setChecked(z);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public void setEnabled(boolean z) {
            ((SwitchCompat) this.view).setEnabled(z);
        }

        @Override // com.urbanairship.android.layout.widget.CheckableViewAdapter
        public boolean isChecked() {
            return ((SwitchCompat) this.view).isChecked();
        }
    }
}
