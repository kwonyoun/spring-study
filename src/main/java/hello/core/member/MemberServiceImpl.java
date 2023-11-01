package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepositrory memberRepositrory = new MemoryMemberRepositrory();

    @Override
    public void join(Member member) {
        memberRepositrory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositrory.findById(memberId);
    }
    
}
