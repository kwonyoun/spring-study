package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //생성자를 통해 this.memberRepository에 어떤 구현체가 들어갈지 선택한다. 
    //MemoryMemberRepository에 대한 코드는 없다.
    //MemberRepositrory 인터페이스만 있다. 즉, 추상화에만 의존한다. 
    //생성자 주입
    private final MemberRepositrory memberRepositrory;
    public MemberServiceImpl(MemberRepositrory memberRepositrory) {
        this.memberRepositrory = memberRepositrory;
    }
    

    @Override
    public void join(Member member) {
        memberRepositrory.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepositrory.findById(memberId);
    }
    
}
