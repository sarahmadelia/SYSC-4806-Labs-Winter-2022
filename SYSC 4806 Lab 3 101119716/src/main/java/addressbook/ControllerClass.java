package addressbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class, initalised with Spring tutorial
 * Didn't have time to finish but will before Lab 5
 *
 */
@Controller
public class ControllerClass {


    @Autowired
    AddressBookRepository repository;

    @GetMapping("/greeting")
    public String index(Model model) {

        AddressBook book = new AddressBook();

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/greeting")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book = repository.findById(new Long(1)).orElse(new AddressBook(1L));

        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";

    }
    @GetMapping("/a/{ID}")
    public String addBuddy(Model model, @PathVariable Long ID){
        AddressBook book = repository.findById(ID).orElse(null);
        if(book == null){
            book = new AddressBook(ID);
            repository.save(book);
        }
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/a/{ID}")
    public String addBuddyToAddressBook(@ModelAttribute BuddyInfo buddy, Model model, @PathVariable Long ID){
        AddressBook book = repository.findById(ID).orElse(null);
        if(book == null){
            book = new AddressBook(ID);
            repository.save(book);
        }
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
    }

}
