package org.top.rentalhousingcatalog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Репозиторий для выполнения операций с сущностями RentalHouse, которые являются отображением таблицы rental_house
// Расширяет CrudRepository, для которого необходимо указать сущность, с которой работает репозиторий
// и тип первичного ключа
@Repository
public interface RentalHouseRepository extends CrudRepository<RentalHouse, Integer> {
}
