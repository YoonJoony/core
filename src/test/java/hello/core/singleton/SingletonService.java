package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //자기 내부 객체를 static으로 가져서 하나만 존재하게됨.

    public static SingletonService getInstance() { //자기 자신 인스턴스 객체를 하나 생성해서 여기에만 들어가있는거
        return instance;
    }

    private  SingletonService() { //private로 생성자 타입을 설정하여 다른 클래스에서 생성이 안되게 막음
        
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
