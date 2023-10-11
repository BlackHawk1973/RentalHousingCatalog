package org.top.rentalhousingcatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

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
        return LocalTime.now() + ": Сервер запущен и работает."
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }
}
