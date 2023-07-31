kubectl apply -f category-service/config/category-service.yml 
kubectl apply -f category-service/config/deployment.yml 

kubectl apply -f product-service/config/product-service.yml 
kubectl apply -f product-service/config/deployment.yml 

kubectl apply -f gateway-service/config/gateway-service.yml 
kubectl apply -f gateway-service/config/deployment.yml 
