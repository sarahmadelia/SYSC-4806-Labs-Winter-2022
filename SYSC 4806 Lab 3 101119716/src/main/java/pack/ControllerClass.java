package pack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class, initalized with Spring tutorial
 */
@Controller
public class ControllerClass {


    @Autowired
    AddressBookRepository repository;

    @GetMapping("/Greeting")
    public String index(Model model) {

        AddressBook book = new AddressBook();

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book = repository.findById(buddy.getId()).orElse(new AddressBook());
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

}
