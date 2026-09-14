package javax.xml.bind.annotation.adapters;

/* JADX INFO: loaded from: classes5.dex */
public abstract class XmlAdapter<ValueType, BoundType> {
    public abstract ValueType marshal(BoundType boundtype) throws Exception;

    public abstract BoundType unmarshal(ValueType valuetype) throws Exception;

    protected XmlAdapter() {
    }
}
