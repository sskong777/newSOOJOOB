package freesia.soojoob.global.login.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.token.key}")
    private String secretKey;

    // 토큰 유효시간
    private long tokenValidTime = 240 * 60 * 1000L;

    private final UserDetailsService userDetailsService;

    // 객체 초기화, secretKey를 Base64로 인코딩한다.
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT 토큰 생성
    public String createToken(String email) {
        Claims claims = Jwts.claims().setSubject(email); // JWT payload 에 저장되는 정보단위
//        claims.put("roles", roles); // 정보는 key / value 쌍으로 저장된다.
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .setClaims(claims) // 정보 저장
//                .claim("userIdx", userIdx)
                .claim("email", email)
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
                // FrontEnd와 일치하게 설정해주기. 아마 그래야 FrontEnd와 통신에 문제 없음 //
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과
                // signature 에 들어갈 secret값 세팅
                .compact();
    }

    // JWT 토큰에서 인증 정보 조회
    public Authentication getAuthentication(String token) {
        System.out.println("token = " + token);
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        // 추출하면 username, email등 유저의 정보가 나오게 됨.
    }

    // 토큰에서 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // Request의 Header에서 token 값을 가져옵니다. "Authorization" : "TOKEN값'
    public String resolveToken(HttpServletRequest request) {
        String token = null;
        Cookie cookie = WebUtils.getCookie(request, "X-AUTH-TOKEN");
        if(cookie != null) token = cookie.getValue();
        return request.getHeader("X-AUTH-TOKEN");
    }

    // 토큰의 유효성 + 만료일자 확인  // -> 토큰이 expire되지 않았는지 True/False로 반환해줌.
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);

            System.out.println("claims = " + claims);  // JWT 토큰(클라이언트에서 보낸)이 잘 들어오는지 검증하는 부분 -> 서버 콘솔에 token 찍힘.
            return !claims.getBody().getExpiration().before(new Date()); // expire시간이 되지 않았다면 True!
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Jwt Token을 복호화 하여 userPk를 얻는다.
     */
    public Long getUserIdFromJwt(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return (Long) claims.getBody().get("userPk");
    }


}