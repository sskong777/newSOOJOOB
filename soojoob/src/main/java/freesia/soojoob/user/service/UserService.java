package freesia.soojoob.user.service;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;

public interface UserService {
    void addUser(SignUpDto signUpDto);

    UpdateUser editUser(UpdateUser updateUser);

    void deleteUser(Long id);
}
