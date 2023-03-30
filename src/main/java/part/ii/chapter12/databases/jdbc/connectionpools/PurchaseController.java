package part.ii.chapter12.databases.jdbc.connectionpools;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @GetMapping("all")
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    @PostMapping("add")
    public void addPurchase(@RequestBody Purchase purchase) {
        purchaseRepository.addPurchase(purchase);
    }
}
