package learning.java.bankApp.restApi;

import jakarta.validation.Valid;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.facade.BankAppFacade;
import learning.java.bankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankApp/user")
public class BankAppController {
    private final BankAppFacade bankAppFacade;

    @Autowired
    public BankAppController(BankAppFacade bankAppFacade) {
        this.bankAppFacade = bankAppFacade;
    }

    @GetMapping("/id")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {

        try {
            UserDto userDto = bankAppFacade.findUser(id);
            return ResponseEntity.ok(userDto);
        }
        catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

