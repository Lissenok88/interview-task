Test task
==========

The client needs to display the transaction history of the personal account in the form of the following table.

### Technology stack used:
* Java
* Gradle
* Lombok

### Project key logic:
* Table:
  ФИО
  |-------------------------------------------------------------------------------------|
  |  дата  |  сумма списания  |  сумма пополнения  |  способ поплнения  |  комментарий  |
  |-------------------------------------------------------------------------------------|
  |        |  итоговая сумма  |  итоговая сумма    |                    |               |

* There is data in the personal account database with operations for replenishing and debiting the balance (data.json).
* Let's assume that you have already received data from the database in the form of an Account entity.
* You need to transform the data from the entity to display it in the table.
* GOTO DataService