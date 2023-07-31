docker build -t category-service .
docker build -t product-service .
docker build -t gateway-service .

docker save -o category-service.tar category-service:latest
docker save -o product-service.tar product-service:latest
docker save -o gateway-service.tar gateway-service:latest

ctr -n=k8s.io images import gateway-service.tar
ctr -n=k8s.io images import category-service.tar
ctr -n=k8s.io images import product-service.tar 


kubectl port-forward deployment.apps/gateway-service 8080:80 -n development

curl -s 127.0.0.1:8080/category-service/api/v1/list | jq .
curl -s 127.0.0.1:8080/product-service/api/v1/list | jq .
