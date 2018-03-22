docker -H 192.168.20.10 stop employee
docker -H 192.168.20.10 rm employee
docker -H 192.168.20.10 run -d --name employee -p 6030:8080 -v /hide/Develop/Docker/thematic-example-employee/logs:/build 192.168.20.10:8082/thematic-example-employee-boot