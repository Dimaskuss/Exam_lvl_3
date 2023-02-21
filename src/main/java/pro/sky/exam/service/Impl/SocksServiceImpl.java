package pro.sky.exam.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.exam.exceptoin.ValidateException;
import pro.sky.exam.model.Sock;
import pro.sky.exam.model.SocksBatch;
import pro.sky.exam.model.SocksColor;
import pro.sky.exam.model.SocksSize;
import pro.sky.exam.repository.SocksRepository;
import pro.sky.exam.service.SocksService;
import pro.sky.exam.service.ValidationService;

import java.util.Map;

@Service
@AllArgsConstructor
public class SocksServiceImpl implements SocksService {

    private final SocksRepository socksRepository;
    private final ValidationService validationService;


    @Override
    public int accept(SocksBatch socksBatch) {
        if (!validationService.validate(socksBatch)) {
            throw new ValidateException();
        }
        socksRepository.save(socksBatch);


        return socksRepository.getAll().get(socksBatch.getSock());
    }

    @Override
    public int issuance(SocksBatch socksBatch) {
        if (!validationService.validate(socksBatch)) {
            throw new ValidateException();
        }

        return socksRepository.remove(socksBatch);
    }

    @Override
    public int countSocks(SocksSize size, SocksColor color, int cottonPart) {
        if (!validationService.validateSock(size, color, cottonPart)) {
            throw new ValidateException();
        } else {
            Map<Sock, Integer> sockMap = socksRepository.getAll();
            for (Map.Entry<Sock, Integer> socks : sockMap.entrySet()) {
                if (socks.getKey().getColor().equals(color)
                        && socks.getKey().getSize().equals(size)
                        && socks.getKey().getCottonPart() == cottonPart) {
                    return socks.getValue();
                }
            }

        }
        return 0;
    }

    @Override
    public int count(SocksColor color, SocksSize size, int cottonMin, int cottonMax) {
        if (!validationService.validate(color, size, cottonMin, cottonMax)) {
            throw new ValidateException();
        } else {
            int countSocks = 0;

            Map<Sock, Integer> sockMap = socksRepository.getAll();

            for (Map.Entry<Sock, Integer> socks : sockMap.entrySet()) {

                if (socks.getKey().getColor().equals(color) && socks.getKey().getSize().equals(size)
                        && socks.getKey().getCottonPart() <= cottonMax && socks.getKey().getCottonPart() >= cottonMin) {
                    countSocks += socks.getValue();

                }


            }
            return countSocks;

        }

    }

    @Override
    public int delete(SocksBatch socksBatch) {
        if (!validationService.validate(socksBatch)) {
            throw new ValidateException();
        }

        return socksRepository.remove(socksBatch);
    }

    @Override
    public Map<Sock, Integer> getAll() {

        return socksRepository.getAll();
    }

}
