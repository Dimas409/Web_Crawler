package CollectAllData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Stations {
    private String name;
    private String line;
    private String date;
    private String depth;
    private boolean hasConnection;
}
