package com.example.demo.member;

public class MemberServiceImpl implements MemberService{
	
	private final MemberRepository memberRepository; // = new MemoryMemberRepository();  // 구현체를 꼇다 뺏다 // dip 위반
	// MemoryMemberRepository 의존하지 않고 단지 MemberRepository 인터페이스만 의존한다.
	// 다형성에 의해서 뭔가가 구현될건대 오직 인터페이스만 바라보고 외부에서 구현 객체가 주입되도록 
	
	public MemberServiceImpl(MemberRepository memberRepository) {  // 인터페이스 추상화에만 의존 
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);  // 메모리에서 가져오든, db에서 가져오든 신경안쓰고 인터페이스에 맞추어서 호출만! 즉, 개발 실행에만 집중한다. 
	}

}
