package freesia.soojoob.user.service;

import freesia.soojoob.user.dto.SignUpDto;

public interface UserService {
    void addUser(SignUpDto signUpDto);
}
