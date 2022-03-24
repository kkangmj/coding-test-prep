# 동적 계획법(DP)
### DP의 사용 조건
   - Overlapping Subproblems(겹치는 부분 문제)
     - 동일한 작은 문제들이 반복해 나타남. 
   - Optimal Substructure(최적 부분 구조)
     - 부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과값을 낼 수 있음.
     - 특정 문제의 정답은 문제의 크기에 상관없이 항상 동일함.
     

### DP 사용하기
1. DP로 풀 수 있는 문제인지 확인
   - 해당 문제가 작은 문제들로 이루어진 하나의 함수로 표현될 수 있는지 판단
2. 문제의 변수 파악
3. 해당 변수로 이루어진 점화식 만들기
4. 메모하기
   - 변수값에 따른 결과를 저장할 배열을 만들고 결과가 도출될 때마다 배열 내 저장해 재사용
5. 기저 상태 파악하기
   - ex) 피보나치 수열에서 f(0) = 0, f(1) = 1
6. 구현하기
   - Bottom-Up 방식
     - 작은 문제부터 계산을 수행해 그 결과를 재사용하여 전체 큰 문제를 해결하는 방식
     - dp[0]이 기저 상태이고 dp[n]을 찾는 것이 목표일 때, dp[0]부터 시작하여 반복문을 통해 점화식으로 결과를 내 dp[n]까지 그 값을 전이시켜 재활용하는 방식
        ```
         public static int bottomUp(int n) {
            // 기저 상태
            bottomUp_memo[0] = 0; bottomUp_memo[1] = 1;
                   
            // 반복문
            for (int i = 2; i <= n; i++) {
                bottomUp_memo[i] = bottomUp_memo[i-1] + bottomUp_memo[i-2];
            }
                   
            return bottomUp_memo[n];
         }
       ``` 
   - Top-Down 방식
     - 기저 상태인 dp[0]에서 출발하는 대신 dp[n]의 값을 찾기 위해 위에서부터 호출을 시작해 dp[0]까지 내려간 다음 결과 값을 재귀를 통해 전이시켜 재활용하는 방식
         ```
       public static int topDown(int n) {
            // 기저 상태
            if (n < 2) return topDown_memo[n] = n;
                        
            // 메모에 계산된 값 있으면 재활용
            if (topDown_memo[n] > 0) return topDown_memo[n];
                   
            // 재귀
            topDown_memo[n] = topDown(n-1) + topDown(n-2);
                        
            return topDown_memo[n];
       } 
       ```
### 예제
1. 막대기 자르기
   - 점화식
     - Rn = max(Pi + Rn-1) (i는 1부터 n) : 길이가 n인 막대기의 최대 가격
   ```
   // Bottom-Up 방식
      
   // 막대기 길이(인덱스) 별 가격
   var p = [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30];
      
   function cutRod(p, n) {
     var r = [0];
     for (var j = 1; j <= n; j++) {
       q = -1;
       for (var i = 1; i <= j; i++) {
         q = Math.max(q, p[i] + r[j - i]);
       }
       r[j] = q;
     }
     return r[n];
   }
   ```
2. 최장 공통 부분 수열 문제
   - 두 문자열에서 순서대로 겹치는 문자의 최대 개수를 구하는 문제 
   - 점화식 
     - lcs(i, j) = lcs(i-1, j-1) + 1 : 문자열의 마지막 두 문자가 같은 경우
     - lcs(i, j) = max(lcs(i, j-1), lcs(i-1, j)) : 문자열의 마지막 두 문자가 다른 경우
     - lcs(i, j) : 두 문자열 i, j의 공통 부분 수열의 최장 길이
4. 0/1 배낭 문제
   - 점화식

### Links
- https://hongjw1938.tistory.com/47
- https://www.zerocho.com/category/Algorithm/post/584b979a580277001862f182


<br>

# What I've learned from DP problems
### 배열은 신중하게 사용하자
- 배열을 하나 더 사용하는 순간 실행 속도는 확연히 떨어진다. 
- 아래는 1463번 문제에서 배열을 두 개 사용했을 때와 하나 사용했을 때의 실행속도 
    <img src="https://user-images.githubusercontent.com/52561963/158157460-44df84ce-569b-4671-980e-b14cb2eda8ac.png" width="400" />

# ETC
- 11057번 문제 코틀린 기준 5등!
    <img src="https://user-images.githubusercontent.com/52561963/159643602-344beb98-7af8-4799-97e7-5fead2177eef.png" width="400" />