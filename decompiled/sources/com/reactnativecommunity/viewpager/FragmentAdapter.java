package com.reactnativecommunity.viewpager;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class FragmentAdapter extends FragmentStateAdapter {
    private List childrenViews;

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.childrenViews = new ArrayList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i) {
        return new ViewPagerFragment((View) this.childrenViews.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.childrenViews.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return ((View) this.childrenViews.get(i)).getId();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public boolean containsItem(long j) {
        Iterator it = this.childrenViews.iterator();
        while (it.hasNext()) {
            if (((int) j) == ((View) it.next()).getId()) {
                return true;
            }
        }
        return false;
    }

    public void addFragment(View view, int i) {
        this.childrenViews.add(i, view);
        notifyItemInserted(i);
    }

    public void removeFragment(View view) {
        removeFragmentAt(this.childrenViews.indexOf(view));
    }

    public void removeFragmentAt(int i) {
        this.childrenViews.remove(i);
        notifyItemRemoved(i);
    }

    public void removeAll() {
        this.childrenViews.clear();
        notifyDataSetChanged();
    }

    public View getChildViewAt(int i) {
        return (View) this.childrenViews.get(i);
    }
}
