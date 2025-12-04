package io.cucumber.datatable.dependency.difflib;

import io.cucumber.datatable.dependency.difflib.Delta;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ChangeDelta<T> extends Delta<T> {
    public ChangeDelta(Chunk<T> chunk, Chunk<T> chunk2) {
        super(chunk, chunk2);
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void applyTo(List<T> list) throws PatchFailedException {
        verify(list);
        int position = getOriginal().getPosition();
        int size = getOriginal().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(position);
        }
        Iterator<T> it = getRevised().getLines().iterator();
        while (it.hasNext()) {
            list.add(position + i, it.next());
            i++;
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void restore(List<T> list) {
        int position = getRevised().getPosition();
        int size = getRevised().size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            list.remove(position);
        }
        Iterator<T> it = getOriginal().getLines().iterator();
        while (it.hasNext()) {
            list.add(position + i, it.next());
            i++;
        }
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public void verify(List<T> list) throws PatchFailedException {
        getOriginal().verify(list);
        if (getOriginal().getPosition() > list.size()) {
            throw new PatchFailedException("Incorrect patch for delta: delta original position > target size");
        }
    }

    public String toString() {
        return "[ChangeDelta, position: " + getOriginal().getPosition() + ", lines: " + getOriginal().getLines() + " to " + getRevised().getLines() + "]";
    }

    @Override // io.cucumber.datatable.dependency.difflib.Delta
    public Delta.TYPE getType() {
        return Delta.TYPE.CHANGE;
    }
}
