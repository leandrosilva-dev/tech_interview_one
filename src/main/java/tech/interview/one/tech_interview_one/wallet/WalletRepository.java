package tech.interview.one.tech_interview_one.wallet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface WalletRepository extends CrudRepository<Wallet, Long> {
    Optional<Wallet> findByUserId(Long userId);
}
