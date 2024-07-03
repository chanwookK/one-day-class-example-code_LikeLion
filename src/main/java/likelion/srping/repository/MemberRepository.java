package likelion.srping.repository;

import likelion.srping.data.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //save(E entity)
    //delete(E entity)
    //findById(ID id), findAll(), count(), existsById(ID id)
    //등의 기본 매소드 제공

    List<Member> findByName(String name);
}
