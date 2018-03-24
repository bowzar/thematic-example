docker -H 192.168.20.10 stop thematic-example-employee-boot
docker -H 192.168.20.10 rm thematic-example-employee-boot

docker -H 192.168.20.10 run --name thematic-example-employee-boot -d -p 6030:8080 -e PARAMS="--spring.profiles.active=dev" -v /hide/Develop/Docker/thematic-example-employee/config:/config -v /hide/Develop/Docker/thematic-example-employee/logs:/build 192.168.20.10:8082/thematic-example-employee-boot