package tech.interview.one.tech_interview_one.wallet;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private WalletRepository repository;

    public WalletService(WalletRepository repository){
        this.repository = repository;
    }

    public Optional<Wallet> findByUserId(Long id){
        return this.repository.findByUserId(id);
    }
}
