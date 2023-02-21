package pro.sky.exam.service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.exam.model.SocksBatch;
import pro.sky.exam.model.SocksColor;
import pro.sky.exam.model.SocksSize;
import pro.sky.exam.service.ValidationService;

@Service
public class ValidationImpl implements ValidationService {
    @Override
    public boolean validate(SocksBatch socksBatch) {

        return socksBatch.getSock() != null && socksBatch.getQuantity() > 0
                && validateSock(socksBatch.getSock().getSize(), socksBatch.getSock().getColor(), socksBatch.getSock().getCottonPart());
    }

    @Override
    public boolean validate(SocksColor color, SocksSize size, int cottonMin, int cottonMax) {
        return size != null && color != null && cottonMin >= 0 && cottonMin < cottonMax && cottonMax <= 100;
    }

    @Override
    public boolean validateSock(SocksSize size, SocksColor color, int cottonPart) {
        return size != null && color != null && cottonPart >= 0 && cottonPart <= 100;
    }


}
