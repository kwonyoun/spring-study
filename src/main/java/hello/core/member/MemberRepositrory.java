package hello.core.member;

public interface MemberRepositrory {
    void save(Member member);
    Member findById(Long MemberId);
}
