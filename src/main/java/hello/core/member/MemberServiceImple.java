package hello.core.member;

public class MemberServiceImple implements MemberService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();//다형성에 의해 구현체의 메소드 호출

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
