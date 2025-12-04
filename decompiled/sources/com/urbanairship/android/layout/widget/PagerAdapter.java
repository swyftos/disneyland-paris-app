package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.util.LayoutUtils;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class PagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final List items = new ArrayList();
    private final PagerModel pagerModel;
    private final ViewEnvironment viewEnvironment;

    public PagerAdapter(@NonNull PagerModel pagerModel, @NonNull ViewEnvironment viewEnvironment) {
        this.pagerModel = pagerModel;
        this.viewEnvironment = viewEnvironment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(viewGroup.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BaseModel<?, ?, ?> itemAtPosition = getItemAtPosition(i);
        viewHolder.container.setId(this.pagerModel.getPageViewId(i));
        viewHolder.bind(itemAtPosition, this.viewEnvironment);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        super.onViewRecycled((PagerAdapter) viewHolder);
        viewHolder.onRecycled();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return ((BaseModel) this.items.get(i)).getViewInfo().getType().ordinal();
    }

    public BaseModel<?, ?, ?> getItemAtPosition(int i) {
        return (BaseModel) this.items.get(i);
    }

    public void setItems(@NonNull List<BaseModel<?, ?, ?>> list) {
        if (this.items.equals(list)) {
            return;
        }
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup container;

        public ViewHolder(@NonNull Context context) {
            this(new FrameLayout(context));
        }

        private ViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            this.container = viewGroup;
        }

        public void bind(@NonNull BaseModel<?, ?, ?> baseModel, @NonNull ViewEnvironment viewEnvironment) {
            this.container.addView(baseModel.createView(this.itemView.getContext(), viewEnvironment, null), -1, -1);
            LayoutUtils.doOnAttachToWindow(this.itemView, new Runnable() { // from class: com.urbanairship.android.layout.widget.PagerAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$bind$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$bind$0() {
            ViewCompat.requestApplyInsets(this.itemView);
        }

        public void onRecycled() {
            this.container.removeAllViews();
        }
    }
}
