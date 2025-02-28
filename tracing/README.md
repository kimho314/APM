# Spring Boot3 + OpenTelemetry + Jaeger

## 실행 방법
1. docker-compose.yaml 실행한다.
```
$ docker compose up -d
```

2. Spring Boot Application 실행
    - ControllerV1 : 한 개 API에 대해서만 tracing하는 목적으로 만든 컨트롤러입니다.
    - ControllerV2 : 두 개의 다른 서버에 API에 대해서 tracing하는 목적으로 만든 컨트롤러. jar 파일을 옵션을 통해 다른 포트로 구동하고 테스트 해야한다.
    - ControllerV3 : 두 개의 API가 있고, 한 개의 API에서 DB에 쿼리를 날리는 것을 tracing하기 위해 만든 컨트롤러입니다. -> 쿼리의 parameter를 확인할 수 없다.
