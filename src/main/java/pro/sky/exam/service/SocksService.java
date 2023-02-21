package pro.sky.exam.service;

import pro.sky.exam.model.Sock;
import pro.sky.exam.model.SocksBatch;
import pro.sky.exam.model.SocksColor;
import pro.sky.exam.model.SocksSize;

import java.util.Map;

/**
 * Сервисы управления складом
 */
public interface SocksService {

    /**
     * Добавления товара
     *
     * @param socksBatch - партия носков
     * @return - количество данных носков на складе
     */
    int accept(SocksBatch socksBatch);


    /**
     * Отпуск носков со склада
     *
     * @param socksBatch партия носков
     * @return остаток носков на складе
     */
    int issuance(SocksBatch socksBatch);


    /**
     * Определение количества носков определенного типа (Дополнительно сделал пока не разобратся Min/Max)
     *
     * @param size       размер
     * @param color      цвет
     * @param cottonPart содержание хлопка
     * @return количество носков
     */
    int countSocks(SocksSize size, SocksColor color, int cottonPart);


    /**
     * Определение количества носков определенного типа c разным количеством хлопка
     *
     * @param socksColor цвет
     * @param socksSize  размер
     * @param cottonMin  минимальное значение хлопка
     * @param cottonMax  Максимальное значение хлопка
     * @return количество носков
     */
    int count(SocksColor socksColor, SocksSize socksSize, int cottonMin, int cottonMax);


    /**
     * Списание определенной партии
     *
     * @param socksBatch партия носков
     * @return остаток носков на складе
     */
    int delete(SocksBatch socksBatch);


    /**
     * Метод для отслеживания состояния склада (Сделал дополнительно для отладки других методов)
     *
     * @return содержание склада в виде списка
     */
    Map<Sock, Integer> getAll();
}
