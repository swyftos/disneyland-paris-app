package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SchemaAttributeType implements Serializable {
    private String attributeDataType;
    private Boolean developerOnlyAttribute;
    private Boolean mutable;
    private String name;
    private NumberAttributeConstraintsType numberAttributeConstraints;
    private Boolean required;
    private StringAttributeConstraintsType stringAttributeConstraints;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public SchemaAttributeType withName(String str) {
        this.name = str;
        return this;
    }

    public String getAttributeDataType() {
        return this.attributeDataType;
    }

    public void setAttributeDataType(String str) {
        this.attributeDataType = str;
    }

    public SchemaAttributeType withAttributeDataType(String str) {
        this.attributeDataType = str;
        return this;
    }

    public void setAttributeDataType(AttributeDataType attributeDataType) {
        this.attributeDataType = attributeDataType.toString();
    }

    public SchemaAttributeType withAttributeDataType(AttributeDataType attributeDataType) {
        this.attributeDataType = attributeDataType.toString();
        return this;
    }

    public Boolean isDeveloperOnlyAttribute() {
        return this.developerOnlyAttribute;
    }

    public Boolean getDeveloperOnlyAttribute() {
        return this.developerOnlyAttribute;
    }

    public void setDeveloperOnlyAttribute(Boolean bool) {
        this.developerOnlyAttribute = bool;
    }

    public SchemaAttributeType withDeveloperOnlyAttribute(Boolean bool) {
        this.developerOnlyAttribute = bool;
        return this;
    }

    public Boolean isMutable() {
        return this.mutable;
    }

    public Boolean getMutable() {
        return this.mutable;
    }

    public void setMutable(Boolean bool) {
        this.mutable = bool;
    }

    public SchemaAttributeType withMutable(Boolean bool) {
        this.mutable = bool;
        return this;
    }

    public Boolean isRequired() {
        return this.required;
    }

    public Boolean getRequired() {
        return this.required;
    }

    public void setRequired(Boolean bool) {
        this.required = bool;
    }

    public SchemaAttributeType withRequired(Boolean bool) {
        this.required = bool;
        return this;
    }

    public NumberAttributeConstraintsType getNumberAttributeConstraints() {
        return this.numberAttributeConstraints;
    }

    public void setNumberAttributeConstraints(NumberAttributeConstraintsType numberAttributeConstraintsType) {
        this.numberAttributeConstraints = numberAttributeConstraintsType;
    }

    public SchemaAttributeType withNumberAttributeConstraints(NumberAttributeConstraintsType numberAttributeConstraintsType) {
        this.numberAttributeConstraints = numberAttributeConstraintsType;
        return this;
    }

    public StringAttributeConstraintsType getStringAttributeConstraints() {
        return this.stringAttributeConstraints;
    }

    public void setStringAttributeConstraints(StringAttributeConstraintsType stringAttributeConstraintsType) {
        this.stringAttributeConstraints = stringAttributeConstraintsType;
    }

    public SchemaAttributeType withStringAttributeConstraints(StringAttributeConstraintsType stringAttributeConstraintsType) {
        this.stringAttributeConstraints = stringAttributeConstraintsType;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getAttributeDataType() != null) {
            sb.append("AttributeDataType: " + getAttributeDataType() + ",");
        }
        if (getDeveloperOnlyAttribute() != null) {
            sb.append("DeveloperOnlyAttribute: " + getDeveloperOnlyAttribute() + ",");
        }
        if (getMutable() != null) {
            sb.append("Mutable: " + getMutable() + ",");
        }
        if (getRequired() != null) {
            sb.append("Required: " + getRequired() + ",");
        }
        if (getNumberAttributeConstraints() != null) {
            sb.append("NumberAttributeConstraints: " + getNumberAttributeConstraints() + ",");
        }
        if (getStringAttributeConstraints() != null) {
            sb.append("StringAttributeConstraints: " + getStringAttributeConstraints());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((getName() == null ? 0 : getName().hashCode()) + 31) * 31) + (getAttributeDataType() == null ? 0 : getAttributeDataType().hashCode())) * 31) + (getDeveloperOnlyAttribute() == null ? 0 : getDeveloperOnlyAttribute().hashCode())) * 31) + (getMutable() == null ? 0 : getMutable().hashCode())) * 31) + (getRequired() == null ? 0 : getRequired().hashCode())) * 31) + (getNumberAttributeConstraints() == null ? 0 : getNumberAttributeConstraints().hashCode())) * 31) + (getStringAttributeConstraints() != null ? getStringAttributeConstraints().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SchemaAttributeType)) {
            return false;
        }
        SchemaAttributeType schemaAttributeType = (SchemaAttributeType) obj;
        if ((schemaAttributeType.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (schemaAttributeType.getName() != null && !schemaAttributeType.getName().equals(getName())) {
            return false;
        }
        if ((schemaAttributeType.getAttributeDataType() == null) ^ (getAttributeDataType() == null)) {
            return false;
        }
        if (schemaAttributeType.getAttributeDataType() != null && !schemaAttributeType.getAttributeDataType().equals(getAttributeDataType())) {
            return false;
        }
        if ((schemaAttributeType.getDeveloperOnlyAttribute() == null) ^ (getDeveloperOnlyAttribute() == null)) {
            return false;
        }
        if (schemaAttributeType.getDeveloperOnlyAttribute() != null && !schemaAttributeType.getDeveloperOnlyAttribute().equals(getDeveloperOnlyAttribute())) {
            return false;
        }
        if ((schemaAttributeType.getMutable() == null) ^ (getMutable() == null)) {
            return false;
        }
        if (schemaAttributeType.getMutable() != null && !schemaAttributeType.getMutable().equals(getMutable())) {
            return false;
        }
        if ((schemaAttributeType.getRequired() == null) ^ (getRequired() == null)) {
            return false;
        }
        if (schemaAttributeType.getRequired() != null && !schemaAttributeType.getRequired().equals(getRequired())) {
            return false;
        }
        if ((schemaAttributeType.getNumberAttributeConstraints() == null) ^ (getNumberAttributeConstraints() == null)) {
            return false;
        }
        if (schemaAttributeType.getNumberAttributeConstraints() != null && !schemaAttributeType.getNumberAttributeConstraints().equals(getNumberAttributeConstraints())) {
            return false;
        }
        if ((schemaAttributeType.getStringAttributeConstraints() == null) ^ (getStringAttributeConstraints() == null)) {
            return false;
        }
        return schemaAttributeType.getStringAttributeConstraints() == null || schemaAttributeType.getStringAttributeConstraints().equals(getStringAttributeConstraints());
    }
}
