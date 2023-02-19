package hello.core.inflearn.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
