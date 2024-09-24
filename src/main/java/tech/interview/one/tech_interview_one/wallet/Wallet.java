package tech.interview.one.tech_interview_one.wallet;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("WALLET")
public record Wallet(
    @Id Long id,
    Long userId,
    BigDecimal balance
) {
    
}