docker -H 192.168.20.10 stop employee
docker -H 192.168.20.10 rm employee

docker -H 192.168.20.10 run --name employee -d -p 6030:8080 -e PARAMS="--spring.profiles.active=dev" -v /hide/Develop/Docker/thematic-example-employee/config:/config -v /hide/Develop/Docker/thematic-example-employee/logs:/build 192.168.20.10:8082/thematic-example-employee-boot