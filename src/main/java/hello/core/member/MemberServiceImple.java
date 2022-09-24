package hello.core.member;

public class MemberServiceImple implements MemberService{
    private final MemberRepository memberRepository; //인터페이스 객체를 선언만 해줬다. (추상화에만 의존하므로 원칙 위배되지 않음)
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); //OCP, DIP 위반하므로 관심사를 분리
    public MemberServiceImple(MemberRepository memberRepository) {
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
}
