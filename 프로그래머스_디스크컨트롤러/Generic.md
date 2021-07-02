## Generic(제네릭)

  
    public class GenericArrayList<T> {

      private Object[] elementData = new Object[5];
      private int size;

      public void add(T value) {
          elementData[size++] = value;
      }

      public T get(int idx) {
          return (T) elementData[idx];
      }
    }
    
 - <T>로 표현하는 것이 제네릭, GenericArrayList는 객체를 생성할때 타입을 지정하면, 생성되는 오브젝트 안에서는 T의 위치에 지정한 타입이 대체되어서 들어가는 것 처럼 컴파일러가 인식한다.
  
### 한정적 타입 매개변수 (Bound Type Parameter)

- 제네릭으로 사용될 타입 파라미터의 범위를 제한할 수 있는 방법


  
      public class GenericArrayList<T extends Number>

  
  
### 제네릭을 사용할 수 없는 경우

- 타입 T가 무엇인지 알수 없기 때문에 new T[number] 와 같이 제네릭으로 배열을 생성불가
- static 변수에도 제네릭 사용 불가, static 변수는 인스턴스에 종속되지 않는 클래스 변수로써 모든 인스턴스가 공통된 저장공간을공유하게 되는 병수


### 제네릭 메서드

- 제네릭 메서드를 정의할대 리턴타입이 무엇인지와 상관없이 내가 제네릭 메서드라는 것을 컴파일러에게 알려줘야함
- 그러기 위해서는 리턴타입을 정의하기 전에 제네릭 타입에 대한 정의를 반드시 적어야한다.
- 제네릭 클래스가 아닌 일반 클래스 내부에도 제네릭 메서드를 정의할수 있다.

    
      public static <T extends CharSequence> void printFirstChar(T param) {
          System.out.println(param.charAt(0));
      }
