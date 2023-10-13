package org.top.rentalhousingcatalog;

import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Optional;

// Контроллер - веб-интерфейс приложения
@RestController
public class ApplicationController {
    // репозиторий для работы с объектами (использование DI)
    private final RentalHouseRepository rentalHouseRepository;
    public ApplicationController(RentalHouseRepository rentalHouseRepository) {
        this.rentalHouseRepository = rentalHouseRepository;
    }
    // дефолтные обработчики
    @GetMapping("")
    public String index() {
        return LocalTime.now() + ": Сервер запущен и работает.";
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    // ОБРАБОТЧИКИ, ВЫЗЫВАЮЩИЕ ОПЕРАЦИИ ПО ВЗАИМОДЕЙСТВИЮ С БД
    // 1. получить все записи
    @GetMapping("houses")
    public Iterable<RentalHouse> findAll() {
        return rentalHouseRepository.findAll();
    }

    // 2. получить запись по id
    @GetMapping("houses/{id}")
    public Optional<RentalHouse> findById(@PathVariable Integer id) {
        return rentalHouseRepository.findById(id);
    }

    // 3. добавить новую запись
    @PostMapping("houses/new")
    public RentalHouse addNew(@RequestBody RentalHouse rentalHouse) {
        return rentalHouseRepository.save(rentalHouse);
    }

    // 4. удалить запись по id
    @DeleteMapping("houses/{id}")
    public Optional<RentalHouse> deleteById(@PathVariable Integer id) {
        Optional<RentalHouse> deleted = rentalHouseRepository.findById(id); // пробуем найти удаляемый объект
        if (deleted.isPresent()) {
            // если он присутствует, то удалить его
            rentalHouseRepository.deleteById(id);
        }
        return deleted; // вернуть удаляемый (вернется удаленный объект, либо null если объекта с таким id не было)
    }

    // 5. изменить запись
    @PostMapping("houses/update")
    public Optional<RentalHouse> updateExisting(@RequestBody RentalHouse rentalHouse) {
        // 1. Проверяем есть ли такая запись
        Optional<RentalHouse> updated = rentalHouseRepository.findById(rentalHouse.getId());
        // 2. если онf есть, то обновляем ее данные
        if (updated.isPresent()) {
            rentalHouseRepository.save(rentalHouse);
            return Optional.of(rentalHouse);
        }
        // 3. вернуть пустое значение
        return Optional.empty();
    }
}
