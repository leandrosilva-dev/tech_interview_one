package tech.interview.one.tech_interview_one.user;

public enum EnumUserType {
    USER(1),
    RETAILER(2);

    private int userType;

    EnumUserType(int userType){
        this.userType = userType;
    }

    public int getValue(){
        return this.userType;
    }
}
