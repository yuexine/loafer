### This project build with Spring-Boot and Angular 4

#### RUN
```
$ mvn clean install
$ cd backend
$ mvn spring-boot:run

```

#### Reference
1. Project Build: https://blog.jdriven.com/2016/12/angular2-spring-boot-getting-started/

2. Router event: http://liuwenzhuang.github.io/2016/03/angular2-dynamic-page-title

#### Issue

#### Doc
1. RxJS http://reactivex.io/rxjs/manual/overview.html

#### Stack

- `Spring-Boot`
- `Spring-Security`
- `Angular4`

#### Docker
1. log: `docker logs -f container-name` or `docker logs -n 10 container-name`
2. push image to aliyun container center after maven package :`mvn clean package -DpushImage`
3. docker exec -i -t  loafer-mail /bin/sh
4. start-order: https://docs.docker.com/compose/startup-order/

