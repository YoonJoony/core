package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //MemberService.class 타입의 "memberService" 이름의 메소드가 반환됨
//        System.out.println("1. memberService = " + memberService);
//        System.out.println("2. memberService.getClass() = " + memberService.getClass());
        //getClass() 객체가 속하는 클래스의 정보를 나타 -> MemberServiceImple()
        assertThat(memberService).isInstanceOf(MemberServiceImple.class);
//        isInstanceOf() : 객체가 지정된 유형(클래스 혹은 인터페이스)의 인스턴스인지 비교하기 위한 연산자. 유형 비교 연산자.
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);//타입으로만 비교할 수 있다.
        //단 같은 타입의 메소드가 2개 이상 있으면 안된다.
        //질문? 같은 타입의 메소드가 2개 이상 있으면 어칼건지
        assertThat(memberService).isInstanceOf(MemberServiceImple.class);
     }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImple.class);
        //구체적으로 반환되는 타입을 적어줘도 된다.
        //허나 위 경우는 구현에 의존하는 코드임으로 MemberService.class 타입으로 지정하는게 바람직
        assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test //항상 테스트는 실패 할 경우 테스트도 만들어 줘야 한다
    @DisplayName("빈 이름으로 조회")
    void findBeanNameX() {
//      MemberService memberService = ac.getBean("XXXXX", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("XXXXX", MemberService.class)); //앞 인자의 예외 타입과 뒤에서 발생된 예외 타입과 비교.
    }
}
