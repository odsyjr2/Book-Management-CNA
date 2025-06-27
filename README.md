# 

## Model
www.msaez.io/#/44573776/storming/b2bc2e56a5f05b28039621bec06e4d8b

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- author management
- subscribers management
- service
- admin
- 대시보드


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- author management
```
 http :8088/authors id="id"email="email"name="name"introduce="introduce"major="major"portfolio="portfolio"registerStatus="registerStatus"
 http :8088/publishManages id="id"authorName="authorName"authorId="authorId"bookTitle="bookTitle"bookContent="bookContent"finalSave="finalSave"publishStatus="publishStatus"
```
- subscribers management
```
 http :8088/subscribers id="id"email="email"name="name"message="message"point="point"joinStatus="joinStatus"ktCustomer="ktCustomer"loginStatus="loginStatus"
```
- service
```
 http :8088/services id="id"publicationId="publicationId"authorName="authorName"authorId="authorId"title="title"summaryText="summaryText"coverImageUrl="coverImageUrl"productRegistered="productRegistered"isPublishCompleted="isPublishCompleted"isBestSeller="isBestSeller"status="status"publishedDate="publishedDate"message="message"
```
- admin
```
 http :8088/admins id="id"requestId="requestId"requestType="requestType"targetId="	targetId"requestedAt="requestedAt"status="status"adminId="adminId"approvedAt="approvedAt"message="	message"
```
- 대시보드
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
