# SpringCloudConfigServerTest

## 해당 서버는 GitHub CodingCheol 에 존재하는 `SpringCloudConfigProperties` _`private`_ `repository` 에 존재하는 properties(.properties, .yaml, .yml)를 대상으로 합니다.
## SSH 를 통한 통신을 진행하며 linux 계열 OS 에서 기본적으로 제공하는 `ssh-keygen`을 이용하여 생성하였습니다.
### 설명
### SSH 란?
~~~.bash
    - 서로 통신 할 때 보안적으로 안전하게 통신을 하기 위해 사용하는 프로토콜
    - 깃헙(github)을 push 명령어도 ssh를 이용한 파일 전송 방법이다. 
    - ssh 프로토콜의 키(공개키, 개인키 )를 통하여 서로를 검증
    - Private Key와 Public Key를 통해 다른 컴퓨터와 통신을 하기 위해서는 먼저 Public Key를 통신하고하는 컴퓨터에 복사하여 저장한다. 그리고 요청을 보내는 클라이언트 사이드 컴퓨터에서 접속 요청을 할 때 응답을 하는 서버 사이드 컴퓨터에 복사되어 저장된 Public Key와 클라이언트 사이드에 해당 Public Key와 쌍을 이루는 Private Key와 비교를 하여 서로 한 쌍의 Key인지 아닌지를 검사를 진행.   
~~~
### ssh-keygen
~~~.bash
    - 리눅스 계열 OS에서 제공되는 `ssh-keygen` 을 이용하여 공개키를 ssh 프로토콜의 키쌍(공개키, 개인키) 을 생성할 수 있다.
    - 사용시 옵션 정보는 아래와 같다.
        * 옵션
        1. -b : 키값의 비트를 지정한다.(rsa 타입은 최소 768 비트가 필요하고 default로 2048 비트로 설정)
        2. -t : RSA / DSA 등 공개키의 타입을 지정한다.
        3. -f : 저장할 키값의 파일명 ( 경로를 포함할 수 있지만 경로만은 안됨., 경로 미지정시에는 현재 위치에 생성. ) —> default (~/.ssh/id_{{type}} ,~/.ssh는 UNIX 계열에서 SSH 클라이언트가 서버로의 접속 시도하게 될 때 기본으로 사용하는 디렉토리다.)
        4. -C : 주석을 입력할 때 사용한다. 하지만! 서버에 따라 특별한 용도로 사용할 수 있다. —> github ssh 를 이용할 때 사용자의 로그인 ID를 적어두면 된다. 
        5. -m : 파일 형식(PEM ... )
        * e.g) ssh-keygen -b 2048 -t rsa -f /etc/ssh/ssh_host_rsa_key 

    - 생성 시 저장소여부, 비밀번호 여부 등을 묻고 생성하게 된다.
    - 비밀키 형식은 생성할때 지정된 키명이고, 공개키의 형식은 비밀키의 `_pub`이 붙은 형태 이다.
    - 성생 후 config 파일은 2개가 존재한다. 
        1. ssh_config : 클라이언트용
        2. sshd_config : 서버용

    ✼ 주의 사항 
     - SSH 설정 시 JGit 에러 발생
       - 해결방법 { FYI) 참조 URL  : https://github.com/spring-cloud/spring-cloud-config/issues/1392 } 
       * JGit requires RSA keys in PEM format. Below is an example ssh-keygen (from openssh) command that will generate a key in the corect format:
           * ssh-keygen -m PEM -t rsa -b 4096

~~~

