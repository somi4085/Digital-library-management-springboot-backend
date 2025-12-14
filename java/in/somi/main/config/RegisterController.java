package in.somi.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.somi.main.entity.User;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private UserConfigService userConfigService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userConfigService.register(user);
        return "User registered successfully";
    }
}
