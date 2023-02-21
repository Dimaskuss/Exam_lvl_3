package pro.sky.exam.service;

import pro.sky.exam.model.SocksBatch;
import pro.sky.exam.model.SocksColor;
import pro.sky.exam.model.SocksSize;

/**
 *  Валидация при создании объектов
 */
public interface ValidationService {

    boolean validate (SocksBatch socksBatch);


    boolean validate (SocksColor socksColor,SocksSize socksSize,  int cottonMin, int cottonMax);

    boolean validateSock(SocksSize socksSize, SocksColor socksColor, int cottonPart);


}
