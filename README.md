# data_JPA_HOMEWORK
JAVA JPA 資料庫CRUD，以API方式製作

取得產品內容
http://localhost:8080/productQuery/{id}

取得訂單內容
http://localhost:8080/orderQuery/{id}

取得訂單的詳細項目
http://localhost:8080/queryOrder/{id}

移除訂單項目
http://localhost:8080/deleteOrder/{id}

新增訂單的細項
http://localhost:8080/orderItem?order_id=依訂單排序&qty=訂購數量&product_id=要購買的產品編號

新增訂單
http://localhost:8080/order?customer=購買人姓名&address=地址

