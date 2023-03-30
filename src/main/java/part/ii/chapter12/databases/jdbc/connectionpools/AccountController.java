package part.ii.chapter12.databases.jdbc.connectionpools;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("all")
    public Iterable<Account> getAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return transferService.getAllAccounts();
        }

        return transferService.findAccountsByName(name);
    }

    @PostMapping("transfer")
    public void transfer(@RequestBody TrasnferRequest trasnferRequest) {
        transferService.transferMoney(trasnferRequest.getSenderId(),
                                      trasnferRequest.getReceiverId(), trasnferRequest.getAmount());
    }
}
