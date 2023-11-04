package hello.core.beenfind;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepositrory;
import hello.core.member.MemoryMemberRepositrory;

class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate(){
        //오류가 발생해야 성공하도록 설정하였다. 
        // MemberRepositrory bean = ac.getBean(MemberRepositrory.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
         () -> ac.getBean(MemberRepositrory.class));
    }
    
    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 저장하면 된다.")
    void findBeanByName(){
        MemberRepositrory memberRepositrory = ac.getBean("memberService1", MemberRepositrory.class);
        Assertions.assertThat(memberRepositrory).isInstanceOf(MemberRepositrory.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepositrory> beansOfType = ac.getBeansOfType(MemberRepositrory.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key: "+key+"/ value: "+beansOfType.get(key));
        }
        System.out.println("beansOfType: "+beansOfType);
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);       
    } 

    @Configuration
    static class SameBeanConfig {
        
        @Bean
        public MemberRepositrory memberService1(){
            return new MemoryMemberRepositrory();
        }

        @Bean
        public MemberRepositrory memberService2(){
            return new MemoryMemberRepositrory();
        }
    }

}
