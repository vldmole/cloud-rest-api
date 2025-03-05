package learning.java.bankApp.restApi;

import jakarta.validation.Valid;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.facade.BankAppFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bankApp/user")
public class BankAppController {
    private final BankAppFacade bankAppFacade;

    @Autowired
    public BankAppController(BankAppFacade bankAppFacade) {
        this.bankAppFacade = bankAppFacade;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> users = bankAppFacade.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/id")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id)
    {
        try {
            UserDto userDto = bankAppFacade.findUser(id);
            return ResponseEntity.ok(userDto);
        }
        catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto)
    {
        try{
            UserDto dto = bankAppFacade.createUser(userDto);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(dto.id())
                    .toUri();

            return ResponseEntity
                    .created(location)
                    .body(userDto);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try{
            bankAppFacade.deleteUser(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

