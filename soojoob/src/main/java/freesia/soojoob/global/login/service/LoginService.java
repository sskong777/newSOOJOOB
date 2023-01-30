package freesia.soojoob.global.login.service;


import freesia.soojoob.global.login.dto.LoginDto;
import freesia.soojoob.global.login.dto.LoginResponse;

import javax.servlet.http.HttpServletResponse;

public interface LoginService {
    LoginResponse login(LoginDto dto);
}
