package freesia.soojoob.global.login.service;

import freesia.soojoob.global.login.UserDetailsImpl;
import freesia.soojoob.global.login.exception.NoExistEmail;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NoExistEmail());

        return new UserDetailsImpl(user);
    }
}
