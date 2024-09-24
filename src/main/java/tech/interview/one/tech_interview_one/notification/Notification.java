package tech.interview.one.tech_interview_one.notification;

public record Notification(
    String status,
    Data data
) {
    public record Data(String message){}
}
