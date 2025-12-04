package io.cucumber.datatable.dependency.difflib.myers;

import io.cucumber.datatable.dependency.difflib.ChangeDelta;
import io.cucumber.datatable.dependency.difflib.Chunk;
import io.cucumber.datatable.dependency.difflib.DeleteDelta;
import io.cucumber.datatable.dependency.difflib.Delta;
import io.cucumber.datatable.dependency.difflib.DiffAlgorithm;
import io.cucumber.datatable.dependency.difflib.InsertDelta;
import io.cucumber.datatable.dependency.difflib.Patch;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class MyersDiff<T> implements DiffAlgorithm<T> {
    private final Equalizer DEFAULT_EQUALIZER;
    private final Equalizer equalizer;

    public MyersDiff() {
        Equalizer equalizer = new Equalizer() { // from class: io.cucumber.datatable.dependency.difflib.myers.MyersDiff.1
            @Override // io.cucumber.datatable.dependency.difflib.myers.Equalizer
            public boolean equals(Object obj, Object obj2) {
                return obj.equals(obj2);
            }
        };
        this.DEFAULT_EQUALIZER = equalizer;
        this.equalizer = equalizer;
    }

    public MyersDiff(Equalizer<T> equalizer) {
        this.DEFAULT_EQUALIZER = new Equalizer() { // from class: io.cucumber.datatable.dependency.difflib.myers.MyersDiff.1
            @Override // io.cucumber.datatable.dependency.difflib.myers.Equalizer
            public boolean equals(Object obj, Object obj2) {
                return obj.equals(obj2);
            }
        };
        if (equalizer == null) {
            throw new IllegalArgumentException("equalizer must not be null");
        }
        this.equalizer = equalizer;
    }

    @Override // io.cucumber.datatable.dependency.difflib.DiffAlgorithm
    public Patch<T> diff(T[] tArr, T[] tArr2) {
        return diff(Arrays.asList(tArr), Arrays.asList(tArr2));
    }

    @Override // io.cucumber.datatable.dependency.difflib.DiffAlgorithm
    public Patch<T> diff(List<T> list, List<T> list2) {
        if (list == null) {
            throw new IllegalArgumentException("original list must not be null");
        }
        if (list2 == null) {
            throw new IllegalArgumentException("revised list must not be null");
        }
        try {
            return buildRevision(buildPath(list, list2), list, list2);
        } catch (DifferentiationFailedException e) {
            e.printStackTrace();
            return new Patch<>();
        }
    }

    public PathNode buildPath(List<T> list, List<T> list2) throws DifferentiationFailedException {
        PathNode pathNode;
        int i;
        List<T> list3 = list;
        if (list3 == null) {
            throw new IllegalArgumentException("original sequence is null");
        }
        if (list2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        }
        int size = list.size();
        int size2 = list2.size();
        int i2 = size + size2 + 1;
        int i3 = (i2 * 2) + 1;
        int i4 = i3 / 2;
        PathNode[] pathNodeArr = new PathNode[i3];
        int i5 = 0;
        PathNode pathNode2 = null;
        pathNodeArr[i4 + 1] = new Snake(0, -1, null);
        while (i5 < i2) {
            int i6 = -i5;
            int i7 = i6;
            while (i7 <= i5) {
                int i8 = i4 + i7;
                int i9 = i8 + 1;
                int i10 = i8 - 1;
                if (i7 == i6 || (i7 != i5 && pathNodeArr[i10].i < pathNodeArr[i9].i)) {
                    pathNode = pathNodeArr[i9];
                    i = pathNode.i;
                } else {
                    pathNode = pathNodeArr[i10];
                    i = pathNode.i + 1;
                }
                pathNodeArr[i10] = pathNode2;
                int i11 = i - i7;
                PathNode diffNode = new DiffNode(i, i11, pathNode);
                while (i < size && i11 < size2) {
                    if (!equals(list3.get(i), list2.get(i11))) {
                        break;
                    }
                    i++;
                    i11++;
                    list3 = list;
                }
                if (i > diffNode.i) {
                    diffNode = new Snake(i, i11, diffNode);
                }
                pathNodeArr[i8] = diffNode;
                if (i >= size && i11 >= size2) {
                    return diffNode;
                }
                i7 += 2;
                list3 = list;
                pathNode2 = null;
            }
            pathNodeArr[(i4 + i5) - 1] = null;
            i5++;
            list3 = list;
            pathNode2 = null;
        }
        throw new DifferentiationFailedException("could not find a diff path");
    }

    private boolean equals(Object obj, Object obj2) {
        return this.equalizer.equals(obj, obj2);
    }

    public Patch<T> buildRevision(PathNode pathNode, List<T> list, List<T> list2) {
        Delta<T> changeDelta;
        if (pathNode == null) {
            throw new IllegalArgumentException("path is null");
        }
        if (list == null) {
            throw new IllegalArgumentException("original sequence is null");
        }
        if (list2 == null) {
            throw new IllegalArgumentException("revised sequence is null");
        }
        Patch<T> patch = new Patch<>();
        if (pathNode.isSnake()) {
            pathNode = pathNode.prev;
        }
        while (pathNode != null) {
            PathNode pathNode2 = pathNode.prev;
            if (pathNode2 == null || pathNode2.j < 0) {
                break;
            }
            if (pathNode.isSnake()) {
                throw new IllegalStateException("bad diffpath: found snake when looking for diff");
            }
            int i = pathNode.i;
            int i2 = pathNode.j;
            pathNode = pathNode.prev;
            int i3 = pathNode.i;
            int i4 = pathNode.j;
            Chunk chunk = new Chunk(i3, copyOfRange(list, i3, i));
            Chunk chunk2 = new Chunk(i4, copyOfRange(list2, i4, i2));
            if (chunk.size() == 0 && chunk2.size() != 0) {
                changeDelta = new InsertDelta<>(chunk, chunk2);
            } else if (chunk.size() > 0 && chunk2.size() == 0) {
                changeDelta = new DeleteDelta<>(chunk, chunk2);
            } else {
                changeDelta = new ChangeDelta<>(chunk, chunk2);
            }
            patch.addDelta(changeDelta);
            if (pathNode.isSnake()) {
                pathNode = pathNode.prev;
            }
        }
        return patch;
    }

    private List copyOfRange(List list, int i, int i2) {
        return new ArrayList(list.subList(i, i2));
    }

    public static <T> T[] copyOfRange2(T[] tArr, int i, int i2) {
        return (T[]) copyOfRange2(tArr, i, i2, tArr.getClass());
    }

    public static <T, U> T[] copyOfRange2(U[] uArr, int i, int i2, Class<? extends T[]> cls) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        T[] tArr = cls == Object[].class ? (T[]) new Object[i3] : (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i3));
        System.arraycopy(uArr, i, tArr, 0, Math.min(uArr.length - i, i3));
        return tArr;
    }
}
