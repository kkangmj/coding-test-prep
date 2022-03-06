### println 대신 BufferedWriter를 사용하자!
```
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
 
public class BufferedWriterTest {
    // BufferedWriter 역시 BufferedReader와 마찬가지로 IOException 처리를 별도로 해줘야 함.
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        // BufferedWriter 객체를 이용하여 출력합니다.
        bw.write("Hello World!");
 
        // write한다고 해서 바로바로 출력되지 않습니다.
        // 직접 출력 stream에 반영되는 것이 아니라 성능을 위해 buffer에 저장해두었다가
        // BufferedWriter가 flush되거나 close되었을 때 한번에 출력 stream에 반영하기 때문입니다.
        bw.flush();
 
        // close는 stream을 닫아버리기 때문에 계속 출력하고자 한다면 flush 사용합니다.
        // bw.close();
 
        // 출력내용에 줄바꿈이 필요하다면 newLine 함수를 사용합니다.
        bw.newLine();
        // 혹은 \n을 출력값의 앞이나 뒤에 넣어줍니다.
        bw.write("new line\n");
        bw.write("new line2");
        bw.close();
    }
} 

```

- https://code0xff.tistory.com/10

<br>

### 단일 쓰레드 환경이라면 StringBuffer 대신 StringBuilder를 사용하자!
```
val sb = StringBuilder("Kelly")
sb.append("Grace")

println(sb)   // Kelly Grace
```
- https://kotlinworld.com/36

<br>

### ToDos
- [ ] 10951번, 10952 with 함수 이용한 방식 적용해보기 (코틀린 인 액션 with 함수 파트 읽은 후에)


<br>

### ETC
- 10953번 문제에서 내 코드가 Kotlin 기준으로 1등을 차지했다...! 놀라워라...
    <img src="https://user-images.githubusercontent.com/52561963/156763917-6f6c60c6-1169-4665-a3d3-2c965140e973.png"/>
- 1924번 문제도 2등을...?! 다만 수요일 WED를 WEN으로, 목요일 THU를 THR라고 작성했다 두 번 틀렸음...
    <img src="https://user-images.githubusercontent.com/52561963/156909796-8f553a16-7c44-4c59-bd24-d6ab569f8d3f.png"/>