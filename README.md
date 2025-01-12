# webflux
spring-webflux-mongo


https://medium.com/@sumanzadeakhil/spring-boot-webflux-mongodb-crud-example-f1689f210b40


Mono<T> — is a publisher that produces from 0 to 1 value of T
Mono is a type that represents 0 or 1 element in the stream. It can be used when:

You expect one item (or no item) to be emitted.
The operation might complete with a result or complete without any result.
Useful for single-value responses, such as:
Retrieving a single record from a database.
Handling HTTP requests that expect a single response (e.g., one user, one document, etc.).
Operations that might return an empty value (e.g., Optional-like behavior).

ex: findUserById()

Flux<T> — is a publisher that produces from 0 to N values of T

Flux is a type that represents 0 to N elements in the stream. It is used when:

You expect multiple items to be emitted, or you don't know how many.
The operation may produce a list of items, or no items at all (which results in an empty stream).
Useful for streaming data or handling multiple records, such as:
Retrieving multiple records from a database.
Handling HTTP requests that expect multiple responses (e.g., a list of users, items, etc.).
Streaming real-time data.

ex: findAllUsers()


A **DTO** is a plain object used for transferring data between different layers of an application, typically from the service layer to the controller layer, or to/from external systems via APIs.

An **Entity** is a class that represents a table in the database. It’s typically used for persistence operations, i.e., saving, fetching, updating, and deleting records in the database.
