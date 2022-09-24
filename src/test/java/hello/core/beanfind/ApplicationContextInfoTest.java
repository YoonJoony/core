package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();//Junit5 부터는 public 설정 안해줘도 됨
                                                                    //getBeanDefinitionNames : 스프링에 등록된 모든 빈 이름 조회
        for (String beanDefinitionName : beanDefinitionNames) { //beanDefinitionNames의 요소를 하나씩 꺼내 대입
            Object bean = ac.getBean(beanDefinitionName); //ac(스프링 컨테이너)의 빈을 꺼낸다. object는 bean의 타입을 모르기 때문에
            System.out.println("name = " + beanDefinitionName + " Object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //beanDefinitionNames의 요소를 하나씩 꺼내 대입
           BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
           //getBeanDefinition : 빈의 정보들
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
               //ROLE_APPLICATION : 스프링 내부에 등록한 빈이 아니라 내가 애플리케이션을 등록하기 위해 등록해준 빈
               Object bean = ac.getBean(beanDefinitionName);
               System.out.println("name = " + beanDefinitionName + " Object = " + bean);
           }
        }
    }
}