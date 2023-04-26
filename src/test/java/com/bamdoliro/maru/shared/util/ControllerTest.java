package com.bamdoliro.maru.shared.util;

import com.bamdoliro.maru.application.auth.LogInUseCase;
import com.bamdoliro.maru.application.auth.RefreshTokenUseCase;
import com.bamdoliro.maru.application.user.SignUpUserUseCase;
import com.bamdoliro.maru.domain.auth.service.TokenService;
import com.bamdoliro.maru.presentation.auth.AuthController;
import com.bamdoliro.maru.shared.config.properties.JwtProperties;
import com.bamdoliro.maru.shared.security.SecurityConfig;
import com.bamdoliro.maru.presentation.user.UserController;
import com.bamdoliro.maru.shared.response.SharedController;
import com.bamdoliro.maru.shared.security.auth.AuthDetailsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@Disabled
@Import(SecurityConfig.class)
@WebMvcTest({
        UserController.class,
        AuthController.class,
        SharedController.class
})
public abstract class ControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;


    @MockBean
    protected SignUpUserUseCase signUpUserUseCase;

    @MockBean
    protected LogInUseCase logInUseCase;

    @MockBean
    protected RefreshTokenUseCase refreshTokenUseCase;


    @MockBean
    protected TokenService tokenService;

    @MockBean
    protected AuthDetailsService authDetailsService;


    @MockBean
    protected JwtProperties jwtProperties;


    protected String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}