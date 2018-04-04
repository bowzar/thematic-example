cd ${WORKSPACE}/thematic-example-employee-boot
mvn docker:push

docker -H 192.168.20.10 ps -a | grep "thematic-example-employee-boot" | awk "{print \$1}" | xargs --no-run-if-empty docker -H 192.168.20.10 stop
docker -H 192.168.20.10 ps -a | grep "thematic-example-employee-boot" | awk "{print \$1}" | xargs --no-run-if-empty docker -H 192.168.20.10 rm

docker -H 192.168.20.10 run --name thematic-example-employee-boot --restart unless-stopped -d -p 6030:8080 -e PARAMS="--spring.profiles.active=pro" -v /hide/Develop/Docker/thematic-example-employee/config:/config -v /hide/Develop/Docker/thematic-example-employee/logs:/build 192.168.20.10:8082/thematic-example-employee-boot

docker -H 192.168.20.10 images | grep "hours ago" | grep "thematic-example-employee-boot" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "days ago" | grep "thematic-example-employee-boot" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "weeks ago" | grep "thematic-example-employee-boot" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "months ago" | grep "thematic-example-employee-boot" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "years ago" | grep "thematic-example-employee-boot" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi




cd ${WORKSPACE}/thematic-example-employee-web
mvn docker:push

docker -H 192.168.20.10 ps -a | grep "thematic-example-employee-web" | awk "{print \$1}" | xargs --no-run-if-empty docker -H 192.168.20.10 stop
docker -H 192.168.20.10 ps -a | grep "thematic-example-employee-web" | awk "{print \$1}" | xargs --no-run-if-empty docker -H 192.168.20.10 rm

docker -H 192.168.20.10 run --name thematic-example-employee-web --restart unless-stopped -d -p 6031:8081  192.168.20.10:8082/thematic-example-employee-web

docker -H 192.168.20.10 images | grep "hours ago" | grep "thematic-example-employee-web" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "days ago" | grep "thematic-example-employee-web" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "weeks ago" | grep "thematic-example-employee-web" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "months ago" | grep "thematic-example-employee-web" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
docker -H 192.168.20.10 images | grep "years ago" | grep "thematic-example-employee-web" | awk "{print \$3}" | xargs --no-run-if-empty docker -H 192.168.20.10 rmi
