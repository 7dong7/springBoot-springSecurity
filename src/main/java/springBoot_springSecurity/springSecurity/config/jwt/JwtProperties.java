package springBoot_springSecurity.springSecurity.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("jwt") // 자바 클래스에서 프로퍼티값을 가져와서 사용하는 어노테이션
public class JwtProperties {

    private String issue;
    private String secretKey;
}
