# boolean 배열_Set의 성능 비교
## 개요
    해당 프로그램은 로또 코드를 작성할 때 Set을 이용한 경우와
    boolean 배열을 활용해 코드를 작성했을 때 어떤 게 더 효율적인지를 
    확인하기 위해 작성했으며, 
    이를 위해 javax swing awt 라이브러리를 학습해 적용해 보았습니다.
    멀티스레드 개념을 넣어 다중처리를 시도해 보았지만 원활하지 않았던 문제가 있으며
    int로만 받으면 값이 너무 적어 long으로 처리했으며
    양수 숫자만 받을 수 있습니다.
    awt를 이용한 event로 실행 버튼을 Enter를 이용해서도 상호작용이 가능하게 했습니다.
    
    결과가 표시도 될 뿐만 아니라 파일 저장을 텍스트로 할 수 있으며 현재시간 기준으로 
    로또 성능 비교 결과_yyyyMMddHHmmss.txt 가 default 값으로 잡힙니다.
    해당 프로그램을 실행한 동안에는 저장하기 기록이 남기 때문에
    다시 프로그램을 실행했을 때, 이전에 저장한 경로를 이용해 다시 저장이 가능하게 만들었습니다.

    boolean 배열과 set을 이용해 실질적으로 번호를 받을 수 있는 StringBuilder 코드도 남아 있기 때문에
    만약 필요하다면 활용할 수 있을 것입니다. 
    
    다만, 이는 개방 폐쇄 원칙을 지키지 않은 것이며, 해당 코드는 SRP 등 
    SOLID 원칙이 모두 적용된 코드가 아닌 정말 TOY 프로젝트 형태의 파일입니다.
    
    또한 결과를 놓고 말씀드리면, 100 이하의 적은 경우라면 차이가 미미하지만 
    50000 이상의 수에서는 boolean의 고정형 방식이 동적인 Set보다 압도적으로 빠릅니다.

![10,000,000개_테스트 이미지](https://github.com/wsh096/TOY-Java-BenchMark/blob/main/boolean%EB%B0%B0%EC%97%B4_Set%EB%B2%A4%EC%B9%98%EB%A7%88%ED%81%AC/image/10%2C000%2C000%EA%B2%B0%EA%B3%BC_txt_image.png)

![10억건_테스트 이미지](https://github.com/wsh096/TOY-Java-BenchMark/blob/main/boolean%EB%B0%B0%EC%97%B4_Set%EB%B2%A4%EC%B9%98%EB%A7%88%ED%81%AC/image/10%2C000%2C000%EA%B2%B0%EA%B3%BC_txt_image.png)