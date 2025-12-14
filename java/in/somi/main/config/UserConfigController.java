package in.somi.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import in.somi.main.entity.User;

@Controller
public class UserConfigController {

	    @Autowired
	    private UserConfigService userService;

	    @PostMapping("/register")
	    public String registerUser(User user) {
	        userService.register(user);
	        return "redirect:/login";
	    }
	}

