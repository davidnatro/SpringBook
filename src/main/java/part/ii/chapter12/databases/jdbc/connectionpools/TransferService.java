package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {
    private final AccountRepositorySpringData accountRepository;

    public TransferService(AccountRepositorySpringData accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {
        Account sender = accountRepository.findById(senderId)
                                          .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountRepository.findById(receiverId)
                                            .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(senderId, senderNewAmount);
        accountRepository.changeAmount(receiverId, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
