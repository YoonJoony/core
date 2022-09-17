package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//  1      AppConfig appConfig = new AppConfig();
//  1      MemberService memberService = appConfig.memberService();
// 스프링으로 전환하기 위해 주석 처리

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext : 스프링 빈을 관리해 준다.
        //AnnotationConfigApplicationContext : 어노테이션 기반 객체를 관리
        // -> AppCpnfig 환경 설정 정보를 가지고 컨테이너에 스프링빈으로 등록된 객체들을 관리해 준다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP); //Long 타입으로 L을 붙혀준다.
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member : " + member.getName());
        System.out.println("find member : " + findMember.getName());
    }
}
