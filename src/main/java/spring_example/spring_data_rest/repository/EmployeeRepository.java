package spring_example.spring_data_rest.repository;
/*подходит для простого приложения как самый быстрый и легкий вариант развертывания REST API сервиса
не нужно писать никаких методов, все дефолтные методы создаются Spring Boot
однако, чтобы добавить новые методы и условия придется добавлять и сервисы и контроллеры)*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_example.spring_data_rest.entity.Employee;


@Repository //можно не писать, не влияет ни на что, Spring и так понимает, что это репозиторий, т.к. класс наследуется от т.к. JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

/*Spring Data REST предоставляет механизм автоматического создания REST API на основе типа Entity,
прописанного в репозитории проекта. То есть он сканирует наш репозиторий EmployeeRepository,
посмотрит на первый дженерик Employee, который является типом Entity
и создаст employees (изменяет первую букву на строчную и добавляет -s окончание (мн.число)
для создания методов без контроллеров использует best-practice Spring Boot REST API

HTTPметод       URL                              CRUD операция
GET             employees                   Получение всех работников
GET             employees/{employeeId}      Получение одного работника
POST            employees                   Добавление работника
PUT             employees                   Изменение работника (в отличие от Spring Boot REST API, в data-rest для изменения нужно добавить id, иначе команда игнорируется, ошибка 404)
DELETE          employees/{employeeId}      Удаление работника

 такие api создаются by default если мы используем зависимость data-rest и не создаем своего контроллера с его mapping
 */
