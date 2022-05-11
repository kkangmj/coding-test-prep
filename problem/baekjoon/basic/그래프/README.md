### DFS, BFS 알고리즘의 기본
- 1260번 문제 확인

<br>

### ETC
- 코틀린 기준 11724번 문제 4등~~!

    <img src="https://user-images.githubusercontent.com/52561963/159118488-4353dfef-a613-4d5c-96f0-16341ad1bc3c.png" width="400" />
  
- 코틀린 기준 1707번 문제 6등!

  <img src = "https://user-images.githubusercontent.com/52561963/162409868-54a46f2f-3ea3-453c-bef1-fad308c097bd.png" width="400" >  
  <img src="https://user-images.githubusercontent.com/52561963/162409966-9e51131b-ed74-451e-8c89-6036d76acd94.png" width="400" >
  
  - 정말 오랜 시간이 걸렸다. 약 13번의 도전 후 성공... 
  - 처음에는 입력받은 vertex + 1 크기의 2차원 배열에 인접 vertex를 표현하였으나 메모리 초과. 실제로 이렇게 하면 문제에서 제한된 메모리를 훨씬 초과했다.
  - 그래서 Array<Int>{ mutableListOf() }로 배열을 생성한 뒤, 인접한 vertex가 있는 경우에만 해당 인덱스에 맞춰 list에 넣어주는 방식으로 변경함.
  - 그러나 그 이후 계속 시간초과가 떴고, 그 원인은 너무 많은 반복문의 사용(특히 범위)가 컸음.
  - 그리고 성공! 어제부터 시도해본 문제인데 풀어서 행복하고, 상위권이라 기분이 좋다.
  - dfs가 좀 더 편해서 dfs로 풀었는데 나중에 bfs로 풀어보는 것도 좋을 것 같다.  

- 10451번 문제 1등!

  <img src="https://user-images.githubusercontent.com/52561963/167764591-1335e5d7-7841-4329-be13-6f7d8b602a42.png" width="400">

- 2331번 문제도 1등~

  <img src="https://user-images.githubusercontent.com/52561963/167769095-724798e8-dece-472f-8e4c-5f4f239ea555.png" width="400">