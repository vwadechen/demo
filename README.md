# Car Rental System Based on Springboot



## Car rental interface

Request type: post

Api address: http://119.29.56.35:8080/car/save

**Input**

| Input parameters | Parameter Type | Description                |
| ---------------- | -------------- | -------------------------- |
| carType          | String         | Car type                   |
| custName         | String         | Customer name              |
| custId           | Integer        | Customer Id                |
| rentDay          | Date           | The date of the car rental |
| custPhone        | String         | Customer Phone             |



**Output**

| Output parameters | Parameter Type | Description          |
| ----------------- | -------------- | -------------------- |
| suriNum           | Integer        | Order number         |
| carId             | String         | License plate number |
| rentMoney         | BigDecimal     | Daily rent           |

**example**
```
    {
    "carType": "Toyota Camry",
    "custName": "test1",
    "custId": "1234",
    "custPhone": "10086",
    "rentDay": "2021-03-01"
    }
```

## Order query interface

Request type: get

Api address: http://119.29.56.35:8080/car/order/getOrderList

**Input**

| Input parameters | Parameter Type | Description |
| ---------------- | -------------- | ----------- |
| custId           | Integer        | Customer Id |



**Output**

| Output parameters | Parameter Type | Description                |
| ----------------- | -------------- | -------------------------- |
| suriNum           | Integer        | Order number               |
| carType           | String         | Car type                   |
| rentDay           | Date           | The date of the car rental |
| carId             | String         | License plate number       |
| custId            | Integer        | Customer Id                |
| custName          | String         | Customer name              |
| custPhone         | String         | Customer Phone             |





## Car return interface

Request type: post

Api address: http://119.29.56.35:8080/car/order/returnOrder

**Input**

| Input parameters | Parameter Type | Description  |
| ---------------- | -------------- | ------------ |
| suriNum          | Integer        | Order number |
| custId           | Integer        | Customer Id  |
| returnDay        | Date           | Return date  |



**Output**

| Output parameters | Parameter Type | Description  |
| ----------------- | -------------- | ------------ |
| suriNum           | Integer        | Order number |
| totalMoney        | BigDecimal     | Total Money  |

**example**
```
    {
    "suriNum": "3",
    "custId": "1234",
    "returnDay": "2020-03-05"
    }
```
