package tech.interview.one.tech_interview_one.transfer;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("TRANSFER")
public record Transfer(
    @Id Long id,
    Long payer,
    Long payee,
    @Column("AMOUNT") BigDecimal value
) {
    public Transfer{
        value = value.setScale(2);
    }

    public String toString(){
        return "ID " + this.id + ", payer: " + this.payer + " , payee: " + this.payee + " and value " + this.value;
    }
}
