# 生成镜像

docker build -t category-service .

docker build -t product-service .

docker build -t gateway-service .

# 导出镜像
docker save -o category-service.tar category-service:latest

docker save -o product-service.tar product-service:latest

docker save -o gateway-service.tar gateway-service:latest

# 导入镜像 containerd使用

ctr -n=k8s.io images import gateway-service.tar

ctr -n=k8s.io images import category-service.tar

ctr -n=k8s.io images import product-service.tar 

# 运行postgres，方便测试使用 
docker run -p 5432:5432 -e POSTGRES_PASSWORD=password --rm postgres:latest


kubectl port-forward deployment.apps/gateway-service 8080:80 -n development

curl -s 127.0.0.1:8080/category-service/api/v1/list | jq .

curl -s 127.0.0.1:8080/product-service/api/v1/list | jq .


example.com 绑定host到指定node

http://example.com/category-service/api/v1/list

