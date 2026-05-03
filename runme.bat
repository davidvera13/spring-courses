@echo off

cd "./accounts"
call mvn clean
call docker build . -t localhost:8002/accounts:0.0.2-SNAPSHOT
cd ".."

cd "./cards"
call mvn clean
call docker build . -t localhost:8002/cards:0.0.2-SNAPSHOT
cd ".."

cd "./loans"
call mvn clean
call docker build . -t localhost:8002/loans:0.0.2-SNAPSHOT
cd ".."

@REM we psuh in local nexus ..
call docker push localhost:8002/accounts:0.0.2-SNAPSHOT
call docker push localhost:8002/cards:0.0.2-SNAPSHOT
call docker push localhost:8002/loans:0.0.2-SNAPSHOT

@REM if we remove local image, we can get them with pull
call docker pull localhost:8002/accounts:0.0.2-SNAPSHOT
call docker pull localhost:8002/cards:0.0.2-SNAPSHOT
call docker pull localhost:8002/loans:0.0.2-SNAPSHOT

@REM Running directly, will pull image if not exists
call docker run -d -p 8080:8080 localhost:8002/accounts:0.0.2-SNAPSHOT
call docker run -d -p 9000:9000 localhost:8002/cards:0.0.2-SNAPSHOT
call docker run -d -p 8090:8090 localhost:8002/loans:0.0.2-SNAPSHOT

cd "./-- docker --"
call docker compose up -d
cd ".."