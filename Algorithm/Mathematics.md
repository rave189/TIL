# 수학

- [페르마의 소정리](https://ko.wikipedia.org/wiki/%ED%8E%98%EB%A5%B4%EB%A7%88%EC%9D%98_%EC%86%8C%EC%A0%95%EB%A6%AC)

> p가 소수이고, a가 정수일 때 a<sup>p</sup> 와 a는 서로 합동이다.

C mod p = (A + B)  mod p 일 경우 C mod p = (A mod p + B mod p) mod p 가 성립한다.

A = Q<sub>1</sub> * p + A<sub>1</sub> 이라 하면 A<sub>1</sub> = A mod p 이다.

B = Q<sub>2</sub> * p + B<sub>1</sub> 이라 하면 B<sub>1</sub> = B mod p 이다.

A + B = (Q<sub>1</sub> + Q<sub>2</sub>) * p + A<sub>1</sub> + B<sub>1</sub> 이다. 여기에 mod p을 하게 된다면

(A + B) mod p = (A<sub>1</sub> + B<sub>1</sub>) mod p이 된다. (Q<sub>1</sub> + Q<sub>2</sub>)는 p으로 나눌 경우 나머지가 0이므로 사라진다.)

따라서 (A + B) mod p = (A mod p + B mod p) mod p 이 성립하게 된다.
