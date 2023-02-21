package pro.sky.exam.repository;

import pro.sky.exam.model.Sock;
import pro.sky.exam.model.SocksBatch;

import java.util.Map;

/**
 * Добавление, выгрузка товаров , состояние склада.
 */
public interface SocksRepository {
    void save(SocksBatch socksBatch);

    int remove(SocksBatch socksBatch);

    Map<Sock, Integer> getAll();
}
