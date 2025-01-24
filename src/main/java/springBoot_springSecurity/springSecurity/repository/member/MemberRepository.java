package springBoot_springSecurity.springSecurity.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot_springSecurity.springSecurity.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
