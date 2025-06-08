package com.ui.pojos;

public class AddressPOJO {

    private String company;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postCode;
    private String homePhone;
    private String mobilePhone;
    private String otherInformation;
    private String addressAlias;
    private String state;

    public String getCompany() {
        return company;
    }

    public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String postCode, String homePhone, String mobilePhone, String otherInformation, String addressAlias, String state) {
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postCode = postCode;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.otherInformation = otherInformation;
        this.addressAlias = addressAlias;
        this.state = state;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getOtherInformation() {
        return otherInformation;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "AddressPOJO{" +
                "company='" + company + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", otherInformation='" + otherInformation + '\'' +
                ", addressAlias='" + addressAlias + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
