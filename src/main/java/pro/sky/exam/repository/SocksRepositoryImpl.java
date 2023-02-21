package pro.sky.exam.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pro.sky.exam.model.Sock;
import pro.sky.exam.model.SocksBatch;

import java.util.HashMap;
import java.util.Map;

@Repository
@AllArgsConstructor
public class SocksRepositoryImpl implements SocksRepository {

    private final HashMap<Sock, Integer> socksCount = new HashMap<>();

    @Override
    public void save(SocksBatch socksBatch) {
        if (socksCount.containsKey(socksBatch.getSock())) {
            socksCount.replace(socksBatch.getSock(), (socksCount.get(socksBatch.getSock()) + socksBatch.getQuantity()));
        } else {
            socksCount.put(socksBatch.getSock(), socksBatch.getQuantity());
        }
    }

    @Override
    public int remove(SocksBatch socksBatch) {
        if (socksCount.containsKey(socksBatch.getSock())) {
            if (socksCount.get(socksBatch.getSock()) > socksBatch.getQuantity()) {
                socksCount.replace(socksBatch.getSock(), (socksCount.get(socksBatch.getSock()) - socksBatch.getQuantity()));

                return socksCount.get(socksBatch.getSock());
            } else {
                return socksCount.remove(socksBatch.getSock());
            }
        } else {
            return 0;
        }

    }

    @Override
    public Map<Sock, Integer> getAll() {

        return socksCount;
    }
}
