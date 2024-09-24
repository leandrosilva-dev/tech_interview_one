package tech.interview.one.tech_interview_one.authorizer;

public record Authorizer(
    String status,
    Data data
) {
    public record Data(boolean authorization) {}   
}
