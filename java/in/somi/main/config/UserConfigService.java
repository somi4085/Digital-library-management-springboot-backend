package in.somi.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.somi.main.entity.User;

@Service
public class UserConfigService {

    @Autowired
   private UserConfigRepository userConfigRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userConfigRepository.save(user);
    }
}
