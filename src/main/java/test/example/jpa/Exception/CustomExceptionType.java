package test.example.jpa.Exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CustomExceptionType {

    CUSTOMER_NOT_FOUND("C01", HttpStatus.NOT_FOUND, "고객을 찾지 못했습니다.", Level.WARN),

    INTERNAL_SERVER_ERROR("Z99", HttpStatus.INTERNAL_SERVER_ERROR, "예상되지 못한 에러 입니다.", Level.ERROR);

    /**
     * - {@code innerCode} : 내부용 에러코드 ("Z99") <br>
     * - {@code status} : 외부용 http status code (HttpStatus.INTERNAL_SERVER_ERROR) <br>
     * - {@code message} : 내부 + 외부용 에러 메세지 ("내부 서버 에러 : ") <br>
     * - {@code level} : 내부용 에러 레벨 (Level.ERROR) <br>
     */

    String innerCode;
    HttpStatus status;
    String message;
    Level level;
}
