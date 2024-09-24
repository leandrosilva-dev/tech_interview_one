package tech.interview.one.tech_interview_one.transfer;

public class InvalidTransferException extends RuntimeException{
    InvalidTransferException(String message){
        super(message);
    }
}
