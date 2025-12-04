package io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator;
import java.util.UUID;

/* loaded from: classes5.dex */
public class ObjectIdGenerators {

    public static abstract class None extends ObjectIdGenerator<Object> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static abstract class Base extends ObjectIdGenerator {
        protected final Class<?> _scope;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public abstract Object generateId(Object obj);

        protected Base(Class cls) {
            this._scope = cls;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public Class<?> getScope() {
            return this._scope;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public boolean canUseFor(ObjectIdGenerator objectIdGenerator) {
            return objectIdGenerator.getClass() == getClass() && objectIdGenerator.getScope() == this._scope;
        }
    }

    public static abstract class PropertyGenerator extends Base {
        private static final long serialVersionUID = 1;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public /* bridge */ /* synthetic */ boolean canUseFor(ObjectIdGenerator objectIdGenerator) {
            return super.canUseFor(objectIdGenerator);
        }

        protected PropertyGenerator(Class<?> cls) {
            super(cls);
        }
    }

    public static final class IntSequenceGenerator extends Base {
        private static final long serialVersionUID = 1;
        protected transient int _nextValue;

        protected int initialValue() {
            return 1;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public /* bridge */ /* synthetic */ boolean canUseFor(ObjectIdGenerator objectIdGenerator) {
            return super.canUseFor(objectIdGenerator);
        }

        public IntSequenceGenerator() {
            this(Object.class, -1);
        }

        public IntSequenceGenerator(Class<?> cls, int i) {
            super(cls);
            this._nextValue = i;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<Integer> forScope(Class<?> cls) {
            return this._scope == cls ? this : new IntSequenceGenerator(cls, this._nextValue);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<Integer> newForSerialization(Object obj) {
            return new IntSequenceGenerator(this._scope, initialValue());
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator.IdKey key(Object obj) {
            if (obj == null) {
                return null;
            }
            return new ObjectIdGenerator.IdKey(IntSequenceGenerator.class, this._scope, obj);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public Integer generateId(Object obj) {
            if (obj == null) {
                return null;
            }
            int i = this._nextValue;
            this._nextValue = i + 1;
            return Integer.valueOf(i);
        }
    }

    public static final class UUIDGenerator extends Base {
        private static final long serialVersionUID = 1;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<UUID> forScope(Class<?> cls) {
            return this;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<UUID> newForSerialization(Object obj) {
            return this;
        }

        public UUIDGenerator() {
            this(Object.class);
        }

        private UUIDGenerator(Class cls) {
            super(Object.class);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public UUID generateId(Object obj) {
            return UUID.randomUUID();
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator.IdKey key(Object obj) {
            if (obj == null) {
                return null;
            }
            return new ObjectIdGenerator.IdKey(UUIDGenerator.class, null, obj);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator.getClass() == UUIDGenerator.class;
        }
    }

    public static final class StringIdGenerator extends Base {
        private static final long serialVersionUID = 1;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<String> forScope(Class<?> cls) {
            return this;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator<String> newForSerialization(Object obj) {
            return this;
        }

        public StringIdGenerator() {
            this(Object.class);
        }

        private StringIdGenerator(Class cls) {
            super(Object.class);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public String generateId(Object obj) {
            return UUID.randomUUID().toString();
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public ObjectIdGenerator.IdKey key(Object obj) {
            if (obj == null) {
                return null;
            }
            return new ObjectIdGenerator.IdKey(StringIdGenerator.class, null, obj);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.ObjectIdGenerator
        public boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator) {
            return objectIdGenerator instanceof StringIdGenerator;
        }
    }
}
