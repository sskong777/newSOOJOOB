package freesia.soojoob.user.service;

import freesia.soojoob.global.login.UserDetailsImpl;
import freesia.soojoob.record.entity.Record;
import freesia.soojoob.record.repository.RecordRepository;
import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.dto.UserDetailInfo;
import freesia.soojoob.user.dto.UserInfo;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.AlreadyExistEmailException;
import freesia.soojoob.user.exception.AlreadyExistUsernameException;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RecordRepository recordRepository;

    @Override
    @Transactional
    public void addUser(SignUpDto signUpDto) {
        checkDuplicateEmail(signUpDto.getEmail());
        checkDuplicateUsername(signUpDto.getUsername());
        User user = signUpDto.toEntity();
        user.setPassword(passwordEncoding(user.getPassword()));
        userRepository.save(user);

        Record userRecord = new Record(user);
        recordRepository.save(userRecord);
    }

    private String passwordEncoding(String password) {
        return passwordEncoder.encode(password);
    }


    private void checkDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistEmailException();
        }
    }

    private void checkDuplicateUsername(String username) {
        if (userRepository.existsByUsername(username)) {
            throw new AlreadyExistUsernameException();
        }
    }

    @Override
    @Transactional
    public UpdateUser editUser(UpdateUser info, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        user.update(info);
        userRepository.save(user);
        return user.toUpdateDto();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserInfo findUser(Long id) {
        User user = userRepository.findById(id).orElseThrow( ()-> {
            throw new NoExistUserException();
        });
        return user.toInfoDto();
    }

    @Override
    public UserDetailInfo findUserDetail(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return UserDetailInfo.createUserDetailInfo(user);
    }
}
