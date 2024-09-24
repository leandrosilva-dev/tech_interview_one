package tech.interview.one.tech_interview_one.transfer;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TransferRepository extends ListCrudRepository<Transfer, Long>{
    
}
