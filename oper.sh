kubectl delete -f category-service/config/namespace.yml  -f category-service/config/category-service.yml -f category-service/config/deployment.yml --force --grace-period=0
kubectl delete -f gateway-service/config/gateway-service.yml  -f gateway-service/config/deployment.yml --force --grace-period=0
kubectl delete -f product-service/config/product-service.yml -f product-service/config/deployment.yml --force --grace-period=0

sleep 5

kubectl apply -f category-service/config/namespace.yml  -f category-service/config/category-service.yml -f category-service/config/deployment.yml 
kubectl apply -f gateway-service/config/gateway-service.yml  -f gateway-service/config/deployment.yml
kubectl apply -f product-service/config/product-service.yml -f product-service/config/deployment.yml

#kubectl delete -f category-service/config/category-service.yml --force --grace-period=0
#kubectl delete -f category-service/config/deployment.yml --force --grace-period=0
#
#kubectl delete -f product-service/config/product-service.yml --force --grace-period=0
#kubectl delete -f product-service/config/deployment.yml --force --grace-period=0
#
#kubectl delete -f gateway-service/config/gateway-service.yml --force --grace-period=0
#kubectl delete -f gateway-service/config/deployment.yml --force --grace-period=0
