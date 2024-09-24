package tech.interview.one.tech_interview_one.transfer;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.interview.one.tech_interview_one.authorizer.AuthorizerService;
import tech.interview.one.tech_interview_one.notification.NotificationService;
import tech.interview.one.tech_interview_one.user.EnumUserType;
import tech.interview.one.tech_interview_one.user.UserService;
import tech.interview.one.tech_interview_one.wallet.Wallet;
import tech.interview.one.tech_interview_one.wallet.WalletService;

@Service
public class TransferService {
    
    private TransferRepository transferRepository;
    private WalletService walletService;
    private UserService userService;
    private AuthorizerService authorizerService;
    private NotificationService notificationService;

    public TransferService(TransferRepository transferRepository, WalletService walletService, UserService userService, AuthorizerService authorizerService, NotificationService notificationService){
        this.transferRepository = transferRepository;
        this.walletService = walletService;
        this.userService = userService;
        this.authorizerService = authorizerService;
        this.notificationService = notificationService;
    }

    // A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia;
    @Transactional
    public void transfer(Transfer transfer){
        // Validar se o usuário tem saldo antes da transferência;
        Wallet walletPayer = this.walletService.findByUserId(transfer.payer()).orElseThrow(() -> new InvalidTransferException("Payer  was not found with ID " + transfer.payer()));
        if(walletPayer.balance().subtract(transfer.value()).compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidTransferException("User has not enough balance to do that transaction");
        }

        Wallet walletPayee = this.walletService.findByUserId(transfer.payee()).orElseThrow(() -> new InvalidTransferException("Payee not found with ID " + transfer.payee()));
        if(walletPayee.userId() == walletPayer.userId()){
            throw new InvalidTransferException("The payer and the payee must be different");
        }

        // Lojistas só recebem transferências, não enviam dinheiro para ninguém;
        this.userService.findById(transfer.payer())
        .map(user -> user.type() == EnumUserType.USER.getValue() ? user : null)
        .orElseThrow(() -> new InvalidTransferException("Retailer doesn't have permission to transfer values"));

        // Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock https://util.devi.tools/api/v2/authorize para simular o serviço utilizando o verbo GET
        this.authorizerService.authorize();

        Transfer t = this.transferRepository.save(transfer);

        // No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock https://util.devi.tools/api/v1/notify)) para simular o envio da notificação utilizando o verbo
        this.notificationService.sendMessage("Transfer done with success " + t.toString());
    }
}