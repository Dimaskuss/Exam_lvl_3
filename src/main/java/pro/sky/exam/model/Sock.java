package pro.sky.exam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sock {
    private SocksColor color;
    private SocksSize size;
    private int cottonPart;



}
