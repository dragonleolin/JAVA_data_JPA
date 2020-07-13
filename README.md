# data_JPA_HOMEWORK
JAVA JPA 資料庫CRUD，以API方式製作

啟動serve: 到 DataJpaHomeworkApplication -> 點選右鍵 -> Run As -> Spring Boot App

使用方式: 可以把資料表先放到資料庫中，或是沒有放對應的表，資料庫會自動新增。此API要先使用新增訂單細項才可以用新增訂單，訂單排序需要跟著訂單的id

資料表的放置位置: JAVA_data_JPA/src/main/resources/

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

