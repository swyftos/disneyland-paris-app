package com.disney.id.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.disney.id.android.R;

/* loaded from: classes3.dex */
public final class OneidBrowserPromptBinding implements ViewBinding {

    @NonNull
    public final LinearLayout buttonPanel;

    @NonNull
    public final Button cancelButton;

    @NonNull
    public final Button okButton;
    private final LinearLayout rootView;

    @NonNull
    public final Space spacer;

    @NonNull
    public final TextView target;

    private OneidBrowserPromptBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, Button button2, Space space, TextView textView) {
        this.rootView = linearLayout;
        this.buttonPanel = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.spacer = space;
        this.target = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static OneidBrowserPromptBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static OneidBrowserPromptBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.oneid_browser_prompt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public static OneidBrowserPromptBinding bind(@NonNull View view) {
        int i = R.id.buttonPanel;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cancel_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R.id.ok_button;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.spacer;
                    Space space = (Space) ViewBindings.findChildViewById(view, i);
                    if (space != null) {
                        i = R.id.target;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new OneidBrowserPromptBinding((LinearLayout) view, linearLayout, button, button2, space, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
