### 후보키
- 처음 구현 시 isUnique 부분에서 특정 인덱스의 relation row 값을 저장할 때 set을 사용함. 
- 그러나, 9번과 11번 테스트 케이스 통과가 되지 않음. 
- 반례 발견!
    ```
    // 결과값이 1이어야 하는데 0으로 나옴.
   [["aa", "a"], ["a", "aa"], ["a", "a"]]
   ```
- 특정 인덱스의 relation row 값들은 순서가 있는 상태에서 비교해야 함. 따라서, list로 다시 구현함.
- 통과!