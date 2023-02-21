package pro.sky.exam.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.exam.model.Sock;
import pro.sky.exam.model.SocksBatch;
import pro.sky.exam.model.SocksColor;
import pro.sky.exam.model.SocksSize;
import pro.sky.exam.service.SocksService;

import java.util.Map;

@RestController
@RequestMapping("/api/socks")
@Tag(name = "API по работе со складом носков ", description = "загрузка,отгрузка,удаление товара со склада")

public class SocksStoreController {

    private final SocksService socksService;

    public SocksStoreController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping
    @Operation(summary = "Добавление носков на склад")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "удалось добавить приход"),
            @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    })
    public ResponseEntity<Integer> accept(@RequestBody SocksBatch socksBatch) {

        return ResponseEntity.ok(socksService.accept(socksBatch));


    }

    @PutMapping
    @Operation(summary = "Отпуск носков со склада")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " удалось произвести отпуск носков со склада"),
            @ApiResponse(responseCode = "400", description = "товара нет на складе в нужном количестве или параметры запроса имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    })
    public ResponseEntity<Integer> issuance(@RequestBody SocksBatch socksBatch) {

        return ResponseEntity.ok(socksService.issuance(socksBatch));
    }

    @GetMapping
    @Operation(summary = "Общее количество носков на складе по содержанию хлопка в пределах Min/Max")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "запрос выполнен, результат в теле ответа в виде строкового представления целого числа"),
            @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    })
    public ResponseEntity<Integer> countSocksByCottonPart(@RequestParam SocksColor colorSock,
                                                          @RequestParam SocksSize size,
                                                          @RequestParam int cottonMin,
                                                          @RequestParam int cottonMax) {

        return ResponseEntity.ok(socksService.count(colorSock, size, cottonMin, cottonMax));

    }

    @GetMapping("/sock")
    @Operation(summary = "Общее количество носков на складе по ровному значению содержания хлопка ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "запрос выполнен, результат в теле ответа в виде строкового представления целого числа"),
            @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    })
    public ResponseEntity<Integer> countSocks(@RequestParam SocksSize size,
                                              @RequestParam SocksColor color,
                                              @RequestParam int cottonPart) {

        return ResponseEntity.ok(socksService.countSocks(size, color, cottonPart));
    }

    @DeleteMapping
    @Operation(summary = "Списание испорченных (бракованных)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "запрос выполнен, товар списан со склада"),
            @ApiResponse(responseCode = "400", description = "параметры запроса отсутствуют или имеют некорректный формат"),
            @ApiResponse(responseCode = "500", description = "произошла ошибка, не зависящая от вызывающей стороны")
    })
    public ResponseEntity<Integer> delete(@RequestBody SocksBatch socksBatch) {

        return ResponseEntity.ok(socksService.delete(socksBatch));
    }

    @GetMapping("/all")
    @Operation(summary = "Общее количество носков на складе, отображение состояния склада ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "запрос выполнен, результат в теле ответа в виде списка, наполнения склада")

    })
    public ResponseEntity<Map<Sock, Integer>> getAll() {

        return ResponseEntity.ok(socksService.getAll());
    }
}
