package debmalya.jash.odysses.model;

import java.util.Set;
import lombok.Data;

@Data
public class SelectedPlan {
  private int price;
  private Set<String> planList;
}
