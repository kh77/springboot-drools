# SpringBoot-Drools Example

    - DRL File
    - Decision Table (excel or csv) , need to add 


### Drools maven dependency:

		<dependency>
			<groupId>org.drools</groupId>
			<artifactId>drools-core</artifactId>
			<version>${drools-version}</version>
		</dependency>
		<dependency>
			<groupId>org.drools</groupId>
			<artifactId>drools-compiler</artifactId>
			<version>${drools-version}</version>
		</dependency>

 - For Decision Table

       <dependency>
            <groupId>org.drools</groupId>
            <artifactId>drools-decisiontables</artifactId>
            <version>${drools-version}</version>
        </dependency>


### Based on 'cardType' and 'price' to get discount
 - Using drl file in the resource : order_offer.drl

        curl --location --request POST 'http://localhost:8080/order/offer' \
        --header 'Content-Type: application/json' \
        --data-raw '{
                 "name" : "Ali",
                 "cardType" : "ASKARI",
                 "price": "1600"
        }'


### Based on 'membership' and 'newCustomer' flag to get discount

 - Using Excel file : customer_offer.xls


    curl --location --request POST 'http://localhost:8080/customer/offer' \
    --header 'Content-Type: application/json' \
    --data-raw '{
          "name" : "Ali",
          "membership" : "GOLD",
          "newCustomer": false
    }'
