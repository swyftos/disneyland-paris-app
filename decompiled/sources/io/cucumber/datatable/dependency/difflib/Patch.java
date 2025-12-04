package io.cucumber.datatable.dependency.difflib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes5.dex */
public class Patch<T> {
    private List deltas = new LinkedList();

    public List<T> applyTo(List<T> list) throws PatchFailedException {
        LinkedList linkedList = new LinkedList(list);
        ListIterator<Delta<T>> listIterator = getDeltas().listIterator(this.deltas.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().applyTo(linkedList);
        }
        return linkedList;
    }

    public List<T> restore(List<T> list) {
        LinkedList linkedList = new LinkedList(list);
        ListIterator<Delta<T>> listIterator = getDeltas().listIterator(this.deltas.size());
        while (listIterator.hasPrevious()) {
            listIterator.previous().restore(linkedList);
        }
        return linkedList;
    }

    public void addDelta(Delta<T> delta) {
        this.deltas.add(delta);
    }

    public List<Delta<T>> getDeltas() {
        Collections.sort(this.deltas, DeltaComparator.INSTANCE);
        return this.deltas;
    }
}
