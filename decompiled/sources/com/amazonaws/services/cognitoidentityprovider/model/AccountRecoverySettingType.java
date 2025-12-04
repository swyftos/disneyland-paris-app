package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class AccountRecoverySettingType implements Serializable {
    private List recoveryMechanisms;

    public List<RecoveryOptionType> getRecoveryMechanisms() {
        return this.recoveryMechanisms;
    }

    public void setRecoveryMechanisms(Collection<RecoveryOptionType> collection) {
        if (collection == null) {
            this.recoveryMechanisms = null;
        } else {
            this.recoveryMechanisms = new ArrayList(collection);
        }
    }

    public AccountRecoverySettingType withRecoveryMechanisms(RecoveryOptionType... recoveryOptionTypeArr) {
        if (getRecoveryMechanisms() == null) {
            this.recoveryMechanisms = new ArrayList(recoveryOptionTypeArr.length);
        }
        for (RecoveryOptionType recoveryOptionType : recoveryOptionTypeArr) {
            this.recoveryMechanisms.add(recoveryOptionType);
        }
        return this;
    }

    public AccountRecoverySettingType withRecoveryMechanisms(Collection<RecoveryOptionType> collection) {
        setRecoveryMechanisms(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRecoveryMechanisms() != null) {
            sb.append("RecoveryMechanisms: " + getRecoveryMechanisms());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getRecoveryMechanisms() == null ? 0 : getRecoveryMechanisms().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountRecoverySettingType)) {
            return false;
        }
        AccountRecoverySettingType accountRecoverySettingType = (AccountRecoverySettingType) obj;
        if ((accountRecoverySettingType.getRecoveryMechanisms() == null) ^ (getRecoveryMechanisms() == null)) {
            return false;
        }
        return accountRecoverySettingType.getRecoveryMechanisms() == null || accountRecoverySettingType.getRecoveryMechanisms().equals(getRecoveryMechanisms());
    }
}
