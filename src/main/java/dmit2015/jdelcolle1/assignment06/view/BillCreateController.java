package dmit2015.jdelcolle1.assignment06.view;

import dmit2015.jdelcolle1.assignment06.entity.Bill;
import dmit2015.jdelcolle1.assignment06.repository.BillRepository;
import lombok.Getter;
import org.omnifaces.util.Messages;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("currentBillCreateController")
@RequestScoped
public class BillCreateController {

    @Inject
    private BillRepository _billRepository;

    @Getter
    private Bill newBill = new Bill();

    public String onCreateNew() {
        String nextPage = "";
        try {
            _billRepository.create(newBill);
            Messages.addFlashGlobalInfo("Create was successful.");
            nextPage = "index?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addGlobalError("Create was not successful. {0}", e.getMessage());
        }
        return nextPage;
    }

}