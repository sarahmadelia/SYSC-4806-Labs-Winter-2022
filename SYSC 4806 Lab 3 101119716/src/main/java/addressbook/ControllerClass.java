package addressbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/Greeting")
    public String addBuddy(@ModelAttribute BuddyInfo buddy, Model model) {
        AddressBook book = repository.findById(new Long(1)).orElse(new AddressBook(1L));

        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(book);

        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "addressbook";
//    public void addBuddy(@RequestBody BuddyInfo buddy) {
//        Long aBID = buddy.getId();
//        AddressBook book = AddressBookRepository.findAddressBookById(aBID);
//        BuddyInfoRepository.save(buddy);
//        book.addBuddy(buddy);
//        AddressBookRepository.save(book);

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
