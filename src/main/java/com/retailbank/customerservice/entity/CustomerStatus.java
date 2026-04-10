package com.retailbank.customerservice.entity;

public enum CustomerStatus {

    INITIATED("Initiated"),
    DOC_UPLOADED("Document Uploaded"),
    UNDER_REVIEW("Under Review"),
    VERIFIED("Verified"),
    REJECTED("Rejected");

    public final String value;

    CustomerStatus(String value) {
        this.value = value;
    }

}
