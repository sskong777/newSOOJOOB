package freesia.soojoob.user.service;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.dto.UserInfo;

public interface UserService {
    void addUser(SignUpDto signUpDto);

    UpdateUser editUser(UpdateUser updateUser);

    void deleteUser(Long id);

    UserInfo findUser(Long id);
}
