package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //생성자를 통해 this.memberRepository에 어떤 구현체가 들어갈지 선택한다. 
    //MemoryMemberRepository에 대한 코드는 없다.
    //MemberRepositrory 인터페이스만 있다. 즉, 추상화에만 의존한다. 
    //생성자 주입
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
