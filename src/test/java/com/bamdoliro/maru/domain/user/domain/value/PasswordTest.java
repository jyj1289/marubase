package com.bamdoliro.maru.domain.user.domain.value;

import com.bamdoliro.maru.domain.user.domain.User;
import com.bamdoliro.maru.shared.UserFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void 패스워드를_비교할_때_일치하면_참을_반환한다() {
        // given
        User user = UserFixture.createUser();

        // when and then
        assertTrue(user.getPassword().match("해시값은항상다르다"));
    }

    @Test
    void 패스워드를_비교할_때_일치하지_않으면_거짓을_반환한다() {
        // given
        User user = UserFixture.createUser();

        // when and then
        assertFalse(user.getPassword().match("해시값은항상다르다_이건값도다르다"));
    }
}