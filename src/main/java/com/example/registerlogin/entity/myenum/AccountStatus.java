package com.example.registerlogin.entity.myenum;

import com.example.registerlogin.entity.Account;

public enum AccountStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINE(-2);
    private int value;
    AccountStatus(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountStatus of(int value){
        for (AccountStatus status :
                AccountStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return AccountStatus.UNDEFINE;
    }
}
